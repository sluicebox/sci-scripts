;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm001 of Rm
	(properties
		picture 1
		style 0
		horizon 94
		east 2
		south 8
	)

	(method (init)
		(Load rsVIEW 67)
		(Load rsVIEW 56)
		(Load rsVIEW 120)
		(Load rsVIEW 300)
		(Load rsVIEW 37)
		(Load rsSOUND 41)
		(Load rsSOUND 12)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(2
				(gEgo y: (+ (/ (* (- (gEgo y:) 136) 83) 54) 107))
				(if (< (gEgo y:) 130)
					(gEgo y: 131)
				)
			)
			(8
				(gEgo x: (+ (/ (* (- (gEgo x:) 64) 169) 126) 150))
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10)
		(gAddToPics add: well flower eachElementDo: #init doit:)
		(if global131
			(sun setCycle: Fwd cycleSpeed: 3 init: setScript: sunScript)
		else
			(sun init: addToPic:)
		)
		(if global131
			(sunEyes init:)
		else
			(sunEyes init: addToPic:)
		)
		(jack init: ignoreHorizon: 1 ignoreControl: -1)
		(jill init: ignoreHorizon: 1 ignoreControl: -1)
		(if [global675 1]
			(pail init: stopUpd:)
			(= local3 1)
		)
		(if (not [global675 1])
			(if (proc0_11 56)
				(= [global675 1] 1)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 7)
					)
					(2
						(gGame setSpeed: 10)
					)
				)
				(jack setScript: rhymeScript)
			else
				(jack setScript: lookScript)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 11)
						(== local4 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 11) (== local4 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 11) (== local4 1))
					(rhymeScript cycles: 1)
				)
				(if (and (& temp0 emSHIFT) (!= local3 1))
					(cond
						((proc0_16 event 139 98 154 125)
							(LookAt jack)
							(jack setScript: talkScript)
						)
						((proc0_16 event 165 99 180 125)
							(LookAt jack)
							(jack setScript: talkScript)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo distanceTo: jack) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 1])
				(not global108)
				(< (gEgo distanceTo: jack) 30)
			)
			(= global108 1)
			(LookAt jack)
			(jack setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local3 1)
				(HandsOff)
				(gGlobalMGSound stop:)
				(jack setLoop: 6 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Alas!\nWe need\na pail.}
					dsWIDTH
					80
					dsCOORD
					152
					52
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1 posn: 193 88)
				(itemVisual init: show:)
				(jack setCel: 0)
				(= seconds global121)
			)
			(2
				(gGlobalMGSound number: 1 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(itemVisual hide:)
				(itemBalloon hide:)
				(jack setLoop: 7 setScript: lookScript)
				(= global103 0)
				(= local3 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(= global103 1)
				(= local3 1)
				(= global209 1)
				(if (and (> (gEgo x:) 220) (> (gEgo y:) 180))
					(gEgo setAvoider: Avoid setMotion: MoveTo 190 180 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setAvoider: Avoid setMotion: MoveTo 159 126 self)
			)
			(2
				(proc0_18)
				(pail init:)
				(gEgo
					setScript: (if (> global131 0) musicScript else 0)
					setMotion: MoveTo 223 141 self
				)
				(if (> global131 0)
					(rhymeBox init:)
					(rhymeBox open:)
				)
			)
			(3
				(gEgo setAvoider: 0 setLoop: 1 stopUpd:)
				(if (< global131 1)
					(gEgo setScript: musicScript)
				)
				(= cycles 2)
			)
			(4
				(jill hide:)
				(pail hide:)
				(jack
					setLoop: 2
					setCycle: Fwd
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 117 49 self
				)
			)
			(5
				(jack stopUpd:)
				(if global131
					(gGame setSpeed: 5)
				)
			)
			(6
				(jill
					setLoop: 1
					setCel: 2
					setScript: jillScript
					posn: 129 49
					show:
				)
				(pail posn: 117 49 show:)
				(if global131
					(sun setScript: 0)
					(sunEyes setCel: 0)
				)
				(jack setLoop: 0 setCel: 3 posn: 106 49 setCycle: End self)
			)
			(7
				(if global131
					(sunEyes setCycle: End)
				)
				(jack setCel: 6)
				(RedrawCast)
				(jack setCel: 7)
				(RedrawCast)
				(jack setCel: 6)
				(RedrawCast)
				(jack setCel: 7)
				(RedrawCast)
				(jack setLoop: 3 setCycle: Fwd setMotion: MoveTo 147 116 self)
			)
			(8
				(if global131
					(sunEyes setCycle: Beg)
				)
				(jack setLoop: 5)
				(jill setCycle: End)
			)
			(9)
			(10
				(jack setLoop: 0 setCel: 0)
				(if global131
					(sun setScript: sunScript)
				)
				(gEgo setAvoider: 0 setCycle: Walk setLoop: -1 setMotion: 0)
				(= local0 0)
				(= global103 0)
				(= cycles 2)
			)
			(11
				(jack illegalBits: $8000 ignoreActors: 0)
				(jill illegalBits: $8000 ignoreActors: 0)
				(gEgo illegalBits: $8000 ignoreActors: 0)
			)
			(12
				(gGlobalMGSound number: 1 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(gGame setSpeed: global206)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 180 175)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local4 1)
		)
	)
)

(instance jillScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if global131
					(sunEyes setCycle: End)
				)
				(pail dispose:)
				(jill
					setLoop: 4
					setCycle: Fwd
					illegalBits: 0
					ignoreActors: 1
					setStep: (if global131 3 else 4) (if global131 2 else 3)
					setMotion: MoveTo 172 116 self
				)
			)
			(2
				(if global131
					(sunEyes setCycle: Beg self)
				)
				(jill setCel: 2 stopUpd:)
				(rhymeScript cue:)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sunScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 10))
			)
			(1
				(sunEyes setCycle: End self)
			)
			(2
				(= seconds (Random 0 5))
			)
			(3
				(sunEyes setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 12
		priority 10
	)
)

(instance pail of View
	(properties
		y 116
		x 159
		view 56
	)
)

(instance well of PV
	(properties
		y 42
		x 97
		view 120
		loop 2
	)
)

(instance sun of Prop
	(properties
		y 27
		x 197
		view 120
	)
)

(instance sunEyes of Prop
	(properties
		y 13
		x 197
		view 120
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 3)
	)
)

(instance flower of PV
	(properties
		y 182
		x 265
		view 300
		loop 1
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 56
			setLoop: 1
			setCel: 0
			posn: 198 63
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 37 setLoop: 3 posn: 190 81 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 154
			left: 42
			bottom: 185
			right: 286
			type: 4
			title: {Jack and Jill}
			back: 9
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound loop: 1 play: self)
				(if (< global131 1)
					(rhymeBox init:)
					(rhymeBox open:)
				)
			)
			(1
				(= local1
					(Display
						{Jack and Jill went up the hill,}
						dsWIDTH
						320
						dsCOORD
						5
						5
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(2
				(= local2
					(Display
						{____To fetch a pail of water;}
						dsWIDTH
						320
						dsCOORD
						5
						17
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(3
				(rhymeScript cue:)
				(Display 1 0 dsRESTOREPIXELS local1)
				(Display 1 0 dsRESTOREPIXELS local2)
				(Display
					{Jack fell down, and broke his crown,}
					dsWIDTH
					320
					dsCOORD
					5
					5
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(4
				(jillScript cue:)
				(Display
					{And Jill came tumbling after.}
					dsWIDTH
					320
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(5
				(rhymeScript cue:)
				(self dispose:)
			)
		)
	)
)

(instance jack of Act
	(properties
		y 114
		x 147
		view 67
		loop 7
	)
)

(instance jill of Act
	(properties
		y 114
		x 173
		view 67
		loop 8
	)
)

(instance lookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 1 6)
					(1
						(jack cel: 0 setCycle: End)
					)
					(2
						(jill cel: 0 setCycle: End)
					)
					(3
						(jack setCycle: Beg)
					)
					(4
						(jill setCycle: Beg)
					)
				)
				(= seconds (Random 1 3))
			)
			(1
				(self init:)
			)
		)
	)
)

