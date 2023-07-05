;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2455)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm2455 0
	toadTalker 1
)

(local
	local0 = 3000
)

(instance rm2455 of KQRoom
	(properties
		picture 2455
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(gEgo setScale: 0)
		((ScriptID 7001 2) client: mat hide_mouth: 0 clientCel: -2) ; mathildeTalker
		((ScriptID 13 0) clientCel: -2 hide_mouth: 0) ; aEgoTalker
		(toadTalker client: mat)
		(Load rsSOUND 2461)
		(gKqMusic1 number: 2461 setLoop: -1 play:)
		(proc11_6 2450)
		(proc11_7 exitCode)
		(if (and (IsFlag 57) (not (IsFlag 55)))
			(bowl init:)
		)
		(self
			setScript:
				(if (== global318 39)
					(Load rsVIEW 24557)
					(Load rsVIEW 24558)
					giveToad
				else
					(Load rsVIEW 2456)
					jumpDown
				)
		)
	)

	(method (doit)
		(if local0
			(if (not script)
				(-- local0)
			)
		else
			(gCurRoom setScript: backToHall)
		)
		(super doit: &rest)
	)

	(method (setScript)
		(= local0 3000)
		(super setScript: &rest)
	)
)

(instance jumpDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 2494)
				(Load rsSOUND 2495)
				(gEgo
					view: 2456
					setLoop: 3
					cel: 0
					posn: 149 119
					init:
					setPri: 140
					setCycle: CT 8 1 self
				)
				(mat init: posn: 200 89 setPri: 99 setCycle: Fwd)
				(gKqSound1 number: 2494 setLoop: -1 play:)
			)
			(1
				(gKqSound1 stop:)
				(gKqSound1 number: 2495 setLoop: 1 play:)
				(mat
					view: 2456
					setLoop: 1
					cel: 0
					posn: 175 119
					setPri: 108
					setCycle: End self
				)
				((ScriptID 7001 2) clientCel: -2) ; mathildeTalker
			)
			(2
				(mat doVerb: global318)
			)
		)
	)
)

(instance backToHall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mat
					view: 2456
					setLoop: 1
					cel: 8
					posn: 175 119
					setCycle: Beg self
				)
			)
			(1
				(mat
					view: 2456
					setLoop: 0
					cel: 0
					setPri: 99
					posn: 200 89
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 2450)
			)
		)
	)
)

(instance waveAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2456 setLoop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(mat
					view: 2456
					setLoop: 5
					cel: 0
					posn: 176 116
					setCycle: End self
				)
			)
			(2
				((ScriptID 7001 2) clientCel: -2) ; mathildeTalker
				(gMessager say: 1 0 9 0 self 2450) ; "(IMPATIENTLY)You're wasting my time, little girl!"
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance giveIngredient of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 24551)
				(Load rsVIEW 2456)
				(Load rsSOUND 2465)
				(gEgo
					view: 2456
					setLoop: 4
					cel: 0
					posn: 148 116
					setCycle: CT 3 1 self
				)
			)
			(1
				(gMessager say: 1 global318 10 0 self 2450)
			)
			(2
				(mat
					view: 2459
					setLoop: 3
					cel: 0
					posn: 186 118
					setCycle: End self
				)
			)
			(3
				(mat
					view: 24551
					setLoop: 1
					cel: 0
					posn: 166 150
					setCycle: End self
				)
				(gEgo setCycle: End)
			)
			(4
				(mat
					view: 2456
					setLoop: 6
					setCel: 0
					posn: 189 117
					setCycle: End self
				)
				(sfx
					setLoop: 5
					posn: (- (bowl x:) 15) (- (bowl y:) 17)
					cel: 0
					init:
					setCycle: End self
				)
				(gKqSound1
					number: (if (ingredientCode doit:) 2466 else 2465)
					setLoop: 1
					play:
				)
			)
			(5 0)
			(6
				(sfx dispose:)
				(mat setLoop: 1 cel: 8)
				(if (ingredientCode doit:)
					(gCurRoom setScript: transform)
				else
					(gGame handsOn:)
					(User canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance giveSpoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 24551)
				(gEgo
					view: 2459
					setLoop: 2
					cel: 0
					posn: 131 128
					setCycle: CT 9 1 self
				)
			)
			(1
				(SetFlag 51)
				(gEgo put: 25) ; Silver_Spoon
				(mat
					view: 2459
					setLoop: 3
					cel: 0
					posn: 186 118
					setCycle: CT 5 1 self
				)
			)
			(2
				(mat setCycle: End self)
				(gEgo cel: 10)
			)
			(3
				(= ticks 15)
			)
			(4
				(gEgo setCycle: End)
				((ScriptID 7001 2) clientCel: -2) ; mathildeTalker
				(gMessager say: 1 34 10 0 self 2450) ; "Excellent!"
			)
			(5
				(if (ingredientCode doit:)
					(gCurRoom setScript: transform)
				else
					(gGame handsOn:)
					(User canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance giveBrassBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 68))
					(client setScript: giveGoldBowl)
				else
					(= cycles 1)
				)
			)
			(1
				(Load rsVIEW 2456)
				(Load rsVIEW 2458)
				(Load 140 2463) ; WAVE
				(Load 140 2464) ; WAVE
				(gEgo
					view: 2457
					setLoop: 0
					cel: 0
					posn: 129 127
					setCycle: End self
				)
			)
			(2
				(mat
					view: 2457
					setLoop: 1
					cel: 0
					posn: 176 115
					setCycle: CT 6 1 self
				)
			)
			(3
				(gEgo put: 33) ; Bowl_b
				(SetFlag 350)
				(mat setCycle: End self)
				(gEgo
					view: 2456
					setLoop: 4
					cel: 8
					posn: 148 116
					setCycle: End self
				)
			)
			(4 0)
			(5
				(mat
					view: 2458
					setLoop: 0
					cel: 0
					posn: 188 118
					setCycle: End self
				)
			)
			(6
				(mat view: 2458 setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(gKqSound1 number: 2463 setLoop: 1 play:)
				(mat view: 2458 setLoop: 2 cel: 0 setCycle: CT 11 1 self)
				(ClearFlag 68)
				(SetFlag 382)
			)
			(8
				(gKqSound1 number: 2464 setLoop: 1 play:)
				(mat setCycle: End self)
			)
			(9
				(mat view: 2456 setLoop: 1 cel: 8)
				(gMessager say: 1 95 4 0 self 2450) ; "That was no gold bowl, missy, that was brass. The spell won't work unless the bowl is gold!"
			)
			(10
				(gCurRoom setScript: backToHall)
			)
		)
	)
)

(instance giveGoldBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2458)
				(Load rsVIEW 2456)
				(gEgo
					view: (if (IsFlag 68) 2457 else 24570)
					setLoop: 0
					cel: 0
					posn: 129 127
					setCycle: End self
				)
			)
			(1
				(cond
					((IsFlag 68)
						(SetFlag 57)
						(= register 1)
						(self cue:)
					)
					((IsFlag 351)
						(gMessager say: 1 33 8 0 self 2450) ; "(IMPATIENTLY)Don't waste my time, girl!"
						(+= state 3)
						(= register 0)
					)
					(else
						(SetFlag 351)
						(gMessager say: 1 33 7 0 self 2450) ; "I see you found the bowl, Rosella, but where's the water of emerald?"
						(+= state 3)
						(= register 0)
					)
				)
			)
			(2
				(mat
					view: 2457
					setLoop: 1
					cel: 0
					posn: 176 115
					setCycle: CT 6 1 self
				)
			)
			(3
				(mat setCycle: End self)
				(gEgo
					view: 2456
					setLoop: 4
					cel: 8
					posn: 148 116
					setCycle: End self
				)
			)
			(4 0)
			(5
				(if register
					(mat
						view: 2458
						setLoop: 0
						cel: 0
						posn: 188 118
						setCycle: End self
					)
					(gEgo put: 24) ; Bowl_a
				else
					(gEgo setLoop: 0 posn: 129 127 setCycle: Beg self)
				)
			)
			(6
				(if register
					(mat
						view: 2459
						setLoop: 0
						setCel: 0
						posn: 183 118
						setCycle: End self
					)
				else
					(gCurRoom setScript: backToHall)
				)
			)
			(7
				(bowl init:)
				(mat view: 2456 setLoop: 6 setCel: 0 setCycle: End self)
			)
			(8
				(mat setLoop: 1 cel: 8)
				(gMessager say: 1 33 28 1 self 2450) ; "Mm-hm! Good! Now give me the rest of the ingredients!"
			)
			(9
				(gGame handsOn:)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance giveToad of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsSOUND 2466)
					(Load rsVIEW 24560)
					(mat
						view: 24557
						setLoop: 0
						cel: 0
						posn: 174 110
						setPri: 98
						init:
						cycleSpeed: 11
						setCycle: CT 8 1 self
					)
					(gEgo
						view: 24557
						setLoop: 1
						cel: 0
						posn: 171 113
						setPri: 111
						cycleSpeed: 12
						init:
					)
					((ScriptID 7001 2) mouth_y: 0) ; mathildeTalker
				)
				(1
					(gMessager say: 1 39 12 1 self 2450) ; "(SWEETLY, TRYING TO CHEER HER UP)Mathilde, what is this funny little thing?"
					(gEgo setCycle: CT 3 1 self)
				)
				(2 0)
				(3
					(mat setCycle: CT 11 1 self)
				)
				(4
					(mat setCycle: End self)
					(gEgo setCycle: End self)
				)
				(5 0)
				(6
					(gMessager sayRange: 1 39 12 2 4 self 2450) ; "(EXCITED, THRILLED)Otar's dragon toad! This was King Otar's when he was just a wee lad! It's a magical guardian. When little Otar would take it with him to play, it would watch over him, and get him out of trouble. If he really got into a scrape, it would run home, and tell me where he was!"
				)
				(7
					(gEgo put: 31) ; Dragon_Toad
					(SetFlag 56)
					(mat setLoop: 2 cel: 0 posn: 173 110 setCycle: End self)
				)
				(8
					(mat setLoop: 3 cel: 0 setCycle: End self)
				)
				(9
					(mat setLoop: 4 cel: 0 setCycle: End self)
					(gKqSound1 number: 2466 setLoop: 1 play:)
				)
				(10
					(mat view: 24558 setLoop: 5 cel: 0 setCycle: End self)
				)
				(11
					(gMessager sayRange: 1 39 12 5 9 self 2450) ; "(EXCITED)It's working! Dragon toad, tell me now! Where is King Otar, and what is he doing?"
				)
				(12
					(mat setLoop: 6 cel: 0 posn: 162 150 setCycle: End self)
				)
				(13
					(mat setLoop: 7 cel: 0 posn: 173 112 setCycle: CT 5 1 self)
				)
				(14
					((ScriptID 7001 2) hide_mouth: 1) ; mathildeTalker
					(gMessager say: 1 39 12 10 self 2450) ; "(INTENSELY)Use this rope with the elevator to Ooga Booga. Find the real King of the Trolls. Go now! It may already be too late!"
				)
				(15
					((ScriptID 7001 2) hide_mouth: 0) ; mathildeTalker
					(gEgo
						view: 24558
						posn: 163 152
						setLoop: 8
						cel: 0
						setCycle: CT 4 1 self
					)
				)
				(16
					(gEgo get: 32 setCycle: End self) ; Enchanted_Rope
					(mat setCycle: End self)
				)
				(17 0)
				(18
					(toad init: setCycle: End self)
				)
				(19
					(gEgo get: 31) ; Dragon_Toad
					(= cycles 2)
				)
				(20
					(gGame handsOn:)
					(gCurRoom newRoom: 2450)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(SetFlag 56)
					((ScriptID 7001 2) hide_mouth: 0) ; mathildeTalker
					(gEgo get: 32 get: 31) ; Enchanted_Rope, Dragon_Toad
					(gGame handsOn:)
					(gCurRoom newRoom: 2450)
				)
			)
		)
	)
)

(instance transform of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gKqMusic1 setVol: 63)
					(gGame handsOff: 1)
					(Load rsVIEW 24551)
					(Load rsVIEW 24552)
					(Load rsVIEW 24553)
					(Load rsVIEW 24554)
					(Load rsVIEW 24555)
					(Load 140 2468) ; WAVE
					(Load rsSOUND 2467)
					(Load 140 892) ; WAVE
					(mat
						view: 24551
						setLoop: 3
						cel: 0
						posn: 163 147
						setCycle: End self
					)
				)
				(1
					(mat
						view: 24551
						setLoop: 4
						cel: 0
						posn: 166 150
						setCycle: End self
					)
					(bowl dispose:)
					(gKqSound1 stop:)
					(gKqSound1 number: 2467 setLoop: 1 play:)
				)
				(2
					(bowl init: posn: 170 119)
					(mat
						view: 24554
						setLoop: 0
						cel: 0
						posn: 183 117
						setCycle: End self
					)
				)
				(3
					(sfx
						init:
						setLoop: 2
						posn: 157 99
						setCel: 0
						setCycle: End self
					)
					(gKqSound1 stop:)
					(gKqSound1 number: 2468 setLoop: 1 play:)
				)
				(4
					(sfx dispose:)
					(= ticks 15)
					(gMessager say: 0 0 11 1 self 2450) ; "All right then, girlie! Take a drink!"
				)
				(5
					(= ticks 100)
				)
				(6
					(gEgo
						view: 24552
						setLoop: 0
						setCel: 0
						posn: 128 125
						cycleSpeed: 12
						setCycle: CT 5 1 self
					)
				)
				(7
					(bowl dispose:)
					(gEgo cel: 6)
					(= cycles 6)
				)
				(8
					(gEgo setCycle: End self)
				)
				(9
					(gEgo
						setLoop: 2
						setCel: 0
						posn: 128 125
						setCycle: CT 1 1 self
					)
				)
				(10
					(gKqSound1 number: 892 setLoop: 1 play: self)
					(gEgo setCycle: CT 2 1 self)
				)
				(11
					(gEgo setCycle: End self)
				)
				(12
					(bowl posn: 174 118 init:)
					(gKqSound1 number: 831 setLoop: 1 play:)
					(gEgo
						setLoop: 3
						setCel: 0
						posn: 126 125
						setCycle: End self
					)
				)
				(13
					(gEgo
						setLoop: 4
						setCel: 0
						posn: 124 125
						setCycle: End self
					)
				)
				(14
					(gKqSound1 stop:)
					(gEgo
						setLoop: 5
						setCel: 0
						posn: 107 125
						setCycle: End self
					)
				)
				(15
					(gMessager say: 0 0 11 2 self 2450) ; "(EXCITEDLY)Did it work?"
				)
				(16
					(mat view: 24553 setLoop: 0 cel: 0 setCycle: End self)
				)
				(17
					(Load 140 24701) ; WAVE
					(Load rsSOUND 24702)
					(Load rsSOUND 2469)
					(Load 140 842) ; WAVE
					(Load 140 2470) ; WAVE
					(Load rsSOUND 831)
					(gMessager say: 0 0 11 3 self 2450) ; "(WORRIED)Well...not exactly, dear. Now what did I do wrong...? AHA! I remember! We need a troll hair!"
				)
				(18
					(mat
						view: 24553
						setLoop: 1
						cel: 0
						posn: 178 119
						setCycle: End self
					)
				)
				(19
					(mat
						view: 24553
						setLoop: 2
						cel: 0
						posn: 182 118
						setCycle: CT 5 1 self
					)
				)
				(20
					(gKqSound1 number: 2469 setLoop: 1 setVol: 126 play:)
					(mat setCycle: End self)
				)
				(21
					(gMessager say: 0 0 11 4 self 2450) ; "OW!"
				)
				(22
					(mat
						view: 24553
						setLoop: 3
						cycleSpeed: 10
						cel: 0
						posn: 183 117
						setCycle: End self
					)
				)
				(23
					(gMessager say: 0 0 11 5 self 2450) ; "(DELIGHTED)There we go!"
				)
				(24
					(sfx
						init:
						setLoop: 2
						posn: 159 98
						setCel: 0
						setCycle: CT 2 1 self
					)
				)
				(25
					(sfx setCycle: End self)
					(gKqSound1 number: 842 setLoop: 1 play:)
				)
				(26
					(sfx dispose:)
					(mat
						view: 24554
						cycleSpeed: 12
						setLoop: 1
						cel: 0
						posn: 174 148
						setCycle: CT 5 1 self
					)
				)
				(27
					(bowl dispose:)
					(mat cel: 6)
					(= cycles 10)
				)
				(28
					(mat setCycle: End self)
				)
				(29
					(mat
						view: 24554
						setLoop: 2
						cel: 0
						posn: 162 150
						setCycle: End self
					)
				)
				(30
					(gKqSound1 number: 831 setLoop: 1 play:)
					(gEgo
						view: 24555
						setLoop: 0
						posn: 118 131
						cel: 0
						setCycle: End self
					)
				)
				(31
					(gKqSound1 stop:)
					(gKqSound1 number: 2470 setLoop: -1 play:)
					(gEgo setLoop: 1 posn: 128 128 cel: 0 setCycle: End self)
				)
				(32
					(gEgo setLoop: 2 posn: 134 131 cel: 0 setCycle: End self)
				)
				(33
					(gEgo setLoop: 3 cel: 0 setCycle: End self)
				)
				(34
					(gEgo setLoop: 4 cel: 0 setCycle: End self)
				)
				(35
					(gEgo setLoop: 5 cel: 0 setCycle: CT 12 1 self)
				)
				(36
					(gEgo setCycle: End self)
					(gKqSound1 number: 24701 setLoop: 1 play:)
				)
				(37
					(gEgo setLoop: 6 cel: 0 setCycle: End self)
				)
				(38
					(gKqSound1 number: 24702 setLoop: 1 play:)
					(gEgo setLoop: 7 cel: 0 setCycle: End self)
				)
				(39
					(gEgo setLoop: 9 cel: 0 setCycle: End self)
				)
				(40
					(mat
						view: 24556
						setLoop: 0
						cel: 0
						posn: 162 149
						setCycle: End self
					)
				)
				(41
					(mat setLoop: 1 cycleSpeed: 8 setCycle: Fwd)
					(= seconds 3)
				)
				(42
					(= register ((ScriptID 13 0) modeless:)) ; aEgoTalker
					((ScriptID 13 0) modeless: 2) ; aEgoTalker
					(gMessager say: 0 0 11 6 self 2450) ; "Hmm. The silver spoon melted. And I thought mother's tea was strong! I suppose I should keep it as a momento."
				)
				(43
					(gEgo get: 28) ; Silver_Pellet
					(= cycles 2)
				)
				(44
					((ScriptID 13 0) modeless: register) ; aEgoTalker
					(SetFlag 55)
					(gCurRoom newRoom: 2450)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gEgo get: 28) ; Silver_Pellet
					(SetFlag 55)
					(gCurRoom newRoom: 2450)
				)
			)
		)
	)
)

(instance mat of Prop
	(properties
		noun 1
		view 2456
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 9998)
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 55) (!= theVerb 8) (!= theVerb 39)) ; Do, Dragon_Toad
			(gMessager say: noun 0 25 0 0 2450) ; "(DEFEATED)Run along, child. Run and hide."
		else
			(switch theVerb
				(8 ; Do
					(cond
						((IsFlag 55)
							(cond
								((IsFlag 56)
									(gMessager say: noun theVerb 20 0 0 2450) ; "(URGENTLY)Go, Rosella! Quickly!"
								)
								((IsFlag 374)
									(gMessager say: noun theVerb 24 0 0 2450) ; "(SAD, DEFEATED)Leave me be, child. I'm sick at heart."
								)
								((IsFlag 373)
									(SetFlag 374)
									(gMessager say: noun theVerb 23 0 0 2450) ; "(DETERMINED)Mathilde, maybe if we investigate, we can--"
								)
								(else
									(SetFlag 373)
									(gMessager say: noun theVerb 22 0 0 2450) ; "(CONCERNED, SYMPATHETIC)Mathilde, I know you're concerned for the king, but maybe you shouldn't bait Malicia like you did. She's fully capable of...hurting you."
								)
							)
						)
						(
							(and
								(or (gEgo has: 24) (gEgo has: 33)) ; Bowl_a, Bowl_b
								(gEgo has: 26) ; Baked_Beetles
								(gEgo has: 25) ; Silver_Spoon
								(gEgo has: 27) ; Dragon_Scale
								(IsFlag 68)
							)
							(gMessager say: noun theVerb 4 0 0 2450) ; "(EXCITED)Mathile! I think I have all of the ingredients for the spell!"
						)
						((IsFlag 57)
							(gEgo setLoop: 3 cel: 7)
							(gMessager say: noun theVerb 3 0 0 2450) ; "(SOFTLY, NOT WANTING TO DISTURB MATHILDE)Mathilde? What was that list of ingredients again?"
							(gGame handsOn:)
							(User canControl: 0)
						)
						((IsFlag 350)
							(gMessager say: noun theVerb 6 0 0 2450) ; "Hurry, Rosella. Find the gold bowl!"
						)
						(else
							(gEgo setLoop: 3 cel: 7)
							(gMessager say: noun theVerb 3 0 0 2450) ; "(SOFTLY, NOT WANTING TO DISTURB MATHILDE)Mathilde? What was that list of ingredients again?"
							(gGame handsOn:)
							(User canControl: 0)
						)
					)
					(return 1)
				)
				(95 ; Bowl_b
					(gCurRoom setScript: giveBrassBowl)
				)
				(33 ; Bowl_a
					(gCurRoom setScript: giveGoldBowl)
				)
				(42 ; ???
					(gCurRoom setScript: giveGoldBowl)
				)
				(34 ; Silver_Spoon
					(if (IsFlag 57)
						(gCurRoom setScript: giveSpoon)
					else
						(gMessager say: noun 0 5 0 0 2450) ; "(IMPATIENTLY)The bowl, girl, the bowl!"
						(gGame handsOn:)
						(User canControl: 0)
					)
				)
				(35 ; Baked_Beetles
					(if (IsFlag 57)
						(SetFlag 53)
						(gEgo put: 26) ; Baked_Beetles
						(= global318 theVerb)
						(gCurRoom setScript: giveIngredient)
					else
						(gMessager say: noun 0 5 0 0 2450) ; "(IMPATIENTLY)The bowl, girl, the bowl!"
						(gGame handsOn:)
						(User canControl: 0)
					)
				)
				(36 ; Dragon_Scale
					(if (IsFlag 57)
						(SetFlag 54)
						(gEgo put: 27) ; Dragon_Scale
						(= global318 theVerb)
						(gCurRoom setScript: giveIngredient)
					else
						(gMessager say: noun 0 5 0 0 2450) ; "(IMPATIENTLY)The bowl, girl, the bowl!"
						(gGame handsOn:)
						(User canControl: 0)
					)
				)
				(39 ; Dragon_Toad
					(gCurRoom setScript: giveToad)
				)
				(else
					(gCurRoom setScript: waveAway)
				)
			)
		)
		(return 1)
	)
)

(instance ingredientCode of Code
	(properties)

	(method (doit)
		(if (and (IsFlag 53) (IsFlag 54))
			(IsFlag 51)
		)
	)
)

(instance bowl of View
	(properties
		x 177
		y 116
		view 2459
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 130)
	)
)

(instance sfx of Prop
	(properties
		x 164
		y 98
		view 24551
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 131)
	)
)

(instance toad of Prop
	(properties
		x 229
		y 74
		view 24560
	)

	(method (init)
		(super init: &rest)
		(self setPri: (+ (mat priority:) 1))
	)
)

(instance mySouthExit of ExitFeature ; UNUSED
	(properties
		nsTop 126
		nsRight 319
		nsBottom 137
		exitDir 3
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 2450)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance myEastExit of ExitFeature ; UNUSED
	(properties
		nsLeft 309
		nsRight 319
		nsBottom 139
		exitDir 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 2450)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance myWestExit of ExitFeature ; UNUSED
	(properties
		nsRight 9
		nsBottom 139
		exitDir 4
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 2450)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance toadTalker of KQTalker
	(properties
		loop 26
	)
)

(instance exitCode of Code
	(properties)

	(method (doit)
		(if (User canInput:)
			(gCurRoom setScript: backToHall)
		)
	)
)

