;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room58 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance Room58 of Rm
	(properties
		picture 58
		style 16
	)

	(method (init)
		(Load rsVIEW 58)
		(Load rsVIEW 42)
		(Load rsVIEW 44)
		(Load rsVIEW 521)
		(Load rsSOUND 51)
		(Load rsSOUND 52)
		(Load rsPIC 66)
		(Load rsPIC 61)
		(super init:)
		(self setRegions: 603) ; regHauntedHouse
		(theMusic number: 57 loop: 0)
		(if ((gInventory at: 20) ownedBy: gCurRoomNum) ; Skeleton_Key
			(= local3 1)
		)
		(if global193
			(= local1 1)
		else
			(= local1 0)
		)
		((View new:) view: 521 loop: 2 cel: 0 posn: 102 75 setPri: 4 addToPic:)
		((View new:) view: 521 loop: 2 cel: 1 posn: 231 75 setPri: 4 addToPic:)
		((= local5 (Prop new:))
			view: 521
			loop: 3
			posn: 104 59
			setPri: 2
			init:
			setCycle: Fwd
		)
		((= local6 (Prop new:))
			view: 521
			loop: 3
			posn: 228 59
			setPri: 2
			init:
			setCycle: Fwd
		)
		((= local2 (Prop new:)) view: 521 loop: 1 posn: 181 96 setPri: 5 init:)
		(if global193
			(local2 setCel: 255 addToPic:)
		else
			(local2 hide:)
		)
		(gEgo
			view: 4
			setStep: 4 1
			setPri: 11
			illegalBits: 16384
			posn: 121 155
			baseSetter: (ScriptID 0 1) ; smallBase
			init:
		)
	)

	(method (doit)
		(if
			(and
				(& (gEgo onControl:) $0002)
				(== (gEgo illegalBits:) -32768)
				(not (gEgo script:))
			)
			(gEgo setPri: 11 illegalBits: 16384 baseSetter: (ScriptID 0 1)) ; smallBase
		)
		(if
			(and
				(& (gEgo onControl:) $0010)
				(not (& (gEgo onControl: 1) $0002))
				(not (gEgo script:))
			)
			(gEgo setPri: -1 illegalBits: -32768 baseSetter: 0)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0040)
				(!= (gEgo script:) fallHole)
			)
			(gCurRoom newRoom: 61) ; HauntedTowerMiddle
		)
		(if
			(and
				(& (gEgo onControl:) $0004)
				(!= (gEgo illegalBits:) 16384)
				(!= (gEgo script:) fallHole)
			)
			(HandsOff)
			(gEgo setScript: fallHole)
		)
		(super doit:)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room,tower'))
						(Print 58 0) ; "A dusty, old pipe organ sits in the center of the tower room."
					)
					((Said 'look>')
						(cond
							((or (Said '<down') (Said '/stair'))
								(Print 58 1) ; "The tower stairs spiral steeply downward."
							)
							((Said '<behind/organ')
								(Print 58 2) ; "There is nothing but dust behind the old organ."
							)
							((Said '<in/organ')
								(Print 58 3) ; "You see nothing in the organ."
							)
							((Said '/organ')
								(Print 58 4) ; "Dust and cobwebs cover the old organ."
							)
							((Said '/bench')
								(Print 58 5) ; "There is a bench in front of the old organ."
							)
							((Said '/wall')
								(Print 58 6) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 58 7) ; "There is nothing of interest on the floor."
							)
							((Said '/drawer')
								(if local1
									(if local3
										(Print 58 8) ; "You see a skeleton key in the drawer."
									else
										(Print 58 9) ; "You see an empty drawer."
									)
								else
									(Print 58 10) ; "What drawer?"
								)
							)
						)
					)
					((Said 'pull/bench')
						(Print 58 11) ; "There's no need to move the bench."
					)
					((Said 'play,use/music<sheet')
						(cond
							((== (gEgo view:) 58)
								(if (gEgo has: 26) ; Sheet_Music
									(Print 58 12) ; "You find it difficult to read the old sheet music, but you attempt it anyway."
									(playOrgan changeState: 10)
								else
									(Print 58 13) ; "What music?"
								)
							)
							((gEgo has: 26) ; Sheet_Music
								(Print 58 14) ; "You are not sitting at the organ."
							)
							(else
								(Print 58 13) ; "What music?"
							)
						)
					)
					((or (Said 'play,use/organ,music') (Said 'play[/!*]'))
						(if (== (gEgo view:) 58)
							(if (gEgo has: 26) ; Sheet_Music
								(Print 58 15) ; "You can only remember one "oldie, but goodie.""
							)
							(playOrgan changeState: 0)
						else
							(Print 58 16) ; "You're not sitting at the organ."
						)
					)
					((or (Said 'sit') (Said 'sit/organ,bench'))
						(cond
							((== (gEgo view:) 58)
								(Print 58 17) ; "You are already."
							)
							((gEgo inRect: 129 121 195 126)
								(self setScript: sitOrgan)
							)
							((gEgo inRect: 122 126 211 137)
								(Print 58 18) ; "It would be better to move to the inside of the bench."
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
					(
						(or
							(Said 'get<up')
							(Said 'stand[<up]')
							(Said 'exit/organ,bench')
						)
						(if (== (gEgo view:) 58)
							(self setScript: standOrgan)
						else
							(Print 58 19) ; "You are already standing."
						)
					)
					((Said 'get/key')
						(if local1
							(if local3
								(Print 58 20) ; "You take the skeleton key from the drawer."
								(= local3 0)
								(= global182 1)
								(gEgo get: 20) ; Skeleton_Key
								(gGame changeScore: 2)
							else
								(AlreadyTook) ; "You already took it."
							)
						else
							(Print 58 21) ; "What key?"
						)
					)
					((Said 'close/drawer')
						(if local1
							(Print 58 22) ; "There's no need to close the drawer."
						else
							(Print 58 23) ; "You don't see a drawer."
						)
					)
					((Said 'open/drawer')
						(if local1
							(Print 58 24) ; "The drawer is already open."
						else
							(Print 58 23) ; "You don't see a drawer."
						)
					)
					((Said 'open/bench')
						(Print 58 25) ; "The bench doesn't open."
					)
					((Said 'find/drawer')
						(if local1
							(Print 58 26) ; "You already found it."
						else
							(Print 58 27) ; "Drawer? What drawer?"
						)
					)
				)
			)
		)
	)
)

(instance playOrgan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(local0 loop: 2 setCycle: Fwd)
				(theMusic number: 56 loop: 1 play: self)
			)
			(1
				(Print 58 28) ; "What a virtuoso you are, Rosella!"
				(local0 cel: 0 loop: 4 setCycle: 0)
				(User canInput: 1)
				(theMusic loop: 0)
			)
			(10
				(HandsOff)
				((= local4 (View new:))
					view: 521
					loop: 0
					cel: 0
					posn: 162 95
					setPri: 6
					init:
				)
				(local0 loop: 2 setCycle: Fwd)
				(theMusic number: 57 loop: 1 play: self)
			)
			(11
				(if (== global193 0)
					(++ global193)
					(Print 58 29) ; "What is this? A small drawer has opened in the organ!"
					(gGame changeScore: 4)
					(local2 show: setCycle: End)
					(= local1 1)
				else
					(theMusic loop: 0)
					(local4 dispose:)
				)
				(local0 cel: 0 loop: 4 setCycle: 0)
				(local4 dispose:)
				(User canInput: 1)
			)
		)
	)
)

(instance theMusic of Sound
	(properties)
)

(instance sitOrgan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo setMotion: MoveTo 164 125 self)
			)
			(1
				(gEgo loop: 2)
				(self cue:)
			)
			(2
				((= local0 (Act new:))
					view: 58
					loop: 0
					cel: 0
					setPri: 9
					posn: (gEgo x:) (- (gEgo y:) 13)
					ignoreActors: 1
					illegalBits: 0
					init:
				)
				(gEgo view: 58 loop: 1 cel: 0)
				(gEgo setCycle: End)
				(local0 setCycle: End self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance standOrgan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo cel: 0 loop: 5 setCycle: End)
				(local0 cel: 0 loop: 4 setCycle: End self)
			)
			(1
				(gEgo setPri: -1 view: 4 loop: 3 setCycle: Walk)
				(local0 dispose:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fallHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic number: 51 loop: 1 play: self)
				(gEgo setMotion: 0)
				(HandsOff)
				(gEgo
					view: 44
					setStep: -1 10
					setCycle: Fwd
					setPri:
						(if (< (gEgo priority:) 11)
							(gEgo priority:)
						else
							11
						)
					illegalBits: 0
					setMotion: MoveTo 160 252
				)
			)
			(1
				(gCast eachElementDo: #hide)
				(if (gSounds contains: theMusic)
					(theMusic dispose:)
				)
				(gEgo hide:)
				(gCurRoom drawPic: 61 6)
				(theMusic number: 52 loop: 1 play:)
				(gEgo
					setStep: -1 10
					setCycle: Fwd
					illegalBits: 0
					posn: 160 10
					setPri: 14
					show:
					setLoop: (gEgo loop:)
					setMotion: MoveTo 160 150 self
				)
			)
			(2
				(gEgo setPri: 14 setMotion: MoveTo 160 256 self)
			)
			(3
				(if (gSounds contains: theMusic)
					(theMusic dispose:)
				)
				(gEgo hide:)
				(gCurRoom drawPic: 66 6)
				(theMusic number: 52 loop: 1 play:)
				(gEgo
					posn: 160 10
					show:
					setPri: -1
					setMotion: MoveTo 212 136 self
				)
			)
			(4
				(gSounds eachElementDo: #dispose)
				(gEgo view: 42)
				(RedrawCast)
				(ShakeScreen 10)
				(= seconds 3)
			)
			(5
				(= gDeathFlag 1)
			)
		)
	)
)

