;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use n013)
(use Wat)
(use Interface)
(use MList)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	monkFight 0
	overlayDisposer 1
)

(local
	local0
	local1
	local2
	local3
	[local4 64] = [40 27 8 8 0 0 0 0 30 16 7 47 0 0 0 0 18 23 33 8 0 0 0 0 16 29 20 4 0 0 0 0 100 100 100 100 42 32 20 21 100 100 100 100 30 19 26 31 100 100 100 100 10 10 35 23 100 100 100 100 10 50 10 5]
)

(procedure (localproc_0 &tmp [temp0 200])
	(if local0
		(Format @temp0 &rest)
		(proc13_1 @temp0)
	)
)

(procedure (localproc_1 param1 param2)
	(Max
		24
		(Min
			(+
				(* 36 gHowFast)
				(switch global125
					(1 1)
					(2 0)
					(3 6)
					(4 12)
				)
			)
			(*
				param1
				6
				(if (== param2 rob)
					30
				else
					(-
						32
						(switch global125
							(1 0)
							(2 25)
							(3 25)
							(4 32)
						)
					)
				)
			)
		)
	)
)

(instance defenseOddsCode of Code
	(properties)

	(method (doit param1 param2)
		(return (- (((param1 client:) fight:) success: param2 param1)))
	)
)

(instance attackOddsCode of Code
	(properties)

	(method (doit param1 param2)
		(if (!= ((param1 target:) client:) (param1 client:))
			(((param1 client:) fight:) success: param1 param2)
		)
	)
)

(instance attackStrengthCode of Code
	(properties)

	(method (doit param1)
		(param1 _strength:)
	)
)

(instance RandForward of Fwd
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(= temp0 (client cel:))
		(if
			(and
				(!= (= temp1 (super nextCel: &rest)) temp0)
				(<= (Random 1 100) 60)
			)
			(= temp1 temp0)
		)
		(return temp1)
	)
)

(instance qsp of Script
	(properties)

	(method (init)
		(if (or argc (not (client script:)))
			(super init: &rest)
		)
	)

	(method (doit)
		(if (== seconds cycles ticks (client technique:) 0)
			(= ticks 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= cycles (= ticks 0))
				(= temp3 (client _technique:))
				(= temp2
					(if
						(= temp1
							(if (= temp0 (client opponent:))
								(temp0 _technique:)
							)
						)
						(temp1 target:)
					)
				)
				(cond
					((client _technique:))
					((or (not temp2) (<= (temp1 state:) 0))
						(cond
							(
								(and
									(== global125 4)
									(or (temp0 parriedCycles:) (temp0 ticks:))
								)
								(= temp3
									((client techniques:)
										maxElement: attackStrengthCode
									)
								)
								(client technique: temp3 self)
							)
							(
								(or
									(temp0 parriedCycles:)
									(<= (Random 0 100) (/ (* 100 global125) 4))
								)
								(while 1
									(= temp3
										((client techniques:)
											at:
												(Random
													0
													(-
														((client techniques:)
															size:
														)
														1
													)
												)
										)
									)
									(localproc_0 11 0 (temp3 name:))
									(breakif
										(!= client ((temp3 target:) client:))
									)
								)
								(localproc_0 11 1 (temp3 name:))
								(client technique: temp3 self)
							)
						)
					)
					(temp2
						(if (== client (temp2 client:))
							(= temp3
								((client techniques:)
									maxElement: defenseOddsCode temp1
								)
							)
							(client technique: temp3 self)
						else
							(= temp3
								((client techniques:)
									maxElement: attackOddsCode temp1
								)
							)
							(client technique: temp3 self)
						)
					)
				)
				(if (not temp3)
					(= ticks 1)
				)
			)
			(1
				(= ticks (* 6 (client moveSpeed:)))
			)
			(2
				(self init:)
			)
		)
	)
)

(class qsPart of Part
	(properties)

	(method (onMe &tmp temp0 temp1 temp2)
		(= temp1 (client x:))
		(= temp2 ((client opponent:) x:))
		(= temp0 (/ (+ temp1 temp2) 2))
		(if (<= temp1 temp2)
			(= nsLeft (- (client nsLeft:) 10))
			(= nsRight temp0)
		else
			(= nsLeft temp0)
			(= nsRight (+ (client nsRight:) 10))
		)
		(return (super onMe: &rest))
	)

	(method (strength &tmp temp0)
		(return
			(/
				(*
					(= temp0
						(if (and (not argc) (== client monk))
							(switch global125
								(1 0)
								(2 25)
								(3 25)
								(4 32)
							)
						else
							32
						)
					)
					(super strength: &rest)
				)
				32
			)
		)
	)
)

(class QSFighter of Fighter
	(properties
		cycleSpeed 9
		moveSpeed 9
	)

	(method (init)
		(self setLoop: 0 ignoreActors: illegalBits: 0)
		(super init: &rest)
	)

	(method (setCycle param1 &tmp temp0)
		(= temp0 (if argc param1))
		(if (and cycler (cycler caller:))
			((cycler caller:) cue:)
		)
		(super setCycle: temp0 &rest)
	)

	(method (agonize param1 param2)
		(if _technique
			(self technique: 0)
		)
		(cond
			((or (<= _strength 0) (<= (param2 strength:) 0))
				(self setScript: (Clone getKilled))
			)
			((not script)
				(self setScript: (Clone getHit))
			)
		)
		(= ticks
			(Max
				parriedCycles
				ticks
				(localproc_1 (param1 strength:) self)
			)
		)
		(*= ticks 3)
		(= parriedCycles 0)
	)

	(method (inflict param1 &tmp temp0 temp1)
		(= temp0 (or (opponent script:) (super inflict: param1 &rest)))
		(if parriedCycles
			(= parriedCycles (localproc_1 parriedCycles self))
		)
		(if local3
			(local3 dispose:)
		)
		(= temp1 (opponent loop:))
		(cond
			((== self ((param1 target:) client:))
				(= local3 0)
			)
			(temp0
				((= local3 thudAndGroanSound) play:)
			)
			((or (and (== loop 2) (== temp1 6)) (and (== loop 4) (== temp1 8)))
				((= local3 swishSound) play:)
			)
			((not (opponent technique:))
				((= local3 thudSound) play:)
			)
			(else
				((= local3 woodHitsWoodSound) play:)
			)
		)
	)
)

(instance thudAndGroanSound of Sound
	(properties
		flags 1
		number 935
	)
)

(instance thudSound of Sound
	(properties
		flags 1
		number 588
	)
)

(instance swishSound of Sound
	(properties
		flags 1
		number 934
	)
)

(instance woodHitsWoodSound of Sound
	(properties
		flags 1
		number 122
	)
)

(instance overlayDisposer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thudAndGroanSound dispose:)
				(thudSound dispose:)
				(swishSound dispose:)
				(woodHitsWoodSound dispose:)
				(caller cue:)
				(rob dispose:)
				(monk dispose:)
				(= ticks 1)
			)
			(1
				(LoadMany 0 858 893)
				(self dispose:)
			)
		)
	)
)

(instance monkFight of Fight
	(properties)

	(method (doit)
		(if (and (!= global125 local1) (!= (rob loop:) 10) (!= (monk loop:) 10))
			(self init:)
		)
		(= local1 global125)
		(super doit: &rest)
	)

	(method (dispose)
		(= gPMouse local2)
		(gMouseDownHandler delete: rob)
		(gDirectionHandler delete: rob)
		(gKeyDownHandler delete: rob)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0)
			(1
				(= ticks 1)
			)
			(2
				(= temp0 caller)
				(= caller 0)
				(client setScript: overlayDisposer temp0)
			)
		)
	)

	(method (init param1 &tmp temp0)
		(if argc
			(= local2 gPMouse)
			(= gPMouse 0)
			(gMouseDownHandler addToFront: rob)
			(gDirectionHandler addToFront: rob)
			(gKeyDownHandler addToFront: rob)
		)
		(= local1 global125)
		(robMidHit success: 36 setTarget: monkBody)
		(robHighHit success: 23 setTarget: monkHead)
		(robLowHit success: 52 setTarget: monkLegs)
		(robOverHit success: 11 setTarget: monkOverHead)
		(robMidBlk setTarget: robBody)
		(robHighBlk setTarget: robOverHead)
		(robDuck setTarget: robHead)
		(robJump setTarget: robLegs)
		(rob x: 145 y: 100)
		(monkMidHit success: 36 setTarget: robBody)
		(monkHighHit success: 23 setTarget: robHead)
		(monkLowHit success: 52 setTarget: robLegs)
		(monkOverHit success: 11 setTarget: robOverHead)
		(monkMidBlk setTarget: monkBody)
		(monkHighBlk setTarget: monkOverHead)
		(monkDuck setTarget: monkHead)
		(monkJump setTarget: monkLegs)
		(monk x: 162 y: 97)
		(if argc
			(super init: param1 rob monk @local4 &rest)
		else
			(super init:)
		)
		((rob parts:) eachElementDo: #strength 30)
		((monk parts:)
			eachElementDo:
				#strength
				(switch global125
					(1 0)
					(2 25)
					(3 25)
					(4 32)
				)
		)
		(rob _strength: (/ (* 67 (robBody _strength:)) 100))
		(monk
			_strength:
				(/
					(*
						(switch global125
							(1 100)
							(2 45)
							(3 61)
							(4 88)
						)
						(monkBody _strength:)
					)
					100
				)
		)
		(if (== global125 1)
			(rob setScript: cheatWin)
		else
			(monk plan: qsp)
		)
		(gGame setCursor: 10 1 (monk x:) (- (monk y:) 53))
	)
)

(instance cheatWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rob technique: robOverHit self)
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rob of QSFighter
	(properties
		view 122
	)

	(method (inflict &tmp temp0)
		(= temp0 (super inflict: &rest))
		(if (and script (== global125 1) (not (opponent script:)))
			(opponent setScript: getKilled script)
		)
		(return temp0)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) JOY_UPRIGHT))
				(= local0 (not local0))
			)
			(
				(and
					(not (or ticks parriedCycles))
					(or
						(and (== (event type:) $0040) (== (event message:) JOY_NULL)) ; direction
						(and (== (event type:) evKEYBOARD) (== (event message:) KEY_5))
						(and
							(== global125 2)
							(== (event type:) evMOUSEBUTTON)
							(self onMe: event)
						)
					)
					(= temp0 (opponent technique:))
					(== self ((temp0 target:) client:))
				)
				(= temp0 (_techniques maxElement: defenseOddsCode temp0))
				(event claimed: 1)
				(self technique: temp0)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (not (or _technique cycler (<= _strength 0)))
			(self loop: 0 setCycle: (Clone RandForward))
		)
		(super doit: &rest)
		(cond
			(
				(and
					(not
						(= temp0
							(or
								ticks
								parriedCycles
								(and _technique (_technique ticks:))
							)
						)
					)
					(== gTheCursor gWaitCursor)
				)
				(gGame setCursor: 10)
			)
			((and parriedCycles (!= gTheCursor gWaitCursor))
				(gGame setCursor: gWaitCursor)
			)
		)
	)

	(method (init &tmp temp0)
		(if (= temp0 (== _parts 0))
			(self
				ignoreActors:
				parts: robOverHead robHead robBody robLegs
				techniques:
					robMidBlk
					robHighBlk
					robDuck
					robJump
					robMidHit
					robLowHit
					robHighHit
					robOverHit
			)
		)
		(self loop: 0 setCycle: (Clone RandForward))
		(_techniques name: {robTechs})
		(_parts name: {robParts} eachElementDo: #strength 30)
		(super init: &rest)
	)
)

(instance getKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMouseDownHandler delete: rob)
				(gDirectionHandler delete: rob)
				(gKeyDownHandler delete: rob)
				(rob _strength: 0)
				(monk _strength: 0)
				(= ticks 1)
			)
			(1
				(monk plan: 0)
				(client technique: 0 setLoop: 10 setCel: 0 setCycle: End self)
			)
			(2
				((client opponent:) technique: 0 setLoop: 0 setCel: 0)
				(= ticks 60)
			)
			(3
				(Wat qFight: (if (== client rob) 1 else 2))
				(monkFight cue:)
				(self dispose:)
			)
		)
	)
)

(instance getHit of Script
	(properties)

	(method (dispose)
		(client ticks: register)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (client ticks:))
				(client setLoop: 0 setCel: 0)
				(= ticks (client moveSpeed:))
			)
			(1
				(client setLoop: 9 setCel: 0 setCycle: End self)
			)
			(2
				(= ticks (client moveSpeed:))
			)
			(3
				(client setLoop: 0 setCel: 0 setCycle: (Clone RandForward))
				(gGame setCursor: 10)
				(self dispose:)
			)
			(4
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
				(Printf 11 2 name state) ; "%s state %d"
			)
		)
	)
)

(instance attackElsewhere of Code ; UNUSED
	(properties)

	(method (doit param1 param2)
		(if (not (param1 onMe: param2))
			(((param2 client:) parts:) firstTrue: #onMe param1)
		)
	)
)

(instance robOverHead of qsPart
	(properties)

	(method (onMe)
		(= nsTop (- 30 (client nsTop:)))
		(= nsBottom (client nsTop:))
		(return (super onMe: &rest))
	)
)

(instance robHead of qsPart
	(properties)

	(method (onMe)
		(= nsTop (client nsTop:))
		(= nsBottom
			(+ (client nsTop:) (/ (- (client nsBottom:) (client nsTop:)) 3))
		)
		(return (super onMe: &rest))
	)
)

(instance robBody of qsPart
	(properties)

	(method (onMe)
		(= nsTop
			(+ (client nsTop:) (/ (- (client nsBottom:) (client nsTop:)) 3))
		)
		(= nsBottom
			(+
				(client nsTop:)
				(/ (* (- (client nsBottom:) (client nsTop:)) 2) 3)
			)
		)
		(return (super onMe: &rest))
	)
)

(instance robLegs of qsPart
	(properties)

	(method (onMe)
		(= nsTop
			(+
				(client nsTop:)
				(/ (* (- (client nsBottom:) (client nsTop:)) 2) 3)
			)
		)
		(= nsBottom (+ 30 (client nsBottom:)))
		(return (super onMe: &rest))
	)
)

(class QSTechnique of Technique
	(properties)

	(method (success)
		(Min
			100
			(/
				(*
					(super success: &rest)
					(+
						100
						(if (not (or argc (== client rob)))
							(switch global125
								(2 -2)
								(3 3)
								(4 10)
							)
						)
					)
				)
				100
			)
		)
	)

	(method (dispose)
		(if (not (client cycler:))
			(client loop: 0 cel: 0 setCycle: (Clone RandForward))
		)
		(super dispose: &rest)
	)

	(method (delay)
		(return
			(cond
				(argc
					(super delay: &rest)
				)
				((== client (target client:)) 0)
				((< (client idleCycles:) _delay) _delay)
				(else
					(/ _delay 2)
				)
			)
		)
	)

	(method (strength)
		(return
			(if (and (not argc) (== global125 1) (client plan:))
				0
			else
				(super strength: &rest)
			)
		)
	)

	(method (cue)
		(if (and (client ticks:) (!= (target client:) client))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks
					(*
						1
						(if (!= (target client:) client)
							(+
								(self delay:)
								(Max
									(client ticks:)
									(client parriedCycles:)
								)
							)
						else
							(client parriedCycles:)
						)
					)
				)
				(if (not ticks)
					(self cue:)
				)
			)
			(1
				(client cel: 0 loop: loop telegraph: self setCycle: End self)
			)
			(2
				(= completed 1)
				(client inflict: self)
				(= register (client loop:))
				(= ticks (* (client moveSpeed:) (- 3 (client lastCel:))))
			)
			(3
				(if (== (client loop:) register)
					(client setCycle: Beg self)
				else
					(self dispose:)
				)
			)
			(4
				(= ticks (client moveSpeed:))
			)
			(5
				(self dispose:)
			)
		)
		(localproc_0
			11
			3
			name
			newState
			loop
			(client name:)
			(client loop:)
			(client cel:)
			(if (client cycler:)
				((client cycler:) name:)
			else
				{none}
			)
		)
	)
)

(instance robOverHit of QSTechnique
	(properties
		key 56
		dir 1
		loop 1
		_strength 6
		_delay 24
		_success 11
	)
)

(instance robHighHit of QSTechnique
	(properties
		key 57
		dir 2
		loop 2
		_strength 4
		_delay 18
		_success 23
	)
)

(instance robMidHit of QSTechnique
	(properties
		key 54
		dir 3
		loop 3
		_strength 3
		_delay 12
		_success 36
	)
)

(instance robLowHit of QSTechnique
	(properties
		key 51
		dir 4
		loop 4
		_strength 2
		_delay 6
		_success 52
	)
)

(instance robHighBlk of QSTechnique
	(properties
		key 50
		dir 5
		loop 5
	)
)

(instance robDuck of QSTechnique
	(properties
		key 55
		dir 8
		loop 6
	)
)

(instance robMidBlk of QSTechnique
	(properties
		key 52
		dir 7
		loop 7
	)
)

(instance robJump of QSTechnique
	(properties
		key 49
		dir 6
		loop 8
	)
)

(instance monk of QSFighter
	(properties
		view 124
	)

	(method (inflict)
		(if (!= global125 1)
			(super inflict: &rest)
		)
	)

	(method (init &tmp temp0)
		(if (= temp0 (== _parts 0))
			(self
				ignoreActors:
				parts: monkOverHead monkHead monkBody monkLegs
				techniques:
					monkMidHit
					monkLowHit
					monkHighHit
					monkOverHit
					monkMidBlk
					monkHighBlk
					monkDuck
					monkJump
			)
		)
		(self loop: 0 setCycle: (Clone RandForward))
		(_parts name: {monkParts})
		(_techniques name: {monkTechs})
		(if temp0
			(super init: &rest)
		)
	)

	(method (suffer param1)
		(if (and (== loop 6) (== (opponent loop:) 2))
			(opponent loop: 3)
		)
		(super suffer: param1 &rest)
	)
)

(instance monkOverHead of qsPart
	(properties)

	(method (onMe)
		(= nsTop (- 30 (client nsTop:)))
		(= nsBottom (client nsTop:))
		(return (super onMe: &rest))
	)
)

(instance monkHead of qsPart
	(properties)

	(method (onMe)
		(= nsTop (client nsTop:))
		(= nsBottom
			(+ (client nsTop:) (/ (- (client nsBottom:) (client nsTop:)) 3))
		)
		(return (super onMe: &rest))
	)
)

(instance monkBody of qsPart
	(properties)

	(method (onMe)
		(= nsTop
			(+ (client nsTop:) (/ (- (client nsBottom:) (client nsTop:)) 3))
		)
		(= nsBottom
			(+
				(client nsTop:)
				(/ (* (- (client nsBottom:) (client nsTop:)) 2) 3)
			)
		)
		(return (super onMe: &rest))
	)
)

(instance monkLegs of qsPart
	(properties)

	(method (onMe)
		(= nsTop
			(+
				(client nsTop:)
				(/ (* (- (client nsBottom:) (client nsTop:)) 2) 3)
			)
		)
		(= nsBottom (+ 30 (client nsBottom:)))
		(return (super onMe: &rest))
	)
)

(instance monkOverHit of QSTechnique
	(properties
		loop 1
		_strength 6
		_delay 24
		_success 11
	)
)

(instance monkHighHit of QSTechnique
	(properties
		loop 2
		_strength 4
		_delay 18
		_success 23
	)
)

(instance monkMidHit of QSTechnique
	(properties
		loop 3
		_strength 3
		_delay 12
		_success 36
	)
)

(instance monkLowHit of QSTechnique
	(properties
		loop 4
		_strength 2
		_delay 6
		_success 52
	)
)

(instance monkHighBlk of QSTechnique
	(properties
		loop 5
	)
)

(instance monkDuck of QSTechnique
	(properties
		loop 6
	)
)

(instance monkMidBlk of QSTechnique
	(properties
		loop 7
	)
)

(instance monkJump of QSTechnique
	(properties
		loop 8
	)
)

