<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="未处置完毕事件" prop="receiveUnfinished">
      <el-input v-model="dataForm.receiveUnfinished" placeholder="未处置完毕事件"></el-input>
    </el-form-item>
    <el-form-item label="未处置即关闭事件，无跟进措施" prop="receiveNotFollow">
      <el-input v-model="dataForm.receiveNotFollow" placeholder="未处置即关闭事件，无跟进措施"></el-input>
    </el-form-item>
    <el-form-item label="未处置即关闭事件，造成影响的" prop="receiveEffect">
      <el-input v-model="dataForm.receiveEffect" placeholder="未处置即关闭事件，造成影响的"></el-input>
    </el-form-item>
    <el-form-item label="平安考核扣分事项的事件" prop="receiveDeduct">
      <el-input v-model="dataForm.receiveDeduct" placeholder="平安考核扣分事项的事件"></el-input>
    </el-form-item>
    <el-form-item label="交办处置事件" prop="receivePut">
      <el-input v-model="dataForm.receivePut" placeholder="交办处置事件"></el-input>
    </el-form-item>
    <el-form-item label="排查走访" prop="drivingVisit">
      <el-input v-model="dataForm.drivingVisit" placeholder="排查走访"></el-input>
    </el-form-item>
    <el-form-item label="主动牵头开展行业内专项整治" prop="drivingManage">
      <el-input v-model="dataForm.drivingManage" placeholder="主动牵头开展行业内专项整治"></el-input>
    </el-form-item>
    <el-form-item label="开展跨领域，跨部门联合整治的牵头部门" prop="drivingUnion">
      <el-input v-model="dataForm.drivingUnion" placeholder="开展跨领域，跨部门联合整治的牵头部门"></el-input>
    </el-form-item>
    <el-form-item label="不满意的事件" prop="notSatisfied">
      <el-input v-model="dataForm.notSatisfied" placeholder="不满意的事件"></el-input>
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
          receiveUnfinished: '',
          receiveNotFollow: '',
          receiveEffect: '',
          receiveDeduct: '',
          receivePut: '',
          drivingVisit: '',
          drivingManage: '',
          drivingUnion: '',
          notSatisfied: ''
        },
        dataRule: {
          receiveUnfinished: [
            { required: true, message: '未处置完毕事件不能为空', trigger: 'blur' }
          ],
          receiveNotFollow: [
            { required: true, message: '未处置即关闭事件，无跟进措施不能为空', trigger: 'blur' }
          ],
          receiveEffect: [
            { required: true, message: '未处置即关闭事件，造成影响的不能为空', trigger: 'blur' }
          ],
          receiveDeduct: [
            { required: true, message: '平安考核扣分事项的事件不能为空', trigger: 'blur' }
          ],
          receivePut: [
            { required: true, message: '交办处置事件不能为空', trigger: 'blur' }
          ],
          drivingVisit: [
            { required: true, message: '排查走访不能为空', trigger: 'blur' }
          ],
          drivingManage: [
            { required: true, message: '主动牵头开展行业内专项整治不能为空', trigger: 'blur' }
          ],
          drivingUnion: [
            { required: true, message: '开展跨领域，跨部门联合整治的牵头部门不能为空', trigger: 'blur' }
          ],
          notSatisfied: [
            { required: true, message: '不满意的事件不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/committee_check/checkdepartmentparameter/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.receiveUnfinished = data.checkdepartmentParameter.receiveUnfinished
                this.dataForm.receiveNotFollow = data.checkdepartmentParameter.receiveNotFollow
                this.dataForm.receiveEffect = data.checkdepartmentParameter.receiveEffect
                this.dataForm.receiveDeduct = data.checkdepartmentParameter.receiveDeduct
                this.dataForm.receivePut = data.checkdepartmentParameter.receivePut
                this.dataForm.drivingVisit = data.checkdepartmentParameter.drivingVisit
                this.dataForm.drivingManage = data.checkdepartmentParameter.drivingManage
                this.dataForm.drivingUnion = data.checkdepartmentParameter.drivingUnion
                this.dataForm.notSatisfied = data.checkdepartmentParameter.notSatisfied
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
              url: this.$http.adornUrl(`/committee_check/checkdepartmentparameter/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'receiveUnfinished': this.dataForm.receiveUnfinished,
                'receiveNotFollow': this.dataForm.receiveNotFollow,
                'receiveEffect': this.dataForm.receiveEffect,
                'receiveDeduct': this.dataForm.receiveDeduct,
                'receivePut': this.dataForm.receivePut,
                'drivingVisit': this.dataForm.drivingVisit,
                'drivingManage': this.dataForm.drivingManage,
                'drivingUnion': this.dataForm.drivingUnion,
                'notSatisfied': this.dataForm.notSatisfied
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
