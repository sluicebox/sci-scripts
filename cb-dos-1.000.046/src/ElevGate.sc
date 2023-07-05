;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)

(procedure (localproc_0 param1)
	(Printf 201 16 param1) ; "You firmly %s the handle, but the darn elevator won't move!"
)

(procedure (localproc_1)
	(Print 201 3) ; "Why don't you enter the elevator first?"
)

(procedure (localproc_2 param1)
	(Printf 201 17 param1) ; "The elevator seems to be %sstairs."
)

(procedure (localproc_3 param1)
	(Printf 201 18 param1) ; "You %s in the elevator."
)

(procedure (localproc_4 param1 param2)
	(gCast eachElementDo: #hide)
	(param1 show:)
	(param2 show:)
	(DrawPic 66 7)
	(Print 201 19 #at 120 32) ; "There is a handle on the elevator control. On the face of the control are a keyhole and the words: "up" and "down.""
	(DrawPic gCurRoomNum 6)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(param1 hide:)
	(param2 hide:)
	(gEgo hide:)
)

(class ElevGate of Prop
	(properties
		chainID 0
		elevatorID 0
		downID 0
		upID 0
		msgID 0
		gateStMask 0
		gateX 283
		gateY 125
		elevX 296
		elevY 125
		chainY 0
		upRoomNo 0
		downRoomNo 0
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(= global110 -1)
		(switch gCurRoomNum
			(32
				(= gateStMask 1)
				(= upRoomNo 42)
				(= downRoomNo -1)
			)
			(42
				(= gateStMask 2)
				(= elevY (= gateY 126))
				(= upRoomNo 75)
				(= downRoomNo 32)
			)
			(75
				(= gateStMask 4)
				(= gateX 39)
				(= gateY 112)
				(= elevX 52)
				(= elevY 112)
				(= upRoomNo -1)
				(= downRoomNo 42)
			)
		)
		(= chainY (- elevY 59))
		(self view: 242 loop: 2 posn: gateX gateY stopUpd:)
		(= cel
			(if
				(and
					(& gElevatorState gateStMask)
					(not (& gElevatorState $0010))
					(!= global111 gCurRoomNum)
				)
				(self lastCel:)
			else
				(&= gElevatorState (~ gateStMask))
				0
			)
		)
		(elevatorID view: 242 setPri: 6 ignoreActors: 1 illegalBits: 0)
		(gEgo init:)
		(if (== (& global111 $7fff) gCurRoomNum)
			(elevatorID x: elevX)
			(downID
				view: 166
				loop: 0
				cel: 0
				x: 72
				y: 177
				ignoreActors: 1
				init:
				hide:
			)
			(upID
				view: 166
				loop: 0
				cel: 1
				x: 139
				y: 151
				ignoreActors: 1
				init:
				hide:
			)
			(= temp0 0)
			(if (== global111 gCurRoomNum)
				(Load rsPIC 66)
				(LoadMany rsSOUND 9 66 79 80 81 89 90 103)
				(elevatorID loop: 0 y: elevY stopUpd:)
				(gConMusic stop: prevSignal: 0)
			else
				(gEgo
					posn: elevX (- elevY 2)
					illegalBits: 0
					ignoreActors: 1
					hide:
				)
				(if (< gPrevRoomNum gCurRoomNum)
					(= temp1 50)
					(chainID
						view: 242
						setLoop: 3
						ignoreActors: 1
						illegalBits: 0
						posn: elevX (+ chainY 50)
						setPri: 6
						moveSpeed: 1
						setMotion: MoveTo elevX (- elevY 50)
						init:
					)
				else
					(= temp1 -52)
				)
				(&= global111 $7fff)
				(|= gElevatorState $0040)
				(HandsOff)
				(= global110 0)
				(elevatorID
					setLoop: 1
					y: (+ elevY temp1)
					moveSpeed: 1
					setMotion: MoveTo elevX elevY self
				)
				(= temp0 (elevatorID lastCel:))
			)
			(elevatorID cel: temp0 init:)
		else
			(Load rsVIEW 5)
			(if (& gElevatorState $0020)
				(HandsOff)
				(if (== gCurRoomNum 32)
					(= temp1 0)
				else
					(= temp1 60)
				)
				(= global110 15)
				(gEgo
					view: 5
					setLoop: 4
					setCel: 0
					ignoreActors: 1
					illegalBits: 0
					posn: elevX (- elevY 60)
					setPri: 6
					setStep: 0 7
					moveSpeed: 0
					setMotion: MoveTo elevX (+ elevY temp1) self
				)
			)
			(cond
				((== gCurRoomNum 32)
					(self setPri: 9 ignoreActors: 1)
					(elevatorID
						loop: 4
						cel: (* (& gElevatorState gateStMask) 1)
						posn: gateX gateY
						ignoreActors: 0
						stopUpd:
					)
				)
				((< global111 gCurRoomNum)
					(elevatorID loop: 3 posn: elevX (+ elevY 2))
				)
			)
			(elevatorID init:)
		)
	)

	(method (doit)
		(if (and (not (& gElevatorState $0010)) (not (& gElevatorState $0020)))
			(cond
				((& (gEgo onControl: 1) $0010)
					(= global110 15)
					(|= gElevatorState $0020)
					(HandsOff)
					(gEgo
						view: 5
						setLoop: 4
						setCel: 0
						setPri: 6
						ignoreActors: 1
						illegalBits: 0
						setStep: 0 7
						moveSpeed: 0
						setMotion: MoveTo elevX (+ elevY 60) self
					)
					(gConMusic number: 9 loop: -1 play:)
				)
				((and (& (gEgo onControl: 1) $0008) (== gCurRoomNum global111))
					(self elevatorFunc:)
				)
			)
		)
		(if (== (& gElevatorState $0050) 16)
			(cond
				((> (gEgo y:) (- gateY 2))
					(gEgo posn: elevX (- elevY 2))
					(self elevatorFunc:)
				)
				((!= (gEgo x:) elevX)
					(gEgo posn: elevX (- elevY 2))
				)
			)
		)
		(if (and (== (gConMusic number:) 66) (== (gConMusic prevSignal:) -1))
			(gConMusic prevSignal: 0 number: 103 loop: -1 priority: 15 play:)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				(
					(and
						(!= gCurRoomNum global111)
						(or (Said '*/elevator,lift') (Said 'lift[<open][/*]'))
					)
					(Print 201 0) ; "Currently, you don't SEE an elevator, just an elevator shaft."
				)
				((Said 'look>')
					(cond
						((Said '/archway')
							(Print 201 1) ; "The gate provides protection from the elevator as it moves from floor to floor."
						)
						((Said '<in,in,in/elevator,lift')
							(if (& gElevatorState $0010)
								(Print 201 2) ; "You see the elevator control on the elevator wall."
							else
								(Print 201 3) ; "Why don't you enter the elevator first?"
							)
						)
						((Said '/elevator,lift')
							(Print 201 4) ; "It's odd to see a new-fangled elevator in this old-fashioned house; but how else would the Colonel get up or down the stairs?"
						)
						((Said '/control')
							(cond
								((!= gCurRoomNum global111)
									(CantDo) ; "You can't do that."
								)
								((& gElevatorState $0010)
									(localproc_4 downID upID)
								)
								(else
									(Print 201 3) ; "Why don't you enter the elevator first?"
								)
							)
						)
						((Said '/keyhole')
							(cond
								((!= gCurRoomNum global111)
									(CantDo) ; "You can't do that."
								)
								((& gElevatorState $0010)
									(Print 201 5) ; "It's just an empty keyhole."
								)
								(else
									(Print 201 3) ; "Why don't you enter the elevator first?"
								)
							)
						)
						((Said '/shaft')
							(cond
								((< gCurRoomNum global111)
									(localproc_2 {up})
								)
								((> gCurRoomNum global111)
									(localproc_2 {down})
								)
								((not (& (gEgo onControl: 1) $0028))
									(NotClose) ; "You're not close enough."
								)
							)
						)
					)
				)
				((or (Said 'open/archway,elevator') (Said 'lift[<open][/*]'))
					(self elevatorFunc:)
				)
				((Said 'enter/elevator,lift')
					(if (& gElevatorState $0010)
						(localproc_3 {ARE})
					else
						(self elevatorFunc:)
					)
				)
				((Said 'exit/elevator,lift')
					(if (& gElevatorState $0010)
						(self elevatorFunc:)
					else
						(localproc_3 {AREN'T})
					)
				)
				((Said 'close/archway,elevator,lift')
					(cond
						((not (& gElevatorState gateStMask))
							(AlreadyClosed) ; "It is already closed."
						)
						((& (gEgo onControl: 1) $0008)
							(if (and (== (gEgo y:) gateY) (== gCurRoomNum 32))
								(Print 201 6) ; "You can't; you are blocking the gate."
								(return)
							)
							(self gateFunc: 0 3)
						)
						((& (gEgo onControl: 1) $0020)
							(self gateFunc: 0 2)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'get/control')
					(Print 201 7) ; "Just move it "up" or "down.""
				)
				(
					(or
						(Said '(press,pull,move)<up/control,handle')
						(Said 'up[/!*]')
						(Said '(go,press,pull,move)<up[/!*]')
					)
					(if (& gElevatorState $0010)
						(if
							(and
								(!= upRoomNo -1)
								(or (!= upRoomNo 75) (& gElevatorState $0008))
							)
							(|= gElevatorState $0040)
							(= global110 9)
							(self cue:)
						else
							(localproc_0 {push})
						)
					else
						(localproc_1)
					)
				)
				(
					(or
						(Said '(press,pull,move)<down/control,handle')
						(Said 'down[/!*]')
						(Said '(go,press,pull,move)<down[/!*]')
					)
					(if (& gElevatorState $0010)
						(if (!= downRoomNo -1)
							(|= gElevatorState $0040)
							(= global110 12)
							(self cue:)
						else
							(localproc_0 {pull})
						)
					else
						(localproc_1)
					)
				)
				((Said '(use,press,pull,move)/control,handle')
					(Print 201 8) ; "Which direction? Up or down."
				)
				((Said 'latch/elevator,lift,control')
					(if (& gElevatorState $0010)
						(if (gEgo has: 18) ; brass_key
							(if (& gElevatorState $0008)
								(Print 201 9) ; "A faint click is heard as you turn the key in the lock."
								(&= gElevatorState $fff7)
							else
								(Print 201 10) ; "The control is locked."
							)
						else
							(Print 201 11) ; "You don't have the key for this lock."
						)
					else
						(localproc_1)
					)
				)
				(
					(or
						(Said 'unbar[<use<key]/elevator,lift,control')
						(Said 'attach/key/keyhole,eyehole,control')
					)
					(if (& gElevatorState $0010)
						(if (gEgo has: 18) ; brass_key
							(if (& gElevatorState $0008)
								(Print 201 12) ; "The control is already unlocked."
							else
								(Print 201 9) ; "A faint click is heard as you turn the key in the lock."
								(|= gElevatorState $0008)
							)
						else
							(Print 201 11) ; "You don't have the key for this lock."
						)
					else
						(localproc_1)
					)
				)
				((Said 'attach/key')
					(Print 201 13) ; "Please be more specific."
				)
			)
		)
	)

	(method (elevatorFunc)
		(cond
			((& gElevatorState gateStMask)
				(AlreadyOpen) ; "It is already open."
			)
			((& (gEgo onControl: 1) $0008)
				(if (!= gCurRoomNum global111)
					(self gateFunc: 1 3)
				else
					(|= gElevatorState $0040)
					(= global110 5)
					(self cue:)
				)
			)
			((& (gEgo onControl: 1) $0020)
				(self gateFunc: 1 2)
			)
			((& gElevatorState $0010)
				(|= gElevatorState $0040)
				(= global110 1)
				(self cue:)
			)
			(else
				(NotClose) ; "You're not close enough."
			)
		)
	)

	(method (gateFunc param1 param2)
		(HandsOff)
		(self startUpd:)
		(if (== param1 1)
			(gConMusic number: 81)
			(self setCycle: End self)
			(|= gElevatorState gateStMask)
		else
			(gConMusic number: 79)
			(self setCycle: Beg self)
			(&= gElevatorState (~ gateStMask))
		)
		(gConMusic loop: 1 play:)
		(if (and (== gCurRoomNum 32) (!= gCurRoomNum global111))
			(elevatorID cel: param1 forceUpd:)
			(if (and (& (gEgo onControl: 1) $0020) (== param1 0))
				(= global110 17)
			)
		)
		(if (!= param2 -1)
			(gEgo loop: param2)
		)
	)

	(method (cue)
		(switch (++ global110)
			(0
				(self stopUpd:)
				(&= gElevatorState $ffbf)
				(if (!= gCurRoomNum global111)
					(= global110 -1)
				)
				(HandsOn)
			)
			(1
				(gConMusic number: 80 loop: 1 play:)
				(chainID stopUpd:)
				(elevatorID cycleSpeed: 2 setCycle: Beg self)
				(if (and (== gCurRoomNum 42) (& gElevatorState $0008))
					(HandsOn)
					(= global110 -1)
				)
			)
			(2
				(gConMusic fade:)
				(HandsOff)
				(if (& gElevatorState gateStMask)
					(self cue:)
				else
					(self gateFunc: 1 -1)
				)
			)
			(3
				(self stopUpd:)
				(elevatorID loop: 0 cel: 0 stopUpd:)
				(gEgo
					view: 0
					loop: 2
					posn: (- elevX 1) (- elevY 3)
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo (+ elevX 1) (+ elevY 2) self
					init:
					show:
				)
			)
			(4
				(self gateFunc: 0 3)
			)
			(5
				(if (& (gEgo onControl: 1) $0008)
					(gEgo
						loop: 2
						illegalBits: -32768
						ignoreActors: 0
						setMotion:
							MoveTo
							(gEgo x:)
							(+ (gEgo y:) (gEgo yStep:))
							self
					)
					(-- global110)
				else
					(if (and (IsFirstTimeInRoom) msgID)
						(Print msgID)
					)
					(HandsOn)
					(&= gElevatorState $ffef)
					(= global110 -1)
					(self cue:)
				)
			)
			(6
				(HandsOff)
				(|= gElevatorState $0010)
				(self gateFunc: 1 -1)
				(gEgo
					setMotion: MoveTo elevX (+ gateY (gEgo yStep:))
					init:
				)
			)
			(7
				(gEgo
					ignoreActors: 1
					setMotion: MoveTo elevX (- elevY 2) self
				)
			)
			(8
				(HandsOn)
				(gEgo hide:)
				(elevatorID setLoop: 1 forceUpd:)
				(self gateFunc: 0 -1)
			)
			(9
				(gEgo posn: elevX (- elevY 2) illegalBits: 0 ignoreActors: 1)
				(= global110 -1)
				(self cue:)
			)
			(10
				(gConMusic number: 66 prevSignal: 0 loop: 1 play:)
				(= global111 (| upRoomNo $8000))
				(HandsOff)
				(elevatorID cycleSpeed: 2 setCycle: End self)
			)
			(11
				(elevatorID
					setLoop: 1
					moveSpeed: 1
					setMotion: MoveTo elevX (- elevY 50) self
					startUpd:
				)
			)
			(12
				(gCurRoom newRoom: upRoomNo)
			)
			(13
				(gConMusic number: 66 prevSignal: 0 loop: 1 play:)
				(= global111 (| downRoomNo $8000))
				(HandsOff)
				(elevatorID cycleSpeed: 2 setCycle: End self)
			)
			(14
				(chainID
					view: 242
					setLoop: 3
					ignoreActors: 1
					illegalBits: 0
					posn: elevX chainY
					setPri: 6
					moveSpeed: 1
					setMotion: MoveTo elevX (+ chainY 52)
					init:
				)
				(elevatorID
					setLoop: 1
					moveSpeed: 1
					setMotion: MoveTo elevX (+ elevY 52) self
					startUpd:
				)
			)
			(15
				(gCurRoom newRoom: downRoomNo)
			)
			(16
				(cond
					(
						(or
							(and (== gCurRoomNum 75) (== global111 42))
							(and (== gCurRoomNum 42) (== global111 32))
						)
						(self cue:)
					)
					((== gCurRoomNum 32)
						(gEgo
							view: 5
							setCel: -1
							posn: 297 125
							setCycle: End self
						)
					)
					((== gCurRoomNum 75)
						(gCurRoom newRoom: 42)
					)
					(else
						(gCurRoom newRoom: 32)
					)
				)
			)
			(17
				(gConMusic number: 90 loop: 1 play:)
				(ShakeScreen 10 5) ; ssUPDOWN | $0004
				(= global128 5)
				(= global129 4)
				(= global130 (gEgo lastCel:))
				(gEgo dispose:)
				(EgoDead 201 14) ; "You really got the shaft this time!"
			)
			(18
				(HandsOff)
				(gConMusic number: 89 loop: -1 play:)
				(gEgo
					view: 5
					setLoop: 4
					setCel: 0
					illegalBits: 0
					ignoreActors: 1
					posn: 297 125
					setPri: 6
					moveSpeed: 1
					setMotion: MoveTo 297 182
				)
				(elevatorID
					setLoop: 1
					posn: elevX (- (gEgo y:) 57)
					startUpd:
				)
				(elevatorID
					cel: (elevatorID lastCel:)
					moveSpeed: 1
					setMotion: MoveTo elevX elevY self
				)
				(chainID
					view: 5
					loop: 6
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					posn: 295 126
					priority: 8
					cycleSpeed: 7
					setCycle: End
					init:
				)
			)
			(19
				(gConMusic stop:)
				(= global128 5)
				(= global129 6)
				(= global130 (chainID lastCel:))
				(gEgo dispose:)
				(EgoDead 201 15) ; "Way to go, Sherlock, you just invented the trash compactor!"
			)
		)
	)
)

