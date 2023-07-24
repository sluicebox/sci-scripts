;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64896)
(include sci.sh)
(use Main)
(use TPSound)
(use DialogPlane)
(use Str)
(use Array)
(use Actor)
(use System)

(public
	Face 0
	proc64896_1 1
	soFade 2
	GetTextWidth 3
	GetTextHeight 4
	MakeMessageText 5
	IsStringObject 6
	proc64896_7 7
	proc64896_8 8
	proc64896_9 9
	GetNumMessages 10
	GetRandomNumber 11
	proc64896_12 12
	proc64896_13 13
	GetNumCases 14
	proc64896_15 15
	FadeTo 16
	proc64896_17 17
	CopyWinningWallpaper 18
	proc64896_19 19
	proc64896_20 20
	proc64896_21 21
	proc64896_22 22
	ShowEasterEgg 23
)

(local
	local0 = 1
	local1
	local2
	local3 = 1
)

(procedure (GetRandomNumber param1 param2)
	(if (== param1 param2)
		(return param1)
	)
	(return (Random param1 param2))
)

(procedure (proc64896_8 param1 param2 &tmp temp0 temp1) ; UNUSED
	(= temp1 (Max 0 (- argc 1)))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(if (not (ResCheck param1 [param2 temp0]))
		else
			(Load param1 [param2 temp0])
			(Lock param1 [param2 temp0] 1)
		)
	)
)

(procedure (proc64896_9 param1 param2 &tmp temp0 temp1) ; UNUSED
	(= temp1 (Max 0 (- argc 1)))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(if (not (ResCheck param1 [param2 temp0]))
		else
			(Lock param1 [param2 temp0] 0)
			(UnLoad param1 [param2 temp0])
		)
	)
)

(procedure (IsStringObject param1)
	(if (not param1)
		(return 0)
	)
	(if (== param1 (KArray 9 param1)) ; ArrayGetData
		(return 0)
	else
		(return 1)
	)
)

(procedure (proc64896_7 param1)
	(if param1
		(if (IsStringObject param1)
			(param1 dispose:)
		else
			(KArray 4 param1) ; ArrayFree
		)
	)
)

(procedure (GetTextWidth param1 param2 param3 &tmp temp0 temp1)
	(if (< argc 3)
		(return 0)
	)
	(= temp0 (IntArray new: 4))
	(Text 0 (temp0 data:) (KArray 9 param1) param2 param3 1) ; TextSize, ArrayGetData
	(= temp1 (+ (temp0 at: 2) 1))
	(temp0 dispose:)
	(return temp1)
)

(procedure (GetTextHeight param1 param2 param3 &tmp temp0 temp1)
	(if (< argc 3)
		(return 0)
	)
	(= temp0 (IntArray new: 4))
	(Text 0 (temp0 data:) (KArray 9 param1) param2 param3 1) ; TextSize, ArrayGetData
	(= temp1 (+ (temp0 at: 3) 1))
	(temp0 dispose:)
	(return temp1)
)

(procedure (MakeMessageText param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(if (< argc 1)
		(= temp1 0)
	else
		(= temp1 param1)
	)
	(if (< argc 2)
		(= temp2 0)
	else
		(= temp2 param2)
	)
	(if (< argc 3)
		(= temp3 0)
	else
		(= temp3 param3)
	)
	(if (< argc 4)
		(= temp4 1)
	else
		(= temp4 param4)
	)
	(if (< argc 5)
		(= temp5 gCurRoomNum)
	else
		(= temp5 param5)
	)
	(if (< argc 6)
		(= temp0 0)
	else
		(= temp0 param6)
	)
	(if (not (Message msgGET temp5 temp1 temp2 temp3 temp4))
		(not temp0)
		(return 0)
	)
	(= temp6 (Str newWith: 4000 {}))
	(Message msgGET temp5 temp1 temp2 temp3 temp4 (temp6 data:))
	(return temp6)
)

(procedure (GetNumMessages param1 param2 param3 param4 &tmp temp0)
	(< argc 4)
	(for
		((= temp0 1))
		(Message msgGET param1 param2 param3 param4 temp0)
		((++ temp0))
	)
	(return (- temp0 1))
)

(procedure (GetNumCases param1 param2 param3 &tmp temp0)
	(< argc 3)
	(for ((= temp0 1)) (Message msgGET param1 param2 param3 temp0 1) ((++ temp0))
	)
	(return (- temp0 1))
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (not (> argc 3))
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 temp3)
)

(procedure (FadeTo param1 param2 param3 &tmp temp0)
	(if (< argc 1)
		(return)
	)
	(if (or (< argc 2) (== param2 0))
		(= local0 1)
	else
		(= local0 param2)
	)
	(if (> argc 2)
		(= temp0 param3)
	else
		(= temp0 0)
	)
	(if (< (= local1 param1) local2)
		(poNull setScript: soFadeOut temp0)
	else
		(poNull setScript: soFadeIn temp0)
	)
)

(procedure (proc64896_17 param1)
	(= local2 param1)
	(Palette 2 0 255 local2) ; PalIntensity
)

(procedure (proc64896_1 param1 param2 param3 &tmp [temp0 3] temp3)
	(if (or (< argc 2) (== param2 0))
		(= local0 1)
	else
		(= local0 param2)
	)
	(if (> argc 2)
		(= temp3 param3)
	else
		(= temp3 0)
	)
	(if (or (== argc 0) (== param1 1))
		(= local1 0)
		(= local2 100)
		(poNull setScript: soFadeOut temp3)
	else
		(= local1 100)
		(= local2 0)
		(poNull setScript: soFadeIn temp3)
	)
)

(procedure (proc64896_12 param1 &tmp temp0 temp1 temp2)
	(if (or (not gCuees) (not (gCuees size:)))
		(return)
	)
	(= temp0 (gCuees size:))
	(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
		(= temp2 (gCuees at: temp1))
		(if (and (temp2 respondsTo: #cuee) (== (temp2 cuee:) param1))
			(gCuees delete: temp2)
			(temp2 dispose:)
			(-- temp1)
			(-- temp0)
			(if (not (gCuees size:))
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
	)
)

(procedure (proc64896_13)
	(if (or (not gCuees) (not (gCuees size:)))
		(return)
	)
	(gCuees dispose:)
	(= gCuees 0)
)

(procedure (proc64896_15 param1 param2)
	(if (not (<= 1 param1 9))
		(return)
	)
	(if (poSniffCard plane:)
		(poSniffCard dispose:)
	)
	(if (> argc 1)
		(= local3 param2)
	else
		(= local3 1)
	)
	(poSniffCard cel: param1 init:)
)

(procedure (CopyWinningWallpaper param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(switch param1
		(0
			(= temp0 (Str with: {memory1.drv}))
			(= temp1 (Str with: {VICKY.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(1
			(= temp0 (Str with: {memory2.drv}))
			(= temp1 (Str with: {JAMIELEE.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(2
			(= temp0 (Str with: {memory3.drv}))
			(= temp1 (Str with: {DREW.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(3
			(= temp0 (Str with: {memory4.drv}))
			(= temp1 (Str with: {DEWMI.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(4
			(= temp0 (Str with: {memory5.drv}))
			(= temp1 (Str with: {JUGGS.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(5
			(= temp0 (Str with: {memory6.drv}))
			(= temp1 (Str with: {ANNETTE.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(6
			(= temp0 (Str with: {memory7.drv}))
			(= temp1 (Str with: {THYGH.PICT}))
			(= global235 1)
			(= global236 (Str with: temp1))
		)
		(7
			(= temp0 (Str with: {memory8.drv}))
			(= temp1 (Str with: {DILDO.PICT}))
			(= global235 0)
		)
		(else
			(return)
		)
	)
	(= temp2 (Str format: {%sdrivers:%s} gCurSaveDir (temp0 data:)))
	(if (FileIO fiEXISTS (KArray 9 temp2)) ; ArrayGetData
		(= temp3 (Str format: {%s%s} gCurSaveDir (temp1 data:)))
		(FileIO 12 (temp2 data:) (temp3 data:)) ; Copy
		(temp3 dispose:)
		(if (not global235)
			(= temp4 (MakeMessageText 0 0 71 1 14))
			(= temp5 (Str format: temp4 (temp1 data:)))
			(TextDialog temp5 (Str with: global288))
			(temp4 dispose:)
		)
	else
		(= global235 0)
		(if global236
			(global236 dispose:)
			(= global236 0)
		)
	)
	(temp2 dispose:)
	(temp0 dispose:)
	(temp1 dispose:)
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp1 (+ (= temp0 (/ (= param1 (mod param1 7200)) 20)) 1))
	(= temp2 (- param1 (* temp0 20)))
	(= temp3 (SinMult temp0 param2))
	(= temp5 (- (= temp4 (SinMult temp1 param2)) temp3))
	(= temp6 (+ temp3 (MulDiv temp5 (+ temp2 (/ 20 (+ (Abs temp5) 1))) 20)))
	(Min param2 (Max (- 0 param2) temp6))
)

(procedure (proc64896_19 &tmp temp0)
	(if global267
		(return 0)
	)
	(= temp0 (Str format: {%s%s} gCurSaveDir {1.bmp}))
	(if (FileIO fiEXISTS (KArray 9 temp0)) ; ArrayGetData
		(temp0 dispose:)
		(return 1)
	else
		(= temp0 (Str format: {%s%s} gCurSaveDir {1.PICT}))
		(if (FileIO fiEXISTS (KArray 9 temp0)) ; ArrayGetData
			(temp0 dispose:)
			(return 1)
		else
			(temp0 dispose:)
			(return 0)
		)
	)
)

(procedure (proc64896_20 param1 param2 &tmp temp0 temp1)
	(= temp0 (Str format: {%s%s} gCurSaveDir {1.bmp}))
	(= temp1 (Bitmap 14 (temp0 data:) param1 param2 0 48 88)) ; LoadBMP
)

(procedure (proc64896_21 param1 &tmp temp0)
	(= temp0 (Str format: {%s%d.wav} gCurSaveDir param1))
	(if (FileIO fiEXISTS (KArray 9 temp0)) ; ArrayGetData
		(temp0 dispose:)
		(return 1)
	else
		(= temp0 (Str format: {%s%d.snd} gCurSaveDir param1))
		(if (FileIO fiEXISTS (KArray 9 temp0)) ; ArrayGetData
			(temp0 dispose:)
			(return 1)
		else
			(temp0 dispose:)
			(return 0)
		)
	)
)

(procedure (proc64896_22 &tmp temp0)
	(= temp0 0)
	(if ((ScriptID 64017 0) test: 45) ; oFlags
		(++ temp0)
	)
	(if ((ScriptID 64017 0) test: 89) ; oFlags
		(++ temp0)
	)
	(if ((ScriptID 64017 0) test: 103) ; oFlags
		(++ temp0)
	)
	(if ((ScriptID 64017 0) test: 113) ; oFlags
		(++ temp0)
	)
	(if ((ScriptID 64017 0) test: 115) ; oFlags
		(++ temp0)
	)
	(if ((ScriptID 64017 0) test: 127) ; oFlags
		(++ temp0)
	)
	(return temp0)
)

(procedure (ShowEasterEgg param1)
	(if (poEgg plane:)
		(poEgg dispose:)
	)
	(if (and argc param1)
		(poEgg x: 624)
	else
		(poEgg x: 17)
	)
	(poEgg init:)
)

(instance soFade of Script
	(properties)
)

(instance poNull of Prop
	(properties)
)

(instance soFadeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheDoits add: self)
				(self cue:)
			)
			(1
				(= local2 (Max local1 (- local2 local0)))
				(Palette 2 0 255 local2) ; PalIntensity
				(if (!= local2 local1)
					(= ticks 5)
					(-- state)
				else
					(= cycles 2)
				)
			)
			(2
				(gTheDoits delete: self)
				(self dispose:)
			)
		)
	)
)

(instance soFadeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheDoits add: self)
				(self cue:)
			)
			(1
				(= local2 (Min local1 (+ local2 local0)))
				(Palette 2 0 255 local2) ; PalIntensity
				(if (!= local2 local1)
					(= ticks 5)
					(-- state)
				else
					(= cycles 2)
				)
			)
			(2
				(gTheDoits delete: self)
				(self dispose:)
			)
		)
	)
)

(instance poSniffCard of Prop
	(properties
		x 545
		y 385
		priority 600
		fixPriority 1
		view 7500
	)

	(method (init)
		(super init: &rest)
		(self setScript: soFlashCyberSniff)
	)
)

(instance oCyberSound of TPSound
	(properties)
)

(class soFlashCyberSniff of Script
	(properties
		nFlashes 20
		nClientCel 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= nFlashes 20)
				(= nClientCel (poSniffCard cel:))
				(if local3
					(oCyberSound playSound: 101)
				)
				(= cycles 1)
			)
			(1
				(poSniffCard cel: 0)
				(= ticks 6)
			)
			(2
				(poSniffCard cel: nClientCel)
				(= ticks 12)
			)
			(3
				(-- nFlashes)
				(if nFlashes
					(-= state 3)
				)
				(= cycles 1)
			)
			(4
				(poSniffCard hide: dispose:)
			)
		)
	)
)

(instance soXXXFlashCyberSniff of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 register)
				(= register (IntArray with: temp0 (temp0 cel:) 20 0))
				(register at: 3 (TPSound new:))
				((register at: 3) type: 0 playSound: 101)
				(= cycles 1)
			)
			(1
				((register at: 0) cel: 0)
				(= ticks 6)
			)
			(2
				((register at: 0) cel: (register at: 1))
				(= ticks 12)
			)
			(3
				(register at: 2 (- (register at: 2) 1))
				(if (< (register at: 2) 1)
					(= cycles 1)
				else
					(-= state 3)
					(= cycles 1)
				)
			)
			(4
				((register at: 0) dispose:)
				((register at: 3) dispose:)
			)
		)
	)
)

(class OceanMotionSin of Script
	(properties
		nCenterY 240
		nRange 20
		nStep 9
		nTime 3
		nAngle 0
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(!=
						(= temp0
							(+
								nCenterY
								(MulDiv
									(+
										(localproc_0 (* nAngle 3) 97)
										(localproc_0 (* nAngle 5) 134)
									)
									nRange
									231
								)
							)
						)
						(client y:)
					)
					(client y: temp0)
					(UpdateScreenItem client)
				)
				(+= nAngle nStep)
				(= nAngle (mod nAngle 7200))
				(if global212
					(-- state)
					(= ticks nTime)
				else
					(= cycles 1)
				)
			)
			(1
				(if (not global212)
					(-- state)
				else
					(-= state 2)
				)
				(= ticks 60)
			)
		)
	)
)

(instance poEgg of Prop
	(properties
		x 17
		y 21
		priority 600
		fixPriority 1
		view 7069
	)

	(method (init)
		(super init: &rest)
		(self setScript: soFlashEgg)
	)
)

(instance soFlashEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (= register 12))
			)
			(1
				(poEgg hide:)
				(= ticks 6)
			)
			(2
				(poEgg show:)
				(= ticks 12)
			)
			(3
				(if (-- register)
					(-= state 3)
				)
				(= cycles 1)
			)
			(4
				(poEgg hide: dispose:)
			)
		)
	)
)

