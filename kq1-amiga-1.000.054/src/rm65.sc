;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Blk)
(use Feature)
(use LoadMany)
(use Chase)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm65 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(Print 65 58 #at -1 130 #width 280 #mode 1) ; "You can't do that while you're invisible."
)

(procedure (localproc_1)
	(Print 65 59 #at -1 130 #width 280 #mode 1) ; "You need to be a little closer for a good look."
)

(procedure (localproc_2)
	(Print 65 60 #at -1 130 #width 280 #mode 1) ; "That's in the other room."
)

(procedure (localproc_3)
	(return (& (gEgo onControl: 1) $2000))
)

(procedure (localproc_4)
	(gEgo inRect: 100 61 124 82)
)

(instance stoolBlock of Blk
	(properties
		top 88
		left 88
		bottom 100
		right 112
	)
)

(instance rm65 of Rm
	(properties
		picture 65
		north 80
		west 28
	)

	(method (init)
		(LoadMany rsVIEW 119 65 52 115 118 265)
		(LoadMany rsSOUND 88 86 87 85 84 40)
		(self style: 3)
		(super init:)
		(SetCursor gWaitCursor 0 298 1)
		(gEgo posn: 36 126 loop: 0 init:)
		(proc0_1)
		((ScriptID 0 23) number: 88 loop: -1 playBed:) ; backSound
		(stool init: stopUpd:)
		(pot init:)
		(if (not (IsFlag 77))
			(note setPri: 7 init: stopUpd:)
		)
		(bed init:)
		(bed2 init:)
		(bedroomTable init:)
		(table init:)
		(bars init:)
		(spiderWeb init:)
		(door init: cel: (if (IsFlag 15) 3 else 0) setPri: 2 stopUpd:)
		(if (not (IsFlag 76))
			(rmCheese setPri: 1 init: stopUpd:)
		)
		(fire init: stopUpd:)
		(bubble init: stopUpd:)
		(smoke setPri: 4 init: stopUpd:)
		(if (>= global101 1)
			(fire setCycle: Fwd)
			(bubble setCycle: Fwd)
			(smoke setScript: smokeFace)
		)
		(if (IsFlag 74)
			(goop init:)
		)
		(if (IsFlag 2)
			(Print 65 0) ; "As soon as you entered the gingerbread house, the goat ran off. Something sure spooked him from this place!"
			(ClearFlag 2)
		)
		(cond
			((IsFlag 16)
				(witch init: setCycle: Walk)
				(witch setScript: witchHome)
			)
			((IsFlag 74) 0)
			((and (not script) (not global124))
				(= local0 300)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((IsFlag 1)
				(ClearFlag 1)
				(proc0_1)
				(Print 65 1) ; "Your ring mysteriously stops working in here."
			)
			((IsFlag 43)
				(ClearFlag 43)
				(gEgo ignoreBlocks: stoolBlock)
			)
			((& (gEgo onControl: 1) $0004)
				(SetCursor gWaitCursor 0 153 150)
				(self newRoom: 28)
			)
			(script
				(script doit:)
			)
			((== local0 100)
				((ScriptID 0 21) number: 84 init: loop: 1 play:) ; gameSound
				(Print 65 2) ; "Off in the distance you hear a high, squeaky voice say, "I can smell someone tasty in my house.""
				(-- local0)
			)
			((> local0 1)
				(-- local0)
			)
			((and (== local0 1) (not (& (gEgo onControl: 1) $4000)))
				(= local0 0)
				(witch setScript: witchEnter)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'play/fiddle')
				(cond
					((not (gCast contains: witch))
						(event claimed: 0)
					)
					((not (gEgo has: 17)) ; Fiddle
						(proc0_6) ; "You don't have anything that fits that description in your inventory."
					)
					(else
						(Print 65 3) ; "At the moment, it's important NOT to let the witch know you're here."
					)
				)
			)
			((Said 'eat,eat/building')
				(Print 65 4) ; "Though the outside of this house was tempting, there's nothing inside that seems remotely edible."
			)
			((Said '/witch>')
				(cond
					((IsFlag 74)
						(Print 65 5) ; "You've killed the witch!"
						(event claimed: 1)
					)
					((not (gCast contains: witch))
						(Print 65 6 #at -1 130 #width 280 #mode 1) ; "There is no witch here... AT THE MOMENT!!"
						(event claimed: 1)
					)
					((Said 'pull')
						(Print 65 7) ; "Too late...she sees you, and you're in trouble."
					)
					((Said 'kill')
						(Print 65 8) ; "You can't kill the witch now."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'fill/bucket')
				(if (gEgo has: 8) ; Empty_Water_Bucket
					(Print 65 9) ; "There is nothing here that's worth putting in the bucket...certainly not that awful green goop."
				else
					(Print 65 10) ; "You don't have the bucket."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[/room,building]')
						(Print 65 11 #at -1 130 #width 280 #mode 1) ; "In contrast to its delightful exterior, the inside of the gingerbread house looks dark and ominous."
					)
					((Said '/bedroom')
						(if (localproc_3)
							(Print 65 12 #at -1 130 #width 280 #mode 1) ; "It looks like an ordinary bedroom."
						else
							(Print 65 13 #at -1 130 #width 280 #mode 1) ; "You can't see much from where you are."
						)
					)
					((Said '<in/cage')
						(Print 65 14 #at -1 130 #width 280 #mode 1) ; "All you see are a few gingerbread crumbs lying on the floor of the cage. You wonder about this."
					)
					((Said '/table')
						(if (localproc_3)
							(bedroomTable doLook: 1)
						else
							(table doLook: 1)
						)
					)
				)
			)
			((Said 'eat,eat,drink/liquid,brew')
				(Print 65 15 #at -1 130 #width 280 #mode 1) ; "Yech!!!!"
			)
			((Said 'smell,smell')
				(Print 65 16 #at -1 130 #width 280 #mode 1) ; "The sickening stench from the pot is everywhere."
			)
			((Said 'open,open/cage')
				(Print 65 17) ; "Since there's no door here, you don't have anything to open."
			)
			((Said 'bend/bar')
				(Print 65 18 #at -1 130 #width 280 #mode 1) ; "The bars are far too strong for you to bend."
			)
			((Said 'open,open/cabinet,door')
				(cond
					((IsFlag 1)
						(localproc_0)
					)
					((IsFlag 15)
						(Print 65 19) ; "It is already open."
					)
					(script
						(PrintTooBusy)
					)
					((localproc_4)
						(self setScript: openCabinet)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'close,close/cabinet,door')
				(cond
					((not (localproc_4))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(script
						(PrintTooBusy)
					)
					((IsFlag 15)
						(self setScript: closeCabinet)
					)
					(else
						(Print 65 20) ; "It is already closed."
					)
				)
			)
			((Said 'get,get/cheese')
				(cond
					((IsFlag 76)
						(Print 65 21) ; "You've already accomplished that task."
					)
					((not (IsFlag 15))
						(Print 65 22) ; "There isn't any here."
					)
					((IsFlag 1)
						(localproc_0)
					)
					(script
						(PrintTooBusy)
					)
					((localproc_4)
						(self setScript: getCheese)
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'feel/caldron')
				(cond
					((localproc_3)
						(localproc_2)
					)
					((gEgo inRect: 15 70 110 110)
						(Print 65 23 #at -1 130 #width 280 #mode 1) ; "The pot is hot enough to burn your hand. The fire must have been burning for a long time."
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'climb,climb,dive,jump<in,in/caldron')
				(cond
					((localproc_3)
						(localproc_2)
					)
					((gEgo inRect: 15 70 110 110)
						(Print 65 24 #at -1 130 #width 280 #mode 1) ; "You briefly consider diving into the foul brew, but your desire to remain alive prevails over your rather strange inclination."
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((or (Said 'nap') (Said 'go/nap') (Said 'get/nap'))
				(if (localproc_3)
					(Print 65 25 #at -1 130 #width 280 #mode 1) ; "You wouldn't want to sleep on a witch's bed."
				else
					(Print 65 26 #at -1 130 #width 280 #mode 1) ; "You may have seen a bed in the other room, but I am not sure."
				)
			)
			((Said 'rub/ring')
				(Print 65 27 #at -1 130 #width 280 #mode 1) ; "The ring does not seem to work in the witch's house."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance witch of Actor
	(properties
		x 94
		y 85
		view 115
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'talk,talk,say/witch')
				(Print 65 28 #at -1 130 #width 280 #mode 1) ; "Now is not a good time to try and start a conversation!"
			)
			((Said 'look,look/witch')
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(if (and (localproc_3) (>= argc 2))
					(Print 65 29) ; "The witch is in the other room."
				else
					(Print 65 30) ; "This ugly old witch is one of the most hideous sights you have ever seen. Her eyes are dark and evil, and her crooked smile twitches hungrily. She's not to be trusted."
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 43
		y 82
		view 265
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/fire')
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (>= argc 2) (localproc_3))
					(localproc_2)
				else
					(Print 65 31 #at -1 130 #width 280 #mode 1) ; "The fire is very, very hot. It's best to leave it alone."
				)
			)
		)
	)
)

(instance bubble of Prop
	(properties
		x 62
		y 67
		view 265
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/liquid,brew') (MousedOn self event 3))
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(cond
					((and (localproc_3) (== (invItem type:) 128))
						(localproc_2)
					)
					(
						(and
							(not (gEgo inRect: 15 70 110 110))
							(== (invItem type:) 128)
						)
						(localproc_1)
					)
					(else
						(Print 65 32 #at -1 120 #width 280 #mode 1) ; "As the green liquid is terribly goopy, the fire must have been burning underneath it for quite some time."
					)
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 62
		y 62
		noun '/smoke'
		view 265
		loop 2
		cycleSpeed 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/smoke')
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(cond
					((localproc_3)
						(Print 65 33 #at -1 130 #width 280 #mode 1) ; "That smoke smells... and even LOOKS evil!"
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					(else
						(smoke setScript: seeSpectre)
					)
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 119
		y 33
		view 265
		loop 3
		cycleSpeed 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/cabinet,shelf') (MousedOn self event 3))
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(cond
					((and (not (localproc_4)) (== (invItem type:) 128))
						(localproc_1)
					)
					((not (IsFlag 15))
						(Print 65 34 #at -1 130 #width 280 #mode 1) ; "The cabinet on the wall is rather plain and simple."
					)
					((IsFlag 76)
						(Print 65 35 #at -1 130 #width 280 #mode 1) ; "There is nothing but a bare shelf here."
					)
					(else
						(Print 65 36 #at -1 130 #width 280 #mode 1) ; "Sitting on the shelf is a delicious piece of Swiss cheese."
					)
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance poof of Prop
	(properties
		z 26
		view 265
		loop 6
	)
)

(instance stool of View
	(properties
		x 92
		y 94
		view 265
		loop 5
		cel 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/stool')
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(cond
					((and (localproc_3) (>= argc 2))
						(localproc_2)
					)
					((and (> (gEgo distanceTo: stool) 26) (>= argc 2))
						(localproc_1)
					)
					(else
						(Print 65 37) ; "It's just a stool."
					)
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance rmCheese of View
	(properties
		x 112
		y 44
		description {cheese}
		view 265
		loop 5
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/cheese')
				(self doVerb: 1 event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(cond
					((IsFlag 76)
						((gInventory at: 13) showSelf: gEgo) ; Cheese
					)
					((not (localproc_4))
						(localproc_1)
					)
					((not (IsFlag 15))
						(Print 65 22) ; "There isn't any here."
					)
					((not (IsFlag 76))
						(Print 65 36 #at -1 130 #width 280 #mode 1) ; "Sitting on the shelf is a delicious piece of Swiss cheese."
					)
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance note of View
	(properties
		x 240
		y 108
		z 10
		view 265
		loop 5
		cel 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/note,note')
				(self doVerb: 1 event)
			)
			((Said 'get,get/note,note')
				(cond
					((IsFlag 77)
						(Print 65 21) ; "You've already accomplished that task."
					)
					((IsFlag 1)
						(localproc_0)
					)
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((not (gEgo inRect: 220 98 244 123))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(else
						(gCurRoom setScript: getNote)
					)
				)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(cond
					((and (not (localproc_3)) (>= argc 2))
						(Print 65 38) ; "You don't see a note here."
					)
					((and (>= argc 2) (>= (gEgo distanceTo: self) 30))
						(Print 65 39 #at -1 130 #width 280 #mode 1) ; "Your eyes are not sharp enough to see it from here."
					)
					((>= argc 2)
						(Print 65 40 #at -1 130 #width 280 #mode 1) ; "It is written in a familiar language."
					)
					(else
						(Print 65 41 #at -1 130 #width 280 #mode 1) ; "You see a note on the table by the bed."
					)
				)
				(if (>= argc 2)
					(invItem claimed: 1)
				)
			)
		)
	)
)

(instance witchHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(witch illegalBits: 0 startUpd: setMotion: MoveTo 93 105 self)
			)
			(1
				(if (or (IsFlag 1) global124)
					(self changeState: 3)
				else
					(witch setMotion: Chase gEgo 30 self)
				)
			)
			(2
				(HandsOff)
				(witchEnter start: 1)
				(witch setMotion: 0)
				(self dispose:)
				(witch setScript: witchEnter)
			)
			(3
				(witch setMotion: 0 stopUpd:)
				(poof
					init:
					cycleSpeed: 1
					posn: (witch x:) (witch y:)
					setCycle: End self
				)
			)
			(4
				(witch hide:)
				(poof cycleSpeed: 2 setCycle: Beg self)
			)
			(5
				(poof dispose:)
				(if (IsFlag 1)
					(Print 65 42) ; "Be thankful that you are invisible or the witch may have stuck around to try and catch you!"
				else
					(Print 65 43) ; "Be thankful that you have a protective spell or the witch may have stuck around to try and catch you!"
				)
				(witch dispose:)
			)
		)
	)
)

(instance getCheese of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 1)
				(= cycles 4)
			)
			(1
				(rmCheese dispose:)
				(GettingSound init: play:)
				(Print 65 44 #at -1 130 #width 280 #mode 1) ; "You take the cheese from the cabinet."
				(gEgo get: 13) ; Cheese
				(SetScore 76 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getNote of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo 239 107)
				(= cycles 4)
			)
			(1
				(note dispose:)
				(GettingSound init: play:)
				(Print 65 45 #at -1 130 #width 280 #mode 1) ; "You grab the note from the table."
				(gEgo get: 4) ; Note
				(SetScore 77 1)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 1)
				(= cycles 4)
			)
			(1
				(door setCycle: End self)
			)
			(2
				(door stopUpd:)
				(HandsOn)
				(SetFlag 15)
				(SetScore 75 2)
				(self dispose:)
			)
		)
	)
)

(instance closeCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 1)
				(= cycles 4)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(door stopUpd:)
				(HandsOn)
				(ClearFlag 15)
				(self dispose:)
			)
		)
	)
)

(instance witchEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 16)
				((ScriptID 0 21) number: 85 loop: -1 play:) ; gameSound
				(witch
					view: 115
					init:
					illegalBits: -32768
					setPri: -1
					setCycle: Walk
					posn: 36 126
					loop: 0
					setMotion: MoveTo 68 122 self
				)
			)
			(1
				(if (& (gEgo onControl: 1) $2000)
					(witch setScript: witchToPot)
				else
					(proc0_15 witch gEgo)
					(witch view: 118 cel: 0 setCycle: End self)
					((ScriptID 0 21) number: 86 loop: 1 play:) ; gameSound
				)
			)
			(2
				(HandsOff)
				(Print 65 46 #at -1 130 #width 280 #mode 1) ; "Rats! She has cast some spell to keep you from escaping! The witch remarks, "Oh, how nice of you to come for dinner (cackle, cackle)!""
				(witch
					view: 115
					setCycle: Walk
					setAvoider: Avoid
					setMotion: Chase gEgo 24
				)
				(= seconds 4)
			)
			(3
				(proc0_15 witch gEgo)
				(Print 65 47 #at -1 130 #width 280 #mode 1) ; "She looks you over carefully, then states, "You're a little too scrawny for my appetite, but I think you're going to make a lovely dessert!""
				(witch view: 118 cel: 0 setCycle: End)
				((ScriptID 0 21) number: 86 loop: 1 play:) ; gameSound
				(poof init: posn: (gEgo x:) (gEgo y:) setCycle: End self)
			)
			(4
				(gEgo hide:)
				(poof setCycle: Beg self)
			)
			(5
				(= local1 1)
				((ScriptID 0 21) number: 87 loop: 1 play:) ; gameSound
				(poof posn: 160 57 setCycle: End self)
			)
			(6
				(proc0_1)
				(gEgo posn: 160 57 show:)
				(poof setCycle: Beg self)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 95)
			)
		)
	)
)

(instance witchToPot of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (& (gEgo onControl: 1) $2000))
				(not (& (gEgo onControl: 1) $0800))
				(< state 6)
			)
			(= seconds 0)
			(self changeState: 6)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'pull,kill/witch[/caldron,brew,liquid]')
				(cond
					((not (gEgo inRect: 110 80 124 99))
						(Print 65 48) ; "You need to get closer. But be careful!"
					)
					(
						(and
							(gCurRoom script:)
							(== (gEgo view:) (if (IsFlag 0) 23 else 16))
						)
						(Print 65 49) ; "It would be easier if you were standing."
					)
					(else
						(event claimed: 1)
						((ScriptID 0 21) number: 40 play:) ; gameSound
						(if (== (witch script:) witchPace)
							(gCurRoom setScript: 0)
						else
							(witch setScript: 0)
							(gCurRoom setScript: shoveWitch)
						)
					)
				)
			)
			((Said 'pull,kill/witch')
				(Print 65 50) ; "There has to be a better way to get rid of this evil old hag!"
			)
			((or (Said 'shoot/witch[<shot]') (Said 'use/shot,(shot<shot)'))
				(Print 65 51) ; "Perhaps you could shoot her if you had a gun and a silver bullet, but you'll find neither of those items in this game. Try to find another way."
			)
			((super handleEvent: event)
				(return)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(witch
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 106 96 self
				)
			)
			(1
				(witch setMotion: MoveTo 99 91 self)
				(gEgo observeBlocks: stoolBlock)
			)
			(2
				(HandsOn)
				(Print 65 52 #at -1 130 #width 280 #mode 1) ; "The witch mutters, "I am going to get my cauldron ready to cook someone for dinner (yum).""
				(witch
					view: 119
					loop: 1
					cel: 0
					illegalBits: 0
					posn: 94 92
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(Print 65 53 #at -1 130 #width 280 #mode 1) ; "The witch mumbles, "After I get the cauldron nice and hot, I will be ready to have someone for dinner (giggle).""
				(if (proc0_24 0)
					(= seconds 9)
				else
					(= seconds 6)
				)
			)
			(4
				(Print 65 54 #at -1 130 #width 280 #mode 1) ; "The witch mutters, "The cauldron is heating up nicely. I wonder who will be my dinner guest!""
				(if (proc0_24 0)
					(= seconds 10)
				else
					(= seconds 7)
				)
			)
			(5
				(Print 65 55 #at -1 130 #width 280 #mode 1) ; "The witch says, "My cauldron is now the perfect temperature. It is time to invite someone for dinner (cackle, cackle)!""
				(if (== (gCurRoom script:) shoveWitch)
					(witch setScript: 0)
				else
					(witch setScript: witchPace)
				)
			)
			(6
				(Print 65 56) ; "The witch sees you!"
				(HandsOff)
				(if (< (gEgo x:) 130)
					(gEgo view: 52 setLoop: 1 setMotion: MoveTo 164 96)
					(= cycles 8)
				else
					(self cue:)
				)
			)
			(7
				(witch view: 118 loop: 4 cel: 0 setCycle: CT 4 1 self)
			)
			(8
				(gEgo setMotion: 0)
				((ScriptID 0 21) number: 86 loop: 1 play:) ; gameSound
				(witch setCycle: End self)
			)
			(9
				(witch view: 115 setCycle: Walk cycleSpeed: 0 posn: 101 97)
				(witchEnter start: 2)
				(witch setScript: witchEnter)
			)
		)
	)
)

(instance witchPace of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (!= (gEgo onControl: 1) 8192) (< 1 state 7))
			(= seconds 0)
			(self changeState: 7)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo ignoreBlocks: stoolBlock)
				(witch setCycle: Beg self)
			)
			(1
				(witch
					view: 115
					loop: 2
					setCycle: Walk
					cycleSpeed: 0
					posn: 99 91
					setMotion: MoveTo 104 96 self
				)
			)
			(2
				(witch setMotion: MoveTo 50 124 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(witch setMotion: MoveTo 106 100 self)
			)
			(5
				(= seconds 2)
			)
			(6
				(self changeState: 2)
			)
			(7
				(HandsOff)
				(Print 65 56) ; "The witch sees you!"
				(gEgo setMotion: 0)
				(witchEnter start: 1)
				(witch setScript: witchEnter)
			)
		)
	)
)

(instance smokeFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke loop: 2 setCycle: Fwd)
				(= cycles (Random 50 100))
			)
			(1
				(smoke loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance seeSpectre of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 gEgo fire)
				(= cycles 4)
			)
			(1
				(gEgo stopUpd:)
				(smoke loop: 4 cel: 0 setCycle: End self)
			)
			(2
				(smoke loop: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(3
				(if (not (>= global101 1))
					(smoke stopUpd:)
				)
				(Print 65 57 #at -1 130 #width 280 #mode 1) ; "D..d..did you see that? Nah! You're imagining things."
				(HandsOn)
				(gEgo startUpd:)
				(if (>= global101 1)
					(smoke setScript: smokeFace)
				)
				(self dispose:)
			)
		)
	)
)

(instance shoveWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 43)
				(gEgo
					ignoreActors:
					illegalBits: 0
					view: 65
					setMotion: 0
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				((ScriptID 0 21) number: 40 loop: 1 play:) ; gameSound
				(witch
					view: 119
					ignoreActors:
					ignoreControl:
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(witch dispose:)
				(goop init:)
				(gEgo setCycle: Beg)
				(= cycles 12)
			)
			(2
				(Print 65 61) ; "With a mighty shove, you courageously push the wicked witch into the pot. Her wild screams are suddenly cut off as she melts away into the oily green slime in the pot. Congratulations!"
				(SetScore 74 7)
				(HandsOn)
				(proc0_1)
				(gEgo loop: 1)
				(self dispose:)
			)
		)
	)
)

(instance goop of View
	(properties
		x 94
		y 92
		view 119
		cel 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and argc (localproc_3))
					(localproc_2)
				else
					(Print 65 62) ; "The oily green slime spilled over when you pushed the witch into the pot."
				)
			)
		)
	)
)

(instance bars of NewFeature
	(properties
		x 169
		y 44
		nsTop 11
		nsLeft 141
		nsBottom 78
		nsRight 197
		description {bars}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look[<at]/bar,cage')
				(self doLook: 1)
			)
		)
	)

	(method (doLook)
		(if (and argc (localproc_3))
			(localproc_2)
		else
			(Print 65 63) ; "The cage is made from strong, thick iron bars. They look a little rusty, but they're solid through and through."
		)
	)
)

(instance bed of NewFeature
	(properties
		x 281
		y 99
		noun '/bed'
		nsTop 77
		nsLeft 265
		nsBottom 122
		nsRight 298
		description {bed}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evMOUSEBUTTON)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
				(& (event modifiers:) emSHIFT)
			)
			(Print 65 64) ; "The witch's bed looks hard and uncomfortable."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doLook)
		(if (not (localproc_3))
			(localproc_2)
		else
			(Print 65 64) ; "The witch's bed looks hard and uncomfortable."
		)
	)
)

(instance bed2 of NewFeature
	(properties
		x 236
		y 130
		noun '/bed'
		nsTop 115
		nsLeft 211
		nsBottom 145
		nsRight 262
		description {bed}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evMOUSEBUTTON)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
				(& (event modifiers:) emSHIFT)
			)
			(Print 65 64) ; "The witch's bed looks hard and uncomfortable."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doLook)
		(if (not (localproc_3))
			(localproc_2)
		else
			(Print 65 64) ; "The witch's bed looks hard and uncomfortable."
		)
	)
)

(instance bedroomTable of NewFeature
	(properties
		x 246
		y 97
		nsTop 93
		nsLeft 230
		nsBottom 102
		nsRight 262
		description {bedroomTable}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/endtable,endtable')
				(self doLook: 1)
			)
		)
	)

	(method (doLook)
		(if (and argc (not (localproc_3)))
			(localproc_2)
		else
			(Print 65 65 #at -1 130 #width 280 #mode 1) ; "It is just a plain, wooden bedside table."
			(if (not (IsFlag 77))
				(Print 65 66 #at -1 130 #width 280 #mode 1) ; "It looks like there is a note lying on top of it."
			)
		)
	)
)

(instance table of NewFeature
	(properties
		x 117
		y 114
		noun '/table<kitchen'
		nsTop 102
		nsLeft 107
		nsBottom 127
		nsRight 128
		description {table}
		sightAngle 360
		getableDist 320
		seeableDist 520
		shiftClick 367
		contClick 369
		lookStr {That is the table where the witch eats her food, whatever... or WHOever...that is!}
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/table<kitchen')
				(self doLook: 1)
			)
		)
	)

	(method (doLook)
		(if (and argc (localproc_3))
			(localproc_2)
		else
			(Print 65 67) ; "That is the table where the witch eats her food, whatever... or WHOever...that is!"
		)
	)
)

(instance spiderWeb of Feature
	(properties
		x 226
		y 31
		nsTop 18
		nsLeft 212
		nsBottom 44
		nsRight 240
		description {spider web}
		sightAngle 360
		closeRangeDist 320
		longRangeDist 320
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/cobweb,spiderweb,(spider<cobweb)')
				(self doVerb: 1 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (not (localproc_3)) (>= argc 2))
					(Print 65 68) ; "There aren't any spider webs in here, as far as you can see."
				else
					(Print 65 69) ; "There is a spider web above the door."
				)
			)
		)
	)
)

(instance pot of NewFeature
	(properties
		x 63
		y 75
		noun '/caldron,caldron'
		nsTop 67
		nsLeft 43
		nsBottom 84
		nsRight 84
		description {pot}
		sightAngle 360
		seeableDist 520
		shiftClick 367
		lookStr {The pot is hot enough to burn your hand.  The fire must have been burning for a long time.}
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((MousedOn self event 3)
				(Print lookStr #at -1 130 #width 280 #mode 1)
				(event claimed: 1)
			)
			((Said 'open,open/caldron')
				(cond
					((localproc_3)
						(localproc_2)
					)
					((gEgo inRect: 15 70 110 110)
						(Print 65 70) ; "You can't open that."
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
			)
			((Said 'look,look,feel/caldron')
				(cond
					((localproc_3)
						(localproc_2)
					)
					((gEgo inRect: 15 70 110 110)
						(Print 65 23 #at -1 130 #width 280 #mode 1) ; "The pot is hot enough to burn your hand. The fire must have been burning for a long time."
					)
					(else
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance GettingSound of Sound
	(properties
		number 105
		priority 10
	)
)

