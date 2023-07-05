;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use eRS)
(use PAvoider)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm033 0
	Biker 1
	Willy_Wily 2
	Biker_Thug 3
)

(local
	local0
	local1
	local2 = 1
	local3
)

(instance rm033 of PQRoom
	(properties
		noun 1
		picture 33
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 47 159 0 188 0 0 319 0 319 189 106 189 256 83 250 82 243 87 205 78 216 72 173 63 162 68 132 63 47 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 59 129 67 125 67 115 83 115 134 86 201 101 122 149
					yourself:
				)
		)
		(super init:)
		(if (== global211 16)
			(HandsOff)
		)
		(gEgo init: actions: egoUseNightStick)
		(self setScript: walkIn1)
		(jukebox init:)
		(stools init:)
		(bartender init: view: 255)
		(chalkboard init:)
		(bench init:)
		(lamp init:)
		(pinball init:)
		(pooltable init:)
		(bar init:)
		(behindbar init:)
		(paper init:)
		(poolCues init:)
		(poster init:)
		(dartBoard init: approachVerbs: 4 1) ; Do, Look
		(beerAd init:)
		(if (!= gPrevRoomNum 32)
			(gLongSong number: 330 setLoop: -1 flags: -1 play:)
		else
			(gLongSong
				number: 330
				fade: 127 5 5 0
				setLoop: -1
				sec: 0
				priority: 0
				flags: -1
			)
		)
		(if (== global211 16)
			(dan init:)
			(poolPlayer init: stopUpd:)
			(rogerBiker init: stopUpd:)
			(bikerWoman init: stopUpd:)
			(mainBiker init:)
			((ScriptID 1272 0) view: 1272) ; marie
			(marie init: stopUpd: --UNKNOWN-PROPERTY-- marieMoves)
			(bartender stopUpd:)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(if (OneOf global211 16 17)
					(self setScript: bounceBack)
				else
					(self setScript: walkOut1 0 32)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(gCast eachElementDo: #setCycle 0)
		(LoadMany 0 939)
		(gLongSong fade: 60 15 20 0)
	)
)

(instance bounceBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch global211
					(16
						(gMessager say: 19 2 14 0 self) ; "Don't leave now. You have to deal with those bikers."
					)
					(17
						(gMessager say: 19 2 15 0 self) ; "Your good friend SweatCheeks Marie is standing by the jukebox. It might be a good idea to talk with her and see what she knows about the drug problem in town."
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 68 156 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useTheGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 21 9 9 0 self) ; "You pull your revolver and shoot the unarmed biker right between the eyes. (No, we're not going to reward your violence with animation of blood and brains hitting the back wall.)"
			)
			(1
				(EgoDead 12)
			)
		)
	)
)

(instance doSomeDrinking of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (!= state 10))
			(HandsOff)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 17)
				(dan setLoop: 2 setCycle: End self)
				(mainBiker
					posn: 238 130
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1)
			(2
				(bikerWoman setLoop: 0 setCycle: CT 4 1)
				(rogerBiker ignoreActors: 1 setCycle: CT 4 1)
				(mainBiker setLoop: 1 setCycle: End self)
				(dan setLoop: 3 setCycle: End self)
			)
			(3)
			(4
				(rogerBiker stopUpd:)
				(bikerWoman setLoop: 4 setCycle: Osc)
				(mainBiker setLoop: 2 setCycle: End self)
			)
			(5
				(bikerWoman setLoop: 4 setCycle: CT 10 1)
				(mainBiker
					view: 1101
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 228 120 self
				)
				(dan setLoop: 3 cycleSpeed: 7 setCycle: End)
			)
			(6
				(dan stopUpd:)
				(mainBiker
					view: 1101
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 195 122 self
				)
			)
			(7
				(poolPlayer
					setLoop: 2
					setCycle: Walk
					setMotion: PolyPath 210 92
				)
				(mainBiker
					view: 1101
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 99 147 self
				)
			)
			(8
				(mainBiker setLoop: 2 setCel: 1)
				(poolPlayer
					setLoop: 3
					setCycle: Walk
					setMotion:
						PolyPath
						(+ (gEgo x:) 60)
						(- (gEgo y:) 15)
						self
				)
			)
			(9
				(HandsOn)
				(bikerWoman setLoop: 0 setCycle: Beg)
				(gEgo setScript: willyMakeIt)
				(gMessager say: 21 2 12) ; "Please move your motorcycles. You're interfering with the business next door."
				(= local1 1)
				(bartender setScript: bartenderThings)
				(marie approachVerbs: 0)
				(self dispose:)
			)
		)
	)
)

(instance willyMakeIt of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gLongSong prevSignal:) -1)
			(gLongSong prevSignal: 0 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bikerWoman stopUpd:)
				(dan stopUpd:)
				(gTheIconBar disable: 0)
				(= seconds 10)
			)
			(1
				(if (and local1 local3)
					(gMessager say: 21 2 10 0 self) ; "Look, let's not get nasty here. All I need you to do is--"
				else
					(self cue:)
				)
			)
			(2
				(HandsOff)
				(gMessager say: 19 31 13) ; "Yaaaaahoo! It's bar-be-que time!"
				(mainBiker dispose:)
				(gEgo view: 259 x: 96 y: 157 setLoop: 0 setCycle: End self)
			)
			(3
				(sfx number: 586 loop: 1 play:)
				(gEgo view: 259 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(sfx number: 586 loop: 1 play:)
				(gEgo view: 259 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(sfx number: 586 loop: 1 play:)
				(gEgo view: 259 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(sfx number: 586 loop: 1 play:)
				(gEgo view: 259 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(sfx number: 586 loop: 1 play:)
				(gEgo view: 259 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(8
				(if (not (gEgo has: 6)) ; Night_Stick
					(gMessager say: 19 31 8 0 self) ; "I'm gonna turn you into pork chops, boy!"
				else
					(= cycles 1)
				)
			)
			(9
				(if (not (gEgo has: 6)) ; Night_Stick
					(EgoDead 10)
				else
					(gMessager say: 19 31 7 1 self) ; "Here's a little tip; standing in the middle of an explosive situation like a cabbage is not a good idea. You're now just another stain on the floor of Wino Willy's."
				)
			)
			(10
				(gMessager say: 19 31 5 1 self) ; "This isn't a nature walk, Bonds. That biker meant business. This is going to have to be a closed-casket funeral..."
			)
			(11
				(EgoDead 9)
			)
		)
	)
)

(instance bartenderThings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender setLoop: 0 cycleSpeed: 8 setCycle: Osc 3 self)
			)
			(1
				(bartender stopUpd:)
				(= seconds 5)
			)
			(2
				(dan setLoop: 3 setCycle: Osc 1 self)
			)
			(3
				(dan stopUpd:)
				(= seconds 5)
			)
			(4
				(bikerWoman setLoop: 3 setCycle: Osc 1 self)
			)
			(5
				(bikerWoman stopUpd:)
				(= seconds 5)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance marieMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(marie ignoreActors: 1 illegalBits: 0 stopUpd:)
				(= seconds 20)
			)
			(1
				(marie setLoop: 3 cycleSpeed: 9 setCel: 0 setCycle: End self)
			)
			(2
				(= ticks 30)
			)
			(3
				(marie setCycle: Beg self)
			)
			(4
				(marie stopUpd:)
				(= seconds (Random 5 10))
			)
			(5
				(marie setLoop: 7 cycleSpeed: 9 setCel: 0 setCycle: End self)
			)
			(6
				(= ticks 30)
			)
			(7
				(marie setCycle: Beg self)
			)
			(8
				(marie stopUpd:)
				(= seconds (Random 5 10))
			)
			(9
				(self changeState: 1)
			)
		)
	)
)

(instance Willy_Wily of Narrator
	(properties
		name {Willy Wily}
		x 200
		y 40
		talkWidth 180
		initialized 1
		showTitle 1
	)
)

(instance Biker_Thug of Narrator
	(properties
		name {Biker Thug}
		x 120
		y 50
		talkWidth 150
		initialized 1
		showTitle 1
	)
)

(instance Biker of Talker
	(properties
		x 2
		y 2
		view 1273
		priority 15
		signal 16400
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 bikerTMouth &rest)
	)
)

(instance bikerTMouth of Prop
	(properties
		nsTop 36
		nsLeft 37
		view 1273
		loop 1
		priority 15
		signal 16400
	)
)

(instance poolPlayer of Actor
	(properties
		x 174
		y 92
		noun 25
		view 1006
		loop 2
		signal 1
	)
)

(instance mainBiker of Actor
	(properties
		view 276
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(if local1
					(= local3 1)
					(willyMakeIt changeState: 1)
				)
			)
			(9 ; Service_Revolver
				(gEgo setScript: 0)
				(gCurRoom setScript: useTheGun)
			)
			(16 ; Night_Stick
				(gEgo setScript: 0)
				(self setScript: egoGetsBad)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bikerWoman of Prop
	(properties
		x 206
		y 152
		noun 25
		view 1011
		signal 1
	)
)

(instance rogerBiker of Prop
	(properties
		x 75
		y 123
		noun 25
		view 1012
		loop 1
	)
)

(instance dan of Prop
	(properties
		x 178
		y 168
		noun 25
		view 1010
		loop 2
		cel 9
	)

	(method (init)
		(super init: &rest)
		(self setScript: doSomeDrinking)
	)
)

(instance bartender of Prop
	(properties
		x 249
		y 163
		noun 24
		view 255
		priority 13
		signal 17
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 34)
					(Willy_Wily init:)
					(Biker_Thug init:)
					(gMessager say: 24 2 10) ; "I don't know nothin' about nothin'."
				else
					(gMessager say: 24 2 12) ; "Good afternoon, Mr. Wily."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance jukebox of Feature
	(properties
		x 221
		y 33
		noun 16
		nsTop 33
		nsLeft 221
		nsBottom 80
		nsRight 255
		sightAngle 40
		approachX 213
		approachY 89
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance stools of Feature
	(properties
		x 221
		y 85
		noun 4
		sightAngle 40
		onMeCheck 4
	)
)

(instance chalkboard of Feature
	(properties
		x 80
		y 35
		noun 8
		nsTop 29
		nsLeft 76
		nsBottom 52
		nsRight 97
		sightAngle 40
		approachX 92
		approachY 84
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance bench of Feature
	(properties
		x 80
		y 65
		noun 9
		sightAngle 40
		onMeCheck 8
	)
)

(instance lamp of Feature
	(properties
		x 100
		y 60
		noun 10
		sightAngle 40
		onMeCheck 16
	)
)

(instance pinball of Feature
	(properties
		x 100
		y 55
		noun 11
		sightAngle 40
		onMeCheck 32
		approachX 136
		approachY 72
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance pooltable of Feature
	(properties
		x 125
		y 75
		noun 5
		sightAngle 40
		onMeCheck 64
	)
)

(instance bar of Feature
	(properties
		x 300
		y 1
		noun 2
		sightAngle 40
		onMeCheck 128
	)
)

(instance behindbar of Feature
	(properties
		x 300
		y 1
		noun 3
		sightAngle 40
		onMeCheck 256
	)
)

(instance beerAd of Feature
	(properties
		noun 12
		nsTop 24
		nsLeft 166
		nsBottom 31
		nsRight 181
		sightAngle 40
		approachX 182
		approachY 73
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance dartBoard of Feature
	(properties
		x 208
		y 30
		noun 15
		nsTop 22
		nsLeft 200
		nsBottom 39
		nsRight 217
		approachX 182
		approachY 73
		approachDist 10
	)
)

(instance poster of Feature
	(properties
		noun 13
		nsTop 25
		nsLeft 145
		nsBottom 31
		nsRight 161
		sightAngle 40
		approachX 136
		approachY 72
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance poolCues of Feature
	(properties
		noun 7
		nsTop 25
		nsLeft 49
		nsBottom 71
		nsRight 64
		sightAngle 40
		approachX 60
		approachY 101
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance paper of Feature
	(properties
		noun 14
		nsTop 25
		nsLeft 186
		nsBottom 35
		nsRight 193
		sightAngle 40
		approachX 182
		approachY 73
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance sfx of Sound
	(properties)
)

(instance walkOut1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 5 setCycle: Fwd setMotion: MoveTo 10 200 self)
			)
			(1
				(gCurRoom newRoom: 32)
			)
		)
	)
)

(instance walkIn1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 35 190
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 86 152 self
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance egoUseNightStick of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; Night_Stick
				(if local2
					(if (not local0)
						(gMessager say: 22 32 4) ; "I'll make you eat that, pig."
						(gEgo
							view: 261
							ignoreActors: 1
							setLoop: 0
							setCycle: 0
							setCel: 0
							posn: 97 154
							setCycle: End
						)
						(= local0 1)
						(return 1)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(9 ; Service_Revolver
				(gCurRoom setScript: useTheGun)
			)
		)
		(return 0)
	)
)

(instance egoGetsBad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= (gEgo view:) 261)
					(gEgo
						view: 261
						ignoreActors: 1
						setLoop: 0
						setCel: 0
						setCycle: 0
						posn: 97 154
						setCycle: End self
					)
				else
					(= ticks 30)
				)
			)
			(1
				(if local0
					(= cycles 2)
				else
					(gMessager say: 22 32 4 0 self) ; "I'll make you eat that, pig."
				)
			)
			(2
				(gEgo view: 261 setLoop: 1 setCel: 0 posn: 83 150)
				(= ticks 10)
			)
			(3
				(gEgo setCycle: CT 6 1 self)
			)
			(4
				(sfx number: 586 loop: 1 play:)
				(mainBiker view: 264 setLoop: 0 posn: 99 155 setCycle: End self)
			)
			(5
				(sfx number: 586 loop: 1 play:)
				(gEgo view: 261 setLoop: 1 cel: 6 setCycle: End self)
			)
			(6
				(gMessager say: 21 32 6) ; "Ooooh, man, ooooh, man, owwww..."
				(= cycles 30)
			)
			(7
				(gMessager say: 23 31 6 4) ; "Nice job, Officer. You defused a potentially dangerous situation, using a minimum of force."
				(= cycles 30)
			)
			(8
				(mainBiker
					view: 264
					setLoop: 0
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(9
				(poolPlayer
					setLoop: 3
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 99 205
				)
				(mainBiker
					view: 1101
					posn: 105 143
					setLoop: 1
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 99 205 self
				)
			)
			(10
				(sfx number: 942 priority: 15 loop: 1 play:)
				(SetScore 164 5)
				(NormalEgo)
				(Face gEgo marie)
				(gEgo setAvoider: PAvoider)
				(mainBiker dispose:)
				(poolPlayer dispose:)
				(= local2 0)
				(= global211 17)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance marie of Actor
	(properties
		x 239
		y 86
		view 1100
		loop 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if local2
					(gMessager say: 20 1 2) ; "This local "Working Girl" looks somehow familiar..."
				else
					(gMessager say: 20 1 1) ; ""Sweet Cheeks" Marie Wilkans. Despite the pounds of makeup and cheap costume jewelry, Marie's smile is so warm you feel yourself starting to squirm. You always had a crush on her in high school..."
				)
			)
			(4 ; Do
				(if local2
					(gMessager say: 20 4 2) ; "Don't touch that girl, you don't know where she's been!"
				else
					(gMessager say: 20 4 1) ; "Good cops don't, Bonds. At least not while on duty."
				)
			)
			(2 ; Talk
				(if local2
					(gMessager say: 20 2 2) ; "The bar is too noisy for the young lady to hear you. There are more pressing issues at hand."
				else
					(gCurRoom setScript: sTalkToMarie)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sTalkToMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerBiker stopUpd:)
				(gLongSong fade: 1 10 10 0)
				(gLongSong2 number: 331 play: 1 loop: -1 flags: -1)
				(gEgo setMotion: PolyPath 210 95 self)
			)
			(1
				(gEgo setLoop: 8 setCel: 6)
				(gLongSong2 fade: 127 10 10 0)
				(marie view: 268 setLoop: 8 setCel: 5 setCycle: 0 setScript: 0)
				(= seconds 2)
			)
			(2
				(gMessager say: 20 2 1 0 self) ; "Well, Marie, what's new on the street?"
			)
			(3
				(marie
					view: 268
					setLoop: 5
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					cycleSpeed: 6
					setMotion: PolyPath 99 199 self
				)
				(gLongSong2 fade: 0 10 10)
				(= ticks 30)
			)
			(4
				(gLongSong fade: 127 10 10 0)
			)
			(5
				(marie dispose:)
				(= global211 18)
				(SetScore 165 3)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

