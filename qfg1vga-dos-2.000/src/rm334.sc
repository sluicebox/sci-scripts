;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 334)
(include sci.sh)
(use Main)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm334 0
	slinkTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm334 of Rm
	(properties
		noun 7
		picture 333
		style 0
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 257 189 213 151 177 145 170 137 165 111 143 112 138 119 143 133 148 149 121 179 108 184 85 189
					yourself:
				)
		)
		(gFeatures
			add:
				onTheWalls
				onBarrels
				onBarrels2
				onHotDogStand
				onBricks
				marksOnWall2
				marksOnWall
			eachElementDo: #init
		)
		(coin ignoreActors: 1 setLoop: 6 setPri: 6 init:)
		(LoadMany rsVIEW 333 503)
		(super init:)
		(switch gPrevRoomNum
			(53
				(gEgo loop: 2 posn: 160 130 init: setScript: moveEgoIn)
			)
			(else
				(if (not gNight)
					(FixTime 20)
				)
				(gEgo init: posn: 162 247 setLoop: 3)
				(self setScript: sEnter)
			)
		)
		(self setRegions: 811 801) ; Street, Town
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 0 6) ; "This place seems sinister at night. Some strange object is glowing at the other end of the alley."
			)
			(4 ; Do
				(gMessager say: 7 4 11) ; "The whole place is in need of repair."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(cond
			(script)
			((and (not local0) (not local0) (< 140 (gEgo y:) 143))
				(self setScript: ambushScript)
			)
			(
				(and
					local0
					(not local1)
					(or (> (gEgo y:) 143) (< (gEgo y:) 140))
				)
				(gCurRoom setScript: stabTheBum)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(self setScript: sExitRoom)
			)
		)
		(super doit:)
	)

	(method (cue)
		(if (not local1)
			(gCurRoom setScript: stabTheBum)
		)
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 101)
		(DisposeScript 988)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance onTheWalls of Feature
	(properties
		x 75
		y 80
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 7 1 11) ; "The walls seem pretty normal, but there are some curious marks on the north ends of the buildings."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onBarrels of Feature
	(properties
		x 106
		y 148
		noun 1
		nsTop 133
		nsLeft 90
		nsBottom 164
		nsRight 122
		sightAngle 40
		onMeCheck 2
	)
)

(instance onBarrels2 of Feature
	(properties
		x 198
		y 120
		noun 2
		nsTop 104
		nsLeft 184
		nsBottom 136
		nsRight 212
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1) ; "Looks like this barrel once contained Dragon's Breath. The bottom's eaten out."
			)
			(4 ; Do
				(gMessager say: 2 4) ; "The barrel is too heavy to pick up."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onHotDogStand of Feature
	(properties
		x 114
		y 128
		noun 5
		nsTop 104
		nsLeft 105
		nsBottom 153
		nsRight 124
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 5 1) ; "An early model of a hot dog stand -- or could it be a hamburger stand?"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onBricks of Feature
	(properties
		x 158
		y 74
		noun 3
		nsTop 42
		nsLeft 129
		nsBottom 104
		nsRight 190
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1) ; "The back wall is one of the best examples of a perpendicular wall that you have ever seen. It reminds you of the time when you thought about climbing Mount Everest."
			)
			(4 ; Do
				(cond
					(
						(and
							local0
							(not local1)
							(or (> (gEgo y:) 143) (< (gEgo y:) 140))
						)
						(gMessager say: 3 4) ; "That's a pretty tall wall."
						(HandsOff)
						(gCurRoom setScript: killTheBum)
					)
					((TrySkill 11 35 0) ; climbing
						(gEgo setScript: toTheCentaur)
					)
					((not [gEgoStats 11]) ; climbing
						(gMessager say: 3 4 3) ; "Leave the climbing to those who know how."
						(++ local3)
					)
					((< 3 local3 10)
						(gMessager say: 3 4 2) ; "You'd better not try to climb the wall any more right now. You've been at this long enough that someone is likely to notice."
						(= local3 10)
					)
					(else
						(gMessager say: 3 4 1) ; "That wall sure is tall. You'll need to practice some more before you'll be ready to climb it."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance marksOnWall of Feature
	(properties
		x 120
		y 103
		noun 6
		nsTop 100
		nsLeft 112
		nsBottom 107
		nsRight 128
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (<= (gEgo y:) 150)
					(gMessager say: 6 1 4) ; "Some sharp object appears to have been thrown at these walls several times."
				else
					(gMessager say: 6 1 5) ; "You can't make them out from here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance marksOnWall2 of Feature
	(properties
		x 203
		y 91
		nsTop 80
		nsLeft 194
		nsBottom 102
		nsRight 212
		sightAngle 40
	)

	(method (doVerb theVerb)
		(marksOnWall doVerb: theVerb &rest)
	)
)

(instance slink of Actor
	(properties
		x 176
		y 135
		noun 8
		view 333
		loop 3
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local4 sneak)
					(gMessager say: 7 1 14) ; "This man may be smiling at you, but he doesn't seem very friendly. He may be short, but that dagger makes him look 7 feet tall."
				else
					(gMessager say: 7 1 13) ; "This man may be smiling at you, but he doesn't seem very friendly. His florid face tells you that this thief is a regular at the "Aces and Eights" tavern."
				)
			)
			(4 ; Do
				(cond
					(local1
						(gMessager say: 7 4 10) ; "The thieves seem to be ignoring you."
					)
					((IsFlag 123)
						(gMessager say: 7 4 12) ; "Yeah, yeah, we know, you're in the Guild too. How's a poor independent businessman supposed to make a living around here with all this competition?"
						(= local1 1)
					)
					((not (or [gEgoStats 8] [gEgoStats 9])) ; stealth, pick locks
						(gMessager say: 7 4 9) ; "What's that supposed to be? You trying to pretend you're a thief or something? Har, har."
					)
					(else
						(gEgo setScript: messageTwo)
					)
				)
			)
			(17 ; lockPick
				(cond
					(local1
						(gMessager say: 7 4 10) ; "The thieves seem to be ignoring you."
					)
					((IsFlag 123)
						(gMessager say: 7 4 12) ; "Yeah, yeah, we know, you're in the Guild too. How's a poor independent businessman supposed to make a living around here with all this competition?"
						(= local1 1)
					)
					((not (or [gEgoStats 8] [gEgoStats 9])) ; stealth, pick locks
						(gMessager say: 7 4 9) ; "What's that supposed to be? You trying to pretend you're a thief or something? Har, har."
					)
					(else
						(gEgo setScript: messageTwo)
					)
				)
			)
			(18 ; thiefKit
				(cond
					(local1
						(gMessager say: 7 4 10) ; "The thieves seem to be ignoring you."
					)
					((IsFlag 123)
						(gMessager say: 7 4 12) ; "Yeah, yeah, we know, you're in the Guild too. How's a poor independent businessman supposed to make a living around here with all this competition?"
						(= local1 1)
					)
					((not (or [gEgoStats 8] [gEgoStats 9])) ; stealth, pick locks
						(gMessager say: 7 4 9) ; "What's that supposed to be? You trying to pretend you're a thief or something? Har, har."
					)
					(else
						(gEgo setScript: messageTwo)
					)
				)
			)
			(2 ; Talk
				(cond
					(local1
						(gMessager say: 7 4 10) ; "The thieves seem to be ignoring you."
					)
					((IsFlag 123)
						(gMessager say: 7 4 7 2) ; "Tell Crusher that the password is 'schwertfisch'. He's in the tavern."
					)
					(else
						(gMessager say: 8 2) ; "My finger is starting to get a bit twitchy, so forget about questions, just pay the man and get out alive."
					)
				)
			)
			(10 ; silver
				(cond
					(local1
						(gMessager say: 7 4 10) ; "The thieves seem to be ignoring you."
					)
					((IsFlag 123)
						(gMessager say: 7 4 12) ; "Yeah, yeah, we know, you're in the Guild too. How's a poor independent businessman supposed to make a living around here with all this competition?"
						(= local1 1)
					)
					(
						(and
							(< ((gInventory at: 0) amount:) 5) ; silver
							(not (gEgo has: 38)) ; gold
						)
						(gMessager say: 8 10 26) ; "Hey! You don't have enough money to be worth our while. How do you expect us poor independent businessmen to make a living?"
						(HandsOff)
						(gCurRoom setScript: killTheBum)
					)
					(else
						(= local1 1)
						(gMessager say: 8 10 25) ; "Thanks, and have a nice evening. It's been a pleasure doing business with you. You can find your way out, I'm sure. But make it fast, before my dagger slips."
						(SolvePuzzle 606 -10 2)
						(roomTimer setReal: gCurRoom 10)
						(gEgo setScript: giveMoney)
					)
				)
			)
			(16 ; dagger
				(gMessager say: 8 16) ; "As you start to draw your weapon, the thieves jump you."
				(HandsOff)
				(gCurRoom setScript: killTheBum)
			)
			(12 ; sword
				(gMessager say: 8 16) ; "As you start to draw your weapon, the thieves jump you."
				(HandsOff)
				(gCurRoom setScript: killTheBum)
			)
			(19 ; thiefLicense
				(if local1
					(gMessager say: 7 4 10) ; "The thieves seem to be ignoring you."
				else
					(gMessager say: 7 4 7 1) ; "You mean that the first victim we've had in months is a thief? Here I thought we were finally going to make some money."
					(= local1 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance sneak of Actor
	(properties
		x 134
		y 162
		noun 8
		view 333
		loop 4
		illegalBits 0
	)

	(method (doVerb theVerb)
		(= local4 sneak)
		(slink doVerb: theVerb &rest)
	)
)

(instance knife of Actor
	(properties
		x 144
		y 115
		view 333
		loop 5
		priority 10
		illegalBits 0
	)
)

(instance knife2 of Actor
	(properties
		x 144
		y 115
		view 333
		loop 5
		priority 10
		illegalBits 0
	)
)

(instance coin of Extra
	(properties
		x 158
		y 111
		noun 4
		view 333
		loop 6
		cycleType 1
		pauseCel 2
		minPause 40
		maxPause 80
		minCycles 1
		maxCycles 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (<= (gEgo y:) 150)
					(gMessager say: 4 1 4) ; "It's a glowing golden coin."
				else
					(gMessager say: 4 1) ; "You just see a glint from here."
				)
			)
			(4 ; Do
				(if (not local1)
					(gEgo setMotion: PolyPath 158 117)
				else
					(gMessager say: 4 1 4) ; "It's a glowing golden coin."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stabTheBum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(gMessager say: 8 0 17 1 self) ; "Aw, ya forgot to pay. What a shame."
			)
			(1
				(gEgo setMotion: 0 setCycle: 0 setScript: 0)
				(sneak ignoreActors: 1 setPri: 10 setCel: 3 init:)
				(self cue:)
			)
			(2
				(gCurRoom setScript: killTheBum)
			)
		)
	)
)

(instance killTheBum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 29)
				(= seconds 2)
			)
			(1
				(sneak setCycle: CT 8 1)
				(knife2
					ignoreActors: 1
					setLoop: 5
					setCel: 0
					setPri: 10
					init:
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 23) self
				)
				(knifeSound number: 31 play:)
			)
			(2
				(knifeSound number: 29 play:)
				(knife2 setCycle: 0)
				(slink ignoreActors: 0 stopUpd:)
				(= cycles 3)
			)
			(3
				(knife2 hide:)
				(gEgo
					view: 503
					setLoop: 0
					cel: 0
					setPri: (- (sneak priority:) 1)
					setCycle: End self
				)
			)
			(4
				(EgoDead 1 2 0 0 800) ; "Perhaps you shouldn't explore dark alleys at night unless you are looking for trouble. Or you should look in your manual to learn how to deal with thieves."
			)
		)
	)
)

(instance moveEgoIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 1)
				(gEgo setMotion: MoveTo 148 142 self)
			)
			(1
				(gEgo setScript: 0)
				(gCurRoom setScript: ambushScript)
			)
		)
	)
)

(instance toTheCentaur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					signal: (| (gEgo signal:) $4000)
					illegalBits: 0
					setCycle: Walk
					setMotion: PolyPath 144 113 self
				)
			)
			(1
				(gEgo
					view: 517
					setLoop: 0
					setCel: 0
					posn: 146 76
					setCycle: Walk
					setMotion: MoveTo 142 62 self
				)
			)
			(2
				(gEgo
					setLoop: 1
					setCel: 0
					posn: 144 44
					setCycle: CT 7 1 self
				)
			)
			(3
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance messageTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 7 4 7 1 self) ; "You mean that the first victim we've had in months is a thief? Here I thought we were finally going to make some money."
				(SolvePuzzle 642 3 2)
				(SetFlag 123)
				(= local1 1)
			)
			(1
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 7 4 7 2 self) ; "Tell Crusher that the password is 'schwertfisch'. He's in the tavern."
				else
					(self cue:)
				)
			)
			(2
				(if (not (gEgo has: 9)) ; thiefLicense
					(gMessager say: 7 4 7 3 self) ; "Now go before I forget you made the sign and I make you pay anyway."
				else
					(self cue:)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
				(roomTimer setReal: gCurRoom 10)
			)
		)
	)
)

(instance slinkTalker of Talker
	(properties
		x 10
		y 10
		view 1333
		talkWidth 260
		textX 15
		textY 112
	)

	(method (init)
		(= global451 2333)
		(PalVary pvCHANGE_TARGET 2333)
		(AssertPalette 1333)
		(= font gUserFont)
		(super init: slinkBust slinkEye slinkMouth &rest)
	)
)

(instance slinkBust of Prop
	(properties
		view 1333
	)
)

(instance slinkMouth of Prop
	(properties
		nsTop 44
		nsLeft 43
		view 1333
		loop 1
	)
)

(instance slinkEye of Prop
	(properties
		nsTop 22
		nsLeft 44
		view 1333
		loop 2
	)
)

(instance knifeSound of Sound
	(properties)
)

(instance leMusic of Sound
	(properties
		flags -1
		number 73
		priority 3
		loop -1
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: MoveTo 162 185 self)
			)
			(2
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(= ticks 30)
			)
			(3
				(if (not (IsFlag 101))
					(SetFlag 101)
					(gMessager say: 7 0 6 0 self) ; "This place seems sinister at night. Some strange object is glowing at the other end of the alley."
				else
					(= seconds 1)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 2 setMotion: MoveTo (gEgo x:) 247 self)
			)
			(1
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance ambushScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(leMusic play:)
				(Load rsSOUND 30)
				(Load rsSOUND 31)
				(= local0 1)
				(gEgo setMotion: PolyPath 148 142)
				(slink ignoreActors: 1 setPri: 7 init: setCycle: End self)
			)
			(1
				(Face gEgo slink)
				(sneak ignoreActors: 1 setPri: 10 init: setCycle: CT 3 1 self)
			)
			(2
				(sneak setCycle: CT 8 1)
				(knife
					ignoreActors: 1
					setLoop: 5
					setPri: 10
					init:
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 194 89 self
				)
				(knifeSound number: 31 loop: 1 play:)
			)
			(3
				(knifeSound number: 30 play:)
				(knife setCel: 2 addToPic:)
				(slink ignoreActors: 0 stopUpd:)
				(= cycles 3)
			)
			(4
				(sneak setCel: 3 ignoreActors: 0 stopUpd:)
				(= cycles 5)
			)
			(5
				(cond
					((not (IsFlag 126))
						(SetFlag 126)
						(if (== gPrevRoomNum 53)
							(gMessager say: 8 0 15) ; "See that dagger? The next one is centered on your back."
						else
							(gMessager say: 8 0 16) ; "That 'Coin Light' spell gets them every time. See that dagger? The next one is centered on your back."
						)
						(HandsOn)
						(self dispose:)
					)
					((not (IsFlag 123))
						(gMessager say: 8 0 23) ; "Why, how nice to see you again. I do hope (for your sake) you brought us some nice shiny new silver."
						(HandsOn)
						(self dispose:)
					)
					((not (gEgo has: 9)) ; thiefLicense
						(gMessager say: 8 0 22) ; "Hey, Sneak, this guy's hard of hearing or something. I told him to get a license last time he was here, and he didn't listen."
						(gCurRoom setScript: killTheBum)
						(self dispose:)
					)
					((IsFlag 299)
						(gMessager say: 8 0 21) ; "As Slink reaches for his dagger, you draw your Thieves' Guild license... You *almost* make it."
						(= seconds 2)
					)
					(else
						(gMessager say: 8 0 19) ; "As Slink reaches for his dagger, you draw your Thieves' Guild license... You win by a close margin."
						(= ticks 30)
					)
				)
				(roomTimer setReal: gCurRoom 20)
			)
			(6
				(if (IsFlag 299)
					(gMessager say: 8 0 18) ; "Hey, Sneak, this guy's hard of hearing or something. I told him to stay out of our alley, and he didn't listen. Let's teach him a little lesson about listening to his betters."
					(gCurRoom setScript: killTheBum)
					(self dispose:)
				else
					(gMessager say: 8 0 20) ; "All right, so you got your license. How nice. Guess we don't get to kill you right now. But stay out of our alley, 'cause we got real short memories, like."
					(SetFlag 299)
					(self dispose:)
					(HandsOn)
					(= local1 1)
				)
			)
		)
	)
)

(instance giveMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				((gInventory at: 38) amount: 0) ; gold
				((gInventory at: 0) amount: 1) ; silver
				(gEgo use: 0 1) ; silver
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance roomTimer of Timer
	(properties)
)

