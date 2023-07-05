;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm21 0
	babaTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(User canInput: 0)
	(switch global274
		(0
			(rm21 setScript: nameDeath)
		)
		(1
			(rm21 setScript: braveDeath)
		)
		(2
			(rm21 setScript: noFetchDeath)
		)
		(3
			(rm21 setScript: noBringDeath)
		)
	)
)

(instance rm21 of Rm
	(properties
		noun 11
		picture 21
		style 1
	)

	(method (dispose)
		(= global451 0)
		(SetFlag 11)
		(gEgo moveSpeed: local4 cycleSpeed: local3)
		(DisposeScript 969)
		(super dispose:)
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 51 164 99 166 145 189 0 189 0 0 319 0 319 189 228 189 229 183 192 160 216 149 160 127 44 132
					yourself:
				)
		)
		(LoadMany rsVIEW 20 21 19 531 122)
		(LoadMany rsSOUND 51 28)
		(LoadMany rsSCRIPT 967)
		(super init:)
		(SolvePuzzle 652 2)
		(if (gEgo has: 21) ; mandrake
			(ClearFlag 326)
		)
		(gLongSong fade:)
		(teleport number: 28 init:)
		(ClearFlag 287)
		(bubbleMusic init: play:)
		(NormalEgo)
		(= global111 0)
		(gFeatures
			add:
				skull
				cauldron
				broom
				note
				bucket
				table
				web
				firePlace
				telephone
				murial
				brokenGate
				hutWindow
		)
		(if (== gPrevRoomNum 299) ; speedRoom
			(gEgo init: posn: 166 187)
		else
			(gEgo loop: 1 posn: 202 187 init:)
		)
		(spider setCycle: Fwd init: stopUpd:)
		(bat init:)
		(= local3 (gEgo cycleSpeed:))
		(= local4 (gEgo moveSpeed:))
		(fire setCycle: Fwd init:)
		(cond
			((not (IsFlag 11))
				(self setScript: firstWitch)
			)
			((== global274 2)
				(= global274 3)
				(self setScript: nextWitch)
			)
			((gEgo has: 20) ; magicMirror
				(= global274 4)
				(self setScript: lastWitch)
			)
			((== global274 3)
				(= global274 4)
				(self setScript: lastWitch)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 17 0 self) ; "Who would have guessed that little chicken hut would have this much room in it."
			)
			(30 ; magicMirror
				(gMessager say: 1 30 0) ; "You furtively grasp the Magic Mirror."
				(SetFlag 325)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance web of Feature
	(properties
		x 68
		y 167
		noun 16
		onMeCheck 2
	)
)

(instance table of Feature
	(properties
		x 270
		y 163
		noun 14
		onMeCheck 4
	)
)

(instance bucket of Feature
	(properties
		x 221
		y 164
		noun 5
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 5 1) ; "Whatever's in this bucket, it really stinks."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance note of Feature
	(properties
		x 242
		y 74
		noun 10
		onMeCheck 16
	)
)

(instance firePlace of Feature
	(properties
		x 282
		y 85
		noun 7
		onMeCheck 32
	)
)

(instance broom of Feature
	(properties
		x 306
		y 141
		noun 4
		onMeCheck 64
	)
)

(instance cauldron of Feature
	(properties
		x 209
		y 130
		noun 6
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 6 1) ; "The fire burns hot under the kettle."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance skull of Feature
	(properties
		x 228
		y 50
		noun 12
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 12 1) ; "The grisly remains of some man-like animal."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance telephone of Feature
	(properties
		x 226
		y 128
		z 73
		noun 15
		nsTop 50
		nsLeft 221
		nsBottom 60
		nsRight 232
		sightAngle 40
	)
)

(instance murial of Feature
	(properties
		x 119
		noun 9
		nsTop 4
		nsLeft 5
		nsBottom 117
		nsRight 233
		sightAngle 40
	)
)

(instance brokenGate of Feature
	(properties
		x 34
		y 141
		noun 3
		nsTop 117
		nsLeft 3
		nsBottom 188
		nsRight 66
		sightAngle 40
	)
)

(instance hutWindow of Feature
	(properties
		x 177
		y 181
		noun 8
		nsTop 176
		nsLeft 161
		nsBottom 187
		nsRight 193
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(switch local2
				(0
					(gMessager say: 8 1 3) ; "Window? What window?"
					(++ local2)
				)
				(1
					(gMessager say: 8 1 1) ; "Okay, Okay, so you think there should be a window here?"
					(++ local2)
				)
				(2
					(gMessager say: 8 1 2) ; "The glass seems to distort the view of the outside world... but which world is it?"
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance reflection of Prop
	(properties
		view 122
		loop 1
		cycleSpeed 1
	)
)

(instance spider of Prop
	(properties
		x 86
		y 171
		noun 13
		view 21
		priority 15
		signal 16
		cycleSpeed 12
	)
)

(instance TP of Prop
	(properties
		view 531
	)
)

(instance fire of Prop
	(properties
		x 273
		y 143
		view 21
		loop 3
	)

	(method (doVerb theVerb)
		(cauldron doVerb: theVerb &rest)
	)
)

(instance bat of Prop
	(properties
		x 62
		y 18
		noun 2
		view 21
		loop 7
		priority 15
		signal 16
		cycleSpeed 8
	)
)

(instance baba of Actor
	(properties
		noun 1
		view 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1) ; "That's one mean Ogress!"
			)
			(30 ; magicMirror
				(gMessager say: 1 30 0) ; "You furtively grasp the Magic Mirror."
				(SetFlag 325)
			)
			(else
				(lastWitch seconds: 0 cue:)
			)
		)
	)
)

(instance firstWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 143 172 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(TP posn: 195 132 setPri: 15 init: setCycle: CT 4 1 self)
			)
			(3
				(teleport play:)
				(TP setCel: 4 setCycle: CT 9 1 self)
				(baba posn: 195 132 setLoop: 6 init:)
			)
			(4
				(TP setCel: 0 dispose:)
				(self cue:)
			)
			(5
				(spider startUpd:)
				(= local1 1)
				(gMessager say: 11 0 0 1 self) ; "Look pets... we have a visitor!"
			)
			(6
				(= local1 0)
				(bat setCycle: End self)
			)
			(7
				(gEgo loop: 0)
				(spider setCycle: 0)
				(= local1 1)
				(gMessager say: 11 0 0 2 self) ; "Powers of Night, Shadows of Day -- Heed now my Words! Henceforth you STAY!"
			)
			(8
				(= local1 0)
				(bat setLoop: 5)
				(baba setLoop: 6 setCycle: End self)
			)
			(9
				(gMessager say: 11 0 9 0 self) ; "Your body is frozen by the power of the witch's spell."
			)
			(10
				(baba
					setLoop: 8
					xStep: 2
					yStep: 5
					setCycle: Walk
					setMotion:
						PolyPath
						(+ (gEgo x:) 20)
						(- (gEgo y:) 5)
						self
				)
			)
			(11
				(baba setCycle: 0)
				(= cycles 2)
			)
			(12
				(gMessager say: 11 0 0 3 self) ; "Well Dearies! What shall we have for supper today?"
				(= local1 1)
			)
			(13
				(spider setCycle: Fwd)
				(bat cycleSpeed: 12 setCycle: Fwd)
				(= seconds 4)
			)
			(14
				(bat setCycle: 0)
				(spider setCycle: 0)
				(gMessager say: 11 0 0 4 self) ; "Hero sandwiches? I had something more formal in mind."
			)
			(15
				(gMessager say: 11 0 7 0 self) ; "Ah...that's it! Frog Legs Fricassee."
			)
			(16
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 3)
			)
			(17
				(gMessager say: 11 0 0 5 self) ; "Now how does that spell go...?"
				(bat setCycle: 0)
				(spider setCycle: 0)
			)
			(18
				(gMessager say: 11 0 0 6 self) ; "Hear me, oh Powers Of Klatha and Mana! Turn now my guest Into species called Rana!"
			)
			(19
				(= local1 0)
				(baba setLoop: 6 setCycle: End self)
			)
			(20
				(gEgo view: 19 loop: 2 cel: 0 setCycle: End self)
				(teleport play:)
			)
			(21
				(baba setLoop: 8 setCycle: Walk setMotion: MoveTo 160 168 self)
			)
			(22
				(gEgo ignoreActors: hide:)
				(baba view: 20 setLoop: 7 setCycle: CT 3 1 self)
			)
			(23
				(baba setCycle: End self)
			)
			(24
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= local1 1)
				(gMessager say: 11 0 0 7 self) ; "I learned that spell from Erasmus, kids. Doesn't it look delicious?"
			)
			(25
				(= local1 0)
				(spider setCycle: 0)
				(bat setCycle: 0)
				(rm21 setScript: firstTalk)
			)
		)
	)
)

(instance firstTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba
					setLoop: 0
					xStep: 3
					yStep: 9
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 276 144 self
				)
			)
			(1
				(baba
					view: 20
					setLoop: 3
					setCycle: 0
					ignoreActors:
					setPri: 13
					cel: 0
				)
				(gEgo
					view: 20
					setLoop: 2
					cel: 0
					posn: 263 97
					setPri: (+ (baba priority:) 1)
					setCycle: Fwd
					ignoreActors:
					show:
				)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(= local1 1)
				(gMessager say: 11 0 0 8 self) ; "BE STILL!"
				(gEgo setCycle: 0)
			)
			(3
				(spider setCycle: 0)
				(bat setLoop: 1 cel: 4 setCycle: Beg self)
			)
			(4
				(gMessager say: 11 0 0 9 self) ; "Critics! We can't all be gourmands, I suppose."
			)
			(5
				(self cue:)
			)
			(6
				(= global274 0)
				(gMessager say: 11 0 14 0 self) ; "Now, Oh-Soon-To-Be-Supper... I don't suppose you have a name?"
			)
			(7
				(switch
					(Print
						addButton: 0 11 0 0 12 0 0 21 ; "Yes"
						addButton: 1 11 0 0 13 0 18 21 ; "No"
						init:
					)
					(0
						(= local1 0)
						(= ticks 1)
					)
					(1
						(localproc_0)
					)
				)
			)
			(8
				(gEgo setCycle: Fwd)
				(= local1 1)
				(self cue:)
			)
			(9
				(gMessager say: 11 0 6 0 self) ; "You try your best to croak out your name, or at least let the witch know that you do indeed have one."
			)
			(10
				(gEgo setCycle: 0)
				(baba setPri: 14)
				(= local1 1)
				(gMessager say: 11 0 0 10 self) ; "So you're the one who's trying to be a hero around here. The only good hero's a dead hero, I always say!"
			)
			(11
				(= seconds 2)
			)
			(12
				(= global274 1)
				(gMessager say: 11 0 0 11 self) ; "But I do have a need for a brave fool. Are YOU brave?"
			)
			(13
				(switch
					(Print
						addButton: 0 11 0 0 12 0 0 21 ; "Yes"
						addButton: 1 11 0 0 13 0 18 21 ; "No"
						init:
					)
					(0
						(= local1 0)
						(= ticks 1)
					)
					(1
						(localproc_0)
					)
				)
			)
			(14
				(gEgo setCycle: Fwd)
				(= local1 1)
				(self cue:)
			)
			(15
				(gMessager say: 11 0 0 14 self) ; "You make little froggy sounds, trying your best to indicate your agreement."
			)
			(16
				(gEgo setCycle: 0)
				(gMessager say: 11 0 0 15 self) ; "Wellll..."
			)
			(17
				(gMessager say: 11 0 0 16 self) ; "If you're willing to do a small little teensy favor for me, I might reconsider having you for supper."
			)
			(18
				(gEgo setCycle: Fwd)
				(self cue:)
			)
			(19
				(= global274 2)
				(gMessager say: 11 0 0 17 self) ; "I need the root of a mandrake plant that grows in the graveyard. Will you be a sweet and fetch me some?"
			)
			(20
				(switch
					(Print
						addButton: 0 11 0 0 12 0 0 21 ; "Yes"
						addButton: 1 11 0 0 13 0 18 21 ; "No"
						init:
					)
					(0
						(= local1 0)
						(= ticks 1)
					)
					(1
						(localproc_0)
					)
				)
			)
			(21
				(gEgo setCycle: Fwd)
				(= local1 1)
				(self cue:)
			)
			(22
				(gMessager say: 11 0 0 18 self) ; ""Anything but Frog Legs Fricassee!", you think. You croak your agreement to the task."
			)
			(23
				(gEgo setCycle: 0)
				(spider setCycle: Fwd)
				(bat setLoop: 5 setCycle: Fwd)
				(gMessager say: 11 0 0 19 self) ; "And I had my mouth watering for frog. Oh well!"
			)
			(24
				(gEgo setCycle: 0)
				(self cue:)
			)
			(25
				(spider setCycle: 0)
				(bat setCycle: 0)
				(gMessager say: 11 0 0 20 self) ; "Hear what I say, And hear me right: Mandrake must be pulled At precisely Midnight!"
			)
			(26
				(gMessager say: 11 0 0 21 self) ; "This I tell you And this I say: Return with the root 'Ere the break of next day."
			)
			(27
				(gMessager say: 11 0 0 22 self) ; "Hear what I say And know I don't lie: Bring back the root Or else you will die!!"
			)
			(28
				(= local1 0)
				(gEgo setCycle: 0 hide:)
				(baba
					view: 20
					setLoop: 1
					xStep: 4
					yStep: 8
					setPri: 10
					setCycle: Walk
					setMotion: PolyPath 123 133 self
				)
			)
			(29
				(baba view: 20 setLoop: 7 cel: 5 setCycle: CT 3 -1 self)
			)
			(30
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(gEgo
					view: 19
					setLoop: 2
					cel: 8
					posn: (- (baba x:) 17) (+ (baba y:) 4)
					setPri: 10
					show:
				)
				(baba setCycle: CT 0 -1 self)
			)
			(31
				(gMessager say: 11 0 0 23 self) ; "You, Shoo!"
			)
			(32
				(baba setLoop: 6 cel: 0 setCycle: End self)
				(TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 11
					init:
					setCycle: CT 5 1 self
				)
				(teleport play:)
			)
			(33
				(gEgo hide:)
				(TP setCycle: End self)
			)
			(34
				(gCurRoom newRoom: 22)
			)
		)
	)
)

(instance nameDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setCel: 1 setPri: 13 setScript: 0)
				(= global111 0)
				(gMessager say: 11 0 13 1 self) ; "Stubborn, aren't you?"
			)
			(1
				(gMessager say: 11 0 0 24 self) ; "Well, you won't be so tough after you've simmered in a little wine sauce."
			)
			(2
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(baba setCel: 1)
				(gMessager say: 11 0 0 25 self) ; "Bon appetite, Dearies!"
			)
			(4
				(EgoDead 80 81) ; "Next time you are asked a question by someone who has just turned you into a frog, perhaps you should be more polite. It's better than being fricasseed!"
			)
		)
	)
)

(instance braveDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(= global111 0)
				(gMessager say: 11 0 0 26 self) ; "It's just as well. I'd lose my dinner if you were brave."
			)
			(1
				(baba setCel: 1)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(gMessager say: 11 0 11 0 self) ; "Lovies, it's about time we dine."
			)
			(2
				(EgoDead 39 40) ; "Didn't anyone ever tell you that a hero is supposed to be brave even when he doesn't feel that way? Looks like you found the coward's way out... sauteed in wine sauce."
			)
		)
	)
)

(instance noFetchDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(gMessager say: 11 0 15 0 self) ; "Well, if you won't be a sweet, then you'll be my meat!"
			)
			(1
				(baba setCel: 1)
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(gMessager say: 11 0 0 27 self) ; "Nothin' says lovin' like frog legs in the oven."
			)
			(2
				(EgoDead 78 79) ; "It seems a shame to have such a promising career go up in flames (assuming she decides to flambe you). Wouldn't it have been better just to do a small favor for such a sweet little old Ogress?"
			)
		)
	)
)

(instance noBringDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baba setScript: 0)
				(gMessager say: 11 0 0 28 self) ; "No mandrake for me, eh? What a waste of spells you turned out to be."
			)
			(1
				(spider setCycle: Fwd)
				(bat setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(gMessager say: 11 0 0 29 self) ; "Actually, since it's my breakfast time, we'll have some amphibian omelette with bacon and legs."
			)
			(3
				(EgoDead 17 18) ; "At least you could have said "Yes" before you croaked!"
			)
		)
	)
)

(instance lastWitch of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 120 150 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(TP posn: 195 132 init: setCycle: CT 4 1 self)
			)
			(3
				(teleport play:)
				(TP setCel: 4 setCycle: CT 9 1 self)
				(baba setLoop: 6 posn: 195 132 init:)
			)
			(4
				(TP setCel: 0 dispose:)
				(spider startUpd:)
				(= local1 1)
				(if (IsFlag 11)
					(gMessager say: 11 0 0 30 self) ; "You again?"
				else
					(gMessager say: 11 0 0 31 self) ; "Hello, Hero."
				)
			)
			(5
				(bat setCycle: End self)
			)
			(6
				(HandsOn)
				(gTheIconBar disable: 1 3 4 5 6)
				(gUser canControl: 0)
				(gUser canInput: 1)
				(gEgo loop: 0)
				(= local1 0)
				(= seconds 10)
			)
			(7
				(= global102 0)
				(HandsOff)
				(bat setCycle: 0)
				(spider setCycle: 0)
				(= local1 1)
				(gMessager say: 11 0 0 32 self) ; "Powers that rule Over regions soggy: Change this creature Back into a froggy!"
			)
			(8
				(gTheIconBar disable: 1 3 4 5 6)
				(if (IsFlag 325)
					(client setScript: endGame)
				else
					(= local1 0)
					(baba setCycle: End self)
				)
			)
			(9
				(gEgo view: 19 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(10
				(spider setCycle: 0)
				(baba
					setLoop: 8
					xStep: 2
					yStep: 5
					setCycle: Walk
					setMotion:
						PolyPath
						(+ (gEgo x:) 20)
						(- (gEgo y:) 5)
						self
				)
			)
			(11
				(= local1 1)
				(gMessager say: 11 0 0 33 self) ; "Ooooh... yummy! I'm glad you returned."
			)
			(12
				(baba setLoop: 6 setCycle: 0)
				(EgoDead 138 139) ; "Before you confront someone who is obviously more powerful than you are, give yourself a chance to reflect."
			)
		)
	)
)

(instance endGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global274 4)
				(baba view: 20 setLoop: 6 cycleSpeed: 18 setCycle: CT 3 1 self)
				(gEgo view: 122 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1)
			(2
				(baba setCycle: End)
				(reflection
					setLoop: 1
					cel: 0
					posn: 132 107
					setPri: (+ (gEgo priority:) 1)
					init:
					setCycle: End self
				)
			)
			(3
				(gEgo setCycle: Beg)
				(baba
					view: 19
					setLoop: 0
					posn: (baba x:) (+ (baba y:) 2)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(baba setLoop: 1 setCycle: Fwd)
				(SolvePuzzle 653 50)
				(= seconds 3)
			)
			(5
				(gMessager say: 11 0 10 0 self) ; "The witch is hopping mad."
			)
			(6
				(gMessager say: 11 0 0 34 self) ; "What have you DONE to me? How DARE you use my own spell against me? I'll, I'll... Oh, oh!"
			)
			(7
				(NormalEgo)
				(Face gEgo baba)
				(gMessager say: 11 0 0 35 self) ; "Hear me, O Elements of Air and Wind. Give me the power to save my own skin!"
			)
			(8
				(teleport play:)
				(TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					cel: 0
					init:
					setCycle: CT 6 1 self
				)
			)
			(9
				(gEgo dispose:)
				(TP setCycle: End self)
			)
			(10
				(TP dispose:)
				(SetFlag 287)
				(gCurRoom newRoom: 22)
			)
		)
	)
)

(instance nextWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 143 172 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(TP posn: 195 132 setPri: 15 init: setCycle: CT 4 1 self)
			)
			(3
				(teleport play:)
				(baba setLoop: 6 posn: 195 132 init:)
				(TP setCel: 4 setCycle: CT 9 1 self)
			)
			(4
				(TP setCel: 0 dispose:)
				(teleport play:)
				(bat setCycle: End self)
			)
			(5
				(gMessager say: 11 0 0 36 self) ; "Back so soon?"
				(spider startUpd:)
				(= local1 1)
			)
			(6
				(gEgo loop: 0)
				(= seconds 2)
			)
			(7
				(bat setCycle: 0)
				(spider setCycle: 0)
				(gMessager say: 11 0 5 1 self) ; "Spirits of Mist And Creatures of Bog: Transform my guest To the shape of a Frog."
			)
			(8
				(= local1 0)
				(baba setCycle: End)
				(= seconds 2)
			)
			(9
				(gEgo view: 19 loop: 2 cel: 0 setCycle: End self)
				(teleport play:)
			)
			(10
				(spider setCycle: 0)
				(baba
					setLoop: 8
					xStep: 2
					yStep: 5
					setCycle: Walk
					setMotion:
						PolyPath
						(+ (gEgo x:) 20)
						(- (gEgo y:) 5)
						self
				)
			)
			(11
				(= cycles 2)
			)
			(12
				(= local1 1)
				(gMessager say: 11 0 16 1 self) ; "This I vow: Stay there now!"
			)
			(13
				(= local1 0)
				(baba setLoop: 6 cel: 0 setCycle: End self)
			)
			(14
				(= local1 1)
				(gMessager say: 11 0 8 1 self) ; "Once again you're a frog, and once again you can't move. You find it very exasperating!"
			)
			(15
				(gMessager say: 11 0 5 2 self) ; "Yum, Yum. Froggie Frappe!"
			)
			(16
				(bat setLoop: 5 setCycle: Fwd)
				(spider setCycle: Fwd)
				(= seconds 2)
			)
			(17
				(= global274 3)
				(bat setCycle: 0)
				(spider setCycle: 0)
				(gMessager say: 11 0 5 3 self) ; "Did you bring me my mandrake like you promised?"
			)
			(18
				(= local1 0)
				(self cue:)
			)
			(19
				(= local1 1)
				(gMessager say: 11 0 6 2 self) ; "As you make a feeble croaking sound, you try to nod your head."
			)
			(20
				(gMessager say: 11 0 5 4 self) ; "Well? Where is it?"
			)
			(21
				(self cue:)
			)
			(22
				(gMessager say: 11 0 5 5 self) ; "What's the matter? Got a frog in your throat?"
			)
			(23
				(bat setCycle: Fwd)
				(spider setCycle: Fwd)
				(= seconds 3)
			)
			(24
				(bat setCycle: 0)
				(spider setCycle: 0)
				(gMessager say: 11 0 5 6 self) ; "I suppose I'll have to turn you back into whatever it is that you were. Pity! You're much more appetizing this way."
			)
			(25
				(self cue:)
			)
			(26
				(gMessager say: 11 0 5 7 self) ; "Creatures of Bog And Spirits of Fog: Return the true form To this rather dumb Frog."
			)
			(27
				(= local1 0)
				(baba setCycle: End self)
			)
			(28
				(teleport play:)
				(gEgo setCycle: Beg self)
			)
			(29
				(NormalEgo)
				(gEgo loop: 0)
				(= local1 1)
				(gMessager say: 11 0 5 8 self) ; "Now, did you put it in your backpack?"
			)
			(30
				(if (gEgo has: 21) ; mandrake
					(SolvePuzzle 654 3)
				)
				(= local1 0)
				(= cycles 5)
			)
			(31
				(if (gEgo has: 21) ; mandrake
					(baba setPri: 9)
					(= local1 1)
					(gMessager say: 11 0 4 1 self) ; "Ah! Here it is."
					(ClearFlag 326)
				else
					(rm21 setScript: noBringDeath)
				)
			)
			(32
				(bat setCycle: Fwd)
				(spider setCycle: Fwd)
				(gMessager say: 11 0 12 9 self) ; "Kids! We have it!"
			)
			(33
				(gEgo use: 21) ; mandrake
				(= local1 0)
				(= seconds 4)
			)
			(34
				(bat setCycle: 0)
				(spider setCycle: 0)
				(self cue:)
			)
			(35
				(= local1 1)
				(gMessager say: 11 0 12 10 self) ; "That's it! The final ingredient. Now we can make our greatest creation..."
			)
			(36
				(gMessager say: 11 0 12 11 self) ; "MANDRAKE MOUSSE!"
			)
			(37
				(bat setCycle: Fwd)
				(spider setCycle: Fwd)
				(= seconds 4)
			)
			(38
				(gMessager say: 11 0 12 12 self) ; "What's that, children? You think we should reward our lackey here?"
			)
			(39
				(gMessager say: 11 0 12 13 self) ; "Very well, ex-frog. I'll let you live this time. Next time, though, it's frog legs for sure!"
			)
			(40
				(self cue:)
			)
			(41
				(= local1 0)
				(baba setLoop: 6 cel: 0 setCycle: End self)
			)
			(42
				(gMessager say: 11 0 12 14 self) ; "So... Go!"
			)
			(43
				(TP
					posn: (gEgo x:) (gEgo y:)
					setPri: 15
					init:
					setCycle: CT 6 1 self
				)
				(teleport play:)
			)
			(44
				(gEgo hide:)
				(TP setCycle: End self)
			)
			(45
				(client setScript: 0)
				(gCurRoom newRoom: 22)
			)
		)
	)
)

(instance bubbleMusic of Sound
	(properties
		flags -1
		number 51
		priority 5
		loop -1
	)
)

(instance teleport of Sound
	(properties
		priority 15
	)
)

(instance babaTalker of Talker
	(properties
		x 10
		y 10
		view 1021
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2021)
		(PalVary pvCHANGE_TARGET 2021)
		(AssertPalette 1021)
		(= font gUserFont)
		(super init: babaTalkerBust babaTalkerMouth babaTalkerEyes &rest)
	)
)

(instance babaTalkerBust of Prop
	(properties
		view 1021
	)
)

(instance babaTalkerMouth of Prop
	(properties
		nsTop 48
		nsLeft 41
		view 1021
		loop 1
	)
)

(instance babaTalkerEyes of Prop
	(properties
		nsTop 29
		nsLeft 46
		view 1021
		loop 2
	)
)

