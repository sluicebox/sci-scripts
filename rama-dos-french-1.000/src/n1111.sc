;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1111)
(include sci.sh)
(use Main)
(use Str)
(use WalkieTalkie)
(use File)
(use System)

(public
	proc1111_1 1
	proc1111_2 2
	proc1111_6 6
	proc1111_7 7
	proc1111_8 8
	proc1111_9 9
	proc1111_17 17
	SetFlag 18
	ClearFlag 19
	IsFlag 20
	proc1111_21 21
	proc1111_22 22
	proc1111_23 23
	proc1111_24 24
	proc1111_25 25
	proc1111_29 29
	proc1111_31 31
	proc1111_32 32
	proc1111_33 33
)

(procedure (proc1111_8 &tmp temp0 temp1) ; UNUSED
	(SetFlag 5)
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

(procedure (proc1111_9 &tmp temp0 temp1) ; UNUSED
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
	(ClearFlag 5)
)

(procedure (proc1111_1 param1 param2 param3) ; UNUSED
	(cond
		((and (== argc 1) (not param1))
			(gTesterSound loop: 1 setLoop: 1 stop:)
		)
		(
			(and
				(not (ResCheck rsSOUND param1))
				(not (ResCheck rsAUDIO param1))
				(not (ResCheck 140 param1)) ; WAVE
			))
		((> argc 2)
			(gTesterSound
				number: param1
				loop: param2
				setLoop: param2
				play: 127 param3
			)
		)
		(else
			(gTesterSound number: param1 loop: param2 setLoop: param2 play:)
		)
	)
)

(procedure (proc1111_2 param1) ; UNUSED
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

(procedure (proc1111_17 param1 param2 param3) ; UNUSED
	(PlayVMD 0 param1 0) ; Open
	(PlayVMD 23 0 161) ; RestrictPalette
	(PlayVMD 21 32 60 32 60) ; Black
	(if (> argc 1)
		(PlayVMD 1 32 60 param2) ; Put
	else
		(PlayVMD 1 32 60) ; Put
	)
	(PlayVMD 14 7) ; WaitEvent
	(if (and (== argc 3) param3)
		(gCurRoom drawPic: param3)
	)
	(PlayVMD 6) ; Close
)

(procedure (IsFlag param1)
	(return (& [global300 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(|= [global300 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (proc1111_24 param1)
	(return (not (IsFlag param1)))
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global300 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (proc1111_25 param1) ; UNUSED
	(^= [global300 (/ param1 16)] (>> $8000 (mod param1 16)))
)

(procedure (proc1111_21 param1 param2 param3) ; UNUSED
	(param1 at: param2 param3)
	(param1 at: (+ param2 1) (>> param3 $0008))
)

(procedure (proc1111_22 param1 param2)
	(return
		(+ (& (param1 at: param2) $00ff) (<< (param1 at: (+ param2 1)) $0008))
	)
)

(procedure (proc1111_6 param1 param2 &tmp temp0 temp1 temp2)
	(if global107
		(if (and argc param1)
			(= temp1 param1)
		else
			(= temp1 0)
		)
		(if (> argc 1)
			(= temp2 param2)
			(WalkieTalkie killRobot: temp1 temp2)
		else
			(WalkieTalkie killRobot: temp1)
		)
		(= global107 0)
	)
)

(procedure (proc1111_7 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2)
	(if global107
		(proc1111_6)
	)
	(= global107 param1)
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
			(if (> argc 3) param4 else 0)
			(if (> argc 7) param8 else 0)
			(if (> argc 4) param5 else 0)
			(if (> argc 5) param6 else -1)
			(if (> argc 6) param7 else 0)
	)
)

(procedure (proc1111_23 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(if gAutoRobot
		(= temp2 (Robot 11)) ; FrameNum
		(= temp3 (gAutoRobot robot:))
		(= temp0 (gAutoRobot x:))
		(= temp1 (gAutoRobot y:))
		(proc1111_6)
		(WalkieTalkie showFrame: temp3 (+ temp2 1) temp0 temp1)
		(return temp2)
	)
)

(procedure (proc1111_29 param1)
	(cond
		((== param1 4022)
			(SetFlag 258)
		)
		((and (== param1 4031) (== global269 2))
			(SetFlag 259)
		)
		((== param1 4122)
			(SetFlag 260)
		)
		((and (== param1 4131) (== global269 3))
			(SetFlag 261)
		)
		((== param1 4222)
			(SetFlag 262)
		)
		((== param1 3001)
			(SetFlag 264)
		)
		((== param1 3020)
			(SetFlag 265)
		)
		((== param1 3060)
			(SetFlag 266)
		)
		((OneOf param1 5500 5501)
			(SetFlag 267)
		)
		((== param1 5001)
			(SetFlag 268)
		)
		((OneOf param1 5502 5503)
			(SetFlag 269)
		)
		((== param1 5504)
			(SetFlag 270)
		)
		((== param1 5505)
			(SetFlag 271)
		)
		((== param1 5521)
			(SetFlag 272)
		)
		((== param1 5522)
			(SetFlag 273)
		)
		((== param1 5523)
			(SetFlag 274)
		)
		((== param1 5204)
			(SetFlag 275)
		)
		((== param1 5520)
			(SetFlag 276)
		)
		((== param1 5517)
			(SetFlag 277)
		)
		((== param1 5518)
			(SetFlag 278)
		)
		((== param1 5309)
			(SetFlag 279)
		)
		((== param1 5515)
			(SetFlag 280)
		)
		((== param1 5514)
			(SetFlag 281)
		)
		((== param1 5511)
			(SetFlag 282)
		)
		((== param1 6101)
			(SetFlag 283)
		)
		((== param1 6103)
			(SetFlag 284)
		)
		((== param1 6106)
			(SetFlag 285)
		)
		((== param1 6200)
			(SetFlag 286)
		)
		((== param1 6802)
			(SetFlag 287)
		)
		((== param1 6400)
			(SetFlag 288)
		)
		((== param1 6404)
			(SetFlag 289)
		)
		((== param1 6600)
			(SetFlag 290)
		)
		((== param1 6510)
			(SetFlag 291)
		)
		((== param1 6500)
			(SetFlag 292)
		)
		((== param1 6901)
			(SetFlag 293)
		)
		((== param1 7000)
			(SetFlag 294)
		)
		((== param1 7100)
			(SetFlag 295)
		)
		((== param1 7200)
			(SetFlag 296)
		)
		((== param1 7400)
			(SetFlag 298)
		)
		((== param1 7600)
			(SetFlag 299)
		)
		((== param1 7800)
			(SetFlag 300)
		)
		((== param1 7700)
			(SetFlag 301)
		)
		((== param1 7900)
			(SetFlag 302)
		)
		((== param1 7904)
			(SetFlag 303)
		)
		((== param1 7906)
			(SetFlag 304)
		)
		((== param1 7908)
			(SetFlag 305)
		)
		((== param1 8020)
			(SetFlag 306)
		)
	)
)

(procedure (proc1111_31 param1 param2 param3 &tmp temp0 temp1 temp2)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp0 param3)
	else
		(= temp0 144)
	)
	(if (> argc 3)
		(= temp2 [param3 1])
	else
		(= temp2 0)
	)
	(if (and gMsgType (ResCheck rsMESSAGE 91) (Message msgGET 91 param1 temp0 temp1 1))
		(gMessager say: param1 temp0 temp1 0 temp2 91)
	)
)

(procedure (proc1111_32)
	(if (not (prefFile scratch:))
		(prefFile init:)
	)
	(if (prefFile open: 2)
		(prefFile writeWord: global177)
		(prefFile writeWord: global176)
		(prefFile writeString: (gCurSaveDir data:))
		(prefFile close:)
	)
)

(procedure (proc1111_33 &tmp temp0)
	(if (not (prefFile scratch:))
		(prefFile init:)
	)
	(if (prefFile open: 1)
		(= temp0 (Str newWith: 2 {}))
		(prefFile read: temp0 2)
		(= global177 (proc1111_22 temp0 0))
		(temp0 dispose:)
		(= temp0 (Str newWith: 2 {}))
		(prefFile read: temp0 2)
		(= global176 (proc1111_22 temp0 0))
		(temp0 dispose:)
		(= gCurSaveDir (Str newWith: 128 {}))
		(prefFile readString: gCurSaveDir 128)
		(prefFile close:)
	)
)

(instance prefFile of File
	(properties)

	(method (init &tmp temp0)
		(= temp0 (Str with: global126))
		(temp0 cat: {PREF.DAT})
		(= name (KArray 8 (temp0 data:))) ; ArrayDup
		(= scratch 1)
		(temp0 dispose:)
	)

	(method (dispose)
		(KArray 4 name) ; ArrayFree
		(= name 0)
		(super dispose: &rest)
	)
)

