;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 461)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	blackWidowInset 0
)

(local
	local0
	local1
	local2
)

(instance myConv of Conversation
	(properties)
)

(instance blackWidowInset of KQ6Room
	(properties
		modNum 460
		picture 465
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar disable: 6)
		(gGlobalSound fade: 0 10 10)
		(gGlobalSound2 number: 465 setLoop: -1 setVol: 0 play: fade: 127 10 10)
		(gFeatures add: roomAtLarge web eachElementDo: #init)
		(if (not (IsFlag 160))
			(looseThread init:)
		)
		(if (not (IsFlag 136))
			(parchment init:)
		)
		(spider init:)
		(self setScript: helloScript)
	)

	(method (newRoom)
		(gTheIconBar enable: 6)
		(super newRoom: &rest)
	)

	(method (dispose)
		(ClearFlag 59)
		(super dispose:)
	)
)

(instance looseThread of Prop
	(properties
		x 190
		y 169
		noun 13
		modNum 460
		sightAngle 180
		view 465
		loop 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 160))
					(gGame handsOff:)
					(gCurRoom setScript: unravelWeb)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance parchment of Prop
	(properties
		x 104
		y 93
		noun 12
		modNum 460
		sightAngle 180
		view 465
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if local0
					(gGame handsOff:)
					((ScriptID 40 0) gotParchment: 1) ; rWonder
					(gCurRoom newRoom: 460)
				else
					(gCurRoom setScript: bitParchment)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance love of Actor ; UNUSED
	(properties
		x 146
		y 97
		noun 12
		modNum 460
		yStep 15
		view 465
		loop 4
		priority 15
		signal 18448
		xStep 20
	)
)

(instance spider of Actor
	(properties
		x 196
		y 137
		noun 11
		modNum 460
		sightAngle 180
		yStep 10
		view 466
		loop 1
		illegalBits 0
		xStep 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: touchSpider)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self sightAngle: 180 setCycle: Fwd)
		(super init: &rest)
	)
)

(instance roomAtLarge of Feature
	(properties
		modNum 460
		onMeCheck 32
	)

	(method (doVerb)
		(gGame handsOn:)
		(gCurRoom newRoom: 460)
	)
)

(instance web of Feature
	(properties
		noun 9
		modNum 460
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1 0 1 0 460) ; "An intricately detailed spider's web has been spun between a pile of books and a small tree."
			)
			(5 ; Do
				(= local1 gMouseX)
				(if (> (= local2 gMouseY) 150)
					(= local2 150)
				)
				(gCurRoom setScript: spiderRush)
			)
			(2 ; Talk
				(gMessager say: 9 2 0 1 0 460) ; "The web is as silent as silk."
			)
			(else
				(gMessager say: 9 0 0 1 0 460) ; "Alexander wouldn't want that to get caught in the spider web."
			)
		)
	)
)

(instance spiderRush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 9 5 0 1 self 460) ; "Alexander reaches out to touch the silky web."
			)
			(1
				((ScriptID 40 0) spiderBit: 1) ; rWonder
				(gGame handsOn:)
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance bitParchment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 12 5 11 1 self 460) ; "Alexander reaches out to grab the scrap of parchment."
			)
			(1
				((ScriptID 40 0) parchmentBit: 1) ; rWonder
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance touchSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 11 5 0 1 self 460) ; "Alexander reaches out to touch the black widow."
			)
			(1
				((ScriptID 40 0) spiderBit: 1) ; rWonder
				(gGame handsOn:)
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance unravelWeb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame givePoints: 1)
				(SetFlag 160)
				(= local0 1)
				(gMessager say: 13 5 0 1 self 460) ; "(FURIOUS) HEY! Don't touch that thread!"
			)
			(1
				(gGlobalSound4 number: 467 setLoop: 1 play:)
				(looseThread setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(spider setLoop: 2 setMotion: MoveTo 196 137 self)
				(= seconds 2)
			)
			(3
				(looseThread dispose:)
			)
			(4
				(spider setCycle: 0)
				(gTheIconBar disable: 0)
				(= seconds 5)
			)
			(5
				(spider setCycle: Walk setLoop: 1 setMotion: MoveTo 167 76 self)
			)
			(6
				(gMessager say: 13 5 0 3 self 460) ; "SOME people like to ask for TROUBLE!"
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance helloScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spider
					setCycle: Walk
					setLoop: 1
					ignoreActors:
					ignoreHorizon:
					setMotion: MoveTo 167 76 self
				)
			)
			(1
				(if (IsFlag 56)
					(gMessager say: 8 1 10 1 self 460) ; "So THERE you are, handsome! What can I do for you now?"
				else
					(myConv
						add: 460 8 1 9 1 ; "Wow! Hiya, Gorgeous. What a luscious-looking hunk of flesh you are!"
						add: 460 8 1 9 2 ; "Uh...thank you. I guess. Who are you?"
						add: 460 8 1 9 3 ; "How charming of you to pretend not to know! I'm Black Widow, of course, the femme fatale of all femme fatales. Know what I mean <wink wink>?"
						add: 460 8 1 9 4 ; "You know, I was just thinking it was time I found my fiftieth...er...another husband. It would be quite a horror...I mean an honor to have me as a bride."
						init: self
					)
				)
			)
			(2
				(if (IsFlag 56)
					(self cue:)
				else
					(myConv
						add: 460 8 1 9 5 ; "Just look at my beautiful weaving! It's so light, so delicate, you'll never want to leave my little nest."
						add: 460 8 1 9 6 ; "Hmm. It is a lovely web, but my heart is elsewhere, I'm afraid."
						add: 460 8 1 9 7 ; "DRAT! <ahem> I mean, the loss is yours. I'm sure you'll change your mind once you consider the advantages."
						init: self
					)
				)
			)
			(3
				(SetFlag 56)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

