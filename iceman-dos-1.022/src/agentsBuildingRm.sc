;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n954)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	agentsBuildingRm 0
)

(instance agentsBuildingRm of Rm
	(properties
		picture 80
		horizon 1
		north 84
		east 79
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 280)
		(super init:)
		(self
			setRegions: 310 312 ; tunisia, guardjReg
			setFeatures:
				windo
				((Clone windo)
					x: 32
					y: 41
					z: 0
					nsLeft: 18
					nsTop: 26
					nsRight: 46
					nsBottom: 56
					yourself:
				)
				((Clone windo)
					x: 232
					y: 49
					z: 0
					nsLeft: 219
					nsTop: 39
					nsRight: 246
					nsBottom: 59
					yourself:
				)
				building
				((Clone building)
					x: 12
					y: 100
					z: 0
					nsLeft: 0
					nsTop: 85
					nsRight: 24
					nsBottom: 116
					yourself:
				)
				((Clone building)
					x: 76
					y: 161
					z: 0
					nsLeft: 0
					nsTop: 134
					nsRight: 153
					nsBottom: 189
					yourself:
				)
				((Clone building)
					x: 254
					y: 42
					z: 0
					nsLeft: 189
					nsTop: 0
					nsRight: 319
					nsBottom: 84
					yourself:
				)
		)
		(door init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 310 (gEgo y:) loop: 1 illegalBits: -32768)
				(door stopUpd:)
			)
			(else
				(gIceGlobalSound number: 74 owner: gGame priority: 1 loop: -1 play:)
				(gEgo posn: 286 80 loop: 2)
				(if (tunisia bagBound:)
					(Load rsVIEW 185)
					(van init: setScript: driveAwayScript)
				)
			)
		)
		(if (not (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(gEgo illegalBits: -32766)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,town,scene]')
				(Print 80 0) ; "The sterile symmetry of the apartment buildings seems out of place amidst the rugged rock formations."
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: -32768)
		(super dispose:)
	)
)

(instance driveAwayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo setMotion: MoveTo 260 118 self)
			)
			(2
				(gEgo hide:)
				(head init:)
				(= cycles 20)
			)
			(3
				(van setStep: 1 1 setMotion: MoveTo 380 (van y:))
				(= cycles 3)
			)
			(4
				(van setStep: 2 2)
				(= cycles 6)
			)
			(5
				(van setStep: 4 4)
				(= cycles 12)
			)
			(6
				(van setStep: 6 6)
				(= cycles 18)
			)
			(7
				(van setStep: 8 8 setMotion: MoveTo 380 (van y:) self)
			)
			(8
				(gCurRoom newRoom: 81) ; outsideCompoundRm
			)
		)
	)
)

(instance door of Prop
	(properties
		y 84
		x 284
		view 280
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(or (== (gEgo onControl: 1) 2) (== (gEgo onControl: 1) 4))
				(not (self script:))
				(gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			)
			(HandsOff)
			(self setScript: doorScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event))
					((Said 'look[<at]')
						(Print 80 1) ; "A typical apartment door."
					)
					((Said 'lock,knock')
						(Print 80 2) ; "There's no need to do that."
					)
					((GoToIfSaid self event 287 88 0 80 3))
					((Said 'open')
						(if (not (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
							(Print 80 4) ; "You don't have the key."
						)
					)
					((and (Said 'unlock') (not (gEgo has: 6))) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
						(Print 80 4) ; "You don't have the key."
					)
				)
			)
			((Said 'use/key')
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(HandsOff)
					(gEgo setMotion: MoveTo 287 88)
				else
					(Print 80 5) ; "You don't have a key."
				)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if (> (gEgo y:) (client y:))
					(= register 0)
					(gEgo setMotion: MoveTo (gEgo x:) 80 self)
				else
					(= register 1)
					(gEgo setMotion: MoveTo (gEgo x:) 92 self)
				)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(cond
					((== register 0)
						(gCurRoom newRoom: 84) ; agentApartmentRm
					)
					((tunisia bagBound:)
						(driveAwayScript cue:)
					)
					(else
						(HandsOn)
						(client stopUpd:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance van of Act
	(properties
		y 126
		x 251
		view 185
		cel 1
	)
)

(instance head of Prop
	(properties
		view 185
		cel 2
	)

	(method (init)
		(super init:)
		(self
			x: (+ (van x:) 13)
			y: (- (van y:) 30)
			setPri: (+ (van priority:) 1)
		)
	)

	(method (doit)
		(super doit:)
		(self x: (+ (van x:) 13) y: (- (van y:) 30))
	)
)

(instance building of RFeature
	(properties
		y 39
		x 25
		nsBottom 78
		nsRight 51
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 80 6) ; "A typical example of Tunisian architecture."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 10
		x 27
		nsLeft 11
		nsBottom 21
		nsRight 43
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 80 7) ; "A window."
					)
					((Said 'close,open,(climb<(in,through))')
						(proc0_41) ; "That is not a good idea."
					)
					((Said 'look<(in,through)')
						(Print 80 8) ; "You see only the darkened interior of the building."
					)
				)
			)
		)
	)
)

