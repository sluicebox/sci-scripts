;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	Room69 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance fallMusic of Sound
	(properties)
)

(instance mummyMusic of Sound
	(properties)
)

(instance ladderSpace of Blk
	(properties
		top 146
		left 90
		bottom 152
		right 96
	)
)

(instance Room69 of Rm
	(properties
		picture 69
		style 16
	)

	(method (init)
		(Load rsVIEW 520)
		(Load rsVIEW 522)
		(Load rsVIEW 195)
		(Load rsVIEW 196)
		(Load rsVIEW 197)
		(Load rsVIEW 4)
		(Load rsVIEW 38)
		(Load rsVIEW 519)
		(Load rsVIEW 683)
		(Load rsVIEW 44)
		(Load rsVIEW 41)
		(Load rsVIEW 40)
		(Load rsVIEW 42)
		(Load rsVIEW 37)
		(Load rsVIEW 39)
		(super init:)
		(= local7 0)
		(= local6 0)
		(= gIndoors 1)
		((View new:) view: 522 loop: 3 cel: 0 posn: 253 72 addToPic:)
		((Prop new:) view: 522 loop: 2 cel: 0 posn: 252 58 init: setCycle: Fwd)
		((= local1 (View new:))
			view: 520
			loop: 2
			cel: 0
			setPri: 7
			posn: 160 113
			init:
			stopUpd:
		)
		((= local2 (Prop new:))
			view: 520
			ignoreActors: 1
			setPri: 8
			loop: 0
			cel: 0
			posn: (- (local1 x:) 4) (local1 y:)
			init:
			stopUpd:
		)
		((= local0 (Prop new:))
			view: 522
			setCel: (if global170 255 else 0)
			setPri: 11
			ignoreActors: 1
			posn: 98 88
			init:
		)
		((= local3 (Act new:))
			view: 195
			illegalBits: 0
			setPri: 7
			posn: (local1 x:) (local1 y:)
			init:
		)
		(if ((Inv at: 4) ownedBy: 69) ; Pandora_s_Box
			((= local4 (Act new:))
				view: 519
				illegalBits: 0
				ignoreActors: 0
				posn: 260 172
				init:
			)
		)
		(gEgo
			posn: 41 87
			view: 4
			loop: 0
			ignoreActors: 1
			setStep: 4 1
			illegalBits: -32768
			setPri: 11
			init:
		)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(User canControl: 1 canInput: 1)
			(gEgo setPri: -1)
			(gCurRoom newRoom: 18)
		)
		(if (and (& (gEgo onControl: 1) $0004) (== (gEgo script:) 0))
			(User canControl: 0 canInput: 0)
			(gEgo setScript: cryptFall)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room,crypt'))
						(Print
							(Format ; "What an incredible place! This looks like an ancient burial tomb, with hieroglyphics written on the walls, and an old coffin against the far wall. %s %s"
								@global300
								69
								0
								(if (== global170 0)
									{A pile of rope is at the edge of the upper platform.}
								else
									{ }
								)
								(if (== ((Inv at: 4) owner:) 69) ; Pandora_s_Box
									{You see an odd-looking, little chest here. It must be Pandora's Box.}
								else
									{ }
								)
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/epitaph')
								(Print 69 1) ; "You cannot read the ancient hieroglyphics."
							)
							(
								(and
									(Said '<in/casket[<elderly]')
									(< (gEgo distanceTo: local1) 25)
								)
								(Print 69 2) ; "You don't want to do that!"
							)
							((Said '/casket')
								(Print 69 3) ; "The lid of the coffin is decorated with hieroglyphics."
							)
							((or (Said '/hemp,ladder') (Said '/hemp[<heap]'))
								(if (== global170 0)
									(Print 69 4) ; "You see a pile of rope on the end of the platform."
								else
									(Print 69 5) ; "A rope ladder extends from the platform down to the bottom of the crypt."
								)
							)
							((Said '/platform')
								(if (== global170 0)
									(Print 69 4) ; "You see a pile of rope on the end of the platform."
								else
									(Print 69 6) ; "The platform towers over the floor of the crypt."
								)
							)
							((Said '/wall')
								(Print 69 7) ; "There are ancient hieroglyphics on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(if (== ((Inv at: 4) owner:) 69) ; Pandora_s_Box
									(Print 69 8) ; "Pandora's Box is on the floor of the crypt."
								else
									(Print 69 9) ; "There is nothing of interest on the floor."
								)
							)
							((Said '/mummy')
								(if local8
									(Print 69 10) ; "This mummy appears to be at least a thousand years old! Its' wrappings are loose and decayed...and it stinks!"
								else
									(Print 69 11) ; "There is no mummy here."
								)
							)
							((Said '/box[<pandora]')
								(cond
									((== ((Inv at: 4) owner:) 69) ; Pandora_s_Box
										(Print 69 8) ; "Pandora's Box is on the floor of the crypt."
									)
									((gEgo has: 4) ; Pandora_s_Box
										(event claimed: 0)
									)
									(else
										(Print 69 12) ; "There is no box here."
									)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'get,pull/hemp,ladder,heap')
						(cond
							(global170
								(Print 69 13) ; "The rope is fine where it is."
							)
							((> (gEgo distanceTo: local0) 25)
								(Print 800 1) ; "You're not close enough."
							)
							(else
								(Print 69 14) ; "You reach down and get the pile of rope. To your happy surprise, you find that the rope is actually a rope ladder attached to the end of the platform! Gladly, you throw the rope ladder over the edge of the platform, where it falls to the floor below."
								(gGame changeScore: 2)
								(User canControl: 0 canInput: 0)
								(gEgo setMotion: 0)
								(= local6 1)
								(local0 setScript: DropRope)
							)
						)
					)
					((Said 'climb[/(hemp,ladder)]>')
						(cond
							((not global170)
								(event claimed: 1)
								(Print 800 3) ; "You can't do that now."
							)
							((or (Said '<down') (not local7))
								(event claimed: 1)
								(if (> (gEgo distanceTo: local0) 20)
									(Print 800 1) ; "You're not close enough."
								else
									(gEgo setScript: DownLadder)
								)
							)
							((or (Said '<up') local7)
								(event claimed: 1)
								(if (not (gEgo inRect: 99 142 120 158))
									(Print 800 1) ; "You're not close enough."
								else
									(gEgo ignoreBlocks: ladderSpace)
									(DownLadder changeState: 14)
								)
							)
						)
					)
					((Said 'get/box')
						(cond
							((not local7)
								(Print 69 15) ; "Not from up here!"
							)
							((gEgo has: 4) ; Pandora_s_Box
								(Print 69 16) ; "You already have it."
							)
							((!= ((Inv at: 4) owner:) 69) ; Pandora_s_Box
								(Print 69 17) ; "It's not here."
							)
							((> (gEgo distanceTo: local4) 20)
								(Print 800 1) ; "You're not close enough."
							)
							(else
								(gEgo setScript: stoop)
							)
						)
					)
					((Said 'place,drop/box')
						(cond
							((not (gEgo has: 4)) ; Pandora_s_Box
								(Print 69 18) ; "You don't have it."
							)
							((not local7)
								(Print 69 15) ; "Not from up here!"
							)
							(else
								(gEgo setScript: putBack)
							)
						)
					)
					((Said 'open/box')
						(cond
							((not (gEgo has: 4)) ; Pandora_s_Box
								(Print 69 18) ; "You don't have it."
							)
							((not local7)
								(Print 69 19) ; "You can't do that here."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'read/(epitaph,wall,casket,lid)')
						(Print 69 1) ; "You cannot read the ancient hieroglyphics."
					)
					((Said 'get,rob,get,pull/casket')
						(Print 69 20) ; "It's too heavy to move."
					)
					((Said 'bang[<on]/casket')
						(if (< (gEgo distanceTo: local1) 15)
							(Print 69 21) ; "There's no answer."
						else
							(Print 69 22 #at -1 20) ; "You'll have to get a little closer, Rosella."
						)
					)
					((Said 'open/casket,lid')
						(cond
							((not local7)
								(NotClose) ; "You're not close enough."
							)
							((local2 cel:)
								(Print 69 23 #at -1 20) ; "It's already closed!"
							)
							(else
								(Print 69 2) ; "You don't want to do that!"
							)
						)
					)
					((Said 'get,pull/casket')
						(if local7
							(Print 69 24) ; "The coffin is much too heavy for you to move."
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said 'talk')
						(if local8
							(Print 69 25) ; "You attempt a conversation with the old mummy, and receive nothing but a low moan in reply."
						else
							(Print 69 26) ; "There is no one here who you can talk to."
						)
					)
					((Said '/mummy>')
						(cond
							((not local8)
								(event claimed: 1)
								(Print 69 11) ; "There is no mummy here."
							)
							((Said 'kill')
								(Print 69 27) ; "How can you kill something that is already dead?"
							)
							((Said 'get,capture')
								(Print 69 28) ; "Why would you want it?"
							)
							((Said 'kiss')
								(Print 69 29) ; "What a horrible thought!"
							)
							((Said 'help,save')
								(Print 69 30) ; "It's beyond help."
							)
						)
					)
					((Said 'give/*/mummy')
						(if local8
							(Print 69 31) ; "The mummy doesn't need anything."
						else
							(Print 69 11) ; "There is no mummy here."
						)
					)
				)
			)
		)
	)
)

(instance doMummy of Script
	(properties)

	(method (doit)
		(if (and (== (self state:) 2) (< (gEgo distanceTo: local3) 25))
			(local3 setMotion: 0)
			(self changeState: 3)
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 69 32 #at -1 20 #time 3) ; "Look out for the mummy!!"
				(local2 priority: 8)
				(= local8 1)
				(local3 show:)
				(local2 setCycle: End self)
			)
			(1
				(local3 setCycle: End self)
			)
			(2
				(local3
					view: 196
					setCycle: Walk
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setPri: 9
					setStep: 3 2
					setMotion: MoveTo 145 135 self
				)
				(mummyMusic number: 27 init: loop: 1 play:)
			)
			(3
				(local2 ignoreActors: 0 stopUpd:)
				(if (gEgo has: 7) ; Obsidian_Scarab
					(Print 69 33 #at -1 20 #time 4) ; "The mummy runs from your powerful scarab."
					(self changeState: 5)
				else
					(Print 69 34 #at -1 20 #time 5) ; "How did you get here without the scarab? You will be the next victim of the mummy!!"
					(self changeState: 20)
				)
			)
			(5
				(local3
					setPri: 9
					ignoreActors: 1
					setMotion: MoveTo (local1 x:) (local1 y:) self
				)
			)
			(6
				(local3 view: 195 setPri: 7 loop: 0 setCycle: Beg self)
			)
			(7
				(local2 ignoreActors: 1 setCycle: Beg self)
			)
			(8
				(local3 hide:)
				(= local8 0)
				(mummyMusic dispose:)
				(local2 setPri: 7 stopUpd:)
				(= state -1)
				(client setScript: 0)
			)
			(20
				(local3 moveSpeed: 0 setMotion: Chase gEgo 15 self)
			)
			(21
				(Print 69 35) ; "Boy, those guys are sometimes fast for their age!"
				(= gDeathFlag 1)
			)
		)
	)
)

(instance DownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: 0)
				(self cue:)
			)
			(1
				(gEgo
					view: 38
					setLoop: 0
					illegalBits: 0
					posn: 98 88
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 setCycle: End self)
			)
			(3
				(gEgo
					view: 39
					x: 98
					y: (+ (gEgo y:) 35)
					setLoop: 1
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Rev
					setMotion: MoveTo 98 150 self
				)
			)
			(4
				(gEgo loop: 0 posn: 104 150 setCycle: Beg self)
			)
			(5
				(gEgo
					view: 4
					posn: 107 150
					setLoop: -1
					cycleSpeed: 0
					moveSpeed: 0
					loop: 1
					setPri: -1
					setCycle: Walk
					illegalBits: -32768
					ignoreActors: 0
				)
				(self cue:)
			)
			(6
				(= local7 1)
				(= local6 0)
				(gEgo observeBlocks: ladderSpace)
				(User canControl: 1 canInput: 1)
				(self cue:)
			)
			(7
				(if (== (local3 script:) 0)
					(local3 setScript: doMummy)
				)
			)
			(14
				(User canControl: 0 canInput: 0)
				(gEgo
					view: 39
					setLoop: 0
					setMotion: 0
					illegalBits: 0
					posn: 107 152
					script: DownLadder
					setCycle: End self
					forceUpd:
				)
			)
			(15
				(gEgo
					view: 39
					x: 98
					setPri: 11
					setLoop: 1
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo (+ (local0 x:) 0) (+ (local0 y:) 35) self
				)
			)
			(16
				(gEgo
					view: 38
					posn: 96 (local0 y:)
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 1
					setCycle: Beg self
				)
			)
			(17
				(self cue:)
			)
			(18
				(gEgo
					view: 4
					posn: 80 88
					setLoop: -1
					setCycle: Walk
					illegalBits: -32768
				)
				(User canControl: 1 canInput: 1)
				(= state -1)
				(= local6 0)
				(= local7 0)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance DropRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 70 88 self)
			)
			(1
				(gEgo view: 37 setLoop: 0 setCycle: End self)
			)
			(2
				(local0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(local0 stopUpd:)
				(= global170 1)
				(gEgo view: 41 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 4 setLoop: -1 setCycle: Walk)
				(User canControl: 1 canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance cryptFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setPri: (if (< (gEgo y:) 84) -1 else 12)
				)
				(self cue:)
			)
			(1
				(fallMusic number: 51 play:)
				(gEgo view: 44 moveSpeed: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 2 xStep: 10 yStep: 10 setCycle: Fwd)
				(if (< (gEgo y:) 84)
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 10)
							(+ (gEgo y:) 60)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 10)
							(+ (gEgo y:) 70)
							self
					)
				)
			)
			(3
				(gEgo view: 42 setLoop: 0 setCel: 0 setPri: -1)
				(RedrawCast)
				(fallMusic dispose:)
				(ShakeScreen 5)
				(= seconds 1)
			)
			(4
				(Print 69 36 #width 100 #at -1 20) ; "Oops! You slipped."
				(= seconds 4)
			)
			(5
				(client setScript: 0)
				(= gDeathFlag 1)
			)
		)
	)
)

(instance stoop of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 40 cel: 0 setCycle: End self)
				(if (> (gEgo x:) (local4 x:))
					(gEgo loop: 1)
				else
					(gEgo loop: 0)
				)
			)
			(1
				(gEgo get: 4) ; Pandora_s_Box
				(local4 dispose:)
				(if (not global218)
					(= global218 1)
					(= global182 1)
					(gGame changeScore: 4)
				)
				(if (== global169 0)
					(gGame changeScore: -2)
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo view: 4 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance putBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 40 cel: 0 setCycle: End self)
				(if (> (gEgo x:) 160)
					(gEgo loop: 1)
				else
					(gEgo loop: 0)
				)
			)
			(1
				(gEgo put: 4 69) ; Pandora_s_Box
				(if (== global169 0)
					(gSounds eachElementDo: #dispose)
					((Sound new:) number: 50 loop: 1 play:)
					(gGame changeScore: 2)
				)
				((= local4 (Act new:))
					view: 519
					posn:
						(if (> (gEgo x:) 160)
							(- (gEgo x:) 20)
						else
							(+ (gEgo x:) 20)
						)
						(gEgo y:)
					init:
				)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo view: 4 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

