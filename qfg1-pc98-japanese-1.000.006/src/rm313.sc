;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use SmoothLooper)
(use Chase)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm313 0
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
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
)

(procedure (localproc_0)
	(HighPrint 313 0) ; "The smell of lavender and dust fills your nose as you walk in. This reminds you of a great aunt's house you once visited. The couch looks every bit as uncomfortable as your aunt's."
	(HighPrint 313 1) ; "There is a covered birdcage near the stairs, and a knitting basket beside the couch."
)

(procedure (localproc_1)
	(SolvePuzzle 629 3 2)
	(cond
		((or (== (catWalk state:) 6) (== (catWalk state:) 7))
			(= local12 0)
			(catWalk changeState: 8)
		)
		((& (gEgo onControl: 1) $4000)
			(HighPrint 313 2) ; "Just wait. He'll catch up to you"
		)
		(else
			(NotClose)
		)
	)
)

(procedure (localproc_2)
	(cond
		((IsFlag 132)
			(AlreadyDone)
		)
		((< (gEgo distanceTo: local4) 15)
			(HighPrint 313 3) ; "In the purse, you find 20 silvers and some soiled hankies. You take the silver."
			(gEgo get: 1 20) ; silver
			(SetFlag 132)
			(SolvePuzzle 626 1 2)
		)
		(else
			(NotClose)
		)
	)
)

(procedure (localproc_3)
	(cond
		((IsFlag 131)
			(AlreadyDone)
		)
		((< (gEgo distanceTo: local3) 15)
			(HighPrint 313 4) ; "A string of pearls seems to have fallen into the bag among the knitting. You take the pearls, of course."
			(gEgo get: 18) ; pearl
			(SetFlag 131)
			(SolvePuzzle 627 1 2)
		)
		(else
			(NotClose)
		)
	)
)

(procedure (localproc_4)
	(cond
		((IsFlag 134)
			(HighPrint 313 5) ; "You find nothing else of value in the desk."
		)
		((gEgo inRect: 22 131 53 152)
			(SolvePuzzle 624 1 2)
			(gEgo setScript: deskOpen)
		)
		(else
			(NotClose)
		)
	)
)

(procedure (localproc_5)
	(cond
		((IsFlag 135)
			(AlreadyDone)
		)
		((< (gEgo distanceTo: local0) 25)
			(gEgo setScript: birdieSings)
		)
		(else
			(NotClose)
		)
	)
)

(instance cat of Act
	(properties)
)

(instance catTurn of SmoothLooper
	(properties
		vChangeDir 637
	)
)

(instance rm313 of Rm
	(properties
		picture 313
		style 2
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 92)
		(= global325 (SoundFX 26))
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 313 635 636 525)
		(Load rsSOUND 8)
		(Load rsSOUND (SoundFX 52))
		(super init:)
		(SolvePuzzle 623 5 2)
		(gMouseHandler add: self)
		(SL enable:)
		(NormalEgo)
		(gEgo posn: 159 189 init: setMotion: MoveTo 159 170)
		(= global325 (SoundFX 52))
		(cat
			view: 635
			loop: 4
			posn: 280 165
			init:
			moveSpeed: 1
			setStep: 3 1
			setCycle: Walk
			setScript: catWalk
		)
		((= local0 (Prop new:))
			view: 313
			loop: 2
			cel: 0
			posn: 209 110
			z: 22
			init:
			stopUpd:
		)
		((= local1 (Prop new:))
			view: 313
			loop: 1
			cel: 0
			posn: 31 135
			init:
			setPri: 10
			stopUpd:
		)
		((= local2 (View new:))
			view: 313
			loop: 2
			cel: 2
			posn: 279 95
			stopUpd:
			addToPic:
		)
		((= local5 (View new:))
			view: 313
			loop: 2
			cel: 3
			posn: 71 116
			stopUpd:
			addToPic:
		)
		((= local6 (View new:))
			view: 313
			loop: 2
			cel: 4
			posn: 28 124
			setPri: 11
			stopUpd:
			addToPic:
		)
		((= local4 (View new:))
			view: 313
			loop: 2
			cel: 6
			posn: 81 141
			z: 12
			init:
			setPri: 10
			stopUpd:
		)
		((= local3 (View new:))
			view: 313
			loop: 2
			cel: 5
			posn: 172 136
			setPri: 10
			init:
			stopUpd:
		)
		((View new:)
			view: 313
			loop: 0
			cel: 0
			posn: 117 149
			ignoreActors:
			setPri: 12
			init:
			stopUpd:
			addToPic:
		)
		(if (not (IsFlag 133))
			((= local7 (View new:))
				view: 313
				loop: 2
				cel: 1
				posn: 87 148
				ignoreActors:
				setPri: 12
				init:
				stopUpd:
			)
			((= local8 (View new:))
				view: 313
				loop: 2
				cel: 1
				posn: 142 148
				ignoreActors:
				setPri: 12
				init:
				stopUpd:
			)
		)
		(self setLocales: 801)
		(self setScript: first313Script)
		(sillyThief init: play:)
	)

	(method (doit)
		(cond
			((> (gEgo y:) 189)
				(= global111 gDay)
				(gCurRoom newRoom: 310)
			)
			(
				(and
					(& (gEgo onControl: 1) $2000)
					(== (gEgo loop:) 1)
					(!= local9 1)
				)
				(= local9 1)
				(gEgo setScript: climbUp1)
			)
			(
				(and
					(& (gEgo onControl: 1) $1000)
					(== (gEgo loop:) 1)
					(!= local9 2)
				)
				(= local9 2)
				(gEgo setScript: climbUp2)
			)
			(
				(and
					(& (gEgo onControl: 1) $0800)
					(== (gEgo loop:) 1)
					(!= local9 3)
				)
				(= local9 3)
				(gEgo setScript: climbUp3)
			)
			((and (< (gEgo y:) 103) (== (gEgo loop:) 0))
				(gEgo setScript: climbDown)
			)
			((== (gEgo onControl: 1) 1024)
				(= local9 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,(look,look<in)>')
				(cond
					((Said '/purse')
						(localproc_2)
					)
					((Said '/bag,basket')
						(localproc_3)
					)
					((Said '/birdcage,birdcage')
						(localproc_5)
					)
					((Said '/couch')
						(cond
							((IsFlag 130)
								(HighPrint 313 6) ; "You find nothing else by searching the couch."
							)
							((gEgo inRect: 80 125 150 145)
								(HighPrint 313 7) ; "You find 3 silvers that have fallen down into the cushions."
								(gEgo get: 1 3) ; silver
								(SetFlag 130)
								(SolvePuzzle 625 1 2)
							)
							(else
								(NotClose)
							)
						)
					)
					((Said '/desk,drawer')
						(localproc_4)
					)
					((Said '/plant')
						(if
							(or
								(< (gEgo distanceTo: local5) 15)
								(gEgo inRect: 22 131 53 152)
							)
							(HighPrint 313 8) ; "Nothing but dirt and leaves there."
						else
							(NotClose)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'open,open,open>')
				(cond
					((Said '/desk,drawer')
						(localproc_4)
					)
					((Said '/purse')
						(localproc_2)
					)
					((Said '/bag,basket')
						(localproc_3)
					)
					((Said '/birdcage,birdcage')
						(localproc_5)
					)
				)
			)
			((Said 'get,get>')
				(cond
					((Said '/candlestick,stick,holder,candle')
						(cond
							((IsFlag 133)
								(AlreadyDone)
							)
							((gEgo inRect: 62 145 166 165)
								(HighPrint 313 9) ; "You take the silver candlesticks and stow them in your pack."
								(gEgo get: 17 2) ; candlestick
								(local7 dispose:)
								(local8 dispose:)
								(SetFlag 133)
								(SolvePuzzle 628 1 2)
							)
							(else
								(NotClose)
							)
						)
					)
					((Said '/purse')
						(localproc_2)
					)
					((Said '/bag,basket')
						(localproc_3)
					)
					((Said '/couch')
						(HighPrint 313 10) ; "Call Mayflower!"
					)
				)
			)
			(
				(or
					(Said 'lift,lift,get/cover')
					(Said 'uncover/birdcage,birdcage')
				)
				(localproc_5)
			)
			((Said 'look,look[<at,around][/!*,room,building]')
				(localproc_0)
			)
			((or (Said 'look,look<up') (Said 'look,look/ceiling'))
				(HighPrint 313 11) ; "Nothing up there."
			)
			((or (Said 'look,look<down') (Said 'look,look/floor'))
				(HighPrint 313 12) ; "The rug is blue, and the floor has recently been painted red."
			)
			((Said 'look,look/dust')
				(HighPrint 313 13) ; "The house is tidy, but there is a layer of dust over everything."
			)
			((or (MouseClaimed onRug event 3) (Said 'look,look/carpet'))
				(HighPrint 313 14) ; "The oval rug is blue to match the walls."
			)
			((Said 'look,look/ladder,door')
				(HighPrint 313 15) ; "The stairs lead to the door to an upstairs room."
			)
			((MouseClaimed onDoor event 3)
				(HighPrint 313 16) ; "The door to the upstairs room."
			)
			((Said 'look,look/wall')
				(HighPrint 313 17) ; "The walls are a deep shade of blue."
			)
			((or (MouseClaimed onFireplace event 3) (Said 'look,look/chimney'))
				(HighPrint 313 18) ; "The fire is out, but the heat from the hearth is still felt in the room."
			)
			((or (MouseClaimed onFireplace event 3) (Said 'look,look/chimney'))
				(HighPrint 313 18) ; "The fire is out, but the heat from the hearth is still felt in the room."
			)
			((or (MouseClaimed onPurse event 3) (Said 'look,look/purse,couch'))
				(HighPrint 313 19) ; "The Little Old Lady left her purse on the couch. Mighty careless."
			)
			((or (MouseClaimed onLamp event 3) (Said 'look,look/mantle'))
				(HighPrint 313 20) ; "On the mantle sits an ordinary hurricane lamp which provides the only light in the room."
			)
			(
				(or
					(MouseClaimed onLCandle event 3)
					(MouseClaimed onRCandle event 3)
					(Said 'look,look/candle,candlestick')
				)
				(if (not (gEgo has: 17)) ; candlestick
					(HighPrint 313 21) ; "The candlesticks are heavy, ornate and made of sterling silver."
				)
			)
			((Said 'look,look/table')
				(if (gEgo has: 17) ; candlestick
					(HighPrint 313 22) ; "There is a lace doily on the wooden table."
				else
					(HighPrint 313 23) ; "There is a lace doily in the center of the wooden table and a pair of silver candlesticks on either side of it."
				)
			)
			((or (MouseClaimed onDoily event 3) (Said 'look,look/doily'))
				(HighPrint 313 24) ; "The doily is lacy and shows fine workmanship. It is slightly yellow with age."
			)
			(
				(or
					(MouseClaimed onCage event 3)
					(Said 'look,look/birdcage,birdcage,stand,stand,cover')
				)
				(HighPrint 313 25) ; "The birdcage is on a tall brass stand. There is a cover draped over it to keep the bird warm and quiet."
			)
			((Said 'look,look/bird')
				(if local17
					(HighPrint 313 26) ; "Cute but NOISY!."
				else
					(HighPrint 313 27) ; "The cage is covered, and you can't see the bird."
				)
			)
			((or (MouseClaimed cat event 3) (Said 'look,look/cat'))
				(HighPrint 313 28) ; "The little house cat seems harmless, but strangely restless."
			)
			((or (MouseClaimed onDesk event 3) (Said 'look,look/desk'))
				(HighPrint 313 29) ; "Against the wall, there is a small wooden desk with a potted plant on it. The desk has one drawer."
			)
			((MouseClaimed onRubberPlant event 3)
				(HighPrint 313 30) ; "It's a rubber plant."
			)
			((MouseClaimed onColeusPlant event 3)
				(HighPrint 313 31) ; "The Coleus plant has brightly colored leaves."
			)
			((Said 'look,look/plant')
				(HighPrint 313 32) ; "On the desk there is a plant which looks like some kind of violet. In the corner is a taller, leafy house plant."
			)
			((Said 'look,look/pan')
				(HighPrint 313 33) ; "There are no drugs here."
			)
			((Said 'look,look/railing')
				(HighPrint 313 34) ; "It's part of the stairs."
			)
			((or (MouseClaimed onBag event 3) (Said 'look,look/bag,basket'))
				(HighPrint 313 35) ; "The knitting bag is decorated on the outside with knitted figures. The Little Old Lady must do knitting when she's not asleep."
			)
			((Said 'look,look/collar')
				(HighPrint 313 36) ; "The little cat is wearing a cheap rhinestone collar."
			)
		)
	)
)

(instance birdieSings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 135)
				(= local17 1)
				(local0 setLoop: 3 setCycle: Fwd startUpd:)
				(= seconds 6)
			)
			(1
				(Print ; "CHIRP! CHIRP!"
					313
					37
					#at
					-1
					15
					#title
					{Little Birdie%j\b6\dc\b2\b2 \ba\c4\d8\c1\ac\dd}
				)
				(Print ; "Kitty, you'd better not be bothering the little birdie again!"
					313
					38
					#at
					-1
					15
					#title
					{Little Old Lady%j\ba\b6\de\d7\c5 \b5\ca\de\b1\c1\ac\dd}
				)
				(HighPrint 313 39) ; "Who would think a little birdie could be so noisy!"
				(self cue:)
			)
			(2
				(local0 setLoop: 2 setCel: 0 stopUpd:)
				(= cycles 2)
			)
			(3
				(HighPrint 313 40) ; "You quickly cover the cage and hope the bird shuts up."
				(= local17 0)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance deskOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(local1 setCycle: End self)
			)
			(1
				(HighPrint 313 41) ; "You find 1 silver in the desk drawer. You find nothing else of any value to you."
				(gEgo get: 1 1) ; silver
				(SetFlag 134)
				(self cue:)
			)
			(2
				(local1 setCycle: Beg)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance first313Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (or (not (IsFlag 92)) (!= gPrevRoomNum 0))
					(localproc_0)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance catWalk of Script
	(properties)

	(method (doit)
		(cond
			(local13
				(= local13 0)
				(cat setScript: getReady)
			)
			(
				(and
					(& (gEgo onControl: 1) $4000)
					(> (gEgo distanceTo: cat) 17)
					(not local10)
				)
				(self changeState: 5)
			)
			(
				(and
					(>= state 5)
					(== local9 0)
					(not (& (gEgo onControl: 1) $4000))
				)
				(= local10 0)
				(self changeState: 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'pat[/cat]')
						(= local15 1)
						(localproc_1)
					)
					(
						(or
							(Said 'feed/cat')
							(Said 'give/food/cat')
							(Said 'give/food<cat')
						)
						(= local16 1)
						(localproc_1)
					)
					((Said 'hit,kill/cat')
						(if (or (== (catWalk state:) 6) (== (catWalk state:) 7))
							(HandsOff)
							(TimePrint 6 313 42) ; "You have a bad feeling about the very deep, low growl emanating from the cat."
							(cat setScript: gonnaGetYou)
						else
							(NotClose)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cat setLoop: 4 setMotion: 0 cycleSpeed: 4)
				(if (and (not local10) (not local14))
					(= seconds 4)
				)
			)
			(1
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat
					setLoop: -1
					loop: 0
					cel: 0
					cycleSpeed: 1
					moveSpeed: 1
					xStep: 3
					yStep: 1
					setMotion: MoveTo 240 123 self
				)
			)
			(2
				(cat setMotion: MoveTo 180 123 self)
			)
			(3
				(cat setMotion: MoveTo 220 165 self)
			)
			(4
				(= state 0)
				(cat setMotion: MoveTo 280 165 self)
			)
			(5
				(= local10 1)
				(= seconds 0)
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat
					setLoop: -1
					loop: 0
					cel: 0
					cycleSpeed: 1
					setMotion: Chase gEgo 15 self
				)
			)
			(6
				(HandsOff)
				(= local10 0)
				(++ local12)
				(cat loop: 4 setMotion: 0 cycleSpeed: 4)
				(if (== local12 2)
					(= cycles 2)
				else
					(HandsOn)
				)
			)
			(7
				(= local12 0)
				(++ local11)
				(HandsOn)
				(switch local11
					(1
						(HighPrint 313 43) ; "The cat seems to want something."
					)
					(2
						(HighPrint 313 44) ; "The cat seems more insistent than before."
					)
					(3
						(HandsOff)
						(TimePrint 6 313 42) ; "You have a bad feeling about the very deep, low growl emanating from the cat."
						(cat setScript: gonnaGetYou)
					)
				)
			)
			(8
				(HandsOff)
				(LookAt gEgo cat)
				(= cycles 2)
			)
			(9
				(if local15
					(switch local11
						(0
							(HighPrint 313 45) ; "You pet the nice kitty."
						)
						(1
							(HighPrint 313 46) ; "The cat really likes being petted."
						)
						(2
							(HighPrint 313 47) ; "This is a very insistent cat."
						)
					)
				)
				(if local16
					(switch local11
						(0
							(HighPrint 313 48) ; "You feed the nice kitty a crumb."
						)
						(1
							(HighPrint 313 49) ; "The cat really likes being fed. You give it a leftover morsel."
						)
						(2
							(if (gEgo has: 3) ; food
								(gEgo use: 3 1) ; food
								(HighPrint 313 50) ; "This is a very insistent cat. You give it one of your rations."
							else
								(HighPrint 313 51) ; "You have nothing substantial to feed the cat."
							)
						)
					)
				)
				(= local16 0)
				(= local15 0)
				(if (< local11 3)
					(HighPrint 313 52) ; "Purrrrrrrr!"
				)
				(if (> local11 0)
					(if local16
						(= local11 0)
					else
						(-- local11)
					)
				)
				(HandsOn)
				(= state 7)
			)
		)
	)
)

(instance gonnaGetYou of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(== (gEgo x:) 194)
					(== (gEgo y:) 144)
					(== (cat x:) 260)
					(== (cat y:) 142)
				)
				(cat illegalBits: -32768 setScript: 0)
				(gEgo setScript: catAttack)
			)
			(
				(and
					(== (gEgo x:) 194)
					(== (gEgo y:) 144)
					(not (and (== (cat x:) 260) (== (cat y:) 142)))
				)
				(gEgo view: 525 loop: 0 cel: 0)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat
					setLoop: -1
					loop: 0
					setStep: 3 1
					cycleSpeed: 1
					illegalBits: 0
					setMotion: MoveTo 260 142
				)
				(gEgo illegalBits: 0 ignoreActors: setMotion: MoveTo 194 144)
			)
		)
	)
)

(instance getReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (cat looper:))
					(cat setLoop: catTurn)
				)
				(cat
					setLoop: -1
					loop: 0
					cycleSpeed: 1
					setMotion: MoveTo 260 142 self
				)
			)
			(1
				(cat setMotion: 0 loop: 4 cycleSpeed: 4)
			)
		)
	)
)

(instance catAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local14
					(gEgo setMotion: MoveTo 194 144 self)
				else
					(self cue:)
				)
			)
			(1
				(if local14
					(gEgo view: 525 setLoop: 0 cel: 0)
				)
				(cat
					illegalBits: 0
					ignoreActors:
					looper: 0
					setLoop: 5
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(gEgo setLoop: 1 cel: 0)
				(= cycles 4)
			)
			(4
				(gEgo
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 160 144 self
				)
				(cat loop: 6 cel: 0 cycleSpeed: 1 setCycle: Fwd)
			)
			(5
				(gEgo setCycle: 0)
				(cat loop: 7 cel: 0 setCycle: End self)
			)
			(6
				(cat posn: 243 141)
				(= cycles 1)
			)
			(7
				(cat posn: 226 140)
				(gEgo view: 636 setLoop: 0 setCel: 0)
				(= cycles 1)
			)
			(8
				(cat posn: 209 139)
				(gEgo setCel: 1)
				(= cycles 1)
			)
			(9
				(cat hide:)
				(gEgo setCel: 2)
				(= cycles 1)
			)
			(10
				(gEgo setLoop: 1 setCel: 0)
				(cat
					view: 636
					loop: 2
					cel: 0
					setPri: 12
					posn: 134 126
					setCycle: Fwd
					show:
				)
				(= cycles 40)
			)
			(11
				(if local14
					(EgoDead ; "The Little Old Lady's cries finally bring the Sheriff and Otto to her rescue. They find you pinned to the floor, unconscious, dreaming deliriously of death by sandpaper."
						313
						53
						80
						{ Better stay downstairs next time. %j\c6\b6\b2\c6 \b2\b8\dd\bc\de\ac \c5\b6\af\c0\c8;\c2\b7\de\c9\c4\b7\c6\ca \b2\af\b6\b2\c6 \c4\c4\de\cf\d9\cd\de\b7\c0\de\c8}
						82
						637
						1
						0
					)
				else
					(EgoDead ; "When the Little Old Lady awakes to see what's going on, you have to concede to her (through lips that are as raw as hamburger) that you've been licked! She summons the Sheriff and his goon, Otto."
						313
						54
						80
						{ What a cute little kitty! %j\c5\dd\c3\b6\dc\b2\b2 \ba\c8\ba\c1\ac\dd!}
						82
						637
						1
						0
					)
				)
			)
		)
	)
)

(instance climbUp1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local13 1)
				(gEgo
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 177 101 self
				)
			)
			(1
				(HandsOn)
				(gEgo setLoop: -1 illegalBits: -32768)
				(Print 313 55 #at 78 101) ; "SQUEEEEAK!"
				(gEgo setScript: 0)
			)
		)
	)
)

(instance climbUp2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 1
					setMotion: MoveTo 160 90 self
				)
			)
			(1
				(HandsOn)
				(gEgo setLoop: -1 illegalBits: -32768)
				(Print 313 56 #at 62 92) ; "CREEEEAAK!"
				(gEgo setScript: 0)
			)
		)
	)
)

(instance climbUp3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 1
					setMotion: MoveTo 146 74 self
				)
			)
			(1
				(HandsOn)
				(gEgo setLoop: -1 illegalBits: -32768)
				(Print 313 57 #at 41 88) ; "SCRAAAAWK!"
				(HighPrint 313 58) ; "The owner of the house awakens..."
				(Print ; "Help! Burglars! Sheriff! Help! Kitty! Kitty! \8f\95\82\af\82\c4\81I\81@\93D\96_\81I\81@\95\db\88\c0\8a\af\81I\81@\8f\95\82\af\82\c4\81I\81@\94L\82\bf\82\e1\82\f1\81I\81@\94L\82\bf\82\e1\82\f1\82\e2\81I"
					313
					59
					#at
					-1
					20
					#mode
					1
					#title
					{Little Old Lady%j\ba\b6\de\d7\c5 \b5\ca\de\b1\c1\ac\dd}
				)
				(= local14 1)
				(gEgo setScript: climbDown)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local9 0)
				(gEgo
					illegalBits: 0
					setLoop: 0
					setMotion: MoveTo 194 107 self
				)
			)
			(1
				(if local14
					(Print ; "KITTY!!!"
						313
						60
						#at
						-1
						15
						#title
						{L.O.L.%j\c1\b2\bb\b2 \b5\ca\de\b1\c1\ac\dd}
					)
					(gEgo setLoop: -1 setScript: catAttack)
					(cat setScript: 0)
				else
					(HandsOn)
					(gEgo setLoop: -1 illegalBits: -32768)
					(gEgo setScript: 0)
					(cat setScript: catWalk)
				)
			)
		)
	)
)

(instance onPurse of RFeature
	(properties
		nsTop 119
		nsLeft 75
		nsBottom 129
		nsRight 85
	)
)

(instance onBag of RFeature
	(properties
		nsTop 122
		nsLeft 165
		nsBottom 135
		nsRight 177
	)
)

(instance onCage of RFeature
	(properties
		nsTop 69
		nsLeft 202
		nsBottom 88
		nsRight 214
	)
)

(instance onCouch of RFeature ; UNUSED
	(properties
		nsTop 112
		nsLeft 86
		nsBottom 131
		nsRight 152
	)
)

(instance onRubberPlant of RFeature
	(properties
		nsTop 77
		nsLeft 63
		nsBottom 115
		nsRight 76
	)
)

(instance onColeusPlant of RFeature
	(properties
		nsTop 107
		nsLeft 19
		nsBottom 123
		nsRight 33
	)
)

(instance onDoor of RFeature
	(properties
		nsTop 6
		nsLeft 70
		nsBottom 50
		nsRight 105
	)
)

(instance onFireplace of RFeature
	(properties
		nsTop 93
		nsLeft 259
		nsBottom 143
		nsRight 288
	)
)

(instance onLamp of RFeature
	(properties
		nsTop 73
		nsLeft 274
		nsBottom 94
		nsRight 284
	)
)

(instance onDesk of RFeature
	(properties
		nsTop 124
		nsLeft 19
		nsBottom 137
		nsRight 43
	)
)

(instance onDoily of RFeature
	(properties
		nsTop 144
		nsLeft 97
		nsBottom 150
		nsRight 130
	)
)

(instance onLCandle of RFeature
	(properties
		nsTop 133
		nsLeft 83
		nsBottom 149
		nsRight 91
	)
)

(instance onRCandle of RFeature
	(properties
		nsTop 133
		nsLeft 137
		nsBottom 149
		nsRight 146
	)
)

(instance onRug of RFeature
	(properties
		nsTop 136
		nsLeft 163
		nsBottom 158
		nsRight 223
	)
)

(instance sillyThief of Sound
	(properties
		number 8
		loop -1
	)
)

