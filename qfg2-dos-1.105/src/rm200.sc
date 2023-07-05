;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Stage)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	[knobX 3] = [157 212 248]
	[knobY 3] = [40 32 38]
	[footX 4] = [248 212 157 186]
	[footY 4] = [142 154 139 131]
	localTime
	toldFortune
	waitForName
	dontScriptBody
	[tmpName 30]
	[speechStr 120]
	[astroGenList 38] = [1 2 3 4 5 6 7 8 9 0 10 11 12 0 13 14 0 0 15 0 0 0 16 0 17 0 18 0 0 0 19 0 20 0 0 0 0 0]
	[astroSpecList 52] = [21 '//pawn,destruction,danger,grave,temptation,despair,desolation' 22 '//hero' 23 '//blackness' 24 '//sign' 25 '//amal,salim' 26 '//dragon' 27 '//scorpion' 28 '//service,job' 29 '//portent,omen' 30 '//star' 31 '//astrology' 32 '//planet' 33 '//hand' 34 '//shadow,eye' 35 '//constellation' 36 '//ali,boy' 37 '//zodiac' 38 '//poison' 39 '//map,chart' 40 '//chart,rebus' 41 '//bed' 42 '//model,orrery,(system<planetary)' 43 '//dartboard,dart,(board<dart)' 15 '//cost,due,rate' -1 '//fortune,fortune,horoscope,reading' 0 0]
	[handMotions 45] = [0 21 23 17 9 5 5 13 17 9 17 7 2 5 17 25 5 23 7 17 7 0 2 9 13 17 17 17 23 5 5 17 13 21 9 13 2 21 9 13 13 21 2 13 23]
)

(procedure (AddFeet &tmp I guy)
	(for ((= I 0)) (< I 4) ((++ I))
		((= guy (aFoot new:)) x: [footX I] y: [footY I])
		(InitAddToPics guy)
	)
)

(procedure (AddKnobs &tmp I guy)
	(for ((= I 0)) (< I 3) ((++ I))
		((= guy (bedKnob new:)) x: [knobX I] y: [knobY I])
		(InitAddToPics guy)
	)
)

(instance rm200 of Stage
	(properties
		picture 200
		style 9
		west 704
		topExit 0
		bottomExit 0
		rightExit 0
		leftFromX -12
		leftFromY 180
		leftExit 2
		leftToX 92
		leftToY 154
	)

	(method (init)
		(LoadMany rsVIEW 200 205)
		(LoadMany rsTEXT 205)
		(Load rsSOUND 200)
		(= localTime gTimeODay)
		(SolvePuzzle 616 5)
		(astro setPri: 11 init:)
		(body init:)
		(dart init: hide:)
		(gEgo init:)
		(NormalEgo)
		(model init: setCycle: Fwd)
		(= entranceScript welcome)
		(super init:)
		(AddFeet)
		(AddKnobs)
		(InitAddToPics dartBoard chart bedRuffle canopy rug)
		(InitFeatures roofHole ladder map symbol bed)
		(gCSound number: 200 loop: -1 priority: 0 playBed:)
	)

	(method (doit)
		(if (and (& (gEgo onControl: 1) $0002) (!= inOut 1))
			(if (not (IsFlag 131))
				(SetFlag 131)
				(self setScript: firstTimeOut)
			else
				(= edgeHit 4)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gCSound loop: 0 fade:)
		(= gRoomExitDir 1)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 200 0) ; "As you gaze about the home of the Astrologer, you are reminded of a small boy's playroom, bunk bed, toys, and all."
			)
			(
				(Said
					'tell//self,past,life,accomplishment,experience,adventure,spielburg'
				)
				(if (== gFortuneDay -1)
					(if (TrySkill 13 50) ; communication
						(SetFlag 18)
						(SkillUsed 4 100) ; luck
					else
						(SetFlag 19)
						(SkillUsed 4 -100) ; luck
					)
					(Say astro 200 1 200 2 200 3) ; "You have lived a most interesting life."
					(= gFortuneDay gDay)
				else
					(Say astro 200 4) ; "As I have said - you have lived a most interesting life."
				)
			)
			(
				(or
					(Said 'give/alm,dinar,cent')
					(Said 'give[/man,abu,astrologer]/alm,dinar,cent')
					(Said 'pay')
				)
				(if (== (CheckFunds 100) 2)
					(GiveMoney 100)
					(SkillUsed 14 25) ; honor
					(Say astro 200 5) ; "Thank you, a thousand thank-yous. It is with your support that I may continue my vital work"
					(handMotionS start: 25)
					(body setScript: handMotionS)
				else
					(HighPrint 200 6) ; "You realize you don't have even a full Dinar to give."
				)
			)
			((Said 'thank')
				(SayThanks astro 200 7)
			)
		)
	)
)

(instance welcome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo astro)
				(astro tLoop: 5)
				(switch (++ gAstroVisits)
					(1
						(Say astro self 200 8 200 9 200 10 200 11) ; "Come in, come in, Hasan, come in."
						(= tmpName 0)
						(= waitForName 120)
					)
					(2
						(if
							(and
								(or (IsFlag 19) (IsFlag 18))
								(!= gFortuneDay gDay)
							)
							(Say astro self 200 12 200 13) ; "It is good that you returned; there is much I need to tell you."
						else
							(Say astro self 200 14) ; "Welcome. May the stars smile upon you."
						)
					)
					(3
						(HandsOn)
						(gCurRoom setScript: readBook)
					)
					(else
						(cond
							((<= 3 gDay 6)
								(Say astro self 200 15) ; "There are omens of fire throughout the sky, and many portents of destruction. Now, what is it that you wish to know this bright day?"
							)
							((<= 8 gDay 10)
								(Say astro self 200 16) ; "A sign of wind rises in the east and the city is like a leaf before it. How is it that I may help you?"
							)
							((<= 12 gDay 13)
								(Say astro self 200 17) ; "I have seen signs of heavy, impending doom. Now how else can I make your day?"
							)
							((<= 14 gDay 15)
								(Say astro self 200 18) ; "Water rules this day, both lack of it, and the surfeit of it. You should either invest heavily in wine or waterwings."
							)
							(else
								(Say astro self 200 19) ; "There will be a great rise in celebrations today, followed by a rapid decline tomorrow. What else can I do for you?"
							)
						)
					)
				)
			)
			(1
				(if (not waitForName)
					(self changeState: 4)
				else
					(Print ; "What might I call you?"
						200
						20
						#title
						{Abu al-Njun:}
						#window
						TopWindow
						#edit
						@tmpName
						41
					)
					(if (StrLen @tmpName)
						(SkillUsed 13 20) ; communication
						(self changeState: 3)
					else
						(SkillUsed 13 -10) ; communication
						(Say astro self 200 21) ; "I must know who you are before I can be of service to you. What is your name that I might call you?"
					)
				)
			)
			(2
				(self changeState: 1)
			)
			(3
				(if (not (StrFind @tmpName @gUserName))
					(SkillUsed 14 -20) ; honor
					(Format @speechStr 200 22 @tmpName) ; "What an interesting name, %s. It certainly isn't one I would have expected you to bear."
				else
					(SkillUsed 14 30) ; honor
					(StrCpy @tmpName @gUserName)
					(Format @speechStr 200 23 @tmpName) ; "Ah, %s. It is indeed a name for heroes."
				)
				(Say astro self @speechStr 200 24)
			)
			(4
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance readBook of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(astro tLoop: 5)
				(Say astro self 200 25) ; "Just a moment. I'm doing a very important derivation right now."
			)
			(1
				(= cycles 4)
			)
			(2
				(= dontScriptBody 1)
				(astro hide:)
				(body loop: 4 cel: 6 cycleSpeed: 2 setCycle: Beg self startUpd:)
			)
			(3
				(= seconds 3)
			)
			(4
				(body setCycle: End self)
			)
			(5
				(body cycleSpeed: 3 loop: 2 cel: 1 setCycle: Beg self)
			)
			(6
				(Say astro self 200 26) ; "Let's see now, if the moon is in the seventh house (mumble, mumble)..."
			)
			(7
				(= seconds 2)
			)
			(8
				(body setCycle: End self)
			)
			(9
				(body setCycle: CT 1 -1 self)
			)
			(10
				(body stopUpd:)
				(astro loop: 5 cel: 0 tLoop: 5 show: talkSpeed: 1)
				(Say astro self 200 27) ; "... hmm... and Jupiter aligns with Mars (mumble, mumble)..."
			)
			(11
				(= cycles 6)
			)
			(12
				(astro hide:)
				(body loop: 3 setCycle: End self)
			)
			(13
				(dart
					show:
					illegalBits: 0
					setPri: 10
					setMotion: MoveTo 40 112 self
				)
			)
			(14
				(dart stopUpd:)
				(body loop: 1 cycleSpeed: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(15
				(body setCycle: 0 loop: 0 cel: 5)
				(astro show: loop: 5 cel: 0)
				(Say astro self 200 28) ; "... then peace shall guide our planet and love ...?!"
			)
			(16
				(body setCycle: Beg)
				(Say astro self 200 29) ; "Naw, it'll never happen."
			)
			(17
				(Say astro self 200 30) ; "Now what was it you needed to know?"
			)
			(18
				(self dispose:)
			)
		)
	)
)

(instance firstTimeOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say astro self 200 31) ; "If you need to know more about the future, visit me again when it arrives."
			)
			(1
				(gCurRoom edgeHit: 4)
				(self dispose:)
			)
		)
	)
)

(instance handMotionS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body setCycle: CT 2 1 self)
			)
			(1
				(body stopUpd:)
			)
			(2
				(body setCycle: End self)
			)
			(3
				(body cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(body stopUpd:)
			)
			(5
				(body cel: 0 setCycle: CT 7 1 self)
			)
			(6
				(body stopUpd:)
			)
			(7
				(body cel: 1)
				(= cycles 2)
			)
			(8
				(body cel: 8 stopUpd:)
			)
			(9
				(body setCycle: CT (Random 6 8) 1 self)
			)
			(10
				(= cycles 5)
			)
			(11
				(body setCycle: Beg self)
			)
			(12
				(self changeState: 9)
			)
			(13
				(body cel: 4 setCycle: CT 5 1 self)
			)
			(14
				(body setCycle: CT 1 -1 self)
			)
			(15
				(= cycles (Random 1 8))
			)
			(16
				(self changeState: 13)
			)
			(17
				(body setCycle: CT 7 1 self)
			)
			(18
				(= cycles 6)
			)
			(19
				(body setCycle: Beg self)
			)
			(20
				(body stopUpd:)
			)
			(21
				(body setCycle: CT 7 1 self)
			)
			(22
				(body stopUpd:)
			)
			(23
				(body setCycle: End self)
			)
			(24
				(body stopUpd:)
			)
			(25
				(body cycleSpeed: 1 setCycle: End self)
			)
			(26
				(body setCycle: CT 8 1 self)
			)
			(27
				(body stopUpd:)
			)
		)
	)
)

(instance body of Prop
	(properties
		x 176
		y 147
		noun '/abu,man,astrologer'
		description {Abu Al-njun, the astrologer}
		lookStr {Every day the Astrologer thanks his lucky stars that he has lucky stars.}
		view 205
		cycleSpeed 2
	)
)

(instance astro of Talker
	(properties
		x 192
		y 126
		description {Abu Al-njun, the astrologer}
		lookStr {Every day the Astrologer thanks his lucky stars that he has lucky stars.}
		view 205
		loop 5
		signal 16384
		illegalBits 0
		tLoop 5
		talkSpeed 1
		myName '//astrologer,abu,abu,man'
		title {Abu al-Njun:}
		color 13
		back 1
		msgFile 205
	)

	(method (showText what)
		(if (== what -1)
			(if toldFortune
				(Say astro 200 32) ; "I have told you all I presently know of your future. However, I predict that I will know far more in the future."
			else
				(= toldFortune 1)
				(cond
					((not (or (IsFlag 18) (IsFlag 19)))
						(Say astro 200 33 200 34) ; "If you wish to know your fortune, I will need to know your guiding signs."
					)
					((== gFortuneDay gDay)
						(Say astro 200 35 200 36) ; "I have not yet had time to find your answers."
					)
					((IsFlag 19)
						(SolvePuzzle 615 5)
						(Say astro 200 37 200 38) ; "The portents foretell you will be deceived by darkness and become its pawn in the destruction of all this world."
					)
					((IsFlag 18)
						(SolvePuzzle 615 5)
						(Say astro 200 39 200 40 200 41) ; "Darkness will lead you into a tomb. You will walk in fire, earth, water, and air, through temptation, and at last into despair and desolation."
					)
				)
			)
		else
			(super showText: what &rest)
		)
	)

	(method (atSpec which)
		(return [astroSpecList which])
	)

	(method (atGen which)
		(return [astroGenList which])
	)

	(method (messages args)
		(if (not dontScriptBody)
			(handMotionS start: [handMotions [args 1]])
			(body cel: 0 cycleSpeed: 1 startUpd: setScript: handMotionS)
		)
		(super messages: args &rest)
	)

	(method (endTalk)
		(super endTalk:)
		(if (body script:)
			((body script:) dispose:)
			(body setCycle: 0 cel: 0 stopUpd: forceUpd:)
		)
	)
)

(instance dart of Actor
	(properties
		x 174
		y 144
		z 12
		shiftClick 0
		yStep 4
		view 200
		loop 2
		signal 6144
		xStep 12
	)
)

(instance model of Prop
	(properties
		x 259
		y 150
		noun '/model,orrery,(system<planetary)'
		description {a model of an unknown planetary system}
		lookStr {It's only a model of a planetary system.  It isn't the real thing.}
		view 200
		loop 3
		cycleSpeed 1
	)
)

(instance dartBoard of PicView
	(properties
		x 33
		y 132
		noun '/dartboard,(board[<dart])'
		description {a Psychic Dartboard}
		lookStr {You used to have a "Magic 8-Ball" that performed much the same function as this dartboard.}
		view 200
	)
)

(instance bedRuffle of PicView
	(properties
		x 203
		y 104
		shiftClick 0
		view 200
		loop 5
		priority 15
		signal 16
	)
)

(instance chart of PicView
	(properties
		x 277
		y 128
		noun '/rebus,chart'
		description {a Cryptic Chart of Mystical Origins}
		lookStr {Let's see....\n"P" plus "explosion"....\nno wait...............\nplus "Ka-Boom!"....\nOh heck, you never were any good at these things anyway.}
		view 200
		loop 1
	)
)

(instance canopy of PicView
	(properties
		x 203
		y 51
		noun '/awning'
		description {the bed's canopy}
		lookStr {Helps to keep the stardust off of the sleeping Astrologer.}
		view 200
		loop 4
		priority 15
		signal 16
	)
)

(instance ladder of Feature
	(properties
		x 147
		y 77
		noun '/ladder'
		nsTop 17
		nsLeft 137
		nsBottom 138
		nsRight 158
		description {the ladder to the roof}
		lookStr {The ladder must lead to the roof, where the star gazing is better.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 8)
			(Say astro 200 42) ; "Please, I would prefer if you do not go up there. That leads to my observatory on the roof where I keep very delicate instruments."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance map of Feature
	(properties
		x 90
		y 88
		noun '/chart,map'
		nsTop 55
		nsLeft 57
		nsBottom 122
		nsRight 124
		description {a Map of the Heavens}
		lookStr {The stars are all out of place compared to Spielburg.  Where the heck IS this place?}
	)
)

(instance rug of PicView
	(properties
		x 193
		y 151
		noun '/carpet,carpet'
		description {the Astrologer's rug}
		lookStr {Skillful weaving by willful weavers.}
		view 200
		loop 8
		priority 2
		signal 16
	)
)

(instance bed of Feature
	(properties
		x 202
		y 89
		noun '/bed'
		nsTop 75
		nsLeft 154
		nsBottom 104
		nsRight 251
		description {the Astrologer's bed}
		lookStr {You've heard of four-poster beds, but this is ridiculous.}
	)
)

(instance symbol of Feature
	(properties
		x 152
		y 19
		noun '/rune,star,pattern,ceiling'
		nsTop 5
		nsLeft 102
		nsBottom 33
		nsRight 202
		description {the star symbol on the ceiling}
		lookStr {A star with a hole like a doughnut.  How interesting.}
	)
)

(instance roofHole of Feature
	(properties
		x 153
		y 20
		noun '/chasm,open,open'
		nsTop 16
		nsLeft 137
		nsBottom 25
		nsRight 169
		description {the hole in the roof}
		lookStr {Lookit the hole in the ceiling!\nGee!  What happens if it rains?}
	)
)

(instance aFoot of PicView
	(properties
		shiftClick 0
		view 200
		loop 6
	)
)

(instance bedKnob of PicView
	(properties
		shiftClick 0
		view 200
		loop 7
		priority 11
		signal 16
	)
)

