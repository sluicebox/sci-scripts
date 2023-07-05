;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use PChase)
(use CDActor)
(use IconBar)
(use PolyPath)
(use MoveFwd)
(use StopWalk)
(use SmoothLooper)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	goGet 0
	donkLooper 1
)

(local
	local0
	local1
	local2
	local3
	[local4 40] = [1 8 2 -32 0 2 3 4 0 16 3 3 4 0 -16 1 8 2 -32 0 0 8 2 32 0 3 3 4 0 -16 2 3 4 0 16 0 8 2 32 0]
	local44
	local45
	local46
	local47
	local48
	local49
	local50
	local51
)

(class InvView of View
	(properties
		client 0
	)

	(method (init)
		(super init:)
		(&= signal $feff)
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			(local44
				(if (>= (gEgo distanceTo: self) 45)
					(= local44 0)
				)
			)
			((<= (gEgo distanceTo: self) 35)
				(gCurRoom setScript: goGet 0 client)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: goGet 0 client)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class InvPossesion of InvI
	(properties
		regView 0
	)

	(method (posn param1 param2)
		(regView posn: param1 param2)
	)

	(method (dispose)
		(gInventory delete: self)
		(gTheIconBar curInvIcon: (proc10_17 InvPossesion) show:)
	)

	(method (regViewDisp)
		(regView dispose:)
	)

	(method (init)
		(super init:)
		(regView ignoreActors: 0 init:)
	)

	(method (setRegView param1)
		(self regView: param1)
		(regView client: self)
	)
)

(class InvActor of Tactor
	(properties)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)
)

(class InvFriend of InvI
	(properties
		regActor 0
	)

	(method (posn param1 param2)
		(regActor posn: param1 param2)
	)

	(method (regActorDisp)
		(regActor dispose:)
	)

	(method (init)
		(super init:)
		(regActor ignoreActors: 0 init:)
	)

	(method (dispose)
		(gInventory delete: self)
	)

	(method (setRegActor param1)
		(self regActor: param1)
		(regActor client: self)
	)
)

(class FRoom of Rm
	(properties
		invX 0
		invY 0
		friendX 0
		friendY 0
		northX 0
		northY 0
		southX 0
		southY 0
		eastX 0
		eastY 0
		westX 0
		westY 0
		enterWithFriend 1
		defeatEntrance 0
	)

	(method (init &tmp temp0 temp1)
		(self enter:)
		(super init:)
		(proc10_27)
		(if (= temp0 (proc10_16 InvPossesion))
			(temp0 posn: (gCurRoom invX:) (gCurRoom invY:) init:)
			((temp0 regView:) ignoreActors: 1)
		)
	)

	(method (reflectPosn)
		(if (not defeatEntrance)
			(super reflectPosn: &rest)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		else
			(super doit:)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 2) lookStr) ; Look
			(proc10_23 lookStr)
			(return 1)
		else
			(return 0)
		)
	)

	(method (enter)
		(if (not defeatEntrance)
			(= local46 (proc10_17 InvFriend))
			(if (IsFlag 4)
				(self setScript: enterRM self 0)
				(ClearFlag 4)
			else
				(self setScript: enterRM self (self roomToEdge: gPrevRoomNum))
				(ClearFlag 4)
			)
		else
			(self enterSpecial:)
			(ClearFlag 4)
		)
	)

	(method (enterSpecial))
)

(class HandsOffScript of Script
	(properties)

	(method (init)
		(HandsOff)
		(super init: &rest)
	)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)
)

(instance goGet of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local44 1)
				(= cycles 1)
			)
			(1
				(if (== gCurRoomNum 290)
					(self setScript: roseGet self register)
				else
					(self setScript: genericGet self register)
				)
			)
			(2
				(gTheIconBar curInvIcon: (proc10_17 InvPossesion) show:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance roseGet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 277 62 self)
			)
			(1
				(gGlobalSoundEffect number: 113 setLoop: 1 flags: 1 play:)
				(if (= local45 (proc10_17 InvPossesion))
					(local45 moveTo: gCurRoomNum)
					(local45 posn: (gCurRoom invX:) (gCurRoom invY:) init:)
				)
				(register moveTo: gEgo)
				(register regViewDisp:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance genericGet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local45 (proc10_16 InvPossesion))
				((local45 regView:) ignoreActors: 1)
				(if (> (gEgo x:) (gCurRoom invX:))
					(= local51 10)
				else
					(= local51 -10)
				)
				(gEgo
					setMotion:
						PolyPath
						(+ (gCurRoom invX:) local51)
						(gCurRoom invY:)
						self
				)
			)
			(1
				(gEgo
					view: (+ 70 global139)
					cel: 0
					loop: (< (gEgo x:) (gCurRoom invX:))
					normal: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(gGlobalSoundEffect number: 113 setLoop: 1 flags: 1 play:)
				(if (= local45 (proc10_17 InvPossesion))
					(local45 moveTo: gCurRoomNum)
					(local45 posn: (gCurRoom invX:) (gCurRoom invY:) init:)
					((local45 regView:) ignoreActors: 0)
				)
				(register moveTo: gEgo)
				(register regViewDisp:)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normal: 1)
				(NormalEgo 5 global139)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance enterRM of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch register
					(1
						(= local47 (gCurRoom northX:))
						(= local48
							(if (gCurRoom horizon:)
								(gCurRoom horizon:)
							else
								(gCurRoom northY:)
							)
						)
						(gEgo setHeading: 180)
						(= local50 5)
					)
					(3
						(= local47 (gCurRoom southX:))
						(= local48 (gCurRoom southY:))
						(gEgo setHeading: 0)
						(= local50 20)
					)
					(2
						(= local47 (gCurRoom eastX:))
						(= local48 (gCurRoom eastY:))
						(gEgo setHeading: 270)
						(= local50 50)
					)
					(4
						(= local47 (gCurRoom westX:))
						(= local48 (gCurRoom westY:))
						(gEgo setHeading: 90)
						(= local50 50)
					)
					(0
						(= local47 160)
						(= local48 160)
					)
				)
				(NormalEgo 5 global139)
				(= cycles 1)
			)
			(1
				(gEgo
					posn: local47 local48
					normal: 1
					init:
					setMotion: MoveFwd local50 self
				)
				(gCast delete: gEgo addToFront: gEgo)
			)
			(2
				(if (not local46)
					(self changeState: (+= state 2))
				else
					(switch register
						(1
							(local46 posn: local47 (- local48 20) init:)
							(= temp0 1)
							((local46 regActor:) setHeading: 180)
						)
						(3
							(local46 posn: local47 (+ local48 20) init:)
							(= temp0 5)
							((local46 regActor:) setHeading: 0)
						)
						(2
							(local46 posn: (+ local47 20) local48 init:)
							(= temp0 35)
							((local46 regActor:) setHeading: 270)
						)
						(4
							(local46 posn: (- local47 20) local48 init:)
							(= temp0 35)
							((local46 regActor:) setHeading: 90)
						)
						(0
							(local46 posn: 170 160 init:)
						)
					)
					((local46 regActor:)
						setCycle: StopWalk
						setMotion: MoveFwd temp0 self
					)
					(if ((local46 regActor:) isKindOf: CDActor)
						(gCast delete: ((local46 regActor:) head:))
					)
					(gCast delete: (local46 regActor:))
					(gCast delete: gEgo)
					(gCast delete: (gEgo head:))
					(if ((local46 regActor:) isKindOf: CDActor)
						(gCast addToFront: ((local46 regActor:) head:))
					)
					(gCast addToFront: (local46 regActor:))
					(gCast addToFront: (gEgo head:))
					(gCast addToFront: gEgo)
				)
			)
			(3
				(cond
					((== (gBremenStory state:) 5)
						((local46 regActor:) setMotion: NPFolDog gEgo 40)
					)
					((== (gBremenStory state:) 1)
						((local46 regActor:)
							lookStr: {You see a rooster.}
							description: {Rooster}
							setMotion: NPFolRoos gEgo 40
						)
					)
					((== (gBremenStory state:) 7)
						((local46 regActor:)
							setLoop: donkLooper
							setMotion: NPFollow gEgo 40
						)
					)
					(else
						((local46 regActor:) setMotion: NPFollow gEgo 40)
					)
				)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(class CodeIcon of IconI
	(properties
		signal 129
		highlightColor 255
		value 0
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& signal $0020))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 nsTop)
		(= temp1 nsLeft)
		(= temp2 (- nsBottom 1))
		(= temp3 (- nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
	)

	(method (mask)
		(DrawCel maskView maskLoop maskCel nsLeft nsTop -1)
	)
)

(class TextIcon of IconI
	(properties
		signal 129
		highlightColor 7
		lowlightColor 3
		value 0
		text 0
		textColor 50
	)

	(method (show)
		(super show: &rest)
		(proc10_21 text textColor (+ nsLeft 3) (+ nsTop 4))
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(= temp2 1)
		(if (and argc param1 (& signal $0001))
			(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
			(proc10_21 text (- textColor 2) (+ nsLeft 3) (+ nsTop 4))
			(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
				(temp0 localize:)
				(cond
					((self onMe: temp0)
						(if (not temp1)
							(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
							(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							(proc10_21
								text
								(- textColor 2)
								(+ nsLeft 3)
								(+ nsTop 4)
							)
						)
					)
					(temp1
						(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
						(proc10_21 text textColor (+ nsLeft 3) (+ nsTop 4))
					)
				)
				(temp0 dispose:)
			)
			(temp0 dispose:)
			(if (== temp1 1)
				(DrawCel view loop 0 nsLeft nsTop -1)
				(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
				(proc10_21 text textColor (+ nsLeft 3) (+ nsTop 4))
			)
			(= temp2 temp1)
		)
		(return temp2)
	)
)

(class NPFollow of PFollow
	(properties
		hDist 0
		vDist 0
		initDist 0
	)

	(method (init)
		(super init: &rest)
		(if (== initDist 0)
			(= initDist distance)
		)
		(= vDist (/ (* initDist 2) 3))
		(= hDist initDist)
	)

	(method (doit &tmp temp0)
		(if
			(or
				(>= (= temp0 (gEgo heading:)) 315)
				(<= temp0 45)
				(and (>= temp0 135) (<= temp0 225))
			)
			(= distance vDist)
		else
			(= distance hDist)
		)
		(super doit: &rest)
	)
)

(class NPFolDog of NPFollow
	(properties)

	(method (init)
		(super init: &rest)
		(= local2 (Random 60 100))
	)

	(method (doit)
		(super doit:)
		(if (and (not (gEgo mover:)) (not (client script:)))
			(= local0 (GetTime 1)) ; SysTime12
			(if (!= local1 local0)
				(= local0 local1)
				(if (not (-- local2))
					(= local2 (Random 40 70))
					(if (<= (gEgo distanceTo: client) 40)
						(client setScript: dogJump 0 client)
					)
				)
			)
		)
	)
)

(instance dogJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3
					(/
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(register x:)
							(register y:)
						)
						45
					)
				)
				(register
					view: 648
					setLoop: [local4 (+ (* local3 5) 0)]
					setCel: 0
					xStep: [local4 (+ (* local3 5) 1)]
					yStep: [local4 (+ (* local3 5) 2)]
					normal: 0
					setCycle: Fwd
					setMotion:
						PolyPath
						(+ (register x:) [local4 (+ (* local3 5) 3)])
						(+ (register y:) [local4 (+ (* local3 5) 4)])
						self
				)
			)
			(1
				(register
					view: 647
					cycleSpeed: 8
					moveSpeed: 8
					setLoop: -1
					normal: 1
					setCycle: StopWalk
					setMotion: NPFolDog gEgo 40
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(class NPFolRoos of NPFollow
	(properties)

	(method (init)
		(super init: &rest)
		(= local2 (Random 60 100))
	)

	(method (doit)
		(super doit:)
		(if (and (not (gEgo mover:)) (not (gCurRoom script:)))
			(= local0 (GetTime 1)) ; SysTime12
			(if (!= local1 local0)
				(= local0 local1)
				(if (not (-- local2))
					(= local2 (Random 40 70))
					(if (<= (gEgo distanceTo: client) 40)
						(gCurRoom setScript: roosPeck 0 client)
					)
				)
			)
		)
	)
)

(instance roosPeck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register setCel: 0 setLoop: (Random 4 7) setCycle: End self)
			)
			(1
				(register
					setLoop: -1
					setCycle: StopWalk
					setMotion: NPFolRoos gEgo 40
				)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance donkLooper of SmoothLooper
	(properties
		cycleSpeed 6
		vChangeDir 633
	)

	(method (init)
		(super init: &rest)
		(= inProgress (= oldCycler (= oldMover 0)))
	)

	(method (doit)
		(super doit: &rest)
		(if (= local46 (proc10_17 InvFriend))
			(= local46 (local46 regActor:))
		else
			(= local46 client)
		)
		(cond
			((and inProgress (local46 normal:))
				(local46 normal: 0)
			)
			((and (not inProgress) (not (local46 normal:)))
				(local46 normal: 1)
			)
		)
	)

	(method (cue)
		(if (< nextLoop 15)
			(client normal: 1)
		)
		(super cue: &rest)
	)
)

