;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use n074)
(use n079)
(use LarryRoom)
(use Print)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	[local0 2]
)

(instance rm720 of LarryRoom
	(properties
		noun 1
		picture 720
		autoLoad 0
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(ClearFlag 100)
		(gNarrator x: 10 y: 80 talkWidth: 295)
		((ScriptID 0 11) init: 710) ; iconExit
		(hair setCycle: Fwd init: cycleSpeed: 12 setScript: varySpeed)
		(face init:)
		(arms init:)
		(pants init:)
		(breasts init:)
		(hair init:)
		(body init:)
		(windSFX play:)
		(if global175
			(for ((= temp0 1)) (<= temp0 global175) ((++ temp0))
				(proc74_0 temp0)
			)
		)
		(if (and (== gPrevRoomNum 730) global173)
			(self setScript: itemOnShamScr)
		else
			(gGame handsOn:)
		)
		(if (== global100 720)
			(= gScore 980)
			((ScriptID 88 0) update:) ; PointGauge
			(self setScript: giveChampagneScr)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (!= global175 0)
					(== global179 0)
					(= global179 1)
				)
				(gGame changeScore: 4 256)
				(gMessager
					say:
						noun
						theVerb
						(switch global179
							(0 2)
							(1 3)
							(2 4)
							(3 5)
							(4 6)
						)
				)
				(if (< global179 4)
					(++ global179)
				)
			)
			(13 ; orchid
				(self setScript: giveOrchidScr)
			)
			(16 ; bracelet
				(self setScript: giveBraceletScr)
			)
			(29 ; pearl
				(self setScript: givePearlScr)
			)
			(23 ; diamond
				(self setScript: giveDiamondScr)
			)
			(28 ; sculpture
				(self setScript: giveSculptureScr)
			)
			(53 ; wordsOWisdom
				(self setScript: giveWordsScr)
			)
			(41 ; lamp [ lit ]
				(self setScript: giveLampScr)
			)
			(20 ; champagne [ chilled ]
				(if
					(and
						(IsFlag 258)
						(IsFlag 257)
						(IsFlag 259)
						(IsFlag 260)
						(IsFlag 261)
						(IsFlag 262)
						(IsFlag 263)
					)
					(self setScript: giveChampagneScr)
				else
					(gMessager say: noun theVerb) ; "Would you like to join me in a sparkling glass of ice-cold champagne?"
				)
			)
			(19 ; champagne
				(if
					(and
						(IsFlag 258)
						(IsFlag 257)
						(IsFlag 259)
						(IsFlag 260)
						(IsFlag 261)
						(IsFlag 262)
						(IsFlag 263)
					)
					(gMessager say: noun theVerb 1) ; "Would you like to join me in a glass of lukewarm champagne?"
				else
					(gMessager say: noun theVerb) ; "Would you like to join me in a glass of lukewarm champagne?"
				)
			)
			(else
				(return (super doVerb: theVerb))
			)
		)
		(return 1)
	)

	(method (dispose)
		(gNarrator x: -1 y: -1 talkWidth: 0)
		(gTheIconBar delete: (ScriptID 0 11) addToFront: (ScriptID 0 3)) ; iconExit, icon0
		(super dispose: &rest)
	)
)

(instance varySpeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 50 180))
			)
			(1
				(client cycleSpeed: (Random 8 15))
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance hair of Prop
	(properties
		x 155
		y 3
		noun 4
		view 720
		loop 3
		signal 4096
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
			(rm720 doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance body of View
	(properties
		x 155
		y 3
		view 720
		loop 5
	)

	(method (onMe)
		(return 0)
	)
)

(instance endOfGameScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 7) ; champagne
			)
			(1
				(Prints {Start end of game cartoon})
				(= cycles 2)
			)
			(2
				(gGame restart:)
			)
		)
	)
)

(instance itemOnShamScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom doVerb: global173)
				(= global173 0)
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance face of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 179 11 190 24 185 34 177 38 170 37 166 24 168 13
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
			(gCurRoom newRoom: 730)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance arms of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 164 68 163 71 168 74 171 67 181 60 187 60 189 50 198 44 203 47 201 58 191 79 181 91 176 89 169 84 160 90 156 86 157 67 162 62 163 50
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
			(rm720 doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pants of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 171 95 177 100 186 98 193 90 205 88 206 117 199 124 179 133 168 139 144 133 144 126 136 132 119 126 108 85 117 76 163 95
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
			(rm720 doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance breasts of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 181 61 172 65 169 74 163 71 165 63 169 54
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
			(rm720 doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance giveBraceletScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 5) ; bracelet
				(gMessager say: 1 16 0 1 11 self) ; "Shamara, I brought you this sterling silver bracelet. I hope you like it."
			)
			(1
				(gGame changeScore: 20 257)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 16 0 12 self oneOnly: 0) ; "Your gift symbolizes the spirit of life itself! A ring with no beginning, no end. A solid circle chasing itself round and round a vast emptiness."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveOrchidScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 28) ; orchid
				(gMessager say: 1 13 0 1 5 self) ; "I want you to have this flower."
			)
			(1
				(gGame changeScore: 20 258)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 13 0 6 self oneOnly: 0) ; "...you're using this orchid to symbolize the perfection and purity of Nature, how natural things are best, how the world can create millions of these flowers, no two alike, just like human beings."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance givePearlScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 29) ; pearl
				(gMessager say: 1 29 0 1 14 self) ; "Shamara, I think you should have this pearl."
			)
			(1
				(gGame changeScore: 20 259)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 29 0 15 self oneOnly: 0) ; "(ELATED) I've got it! The iridescent shimmer of a simple sphere, created naturally by one of Earth's simplest creatures from the irritation of a single grain of sand, layered with bodily secretions over a lifetime, creating an object of classic beauty."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveDiamondScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 10) ; diamond
				(gMessager say: 1 23 0 1 5 self) ; "Shamara, I hope you like this diamond. It was a "gift" from a "friend" of mine."
			)
			(1
				(gGame changeScore: 20 260)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 23 0 6 self oneOnly: 0) ; "I've got it! You're trying to tell me that even someone like me, who has been under great pressure for so many years, can use that pressure to transform myself from a dark mental lump of coal into a transcendant human of crystalline purity and beauty."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveSculptureScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 33) ; sculpture
				(gMessager say: 1 28 0 1 6 self) ; "I have this, uh, object..."
			)
			(1
				(gGame changeScore: 20 261)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 28 0 7 self oneOnly: 0) ; "Ah ha! Of course! To me it symbolizes the important role that Art plays in all our lives."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveWordsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 40) ; wordsOWisdom
				(gMessager say: 1 53 0 1 4 self) ; "Shamara, there's something I simply must tell you. May I whisper in your ear?"
			)
			(1
				(gGame changeScore: 20 262)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 53 0 5 self oneOnly: 0) ; "Oooh! My God! But, of course! Why didn't I ever realize that before!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveLampScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 23) ; lamp
				(gMessager say: 1 41 0 1 3 self) ; "For you, Shamara!"
			)
			(1
				(gGame changeScore: 20 263)
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 41 0 4 self oneOnly: 0) ; "Unless... unless... unless that old lamp is a symbol, a representation, of... of... of the lamp of knowledge!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance modifyPaletteScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
				(= register 100)
			)
			(1
				(if (> register 0)
					(-- register)
					(-- state)
				)
				(Palette palSET_INTENSITY 80 254 register)
				(= ticks 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance giveChampagneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 20 1 1 self) ; "Shamara, I've given you all my, ahem, hard-earned "knowledge." NOW will you share this champagne with me?"
			)
			(1
				(gGame changeScore: 20 264)
				(if (>= gScore 1000)
					(= gScore 999)
					(= register 1)
				)
				(gEgo put: 7) ; champagne
				(proc74_0 (++ global175))
				(= cycles 2)
			)
			(2
				(gMessager say: 1 20 1 2 15 self) ; "Oh yes, Larry, I would love to. I just hope that I can somehow find a way to express my appreciation for all you've done for me."
			)
			(3
				((ScriptID 1800 1) font: gBigFont) ; You
				(gMessager say: 1 20 1 16 self) ; "You're a virgin!!"
			)
			(4
				((ScriptID 1800 1) font: 0) ; You
				(gMessager say: 1 20 1 17 24 self) ; "(DOES TAKE TO CAMERA) (Heh, heh, heh.)"
			)
			(5
				(if
					(or
						((ScriptID 88 0) running:) ; PointGauge
						(!= ((ScriptID 88 0) currentValue:) gScore) ; PointGauge
					)
					(-- state)
				)
				(= ticks 20)
			)
			(6
				(if register
					(Load rsVIEW 956)
					(Load rsSOUND 4)
					(gMenuBar hide:)
					(SetPort 0)
					(SetPort 0 0 190 320 10 0)
					(gGlobalSound2 number: 4 loop: 1 play:)
					(pGuage init: setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(7
				(gMessager say: 1 20 1 25 self) ; "Let's go inside, sit by the fire, and begin by drinking a little of this champagne."
			)
			(8
				(= ticks 90)
			)
			(9
				(gGlobalSound1 fade:)
				(gGame hideControls:)
				(gCast eachElementDo: #dispose)
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(DrawPic 98 9)
				(= cycles 2)
			)
			(10
				(= ticks 90)
			)
			(11
				(gGlobalSound2 number: 710 loop: 1 play: self)
			)
			(12
				(= ticks 60)
			)
			(13
				(gGlobalSound2 number: 720 loop: 1 play: self)
				(SetFlag 100)
				((ScriptID 1816 14) bust: 0 eyes: 0 mouth: 0) ; Shamara
				(gMessager say: 1 20 1 26 self) ; "Oh, thank you, Larry! I promise to give it my all."
			)
			(14 0)
			(15
				(gGlobalSound2 number: 720 loop: 1 play: self)
				(gMessager say: 1 20 1 27 self oneOnly: 0) ; "Here's to you, Larry Laffer!"
			)
			(16
				(gGlobalSound1 fade:)
				(= ticks 300)
			)
			(17
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance pGuage of Prop
	(properties
		x 247
		y 144
		view 956
	)
)

(instance windSFX of Sound
	(properties
		flags 1
		number 270
		loop -1
	)
)

