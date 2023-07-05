;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1111)
(include sci.sh)
(use Main)
(use PStopWalk)
(use Str)
(use WalkieTalkie)
(use Motion)
(use File)
(use System)

(public
	proc1111_0 0
	proc1111_1 1
	proc1111_2 2
	proc1111_3 3
	proc1111_4 4
	proc1111_6 6
	proc1111_7 7
	proc1111_8 8
	proc1111_9 9
	proc1111_10 10
	proc1111_11 11
	proc1111_12 12
	proc1111_13 13
	proc1111_14 14
	proc1111_15 15
	proc1111_16 16
)

(local
	[local0 16] = [7000 8 7100 19 7200 11 7300 16 7400 12 7500 13 7600 12 7700 12]
	[local16 16] = [7001 17 7101 17 7201 11 7301 19 7401 18 7501 10 7601 15 7701 11]
	[local32 16] = [7002 18 7102 14 7202 13 7302 14 7402 15 7502 13 7602 18 7702 16]
	[local48 16] = [7003 19 7103 15 7203 18 7303 6 7403 16 7503 18 7603 15 7703 13]
	[local64 16] = [7004 16 7104 20 7204 9 7304 15 7404 12 7504 13 7604 16 7704 16]
	[local80 16] = [7005 17 7105 11 7205 11 7305 12 7405 14 7505 13 7605 14 7705 11]
	[local96 16] = [7006 20 7106 13 7206 16 7306 9 7406 15 7506 13 7606 5 7706 14]
	[local112 16] = [7007 15 7107 13 7207 12 7307 15 7407 16 7507 12 7607 15 7707 4]
	local128 = -1
	[local129 17]
)

(procedure (proc1111_3) ; UNUSED
	(switch (gEgo view:)
		(0
			(gEgo heading: 90)
		)
		(1
			(gEgo heading: 270)
		)
		(2
			(gEgo heading: 180)
		)
		(3
			(gEgo heading: 360)
		)
		(4
			(gEgo heading: 135)
		)
		(5
			(gEgo heading: 225)
		)
		(6
			(gEgo heading: 45)
		)
		(7
			(gEgo heading: 315)
		)
	)
)

(procedure (proc1111_12))

(procedure (proc1111_4 param1 param2) ; UNUSED
	(if (> argc 1)
		(param1 view: param2)
	)
	(param1
		setLoop: -1
		loop: 0
		setMotion: 0
		setCycle: PStopWalk 0
		setSpeed: global158
		ignoreActors: 1
		show:
	)
	(if (not (param1 scaler:))
		(param1 setStep: 3 1 0)
	)
	(UpdateScreenItem param1)
)

(procedure (proc1111_6 param1 param2 &tmp temp0 temp1 temp2)
	(if (and argc param1)
		(= temp1 param1)
	else
		(= temp1 0)
	)
	(if (> argc 1)
		(= temp2 param2)
	else
		(= temp2 gEgo)
	)
	(WalkieTalkie killRobot: temp1 temp2)
)

(procedure (proc1111_8 &tmp temp0 temp1)
	(SetFlag 362)
	(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
		(= temp1 (gCast at: temp0))
		(temp1 y: (- (temp1 y:) 1000))
		(if (temp1 isNotHidden:)
			(UpdateScreenItem temp1)
		)
	)
	(for ((= temp0 0)) (< temp0 (gFeatures size:)) ((++ temp0))
		(= temp1 (gFeatures at: temp0))
		(temp1 y: (- (temp1 y:) 1000))
	)
)

(procedure (proc1111_9 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
		(= temp1 (gCast at: temp0))
		(temp1 y: (+ (temp1 y:) 1000))
		(if (temp1 isNotHidden:)
			(temp1 doit:)
			(if (gCast contains: temp1)
				(UpdateScreenItem temp1)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 (gFeatures size:)) ((++ temp0))
		(= temp1 (gFeatures at: temp0))
		(temp1 y: (+ (temp1 y:) 1000))
	)
	(ClearFlag 362)
)

(procedure (proc1111_11 &tmp temp0 temp1)
	(for ((= temp0 1)) (<= temp0 15) ((++ temp0))
		(if [local129 temp0]
			(while ([local129 temp0] size:)
				(DeleteLine (= temp1 ([local129 temp0] at: 0)) (gCast plane:))
				([local129 temp0] delete: temp1)
			)
			(= [local129 temp0] 0)
		)
	)
	(UpdatePlane (gCast plane:))
	(FrameOut)
	(= local128 -1)
)

(procedure (proc1111_10 &tmp [temp0 5]))

(procedure (proc1111_13 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (not param1)
		(param2 cue:)
		(return)
	else
		(= temp7 (+ (gEgo x:) (* (- (param1 approachX:) (gEgo x:)) 5)))
		(= temp8 (+ (gEgo y:) (* (- (param1 approachY:) (gEgo y:)) 8)))
		(cond
			(
				(or
					(>
						(= temp0
							(GetAngle (gEgo x:) (gEgo y:) temp7 temp8)
						)
						337
					)
					(< temp0 23)
				)
				(= temp1 3)
			)
			((and (> temp0 22) (< temp0 68))
				(= temp1 6)
			)
			((and (> temp0 67) (< temp0 113))
				(= temp1 0)
			)
			((and (> temp0 112) (< temp0 158))
				(= temp1 4)
			)
			((and (> temp0 157) (< temp0 203))
				(= temp1 2)
			)
			((and (> temp0 202) (< temp0 248))
				(= temp1 5)
			)
			((and (> temp0 247) (< temp0 293))
				(= temp1 1)
			)
			((and (> temp0 292) (< temp0 338))
				(= temp1 7)
			)
		)
		(= temp3 (* (gEgo view:) 100))
		(= temp2 (+ 7000 temp3 temp1))
		(for ((= temp6 0)) (<= temp6 14) ((++ temp6))
			(cond
				((== [local0 temp6] temp2)
					(= temp5 [local0 (++ temp6)])
					(break)
				)
				((== [local16 temp6] temp2)
					(= temp5 [local16 (++ temp6)])
					(break)
				)
				((== [local32 temp6] temp2)
					(= temp5 [local32 (++ temp6)])
					(break)
				)
				((== [local48 temp6] temp2)
					(= temp5 [local48 (++ temp6)])
					(break)
				)
				((== [local64 temp6] temp2)
					(= temp5 [local64 (++ temp6)])
					(break)
				)
				((== [local80 temp6] temp2)
					(= temp5 [local80 (++ temp6)])
					(break)
				)
				((== [local96 temp6] temp2)
					(= temp5 [local96 (++ temp6)])
					(break)
				)
				((== [local112 temp6] temp2)
					(= temp5 [local112 (++ temp6)])
					(break)
				)
			)
		)
		(cond
			((not (ResCheck rsVIEW temp2))
				(param2 cue:)
			)
			(
				(and
					(<= argc 2)
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(param1 approachX:)
							(param1 approachY:)
						)
						(param1 approachDist:)
					)
				)
				(gEgo view: temp2 setLoop: 0 1 cel: 0 setCycle: End param2)
			)
			((and (>= argc 3) (== param3 2))
				(param2 cue:)
			)
			(else
				(if (>= argc 4)
					(= temp5 param4)
				)
				(gEgo
					view: temp2
					setLoop: 0 1
					cel: 0
					setCycle: CT temp5 1 param2
				)
			)
		)
	)
)

(procedure (proc1111_7 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2)
	(if (IsFlag 338)
		(proc1111_14 22 param1)
	)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp2 param3)
	else
		(= temp2 0)
	)
	(WalkieTalkie
		doRobot:
			param1
			temp1
			temp2
			(if (not (> argc 7)) self else 0)
			(if (> argc 3) param4 else gEgo)
			(if (> argc 4) param5 else -1)
			(if (> argc 5) param6 else 0)
	)
	(= global202 param1)
)

(procedure (proc1111_14 &tmp [temp0 7]))

(procedure (proc1111_0 &tmp [temp0 8]))

(procedure (proc1111_1 param1 param2 param3)
	(cond
		((and (== argc 1) (not param1))
			(gGDacSound loop: 1 setLoop: 1 stop:)
		)
		(
			(and
				(not (ResCheck rsSOUND param1))
				(not (ResCheck rsAUDIO param1))
				(not (ResCheck 140 param1)) ; WAVE
			))
		((> argc 2)
			(gGDacSound
				number: param1
				loop: param2
				setLoop: param2
				play: 127 param3
			)
		)
		(else
			(gGDacSound number: param1 loop: param2 setLoop: param2 play:)
		)
	)
)

(procedure (proc1111_2 param1)
	(if (ResCheck rsAUDIO param1)
		(Load rsAUDIO param1)
	)
	(if (ResCheck 140 param1) ; WAVE
		(Load 140 param1) ; WAVE
	)
	(if (ResCheck rsSOUND param1)
		(Load rsSOUND param1)
	)
)

(procedure (proc1111_15)
	(if (not (prefFile scratch:))
		(prefFile init:)
	)
	(if (prefFile open: 2)
		(if (IsFlag 127)
			(prefFile writeWord: 1)
		else
			(prefFile writeWord: 0)
		)
		(if (IsFlag 236)
			(prefFile writeWord: 1)
		else
			(prefFile writeWord: 0)
		)
		(prefFile writeWord: global189)
		(prefFile writeWord: global188)
		(prefFile writeWord: global187)
		(prefFile close:)
	)
)

(procedure (proc1111_16)
	(if (not (prefFile scratch:))
		(prefFile init:)
	)
	(if (prefFile open: 1)
		(if (prefFile readWord:)
			(SetFlag 127)
		else
			(ClearFlag 127)
		)
		(if (prefFile readWord:)
			(SetFlag 236)
		else
			(ClearFlag 236)
		)
		(= global189 (prefFile readWord:))
		(DoAudio audVOLUME (= global188 (prefFile readWord:)))
		(DoSound sndMASTER_VOLUME (= global187 (prefFile readWord:)))
		(prefFile close:)
	)
)

(instance showApproach of Code ; UNUSED
	(properties)
)

(instance prefFile of File
	(properties)

	(method (init)
		(= scratch (Str newWith: 10))
		(KString 5 (scratch data:) 0 10 0) ; StrFill
		(scratch cat: {PREF.DAT})
		(= name (scratch data:))
		(scratch data: 0 dispose:)
	)
)

