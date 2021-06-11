<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="会议主题" prop="theme">
      <el-input v-model="dataForm.theme" placeholder="会议主题"></el-input>
    </el-form-item>
    <el-form-item label="会议开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="会议开始时间"></el-input>
    </el-form-item>
    <el-form-item label="会议结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="会议结束时间"></el-input>
    </el-form-item>
    <el-form-item label="参会人员" prop="number">
      <el-input v-model="dataForm.number" placeholder="参会人员"></el-input>
    </el-form-item>
    <el-form-item label="组织者" prop="organizer">
      <el-input v-model="dataForm.organizer" placeholder="组织者"></el-input>
    </el-form-item>
    <el-form-item label="组织机构" prop="institution">
      <el-input v-model="dataForm.institution" placeholder="组织机构"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updatedTime">
      <el-input v-model="dataForm.updatedTime" placeholder="修改时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          theme: '',
          startTime: '',
          endTime: '',
          number: '',
          organizer: '',
          institution: '',
          createTime: '',
          updatedTime: ''
        },
        dataRule: {
          theme: [
            { required: true, message: '会议主题不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '会议开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '会议结束时间不能为空', trigger: 'blur' }
          ],
          number: [
            { required: true, message: '参会人员不能为空', trigger: 'blur' }
          ],
          organizer: [
            { required: true, message: '组织者不能为空', trigger: 'blur' }
          ],
          institution: [
            { required: true, message: '组织机构不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updatedTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/committee_check/meetingdiscussion/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.theme = data.meetingDiscussion.theme
                this.dataForm.startTime = data.meetingDiscussion.startTime
                this.dataForm.endTime = data.meetingDiscussion.endTime
                this.dataForm.number = data.meetingDiscussion.number
                this.dataForm.organizer = data.meetingDiscussion.organizer
                this.dataForm.institution = data.meetingDiscussion.institution
                this.dataForm.createTime = data.meetingDiscussion.createTime
                this.dataForm.updatedTime = data.meetingDiscussion.updatedTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/committee_check/meetingdiscussion/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'theme': this.dataForm.theme,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'number': this.dataForm.number,
                'organizer': this.dataForm.organizer,
                'institution': this.dataForm.institution,
                'createTime': this.dataForm.createTime,
                'updatedTime': this.dataForm.updatedTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
