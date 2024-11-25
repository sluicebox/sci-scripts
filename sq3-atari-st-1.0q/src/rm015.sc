;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm015 0
)

(local
	local0
)

(instance rm015 of Rm
	(properties
		style 0
	)

	(method (init &tmp [temp0 50])
		(if ((gInventory at: 3) ownedBy: 15) ; Reactor
			(self picture: 15)
		else
			(self picture: 157)
		)
		(self setLocales: 700)
		(HandsOff)
		(Load rsVIEW 19)
		(Load rsVIEW 29)
		(Load rsVIEW 32)
		(Load rsVIEW 6)
		(Load rsVIEW 33)
		(Load rsVIEW 34)
		(Load rsVIEW 35)
		(if (and (not (IsItemAt 2 8)) (not (gEgo has: 2))) ; Ladder, Ladder
			(Load rsVIEW 15)
		else
			(Load rsVIEW 288)
		)
		(if (!= gPrevRoomNum 3)
			(Load rsSOUND 56)
		)
		(if (and global133 (== gPrevRoomNum 3))
			(Load rsSOUND 11)
		)
		(Load rsSOUND 12)
		(= global132 0)
		(super init:)
		(self setScript: rmScript)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) global100 (event claimed:))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '[<around,at,in][/area,!*]')
						(if (IsItemAt 3) ; Reactor
							(Print 15 0) ; "You seem to be in a debris-enclosed hollow. Poking out of the ceiling is the chute which you originally entered through. Some crusty lamps linked by non-UL Approved wire provide additional illumination."
						else
							(Print 15 1) ; "You seem to be in a debris-enclosed hollow. Poking out of the ceiling is the chute which you originally entered through. Some crusty lamps linked by non-SQ Approved wire formerly provided additional illumination."
						)
					)
					((Said '/lamp')
						(if (IsItemAt 3) ; Reactor
							(Print 15 2) ; "The aging lamps add extra light to the area. Over-used wires link them to power."
						else
							(Print 15 3) ; "There's something that's in short supply. The only light here is that which manages to filter its way through the dense mesh of metals."
						)
					)
					((Said '/cable')
						(Print 15 4) ; "Some brittle-looking wire runs from lamp to lamp and then disappears into a hole to the left."
					)
					((and local0 (Said '/dog'))
						(Print 15 5) ; "They're rats!"
					)
					((and local0 (Said '/mice,animal,animal'))
						(Print 15 6) ; "You can hear something scurrying around above you. (You can't actually see the rats because they're hidden in the shadows.)"
					)
					((or (Said '/end<cable') (Said '/cable<end'))
						(if (gEgo inRect: 0 125 38 155)
							(if (IsItemAt 3) ; Reactor
								(Print 15 7) ; "They seem to be attached to a reactor."
							else
								(Print 15 8) ; "There is nothing interesting about loose wire ends."
							)
						else
							(Print 15 9) ; "They aren't visible here."
						)
					)
					((Said '/cavity')
						(cond
							((gEgo inRect: 0 125 38 155)
								(Print
									(Format ; "You peer into the small opening and notice %s."
										@global402
										15
										10
										(cond
											(
												(and
													(IsItemAt 3) ; Reactor
													(IsItemAt 0) ; Glowing_Gem
													(IsItemAt 1) ; Wire
												)
												{a tiny reactor which seems to be providing power for the lights, a formerly lustrous gem, and an unconnected wire}
											)
											((and (IsItemAt 3) (IsItemAt 0)) {a tiny reactor which seems to be providing power for the lights and a formerly lustrous gem}) ; Reactor, Glowing_Gem
											((and (IsItemAt 3) (IsItemAt 1)) {a tiny reactor which seems to be providing power for the lights and an unconnected wire}) ; Reactor, Wire
											((and (IsItemAt 0) (IsItemAt 1)) {a formerly lustrous gem, and an unconnected wire}) ; Glowing_Gem, Wire
											((IsItemAt 3) {a tiny reactor which seems to be providing power for the lights}) ; Reactor
											((IsItemAt 1) {an unconnected wire}) ; Wire
											((IsItemAt 0) {a formerly lustrous gem}) ; Glowing_Gem
											(else {nothing but crusty wire ends})
										)
									)
								)
							)
							((gEgo inRect: 248 69 265 77)
								(Print 15 11) ; "You notice nothing of interest."
							)
							(else
								(Print 15 12) ; "You can't from here."
							)
						)
					)
					((or (Said '<up[/ceiling,!*]') (Said '[<up]/ceiling'))
						(Print 15 13) ; "You stare at the ceiling which, as usual, is overhead. You see nothing particularly unique about the structure."
					)
					((Said '/left,partition<w')
						(Print 15 14) ; "This wall is the same as the others except that it has a small hole in it."
					)
					((Said 'climb/wing,cover')
						(Print 15 15) ; "All terrain nearby is chock-full of jagged edges and barbed protrusions. I wouldn't try that here."
					)
					((Said '/chute,door[<garbage]')
						(Print 15 16) ; "The chute juts into the room from high above. It is covered by two large doors. While staring at it, you briefly entertain the thought of trying to climb back up it. You realize that it is firmly sealed and forget about it."
					)
					((Said 'look/ladder')
						(if (IsItemAt 2) ; Ladder
							(Print 15 17) ; "It's a low-tech ascent/descent module"
						else
							(event claimed: 0)
						)
					)
					((or (Said '<down[/deck,!*]') (Said '[<down]/deck'))
						(Print 15 18) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal appears to have been cut from a variety of sources."
					)
					((Said '/partition[<north,e,s]')
						(Print 15 19) ; "The walls consist of compacted refuse. Yuck! There seems to be a small hole in the west one."
					)
					((Said '/heap,artifact,chunk')
						(Print 15 20) ; "In one of the piles you notice a severed wing and some empty cowlings of different shapes and sizes. The items were probably being readied for whatever destructive processing is done aboard this heap."
					)
					((Said '/wing')
						(Print 15 21) ; "The wing has been severed and is now worthless."
					)
					((Said '/cover')
						(Print 15 22) ; "The empty cowlings now cover nothing but useless junk."
					)
				)
			)
			((or (Said 'climb[/ladder]') (Said 'go<up/ladder'))
				(if (and (gEgo inRect: 248 69 265 77) (IsItemAt 2)) ; Ladder
					(gEgo setScript: ladderScript)
				else
					(Print 15 23) ; "There is no ladder near here to climb."
				)
			)
			((Said 'get>')
				(cond
					((Said '/ladder')
						(if
							(and
								(gEgo inRect: 248 69 265 77)
								((gInventory at: 2) ownedBy: 15) ; Ladder
							)
							(ladder dispose:)
							(gEgo get: 2) ; Ladder
							(gGame changeScore: 10)
							(Print 15 24) ; "You grab the ladder and jam it in your pocket."
							(Print 15 25) ; "Ouch!"
						else
							(Print 15 26) ; "There is no ladder near here to get."
						)
					)
					((or (Said '/end<cable') (Said '/cable<end'))
						(if (gEgo inRect: 0 125 38 155)
							(if (IsItemAt 3) ; Reactor
								(Print 15 7) ; "They seem to be attached to a reactor."
							else
								(Print 15 27) ; "They would not be helpful."
							)
						else
							(Print 15 27) ; "They would not be helpful."
						)
					)
					((Said '/artifact,wing,cover')
						(Print 15 28) ; "This stuff has no value to you."
					)
					((Said '/generator')
						(if (IsItemAt 3) ; Reactor
							(if (gEgo inRect: 0 125 38 155)
								(gGame changeScore: 15)
								(Print 15 29) ; "You unhook the reactor from the cheap wires and take it with you."
								(reactorScript init:)
							else
								(Print 15 30) ; "You aren't near it."
							)
						else
							(Print 15 31) ; "There isn't one here to get."
						)
					)
					((Said '/cable')
						(if (IsItemAt 1) ; Wire
							(if (gEgo inRect: 0 125 38 155)
								(Print 15 32) ; "OK."
								(gEgo get: 1) ; Wire
								(gGame changeScore: 5)
							else
								(NotClose) ; "It's not quite within reach."
							)
						else
							(event claimed: 0)
						)
					)
					((Said '/crystal')
						(if (IsItemAt 0) ; Glowing_Gem
							(if (gEgo inRect: 0 125 38 155)
								(Print 15 32) ; "OK."
								(gEgo get: 0) ; Glowing_Gem
								(gGame changeScore: 5)
							else
								(NotClose) ; "It's not quite within reach."
							)
						else
							(event claimed: 0)
						)
					)
					((Said '/all')
						(if (gEgo inRect: 0 125 38 155)
							(if (IsItemAt 0) ; Glowing_Gem
								(gEgo get: 0) ; Glowing_Gem
								(gGame changeScore: 5)
							)
							(if (IsItemAt 1) ; Wire
								(gEgo get: 1) ; Wire
								(gGame changeScore: 5)
							)
							(if (IsItemAt 3) ; Reactor
								(gEgo get: 3) ; Reactor
								(Print 15 32) ; "OK."
								(reactorScript init:)
								(gGame changeScore: 15)
							else
								(Print 15 32) ; "OK."
							)
						else
							(NotClose) ; "It's not quite within reach."
						)
					)
				)
			)
			((Said 'climb,crawl[<through,up,on]/partition,cavity,chute')
				(Print 15 33) ; "You'll not be successful that way."
			)
			((Said 'use,afix,(hook<up)/generator')
				(if (or (gEgo has: 3) (IsItemAt 3)) ; Reactor, Reactor
					(Print 15 34) ; "That won't further your progress."
				else
					(event claimed: 0)
				)
			)
			((Said 'erect,stand,drop,place,use/ladder[/cavity[<by,in]]')
				(if (gEgo inRect: 170 66 292 97)
					(if (gEgo has: 2) ; Ladder
						(putLadderScript init:)
					else
						(Print 15 35) ; "You don't have it."
					)
				else
					(Print 15 36) ; "Not from here."
				)
			)
			((Said 'open/chute,door')
				(Print 15 37) ; "The chute is covered by two large doors which you are unable to open."
			)
		)
	)

	(method (doit)
		(if (IsItemAt 3) ; Reactor
			(if
				(and
					(== (gEgo view:) 0)
					(or
						(== (gEgo onControl: 0) 4)
						(== (gEgo onControl: 0) 5)
					)
				)
				(gEgo view: 32)
			)
			(if (and (== (gEgo view:) 32) (== (gEgo onControl: 0) 1))
				(gEgo view: 0)
			)
		)
		(if
			(and
				(IsItemAt 2 8) ; Ladder
				(not gHandsOff)
				(gEgo inRect: 165 150 175 186)
			)
			(HandsOff)
			(self setScript: mugScript)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 988)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doors init:)
				(if ((gInventory at: 2) ownedBy: 15) ; Ladder
					(ladder init: stopUpd:)
				)
				(if (== gPrevRoomNum 3)
					(gEgo setScript: ladderScript)
					(doors stopUpd:)
				else
					(= cycles 3)
				)
			)
			(1
				(doors setCycle: End self)
			)
			(2
				(gEgo
					view: 35
					posn: 70 120
					setPri: 8
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					init:
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				(doors stopUpd:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
				(thump play:)
			)
			(4
				(gEgo hide:)
				(doors setCycle: Beg self)
			)
			(5
				(doors addToPic:)
				(Print 15 38) ; "Fortunately, you come to a relatively soft landing in a pile of debris."
				(= seconds 2)
			)
			(6
				(HandsOn)
				(gEgo
					view: (if (IsItemAt 3) 32 else 6) ; Reactor
					illegalBits: $8000
					posn: 80 132
					setLoop: -1
					setPri: -1
					loop: 2
					setStep: 3 2
					show:
					cycleSpeed: 0
					setCycle: Walk
				)
				(if (and (IsItemAt 3) (not (IsItemAt 2 8))) ; Reactor, Ladder
					(ratsScript init:)
				)
				(if (and global133 (== gPrevRoomNum 3))
					(gLongSong number: 11 loop: -1 play:)
				)
				(= global100 0)
			)
		)
	)
)

(instance reactorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ladder setLoop: 1 forceUpd:)
				(gEgo get: 3 view: 6) ; Reactor
				(gCurRoom drawPic: 157)
				(doors setLoop: 1 init: addToPic:)
				(rat1 setLoop: 4 init: addToPic:)
				(rat2 setLoop: 4 init: addToPic:)
				(rat3 setLoop: 4 init: addToPic:)
				(eye1 setLoop: 5)
				(eye2 setLoop: 6)
				(eye3 setLoop: 7)
			)
		)
	)
)

(instance mugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 15 39) ; "You hear strange growls which send chills through your sleek, yet rugged, frame. What could it be?"
				(Print 15 40) ; "Suddenly, two hideous figures rush from the shadows toward you!"
				(gEgo view: 288 setLoop: 0 setMotion: MoveTo 170 145 self)
			)
			(1
				(gEgo setLoop: 1 setCycle: Fwd)
				(mugRat1 init: setCycle: Walk setMotion: MoveTo 165 145 self)
				(mugRat2 init: setCycle: Walk setMotion: MoveTo 175 145)
			)
			(2
				(cloud init:)
				(rumble play:)
				(gEgo hide:)
				(mugRat1 hide:)
				(mugRat2 hide:)
				(= seconds 6)
			)
			(3
				(gEgo
					setLoop: 2
					posn: (- (gEgo x:) 20) (- (gEgo y:) 7)
					show:
					stopUpd:
				)
				(mugRat1
					setLoop: 1
					x: (- (mugRat1 x:) 50)
					show:
					setMotion: MoveTo 20 155 self
				)
				(mugRat2
					setLoop: 0
					x: (+ (mugRat2 x:) 50)
					show:
					setMotion: MoveTo 320 155
				)
				(cloud dispose:)
				(rumble stop:)
			)
			(4
				(Print 15 41) ; "Oh my! It appears that your being trapped has made you a prime target for rodent ruffians. What a mess!"
				(EgoDead 901 0 2 3)
			)
		)
	)
)

(instance ladderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 19
					setLoop: (if (IsItemAt 3) 0 else 1) ; Reactor
					setPri: 4
					illegalBits: 0
					ignoreActors: 1
				)
				(if (gEgo inRect: 248 69 265 77)
					(gEgo posn: 258 73 setMotion: MoveTo 258 23 self)
				else
					(gEgo
						posn: 258 23
						init:
						setMotion: MoveTo 258 73 self
						setCycle: Rev
					)
				)
			)
			(1
				(if (gEgo inRect: 248 69 265 77)
					(gEgo
						setPri: -1
						setLoop: -1
						view: (if (not (IsItemAt 3)) 6 else 0) ; Reactor
						setCycle: Walk
						illegalBits: $8000
						ignoreActors: 0
					)
					(User canControl: 1 canInput: 1)
					(= global100 0)
				else
					(gCurRoom newRoom: 3)
				)
			)
		)
	)
)

(instance putLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= global100 1)
				(gEgo setMotion: MoveTo 258 76 self)
			)
			(1
				(gEgo loop: 3)
				(ladder setLoop: (if (IsItemAt 3) 0 else 1) init: stopUpd:) ; Reactor
				(PutItem 2) ; Ladder
				(gGame changeScore: -10)
				(= global100 0)
				(User canControl: 1)
			)
		)
	)
)

(instance ratsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ratTune play:)
				(rat1 posn: -24 242 init: setMotion: MoveTo 24 194 self)
				(= local0 1)
			)
			(1
				(rat1 addToPic:)
				(eye1 init: startExtra:)
				(rat2 posn: 348 227 init: setMotion: MoveTo 297 176 self)
			)
			(2
				(rat2 addToPic:)
				(eye2 init: startExtra:)
				(rat3 posn: 303 2)
				(rat3 init: posn: 303 2 setMotion: MoveTo 261 44 self)
			)
			(3
				(rat3 addToPic:)
				(eye3 init: startExtra:)
			)
		)
	)
)

(instance doors of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 33
			loop: (if (IsItemAt 3) 0 else 1) ; Reactor
			cel: 0
			posn: 64 110
			setPri: 8
			cycleSpeed: 2
		)
	)
)

(instance ladder of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 29
			setLoop: (if (IsItemAt 3) 0 else 1) ; Reactor
			setCel: 0
			posn: 256 70
		)
	)
)

(instance rat1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 34
			setLoop: (if (IsItemAt 3) 0 else 4) ; Reactor
			setCel: 0
			setStep: 3 3
			illegalBits: 0
			setPri: 15
			setCycle: 0
		)
	)
)

(instance rat2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 34
			setLoop: (if (IsItemAt 3) 0 else 4) ; Reactor
			setCel: 1
			setStep: 3 3
			illegalBits: 0
			setPri: 15
			setCycle: 0
		)
	)
)

(instance rat3 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 34
			setLoop: (if (IsItemAt 3) 0 else 4) ; Reactor
			setCel: 2
			setStep: 3 3
			illegalBits: 0
			ignoreHorizon:
			setPri: 15
			setCycle: 0
		)
	)
)

(instance eye1 of Extra
	(properties)

	(method (init)
		(super init:)
		(self
			view: 34
			loop: (if (IsItemAt 3) 1 else 5) ; Reactor
			cel: 0
			posn: 18 171
			setPri: 15
			cycleSpeed: 2
			pauseCel: 0
			minPause: 20
			maxPause: 50
			minCycles: 2
			maxCycles: 4
			isExtra: 1
		)
	)
)

(instance eye2 of Extra
	(properties)

	(method (init)
		(super init:)
		(self
			view: 34
			loop: (if (IsItemAt 3) 2 else 6) ; Reactor
			cel: 0
			posn: 285 153
			setPri: 15
			cycleSpeed: 2
			pauseCel: 0
			minPause: 20
			maxPause: 50
			minCycles: 2
			maxCycles: 4
			isExtra: 1
		)
	)
)

(instance eye3 of Extra
	(properties)

	(method (init)
		(super init:)
		(self
			view: 34
			loop: (if (IsItemAt 3) 3 else 7) ; Reactor
			cel: 0
			posn: 249 30
			setPri: 15
			cycleSpeed: 2
			pauseCel: 0
			minPause: 50
			maxPause: 100
			minCycles: 2
			maxCycles: 4
			isExtra: 1
		)
	)
)

(instance mugRat1 of Act
	(properties
		view 15
	)

	(method (init)
		(super init:)
		(self
			setLoop: 0
			ignoreActors: 1
			illegalBits: 0
			posn: 20 155
			setStep: 12 2
		)
	)
)

(instance mugRat2 of Act
	(properties
		view 15
	)

	(method (init)
		(super init:)
		(self
			setLoop: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 320 155
			setStep: 12 2
		)
	)
)

(instance cloud of Prop
	(properties
		view 15
	)

	(method (init)
		(super init:)
		(self
			setLoop: 3
			ignoreActors: 1
			posn: (- (gEgo x:) 1) (- (gEgo y:) 1)
			setPri: (+ (gEgo priority:) 1)
			setCycle: Fwd
		)
	)
)

(instance ratTune of Sound
	(properties
		number 12
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 2
	)
)

(instance rumble of Sound
	(properties
		number 60
		priority 2
		loop -1
	)
)

