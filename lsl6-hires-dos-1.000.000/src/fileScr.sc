;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Plane)
(use Print)
(use Sound)
(use Motion)
(use System)

(public
	IsFlag 0
	SetFlag 1
	ClearFlag 2
	Face 3
	proc79_4 4
	proc79_5 5
	proc79_6 6
	proc79_7 7
	proc79_8 8
	proc79_11 11
	proc79_12 12
	fileScr 13
	proc79_14 14
)

(local
	local0
)

(procedure (IsFlag param1)
	(gFlags test: param1)
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(gFlags set: param1)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(gFlags clear: param1)
	(return temp0)
)

(procedure (Face param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(= temp1 (param2 x:))
	(= temp2 (param2 y:))
	(if (== argc 3)
		(= temp3 param3)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (if temp3 temp3 else 0))
)

(procedure (proc79_4 param1 param2 param3 param4 param5 param6 param7 &tmp temp0)
	(= temp0 (Plane picture:))
	(Plane picture: -2)
	(dispText
		fore: param2
		back: param3
		font: param7
		skip: -1
		modeless: 2
		posn: param4 param5
		width: param6
		addText: param1
		font: param7
		plane: Plane
		init:
	)
	(Plane picture: temp0)
	(FrameOut)
)

(procedure (proc79_6 param1)
	(if (!= global205 param1)
		(= global205 param1)
		(if (not global206)
			(gTalkerPlane
				addCast:
					(= global206
						((gCast new:) name: {curTalkerCast} init: yourself:)
					)
			)
		)
		(UpdateScreenItem
			((ScriptID 92 1) view: param1 setPri: 200 init: global206 yourself:) ; curTalkerbust
		)
	)
)

(procedure (proc79_7)
	(= global205 0)
	(global206 dispose:)
	(= global206 0)
)

(procedure (proc79_5)
	(if (dispText dialog:)
		((dispText dialog:) dispose:)
	)
)

(procedure (proc79_8 param1)
	(switch param1
		(2
			(if (!= gCurRoomNum 210)
				(proc79_6 1210)
			)
		)
		(18
			(proc79_6 1311)
		)
		(27
			(proc79_6 1311)
		)
		(16
			(proc79_6 1810)
		)
		(20
			(proc79_6 1242)
		)
		(17
			(proc79_6 1230)
		)
		(6
			(cond
				((== gCurRoomNum 370)
					(proc79_6 1521)
				)
				((!= gCurRoomNum 520)
					(proc79_6 1520)
				)
			)
		)
		(3
			(cond
				((== gCurRoomNum 370)
					(proc79_6 1461)
				)
				((not (gCurRoom inset:))
					(proc79_6 1460)
				)
			)
		)
		(12
			(if (!= gCurRoomNum 410)
				(proc79_6 1410)
			)
		)
		(15
			(proc79_6 1241)
		)
		(9
			(proc79_6 1592)
		)
		(23
			(proc79_6 1619)
		)
		(13
			(if (!= gCurRoomNum 250)
				(proc79_6 1250)
			)
		)
		(21
			(if (!= gCurRoomNum 390)
				(proc79_6 1390)
			)
		)
		(10
			(cond
				((== gCurRoomNum 590))
				((== gCurRoomNum 860)
					(proc79_6 1590)
				)
				(else
					(proc79_6 1591)
				)
			)
		)
		(25
			(proc79_6 1146)
		)
		(22
			(proc79_6 1513)
		)
		(11
			(cond
				((IsFlag 92)
					(proc79_6 1431)
				)
				((== gCurRoomNum 420)
					(proc79_6 1432)
				)
				((!= gCurRoomNum 430)
					(proc79_6 1430)
				)
			)
		)
		(24
			(proc79_6 1144)
		)
	)
	(= global178 (Random 30 120))
)

(procedure (proc79_14)
	(return
		(or
			(gEgo edgeHit:)
			(gEgo mover:)
			(gTalkers size:)
			(gCurRoom script:)
			(gEgo script:)
			(!= (gEgo view:) 900)
			(not (gUser controls:))
			(gGame isHandsOff:)
			(gGame script:)
			(Print dialog:)
			(not (gUser input:))
		)
	)
)

(procedure (proc79_12 param1 &tmp temp0 temp1)
	(for ((= temp1 0)) (<= temp1 20) ((++ temp1))
		(for ((= temp0 0)) (<= temp0 (- argc 1)) ((++ temp0))
			(if
				(and
					(> [global237 temp1] 0)
					(== [param1 temp0] [global237 temp1])
				)
				(cond
					((== [global216 temp1] 140)
						(Lock [global216 temp1] [global237 temp1] 0)
						(if (== global100 120)
							(Palette 2 0 255 100) ; PalIntensity
							(Printf
								{DumpFx: dumping element %d type RES WAVE sound %d}
								temp1
								[global237 temp1]
							)
						)
					)
					((== [global216 temp1] 141)
						(Lock [global216 temp1] [global237 temp1] 0)
						(if (== global100 120)
							(Palette 2 0 255 100) ; PalIntensity
							(Printf
								{DumpFx: dumping element %d type RES AUDIO sound %d}
								temp1
								[global237 temp1]
							)
						)
					)
					((and (== [global216 temp1] 132) (== global100 120))
						(Palette 2 0 255 100) ; PalIntensity
						(Printf
							{DumpFx: dumping element %d type RES SOUND sound %d}
							temp1
							[global237 temp1]
						)
					)
				)
				(UnLoad [global216 temp1] [global237 temp1])
				(= [global216 temp1] 0)
				(= [global237 temp1] 0)
				(= [param1 temp0] 0)
			)
		)
	)
)

(procedure (proc79_11 param1 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 (- argc 1)) ((++ temp0))
		(= [global237 temp0] [param1 temp0])
		(cond
			((ResCheck 140 [global237 temp0]) ; WAVE
				(if (== global100 120)
					(Printf
						{element %d sound %d is type RES WAVE}
						temp0
						[global237 temp0]
					)
				)
				(= [global216 temp0] 140)
				(Load [global216 temp0] [global237 temp0])
				(Lock [global216 temp0] [global237 temp0] 1)
			)
			((ResCheck rsAUDIO [global237 temp0])
				(if (== global100 120)
					(Printf
						{element %d sound %d is type RES AUDIO}
						temp0
						[global237 temp0]
					)
				)
				(= [global216 temp0] 141)
				(Load [global216 temp0] [global237 temp0])
				(Lock [global216 temp0] [global237 temp0] 1)
			)
			((ResCheck rsSOUND [global237 temp0])
				(if (== global100 120)
					(Printf
						{element %d sound %d is type RES SOUND}
						temp0
						[global237 temp0]
					)
				)
				(= [global216 temp0] 132)
				(Load [global216 temp0] [global237 temp0])
			)
			((== global100 120)
				(Printf
					{element %d sound %d is type ?!}
					temp0
					[global237 temp0]
				)
				(SetDebug)
			)
		)
	)
)

(instance dispText of Print
	(properties
		doBorder 0
	)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance fileScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 87
					setLoop: 0 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(Message msgGET 85 5 0 14 1 (global186 data:)) ; "Bastard File"
				(gMessager say: 5 4 0 0 self 85) ; "You carefully use your little bastard to round off your one rough fingernail and thus, avoid a visit to the spa's sadistic manicurist."
			)
			(4
				(if (> gHowFast 3)
					(= temp0 4)
				else
					(= temp0 2)
				)
				(gEgo setLoop: 1 1 cel: 0 cycleSpeed: temp0)
				((= local0 (Sound new:)) number: 37 loop: 1)
				(= register 12)
				(= cycles 2)
			)
			(5
				(local0 play:)
				(gEgo setCycle: End self)
			)
			(6
				(if (-- register)
					(-= state 2)
				)
				(gEgo setCycle: Beg self)
			)
			(7
				(local0 dispose:)
				(= local0 0)
				(gEgo normalize: 900 6 1 setHeading: 180 self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

