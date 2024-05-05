;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Interface)
(use Blk)
(use LoadMany)
(use DPath)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm75 0
)

(local
	[local0 2]
	local2
	[local3 2]
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 param1 param2) ; UNUSED
	(if (gEgo has: param1)
		(gEgo put: param1)
		(gGame changeScore: (- 0 param2))
		(return 1)
	else
		(return 0)
	)
)

(instance ratBlock of Blk
	(properties
		top 136
		left 36
		bottom 147
		right 86
	)
)

(instance rm75 of Rm
	(properties
		picture 75
		east 74
		west 76
	)

	(method (init)
		(Load rsVIEW 275)
		(Load rsSOUND 15)
		(if (not (= local5 (IsFlag 32)))
			(LoadMany rsVIEW 3 20 105 106)
			(LoadMany rsSOUND 45 67 46 43)
			((ScriptID 0 21) number: 45 init: loop: -1 play:) ; gameSound
			(if (and (gEgo has: 8) (IsFlag 9)) ; Empty_Water_Bucket
				(Load rsVIEW 50)
			)
		)
		(self
			style:
				(switch gPrevRoomNum
					(west 3)
					(east 2)
				)
		)
		(super init:)
		(if (not local5)
			(= local2 0)
			(rat setPri: 10 ignoreActors: init: stopUpd:)
			(if (>= global101 1)
				(rat setScript: ratBlinkScript)
			)
			(gEgo observeBlocks: ratBlock)
			(ratEyes
				posn: (+ (rat x:) 18) (- (rat y:) 37)
				setPri: 11
				init:
				hide:
				stopUpd:
			)
			(eyeBalls posn: (ratEyes x:) (ratEyes y:) setPri: 11 init:)
			(tongue
				setPri: 11
				posn: (+ (rat x:) 12) (- (rat y:) 35)
				init:
				hide:
				stopUpd:
			)
			(if (>= global101 1)
				(tongue setScript: tongueScript)
			)
			(slobber
				setPri: 10
				posn: (+ (rat x:) 12) (- (rat y:) 35)
				init:
				hide:
				stopUpd:
			)
			(if (>= global101 1)
				(slobber setScript: slobberScript)
			)
			(ratGut
				posn: (+ (rat x:) 5) (- (rat y:) 12)
				cycleSpeed: 2
				setPri: 10
				init:
				stopUpd:
			)
			(if (>= global101 1)
				(ratGut setCycle: Fwd)
			)
			(ratFightCloud init: hide: stopUpd:)
		)
		(door ignoreActors: setPri: 9 init: stopUpd:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 34 144)
				(door setScript: closeDoor)
				(SetFlag 32)
			)
			(else
				(gEgo posn: 317 (proc0_17 166 (gEgo y:) 134))
			)
		)
		(gEgo init:)
		(proc0_1)
		(torchLight setPri: 4 init: stopUpd:)
		(if (>= global101 1)
			(torchLight setCycle: Fwd)
		)
		(if global124
			(= global124 (Random 10 40))
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (not local5) (not local7) (== (gEgo onControl: 1) 64))
				(gEgo setMotion: 0)
				(if (IsFlag 1)
					(Print 75 0) ; "The rat grins crookedly, his long, pointed fangs glistening in the torchlight. His sense of smell alerts him of your presence."
				else
					(Print 75 1) ; "The rat grins crookedly, his long, pointed fangs glistening in the torchlight."
				)
				(Print 75 2) ; "RAT: "That's right, mister, just walk a little closer....""
				(= local7 1)
			)
			((and (not local5) (== (gEgo onControl: 1) 4))
				(gCurRoom setScript: fightRat)
			)
			((== (gEgo onControl: 1) 16)
				(gCurRoom setScript: openDoor)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((and local5 (or (Said '/rat') (Said '//rat')))
				(Print 75 3) ; "Whatever makes you think there's a rat in here?"
			)
			((Said 'trade,bargain//rat<with')
				(Print 75 4) ; "What would you like to give the rat?"
			)
			((or (Said '/mouse') (Said '//mouse'))
				(if local5
					(Print 75 5) ; "Mouse?"
				else
					(Print 75 6) ; "RAT: "Hey, pal, this is no mouse you're talking to here!""
				)
			)
			(
				(or
					(Said 'look,look/rat')
					(MousedOn rat event 3)
					(MousedOn tongue event 3)
					(MousedOn ratGut event 3)
					(MousedOn ratEyes event 3)
				)
				(Print 75 7) ; "You see a giant rat with matted fur and dripping teeth."
				(event claimed: 1)
			)
			((or (Said '/rat>') (Said '//rat>') (Said '/*<rat>'))
				(cond
					((Said 'bite')
						(Print 75 8) ; "Unfortunately, his teeth are larger than yours."
					)
					((Said 'talk,talk')
						(if local2
							(Print 75 9) ; "RAT: "Hey, friend. You wanna go through this door, make me an offer, and I promise I'll letcha breeze right through.""
						else
							(= local2 1)
							(if (IsFlag 1)
								(Print 75 10) ; "RAT: "You're not fooling me with that ol' ring of invisibility trick! I've seen that one a million times...er, I mean, I HAVEN'T seen that one a million times! I can smell you there!"
							else
								(Print 75 11) ; "RAT: "Hello there, my friend. You looking for anything in particular?""
							)
							(Print 75 12) ; "RAT: "You wanna pass through my little door here, right? Well, maybe we can work somethin' out. What's it worth to you?""
						)
					)
					((Said 'kill,shoot,hit,kill/')
						(Print 75 13) ; "Keeping in mind the rat's remarkable agility and even more remarkable fangs, you decide not to risk an attack."
					)
					((Said 'ask/[rat]/door')
						(Print 75 14) ; "RAT: "I know you're gonna want what's behind this door. But what's in it for me?""
					)
					((Said 'show/')
						(cond
							((IsFlag 1)
								(Print 75 15) ; "Since you and all you carry are invisible, the rat can't possibly see what you're trying to show him."
							)
							((Said 'cheese')
								(if (gEgo has: 13) ; Cheese
									(Print 75 16) ; "The giant rat's lips quiver in anticipation at the odor of the cheese. Watch it, though, you don't want to tease this rat."
								else
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								)
							)
							(else
								(Print 75 17) ; "The rat is a dangerous character, teasing him with that might get you into trouble."
							)
						)
					)
					((Said 'throw,throw/boulder,pebble')
						(cond
							((and (gEgo has: 9) (not (IsFlag 32))) ; Pebbles
								(UpdatePebbles)
								(if (== global140 0)
									(Print 75 18) ; "You throw your last pebble at the rat, but in this dim light, you can't see well enough to hit your target."
								else
									(Print 75 19) ; "You throw a pebble at the rat, but in this dim light, you can't see well enough to hit your target."
								)
							)
							((and (IsFlag 32) (gEgo has: 9)) ; Pebbles
								(Print 75 20) ; "What's left to throw the pebble at?"
							)
							(else
								(Print 75 21) ; "You don't have anything like that in your inventory."
							)
						)
					)
					((Said 'throw/bucket,water')
						(cond
							((or (not (gEgo has: 8)) (not (IsFlag 9))) ; Empty_Water_Bucket
								(Print 75 22) ; "You don't have a bucket of water."
							)
							((> (gEgo distanceTo: rat) 70)
								(proc0_4) ; "It's not quite within reach, Sir Graham."
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							(else
								(gCurRoom setScript: waterRat)
							)
						)
					)
					((Said 'capture,hit,pet,touch')
						(cond
							((gCurRoom script:)
								(PrintTooBusy)
							)
							((> (gEgo distanceTo: rat) 65)
								(Print 75 23) ; "You aren't close enough yet."
								(Print 75 24) ; "The rat grins, showing long, pointed teeth. "That's right, mister, just walk a little closer....""
							)
							(else
								(gCurRoom setScript: fightRat)
							)
						)
					)
					((Said 'throw/dagger')
						(cond
							((not (gEgo has: 0)) ; Dagger
								(proc0_6) ; "You don't have anything that fits that description in your inventory."
							)
							((not (IsFlag 32))
								(Print 75 25) ; "In the dim light, your aim would suffer. Better to find a less violent way to get past this dirty rat."
							)
							(else
								(Print 75 26) ; "There's no reason to do that, Sir Graham."
								(event claimed: 1)
							)
						)
					)
					((Said 'feed>')
						(cond
							((Said '/cheese')
								(if (not (gEgo has: 13)) ; Cheese
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 0)
									(= local8 13)
								)
							)
							((Said '/egg')
								(if (not (gEgo has: 15)) ; Gold_Egg
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 6)
									(= local8 15)
								)
							)
							((and (Said '/nut,nut') (IsFlag 67))
								(if (not (gEgo has: 18)) ; Walnut
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 6)
									(= local8 18)
								)
							)
						)
						(cond
							((not local8) 0)
							((> (gEgo distanceTo: rat) 80)
								(Print 75 27) ; "RAT: "Come a little closer. I can't reach it!""
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							(else
								(gCurRoom setScript: grabScript)
							)
						)
					)
					((Said 'give>')
						(cond
							((Said '/treasure')
								(= local9 0)
								(cond
									((gEgo has: 14) ; Magic_Mirror
										(gEgo put: 14) ; Magic_Mirror
										(= local9 8)
									)
									((gEgo has: 16) ; Magic_Shield
										(gEgo put: 16) ; Magic_Shield
										(= local9 8)
									)
									((gEgo has: 1) ; Chest
										(gEgo put: 1) ; Chest
										(= local9 8)
									)
									((gEgo has: 11) ; Pouch
										(gEgo put: 11) ; Pouch
										(if (IsFlag 62)
											(= local9 6)
										else
											(= local9 3)
										)
									)
									((gEgo has: 18) ; Walnut
										(gEgo put: 18) ; Walnut
										(if (IsFlag 67)
											(= local9 6)
										else
											(= local9 3)
										)
									)
									((gEgo has: 15) ; Gold_Egg
										(gEgo put: 15) ; Gold_Egg
										(= local9 6)
									)
									((gEgo has: 12) ; Sceptre
										(gEgo put: 12) ; Sceptre
										(= local9 6)
									)
								)
								(if (== local9 0)
									(Print 75 28) ; "You have nothing the rat wants."
								else
									(gCurRoom setScript: grabScript)
								)
							)
							((Said '/diamond,bag')
								(if (not (gEgo has: 11)) ; Pouch
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(if (IsFlag 62)
										(= local9 3)
									else
										(= local9 6)
									)
									(= local8 11)
								)
							)
							((Said '/mirror')
								(if (not (gEgo has: 14)) ; Magic_Mirror
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 8)
									(= local8 14)
								)
							)
							((Said '/chest')
								(if (not (gEgo has: 1)) ; Chest
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 8)
									(= local8 1)
								)
							)
							((Said '/ring')
								(if (not (gEgo has: 5)) ; Magic_Ring
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 3)
									(= local8 5)
									(ClearFlag 17)
									(ClearFlag 1)
									(proc0_1)
								)
							)
							((Said '/cheese')
								(if (not (gEgo has: 13)) ; Cheese
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 0)
									(= local8 13)
								)
							)
							((Said '/egg')
								(if (not (gEgo has: 15)) ; Gold_Egg
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 6)
									(= local8 15)
								)
							)
							((and (Said '/nut,nut') (IsFlag 67))
								(if (not (gEgo has: 18)) ; Walnut
									(proc0_6) ; "You don't have anything that fits that description in your inventory."
								else
									(= local9 6)
									(= local8 18)
								)
							)
							(
								(and
									(= temp0 (gInventory firstTrue: #saidMe))
									(temp0 ownedBy: gEgo)
								)
								(Print 75 29) ; "Whaddaya tryin' to do, cheat me with that measly offering? What an insult."
							)
							(else
								(event claimed: 0)
							)
						)
						(cond
							((not local8) 0)
							((> (gEgo distanceTo: rat) 80)
								(Print 75 30) ; "RAT: "Come a little closer. I can't reach it!""
							)
							((gCurRoom script:)
								(PrintTooBusy)
							)
							(else
								(gCurRoom setScript: grabScript)
							)
						)
					)
				)
			)
			((Said 'bite')
				(Print 75 31) ; "I'm not sure who or what you want to bite."
			)
			((Said 'talk,talk')
				(Print 75 32) ; "Who do you want to talk to?"
			)
			((Said 'throw')
				(Print 75 33) ; "Who do you want to throw at?"
			)
			((Said 'hit,pet,touch')
				(Print 75 34) ; "Who?"
			)
			((Said 'count/finger')
				(cond
					((IsFlag 1)
						(Print 75 35) ; "When you attempt to count your fingers, you're horrified to see that your whole hand is missing! Then you sheepishly remember your invisibility."
					)
					(local5
						(Print 75 36) ; "Amazingly enough, you still have all your fingers!"
					)
					(else
						(Print 75 37) ; "You nervously count your fingers and find, to your relief, that your hand is unharmed."
					)
				)
			)
			((Said 'listen')
				(if local5
					(Print 75 38) ; "All you can hear is the quiet drip of water from the roof of the cave."
				else
					(Print 75 39) ; "All you can hear is the quiet drip of water from the roof of the cave and the giant rat slavering and licking his lips."
				)
			)
			((Said 'smell,smell')
				(Print 75 40) ; "This cave smells of mold and giant rat."
			)
			((Said 'get,get,drink/water,drink')
				(Print 75 41) ; "Are you sure you want to do that right now? This water looks and smells awful!"
			)
			((Said 'light/torch,match')
				(Print 75 42) ; "You don't have that! But there is enough light in this cave for you to see clearly."
			)
			((or (Said '/wall[<cave]>') (and (Said '/cave>') (Said '/side>')))
				(cond
					((Said 'look,look')
						(Print 75 43) ; "The walls of this cave are damp and moldy."
					)
					((Said 'climb,climb,ascend')
						(Print 75 44) ; "The walls of this shadowy cave are too steep for you to climb."
					)
				)
			)
			((Said '/boulder,mold>')
				(cond
					((Said 'eat,eat')
						(Print 75 45) ; "You're kidding, right?"
					)
					((Said 'get')
						(Print 75 46) ; "Do you really think you're going to need that on your quest, Sir Graham?"
					)
					((Said 'look,look')
						(Print 75 47) ; "When you look closely, you can see that the mold on the cave walls is glowing faintly."
					)
				)
			)
			((Said 'get,bend/stalactite,stalactite>')
				(Print 75 48) ; "These are of no use to you, Sir Graham."
			)
			((Said 'look,look>')
				(cond
					((or (Said '/floor') (Said '<down'))
						(Print 75 49) ; "The floor of this cave is damp with mold."
					)
					((Said '[<at,around][/room,cave]')
						(if (not local5)
							(Print 75 50) ; "You are standing in a cavern, with a wooden door directly across from you. A giant mouse is standing in front of the door."
							(Print 75 51) ; "RAT: "Hey, I ain't no mouse, capishe?""
						else
							(Print 75 52) ; "You are standing in a cavern, with a wooden door directly across from you."
						)
					)
					((Said '/stalactite,stalactite')
						(Print 75 53) ; "These rock formations were slowly created over thousands of years."
					)
				)
			)
			((Said 'give,feed/*')
				(Print 75 54) ; "To whom do you wish to give it?"
			)
			(
				(and
					(== (event type:) evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(== (OnControl PRIORITY (event x:) (event y:)) -32768)
				)
				(Print 75 53) ; "These rock formations were slowly created over thousands of years."
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance torchLight of Prop
	(properties
		x 237
		y 112
		description {torch}
		view 275
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'get,get,get/torch')
				(Print 75 55) ; "The torch is too hot to touch."
			)
			(
				(or
					(MousedOn self event)
					(Said 'look,look/torch,candle,light,flame,fire')
				)
				(Print 75 56) ; "There is a single torch on the wall, illuminating this shadowy cave."
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 31
		y 132
		view 275
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(cond
			((or (Said 'look,look/door') (MousedOn self event 3))
				(Print 75 57) ; "It looks like a sturdy old door."
				(event claimed: 1)
			)
			((Said 'enter,open,open/door')
				(if (IsFlag 32)
					(Print 75 58) ; "Just walk over to it."
				else
					(Print 75 59) ; "You'll need to be much closer to do that, Sir Graham."
				)
			)
		)
	)
)

(instance ratFightCloud of Actor
	(properties
		x 50
		y 150
		view 20
	)

	(method (doVerb))
)

(instance rat of Prop
	(properties
		x 55
		y 150
		view 105
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(cond
			((or (Said 'look,look/rat') (MousedOn self event 3))
				(Print 75 60) ; "This is a big, hungry-looking rat with slavering jaws and long, sharp claws."
				(event claimed: 1)
			)
			((Said 'look,look/teeth')
				(Print 75 61) ; "The rat's gigantic fangs look incredibly sharp, as if they could rip through unprotected flesh like a hot knife through butter. His mouth waters and his lips quiver in anticipation of the meal he may make of you."
			)
			((Said 'look,look/claw')
				(Print 75 62) ; "The rat's sharp, pointed claws look as deadly as his teeth!"
			)
		)
	)
)

(instance tongue of Prop
	(properties
		x 86
		y 115
		view 105
		loop 2
	)
)

(instance slobber of Prop
	(properties
		x 86
		y 115
		view 105
		loop 1
	)
)

(instance ratGut of Prop
	(properties
		x 79
		y 138
		description {rat gut}
		view 105
		loop 3
	)
)

(instance ratEyes of View
	(properties
		x 92
		y 113
		description {rat's eyes}
		view 105
		cel 1
	)
)

(instance eyeBalls of View
	(properties
		x 92
		y 113
		description {eyeball}
		view 105
		loop 5
	)
)

(instance waterRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 50 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= local6 1)
				(ratGut cycleSpeed: 1)
				(Print 75 63) ; "The rat is now dripping wet. Although he doesn't seem to mind the dampness, you haven't gotten any closer to your goal."
				(HandsOn)
				(proc0_1)
				(gEgo loop: 1)
				(UpdateWaterBucket 0)
				(self dispose:)
			)
		)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local8 13)
					(Print 75 64) ; "RAT: "Cheese? Well, yeah, now that you mention it, I guess I am kinda hungry....""
				else
					(Print 75 65) ; "RAT: "Some sort of treasure? Now you're talkin', mister. Lemme see some of that treasure.""
				)
				(= cycles 2)
			)
			(1
				((ScriptID 0 21) fade:) ; gameSound
				(gEgo setMotion: MoveTo 105 (rat y:) self)
			)
			(2
				(proc0_8 local8)
				(gGame changeScore: (- 0 local9))
				(gEgo loop: 1 ignoreBlocks: ratBlock stopUpd:)
				(rat setScript: 0)
				(ratEyes dispose:)
				(eyeBalls dispose:)
				(tongue setScript: 0 dispose:)
				(ratGut dispose:)
				(slobber setScript: 0 dispose:)
				((ScriptID 0 21) number: 67 loop: 1 play:) ; gameSound
				(rat view: 106 setLoop: 0 cycleSpeed: 2 setCycle: End self)
			)
			(3
				(cond
					((IsFlag 1)
						(if (== local8 13)
							(Print 75 66) ; "Using his sense of smell as a guide, the rat quickly snatches it from your hand. You might want to count your fingers."
							(SetScore 102 2)
						else
							(Print 75 67) ; "The rat uses his strong sense of smell as a guide and takes the treasure from your hand."
						)
					)
					((== local8 13)
						(Print 75 68) ; "The rat drools at the sight of the cheese, and snatches it from your hand. You might want to count your fingers."
						(SetScore 102 2)
					)
					(else
						(Print 75 69) ; "The rat takes the treasure from your hand."
					)
				)
				(self cue:)
			)
			(4
				((ScriptID 0 21) number: 43 loop: 1 play:) ; gameSound
				(rat setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(rat dispose:)
				(= local5 1)
				(SetFlag 32)
				(HandsOn)
				(= cycles 2)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance slobberScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(slobber show: setCycle: Fwd)
				(= cycles (Random 40 60))
			)
			(1
				(slobber hide: stopUpd:)
				(= cycles
					(if local6
						(Random 8 15)
					else
						(Random 4 8)
					)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance tongueScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tongue cycleSpeed: 1 setCycle: Fwd show:)
				(= cycles (Random 10 20))
			)
			(1
				(tongue hide: stopUpd:)
				(= cycles 1)
			)
			(2
				(tongue setCel: 0)
				(= seconds (Random 6 15))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance ratBlinkScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(eyeBalls
			cel:
				(cond
					((> (gEgo x:) 166) 0)
					((> (gEgo y:) (+ (rat y:) 5)) 2)
					((< (gEgo y:) (- (rat y:) 5)) 1)
					(else 0)
				)
			forceUpd:
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ratEyes show:)
				(eyeBalls hide: stopUpd:)
				(= cycles (Random 3 6))
			)
			(1
				(ratEyes hide: stopUpd:)
				(eyeBalls show:)
				(= seconds
					(if local6
						(Random 10 20)
					else
						(Random 2 5)
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance fightRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ratEyes hide: stopUpd:)
				(eyeBalls hide: stopUpd:)
				(tongue setScript: 0 hide: stopUpd:)
				(ratGut hide: stopUpd:)
				(slobber setScript: 0 hide: stopUpd:)
				(rat setLoop: 4 setScript: 0 setCycle: End self)
			)
			(1
				(rat hide:)
				(gEgo hide:)
				(ratFightCloud
					posn:
						(/ (+ (rat x:) (gEgo x:)) 2)
						(/ (+ (rat y:) (gEgo y:)) 2)
					setLoop: 2
					setCel: 0
					show:
				)
				((ScriptID 0 21) number: 46 loop: 1 play: self) ; gameSound
				(= cycles 2)
			)
			(2
				(rat stopUpd:)
				(gEgo stopUpd:)
				(if (IsFlag 1)
					(Print 75 70) ; "Using his sense of smell to guide him, the rat attacks you. In the scuffle, your ring falls off, making you visible again."
				)
				(ratFightCloud
					setLoop: 0
					setCycle: Fwd
					show:
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				(= cycles 6)
			)
			(3
				(ratFightCloud
					setLoop: 0
					setMotion:
						MoveTo
						(/ (+ (rat x:) (- (gEgo x:) 35)) 2)
						(rat y:)
				)
			)
			(4
				(gEgo
					view: 3
					setLoop: 0
					setCel: 0
					posn: 82 160
					setCycle: 0
					show:
					stopUpd:
				)
				(rat setLoop: 0 setCel: 0 show: stopUpd:)
				(if (>= global101 1)
					(rat setScript: ratBlinkScript)
				)
				(ratEyes show: stopUpd:)
				(eyeBalls show: stopUpd:)
				(tongue show: stopUpd:)
				(if (>= global101 1)
					(tongue setScript: tongueScript)
				)
				(ratGut show: stopUpd:)
				(slobber show: stopUpd:)
				(if (>= global101 1)
					(slobber setScript: slobberScript)
				)
				(ratFightCloud setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(ratFightCloud hide:)
				(= seconds 3)
			)
			(6
				(EgoDead
					{Rats!__This was one shady character you shouldn't have tangled with.}
				)
				(HandsOn)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(doorSound number: 15 init: loop: 1 play:)
				(gEgo stopUpd:)
				(door cycleSpeed: 1 setCycle: End self)
			)
			(1
				(doorSound stop:)
				(gEgo setMotion: DPath 24 139 -1 139 self)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom west:))
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorSound number: 16 loop: 1 init: play:)
				(gEgo stopUpd:)
				(door cel: 4 setCycle: Beg self)
			)
			(1
				(doorSound stop:)
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

