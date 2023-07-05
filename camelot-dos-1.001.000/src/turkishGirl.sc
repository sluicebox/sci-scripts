;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 148)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	turkishGirl 0
)

(procedure (localproc_0)
	(Print 148 0) ; "I fear the sight of you was too much for that poor girl. She ran as though you were an evil djin."
)

(instance turkishGirl of Act
	(properties
		view 343
	)

	(method (delete)
		(super delete:)
		(DisposeScript 148)
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			illegalBits: 0
			setLoop: 0
			cel: 0
			setScript: (if (== gPrevRoomNum 41) onHerWayIn else onHerWayOut)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'get,kiss,fuck,kill,hit/girl,woman,bitch')
				(Print 148 1) ; "Such profane thoughts betray a moral weakness which may make you unworthy to find or possess the Grail. You must control yourself."
			)
			((Said 'get/jug,jar,pot,drink,water')
				(Print 148 2) ; "The girl, and her jug, have vanished over the hill."
			)
			((Said 'give,pay,sell,bargain[/girl,coin][/girl,coin]')
				(Print 148 3) ; "The girl has no interest in coming near you, let alone taking your money."
			)
			((Said 'talk,ask[/girl,woman][/*]')
				(Print 148 4) ; "She clearly has no desire to speak to you."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said '/girl,woman')
							(Said '//girl,woman')
							(MouseClaimed self event)
						)
						(Print 148 5) ; "The girl found you most frightening and wanted nothing to do with you."
					)
					((or (Said '/jar,jug,pot') (Said '//jar,jug,pot'))
						(Print 148 6) ; "The girl's jar was designed for carrying water."
					)
				)
			)
		)
	)
)

(instance onHerWayOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(turkishGirl
					posn: 143 69
					setStep: 4 4
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 106 88 self
				)
			)
			(1
				(turkishGirl setLoop: 4 cel: 0 setCycle: End self)
				(= cycles 10)
			)
			(2
				(turkishGirl setCycle: Beg self)
			)
			(3
				(turkishGirl
					setCycle: Walk
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 0
					setMotion: MoveTo 92 90 self
				)
			)
			(4
				(turkishGirl setMotion: MoveTo 66 104 self)
			)
			(5
				(turkishGirl setLoop: 2 yStep: 4 setMotion: MoveTo 3 26 self)
			)
			(6
				(User canControl: 1)
				(localproc_0)
				(SetMenu 1283 112 1)
				(client dispose:)
			)
		)
	)
)

(instance onHerWayIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(turkishGirl
					posn: 65 35
					setCycle: Walk
					setLoop: 0
					setStep: 3 3
					setMotion: MoveTo 25 75 self
				)
			)
			(1
				(turkishGirl setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 10)
			)
			(2
				(turkishGirl setCycle: Beg self)
			)
			(3
				(turkishGirl
					setCycle: Walk
					setStep: 4 4
					setLoop: 2
					cycleSpeed: 0
					setMotion: MoveTo 0 25 self
				)
			)
			(4
				(if (not (IsFlag 20))
					(User canControl: 1)
				)
				(localproc_0)
				(SetMenu 1283 112 1)
				(client dispose:)
			)
		)
	)
)

