;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	boat 0
)

(local
	local0
)

(instance boat of Rm
	(properties
		picture 79
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(Load rsVIEW 202)
		(Load rsFONT 41)
		(skiff
			view: 202
			loop: 0
			posn: 11 150
			setPri: 13
			setStep: 1 1
			setMotion: MoveTo 310 150 self
			setScript: Polling
			init:
		)
		(skiff cel: (- (NumCels skiff) 1))
		(if gDetailLevel
			(ripple
				view: 202
				loop: 1
				cel: 0
				setPri: 12
				setCycle: Fwd
				setStep: 1 1
				init:
			)
			(reflection
				view: 202
				loop: 5
				posn: 143 134
				setCycle: Fwd
				cycleSpeed: 2
				ignoreActors: 1
				init:
			)
			(fly1
				view: 202
				setLoop: 6
				cel: 0
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly2
				view: 202
				setLoop: 6
				cel: 1
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly3
				view: 202
				setLoop: 6
				cel: 2
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly4
				view: 202
				setLoop: 6
				cel: 3
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly5
				view: 202
				setLoop: 6
				cel: 4
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
			(fly6
				view: 202
				setLoop: 6
				cel: 5
				posn: (Random 60 260) (Random 40 150)
				setStep: 3 3
				observeBlocks: picWindow
				ignoreActors: 1
				ignoreHorizon: 1
				setMotion: Wander 5
				cycleSpeed: 2
				setCycle: Fwd
				init:
			)
		)
		(picWindow left: 60 right: 260 bottom: 150 top: 40 init:)
		(Display 780 0 dsCOORD 100 30 dsWIDTH 240 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0) ; "Two nights later..."
		(gConMusic number: 5 loop: -1 play:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((or (== (event message:) KEY_S) (== (event message:) KEY_s))
						(cls)
						(event claimed: 1)
						(gCurRoom newRoom: 781) ; dock
					)
					((or (== (event message:) KEY_RETURN) (== (event message:) KEY_SPACE))
						(SetFlag 50)
					)
				)
			)
			(evMOUSEBUTTON
				(SetFlag 50)
			)
		)
		(if (IsFlag 50)
			(cls)
			(event claimed: 1)
			(gCurRoom newRoom: 44)
		)
	)

	(method (doit &tmp temp0)
		(ripple posn: (+ (= temp0 (skiff x:)) 37) (+ (skiff y:) 1))
		(if (and (not local0) (> temp0 60))
			(Display 780 1 dsCOORD 61 44 dsWIDTH 240 dsCOLOR 0 dsBACKGROUND -1 dsFONT 41) ; "Programmed by: Chris Hoyt & Chris Iden"
			(Display 780 1 dsCOORD 60 43 dsWIDTH 240 dsCOLOR 15 dsBACKGROUND -1 dsFONT 41) ; "Programmed by: Chris Hoyt & Chris Iden"
			(= local0 1)
		)
	)

	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (cue)
		(cls)
		(gCurRoom newRoom: 781) ; dock
	)
)

(instance Polling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 15 50))
			)
			(1
				(if (skiff cel:)
					(skiff setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(skiff setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance reflection of Prop
	(properties)
)

(instance skiff of Act
	(properties)
)

(instance ripple of Act
	(properties)
)

(instance fly1 of Act
	(properties)
)

(instance fly2 of Act
	(properties)
)

(instance fly3 of Act
	(properties)
)

(instance fly4 of Act
	(properties)
)

(instance fly5 of Act
	(properties)
)

(instance fly6 of Act
	(properties)
)

(instance picWindow of Cage
	(properties)
)

