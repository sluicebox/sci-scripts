;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 146)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	aqueduct 0
	drink 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance aqueduct of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 41)
		(Load rsVIEW 89)
		(super init:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(Said 'ask[/merlin]/aquaduct,hezakiah,king')
					(Said 'tell[/me]/aquaduct,hezakiah,king')
				)
				(SetScore 290 1 1)
				(Print 146 0) ; "800 years before the birth of Christ, King Hezekiah ruled a city built on the large hill above this tunnel."
				(Print 146 1) ; "The Assyrians were coming to attack the city, and the only source of water, the Spring of Gihon, lay before them at the base of the city."
				(Print 146 2) ; "Hezekiah sent two teams of men to dig a tunnel. One began at the Spring, the other from the opposite side of the hill."
				(Print 146 3) ; "It is an amazing feat of that age that they dug through solid rock and met in the middle, thus forming this underground aqueduct."
				(Print 146 4) ; "The water flowed then from the Spring, which was covered over from sight, to the Pool of Siloam, hidden upon the far side of the hill."
				(Print 146 5) ; "When the enemy arrived, they found no water and were forced to give up their seige. Thus did King Hezekiah save his city."
				(Print 146 6) ; "And yet, of that city no trace remains, and in its place the city now known as Jerusalem was built upon a larger hill to the north."
			)
			((Said 'get,carry,fetch,carry/water')
				(Print 146 7) ; "If only you had a waterskin, but you do not. You must drink your fill and reach Jerusalem as quickly as possible."
			)
			((or (Said '(go<dive),dive,bathe') (Said 'get/avebury'))
				(Print 146 8) ; "This is neither the time nor place."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					((Said '//assyrian')
						(Print 146 9) ; "They were foes of King Hezekiah."
					)
					((Said '//jerusalem,city')
						(if (IsFlag 105)
							(Print 146 10) ; "You may as well get started. You have a long walk back."
						else
							(Print 146 11) ; "It must be near."
						)
					)
					((or (Said '/hill') (Said '//hill'))
						(Print 146 12) ; "You are under a hill at present."
					)
					((or (Said '/spring,gihon') (Said '//spring,gihon'))
						(Print 146 13) ; "The Spring of Gihon lies upon the far side of the large hill through which this aqueduct was dug. It was hidden by King Hezekiah centuries ago."
					)
					((or (Said '/pool,siloam') (Said '//pool,siloam'))
						(Print 146 14) ; "The Pool of Siloam is fed by the Spring of Gihon through Hezekiah's Aqueduct."
					)
				)
			)
		)
	)
)

(instance drink of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5
					(cond
						((> global204 5000) 1)
						((> global204 3000) 2)
						((> global204 2000) 3)
						((> global204 1000) 4)
						((> global204 1000) 4)
						((> global204 500) 5)
						(else 6)
					)
				)
				(if (== gCurRoomNum 41)
					(= temp0 147)
				else
					(= temp0 117)
				)
				(if (> (gEgo y:) temp0)
					(gEgo setMotion: MoveTo (gEgo x:) temp0 self)
				else
					(self cue:)
				)
			)
			(1
				((= local2 (View new:))
					view: 89
					posn: (gEgo x:) (gEgo y:)
					setLoop: 8
					setCel: 0
					ignoreActors: 1
					init:
				)
				(gEgo
					view: 89
					setLoop: 1
					cel: 0
					illegalBits: 0
					x: (+ (gEgo x:) 1)
					z: 2
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(if (not local4)
					(= local4 1)
					((= local1 (Prop new:))
						view: 89
						ignoreActors: 1
						posn: (gEgo x:) (gEgo y:)
						setLoop: 4
						cycleSpeed: 1
						init:
						setCycle: Fwd
					)
				)
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo setLoop: 2 cel: 1 setCycle: Beg self)
			)
			(6
				(if local5
					(-- local5)
					(self changeState: 2)
				else
					(if (not local3)
						(= local3 1)
						(if (== gCurRoomNum 50)
							(Print 146 15) ; "The cold water within this cool tunnel sends a shiver running through your body."
						else
							(Print 146 16) ; "The waters of the Pool of Siloam are cold and pure and fill you with relief."
						)
					)
					(gEgo setLoop: 2 cel: 1 setCycle: Beg self)
				)
			)
			(7
				(local1 dispose:)
				(= local4 0)
				(gEgo setLoop: 1 cel: 2 setCycle: Beg self)
			)
			(8
				(SetFlag 84)
				(ClearFlag 85)
				(ClearFlag 98)
				(ClearFlag 92)
				(ClearFlag 82)
				(ClearFlag 110)
				(= global204 8000)
				(local2 dispose:)
				(gEgo setLoop: 2)
				(gEgo
					view: 41
					x: (- (gEgo x:) 1)
					z: 0
					setLoop: -1
					cel: 2
					illegalBits: -32768
					cycleSpeed: 0
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

