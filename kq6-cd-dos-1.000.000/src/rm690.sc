;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use rgDead)
(use KQ6Print)
(use KQ6Room)
(use Conversation)
(use MCyc)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm690 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 81] = [2 0 8 55 2 1 17 58 2 2 21 59 2 3 32 58 2 4 43 53 2 5 53 50 2 6 59 51 2 7 65 52 2 8 73 53 2 9 85 56 2 10 87 61 2 11 89 72 3 0 282 55 3 1 291 56 3 1 291 56 3 1 291 56 3 2 302 57 3 3 313 57 3 4 318 57 3 5 318 59 -32768]
	[local86 57] = [4 0 311 105 4 1 302 107 4 2 293 111 4 3 278 112 4 4 269 123 5 0 83 108 5 1 75 111 5 2 66 113 5 3 54 113 5 4 44 118 5 5 33 117 5 6 22 118 5 7 10 119 5 8 3 115 -32768]
)

(instance rm690 of KQ6Room
	(properties
		noun 3
		picture 690
		south 680
	)

	(method (init)
		(Load rsVIEW 691)
		(flame init: setCycle: Fwd)
		(alex init:)
		(lord init:)
		(leftarm init:)
		(rightarm init:)
		(deadHand init:)
		(deadFist init:)
		(deadEyes init: setScript: eyeScript)
		(gGame handsOff:)
		(gTheIconBar disable: 0)
		(self setScript: introScript)
		(super init: &rest)
	)

	(method (newRoom)
		(introGhost setCycle: 0)
		(LoadMany 0 942)
		(super newRoom: &rest)
	)
)

(instance sfx of Sound
	(properties)
)

(instance alex of Actor
	(properties
		x 127
		y 144
		noun 2
		view 691
		priority 2
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; flute
				(gMessager say: noun theVerb 0) ; "Alexander isn't bad on the flute, but he's hardly Orpheus! Death is unlikely to be amused at his amateurish playing!"
			)
			(1 ; Look
				(gMessager say: noun theVerb 0) ; "The young prince trembles with dread as he stands before the Lord of the Dead. Despite his fear, he remains determined in his cause and unwavering in his stance."
			)
			(5 ; Do
				(gMessager say: noun theVerb 0) ; "Alexander touches himself to make sure he's still in one piece!"
			)
			(else
				(gMessager say: noun 0 0) ; "There's no time for that now! That won't help Alexander convince Death of anything."
			)
		)
	)
)

(instance flame of Actor
	(properties
		x 22
		y 84
		view 690
		loop 1
		cycleSpeed 10
	)
)

(instance lord of Feature
	(properties
		noun 4
		onMeCheck 6
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 28 8 14 30 31 47 50 1 32 65 68 33 70 16 37) ; spellBook, dagger, potion, feather, flute, flower, handkerchief, Look, poem, note, rabbitFoot, ribbon, royalRing, scythe, nightingale
			(gMessager say: noun theVerb)
		else
			(switch theVerb
				(5 ; Do
					(gGame handsOff:)
					(gCurRoom setScript: alexHand)
				)
				(48 ; gauntlet
					(gGame handsOff:)
					(gGame givePoints: 2)
					(gCurRoom setScript: issueChallenge)
				)
				(13 ; mirror
					(if local0
						(gMessager say: noun theVerb 5) ; "Perhaps Alexander should first state his purpose before he tries something like that!"
					else
						(gGame handsOff:)
						(gGame givePoints: 4)
						(gCurRoom setScript: holdUpMirror)
					)
				)
				(42 ; boringBook
					(if local0
						(gMessager say: noun theVerb 5) ; "The Lord of the Dead would probably not be interested in a bedtime story."
					else
						(gMessager say: noun theVerb 6) ; "Alexander's heard the expression "bored to tears," but somehow, he doesn't think it would work in Death's case!"
					)
				)
				(2 ; Talk
					(if local0
						(gMessager say: noun theVerb 5) ; "I seek a boon, my lord."
					else
						(gMessager say: noun theVerb 6) ; "Perhaps a tale of my love?"
					)
				)
				(else
					(if local0
						(gMessager say: noun 0 5) ; "I brought this, my lord."
					else
						(gMessager say: noun 0 6) ; "I have this, my lord."
					)
				)
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gMessager say: 1 0 1 0 self) ; "Why have you entered my domain still wearing your flesh?"
			)
			(2
				(= local0 1)
				(introGhost init: setCycle: MCyc @local5 introGhost)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= seconds 15)
			)
			(3
				(gGame handsOff:)
				(= local0 0)
				(gMessager say: 1 0 2 0 self) ; "The will to live is strong, is it not? Never mind. I will reach out to YOU."
			)
			(4
				(= cycles 1)
			)
			(5
				(rgDead stateOf690: 1)
				(client setScript: deadTouch 0 1)
			)
		)
	)
)

(instance rightarm of Actor
	(properties
		x 145
		y 144
		view 691
		loop 1
		priority 2
		signal 16400
		cycleSpeed 1
	)
)

(instance leftarm of Actor
	(properties
		x 110
		y 147
		view 691
		loop 2
		priority 2
		signal 16400
	)
)

(instance deadTouch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 682 loop: 1 play:)
				(deadHand setCycle: End self)
			)
			(1
				(= seconds 1)
			)
			(2
				(if register
					(gMessager say: 1 0 4 0 self) ; "The Lord of the Dead's touch fills Alexander instantly with a numbing cold and blackness."
				else
					(gMessager say: 4 5 0 0 self) ; "As though sensing Alexander's desire to touch him, the Lord of the Dead reaches out his hand."
				)
			)
			(3
				(deadHand setCycle: Beg self)
			)
			(4
				(leftarm hide:)
				(rightarm hide:)
				(alex
					view: 691
					setLoop: 7
					cel: 0
					posn: 120 139
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(alex hide:)
			)
			(6
				(gTheIconBar disable:)
				(switch (rgDead stateOf690:)
					(1
						(gCurRoom setScript: deadInHereScript 0 24)
					)
					(else
						(gCurRoom setScript: deadInHereScript 0 23)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 5) (== (gGlobalSound prevSignal:) -1))
			(self cue:)
		)
	)
)

(instance deadInHereScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 200])
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGlobalSound number: 970 loop: 1 play:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 98 10)
				(Message msgGET 916 0 0 register 1 @temp1)
				(Display @temp1 dsCOORD 29 40 dsWIDTH 260 dsCOLOR 47 dsFONT gUserFont dsALIGN alCENTER)
				(gEgo
					init:
					view: 8902
					loop: 0
					cel: 0
					normal: 0
					setScale: 0
					cycleSpeed: 25
					scaleX: 128
					scaleY: 128
					posn: 159 125
					setCycle: End self
				)
			)
			(2
				(gGame setCursor: gNormalCursor)
				(repeat
					(switch
						(= temp0
							(KQ6Print
								window: DeathWindow
								addText: {Please select:} 62 0
								posn: 63 130
								addButton: 1 {Restore} 0 15
								addButton: 2 {Restart} 70 15
								addButton: 3 {Quit} 140 15
								init:
							)
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart: 1)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance DeathWindow of SysWindow
	(properties)

	(method (open)
		(= color 47)
		(= back 0)
		(super open: &rest)
	)
)

(instance issueChallenge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(rightarm view: 691 setLoop: 3 setCycle: End self)
			)
			(1
				(gMessager say: 4 48 0 1 self) ; "I did not come here to die, but to demand my right of challenge! I respectfully challenge thee, Death, by throwing down this gauntlet!"
			)
			(2
				(rightarm setLoop: 4 setCycle: End self)
				(gEgo put: 15 690) ; gauntlet
			)
			(3
				(sfx number: 683 loop: 1 play:)
				(rightarm setLoop: 1)
				(= cycles 2)
			)
			(4
				(theConv
					add: -1 4 48 0 2 ; "Man may pass the portal, and seeks its master Death. Man may pass where Death has trod, and challenge, like Scheherazade, He who reigns beneath the sod, to spare a mortal's breath."
					add: -1 4 48 0 3 ; "He has the gauntlet!"
					add: -1 4 48 0 4 ; "Impossible!"
					add: -1 4 48 0 5 ; "He challenges Death!"
					init: self
				)
			)
			(5
				(deadFist setCycle: CT 5 1 self)
			)
			(6
				(sfx number: 681 loop: 1 play:)
				(deadFist cel: 6)
				(= cycles 2)
			)
			(7
				(theConv
					add: -1 4 48 0 6 ; "(CONTEMPTUOUS, ANGRY) Who are you to challenge Death?"
					add: -1 4 48 0 7 ; "(FRIGHTENED BUT BEING BRAVE) A man of flesh is all I need to be, my lord."
					add: -1 4 48 0 8 ; "(DISDAINFUL) And what is it that you seek with this challenge? The soul of some dead maiden?"
					add: -1 4 48 0 9 ; "I seek the souls of King Caliphim and Queen Allaria of the Land of the Green Isles."
					add: -1 4 48 0 10 ; "You would save two human souls AND emerge alive from this realm yourself? That shall be a difficult challenge indeed. The tomb does not open its doors lightly."
					init: self
				)
			)
			(8
				(theConv
					add: -1 4 48 0 11 ; "(TRYING TO BE BRAVE) Either all three of us leave, or none go."
					add: -1 4 48 0 12 ; "Very well. Then let me think of an appropriate task."
					add: -1 4 48 0 13 ; "Ahhh. Yes. I have it now. Your challenge is this:"
					add: -1 4 48 0 14 ; "For thousands of years I have sat upon this throne. I have heard every sad tale that can be told by human lips."
					add: -1 4 48 0 15 ; "I have seen tragedies that ended empires, injustices that defy reason, love that would light the very stars turn cold and hard. I have seen torments that cannot possibly be borne and yet must be--for centuries."
					add: -1 4 48 0 16 ; "This thing I have never done; I have never shed a tear. Make me cry, thou 'man of flesh.' THAT is my challenge."
					add: -1 4 48 0 17 ; "Make DEATH cry?"
					add: -1 4 48 0 18 ; "Sooner could he turn sea to stone!"
					add: -1 4 48 0 19 ; "Or fire to ice!"
					init: self
				)
			)
			(9
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= local1 1)
				(introGhost init: setCycle: MCyc @local86 introGhost)
				(= seconds 20)
			)
			(10
				(gGame handsOff:)
				(= local1 0)
				(gMessager say: 1 0 3 0 self) ; "Your time, like your life, has just run out, 'Man of Flesh.' You have failed the challenge, and now you must pay the price of your arrogance."
			)
			(11
				(= cycles 1)
			)
			(12
				(rgDead stateOf690: 2)
				(client setScript: deadTouch 0 1)
			)
		)
	)
)

(instance holdUpMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= local2 (gNarrator x:))
				(= local3 (gNarrator y:))
				(= local4 (gNarrator talkWidth:))
				(gNarrator x: 10 y: 10 talkWidth: 100)
				(theConv add: -1 4 13 6 1 init: self) ; "If your existence has been all that you say it has, then truth alone shall be my sword."
			)
			(2
				(gGlobalSound fade:)
				(= local1 0)
				(leftarm hide:)
				(rightarm
					setLoop: 5
					cycleSpeed: 7
					posn: 149 148
					setCycle: End self
				)
			)
			(3
				(sfx number: 684 loop: -1 play:)
				(lookMirror init:)
				(= seconds 2)
			)
			(4
				(theConv
					add: -1 4 13 6 2 ; "The mirror's surface swirls with darkness for a moment, then fills with images even blacker."
					add: -1 4 13 6 3 ; "Reflections of despair, of wailing souls, of shackles colder and more immutable than any forged by man, of a world of thirsts that can never be quenched."
					add: -1 4 13 6 4 ; "Alexander feels the mirror tremble in his grasp and is glad that he cannot see its face, but the Lord of the Dead is transfixed to the mirror, to the screening of his life."
					add: -1 4 13 6 5 ; "Things long forgotten are once more uncovered: his enslavement to this throne while still a man; the years of watching misery and horror and growing ever more numb to it; the seep of his own humanity; the slow growth of a new thing altogether which became that which he is now."
					add: -1 4 13 6 6 ; "His is an existence that has no possibility of redemption, no end."
					add: -1 4 13 6 7 ; "The surrounding spirits draw away in pain. The truth is so sharp, it stabs; so intense, it sears."
					add: -1 4 13 6 8 ; "AEIIII!"
					add: -1 4 13 6 9 ; "Take it away!"
					add: -1 4 13 6 10 ; "Make it stop!"
					init: self
				)
			)
			(5
				(sfx number: 685 loop: 1 play: self)
			)
			(6
				(sfx number: 741 loop: 1 play: self)
			)
			(7
				(lookMirror dispose:)
				(sfx number: 686 loop: 1 play:)
				(tear init: setCycle: End self)
			)
			(8
				(= cycles 30)
			)
			(9
				(theConv add: -1 4 13 6 11 init: self) ; "The mirror of truth cracks from the strain.... And Death sheds a single, gray tear."
			)
			(10
				(rightarm setCycle: Beg self)
			)
			(11
				(theConv
					add: -1 4 13 6 12 ; "Truth is, indeed, a terrible thing."
					add: -1 4 13 6 13 ; "I have worn this mantle for so long, I had forgotten its dreadful weight. You shall take the souls and leave, as I agreed. You have been granted a stay from this inevitable reality. I almost...envy you."
					add: -1 4 13 6 14 ; "(TO OFFSCREEN SERVANTS) Find the souls he has claimed and bring them to me."
					init: self
				)
			)
			(12
				(gGlobalSound number: 688 loop: -1 play:)
				(leftarm show:)
				(rightarm setLoop: 1 posn: 145 144)
				(= seconds 2)
				(gNarrator x: local2 y: local3 talkWidth: local4)
			)
			(13
				(gEgo put: 24 690) ; mirror
				(rgDead stateOf690: 0)
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance alexHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(rgDead stateOf690: 1)
				(client setScript: deadTouch 0 0)
			)
		)
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(client cel: 2)
				(= cycles 2)
			)
			(2
				(client cel: 0)
				(self init:)
			)
		)
	)
)

(instance deadHand of Actor
	(properties
		x 110
		y 121
		view 691
		loop 6
		priority 12
		signal 16
	)
)

(instance deadFist of Actor
	(properties
		x 224
		y 107
		view 692
		cycleSpeed 1
	)
)

(instance theConv of Conversation
	(properties)
)

(instance tear of Actor
	(properties
		x 187
		y 44
		view 692
		loop 1
		cycleSpeed 10
	)
)

(instance lookMirror of Actor
	(properties
		x 177
		y 44
		view 692
		loop 3
	)
)

(instance introGhost of Actor
	(properties
		view 690
	)

	(method (init)
		(self ignoreActors: 1 ignoreHorizon: 1 illegalBits: 0)
		(super init: &rest)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance deadEyes of Prop
	(properties
		x 179
		y 43
		noun 4
		view 692
		loop 4
		signal 24576
	)

	(method (doVerb theVerb)
		(lord doVerb: theVerb &rest)
	)
)

