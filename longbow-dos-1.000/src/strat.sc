;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 171)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use n940)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	strat 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0)
	(if (== ((Inv at: 2) owner:) 140) ; halfHeart
		(gEgo get: 2) ; halfHeart
	)
	(if (== ((Inv at: 11) owner:) 140) ; cask
		(gEgo get: 11) ; cask
	)
	(if (== ((Inv at: 12) owner:) 140) ; puzzleBox
		(gEgo get: 12) ; puzzleBox
	)
	(if (== ((Inv at: 13) owner:) 140) ; robes
		(gEgo get: 13) ; robes
	)
	(if (== ((Inv at: 14) owner:) 140) ; amethyst
		(gEgo get: 14) ; amethyst
	)
	(if (== ((Inv at: 16) owner:) 140) ; fulkScroll
		(gEgo get: 16) ; fulkScroll
	)
	(if (== ((Inv at: 17) owner:) 140) ; handScroll
		(gEgo get: 17) ; handScroll
	)
)

(instance strat of Rm
	(properties
		picture 190
		style 8
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gRgnMusic number: 171 loop: -1 init: play: fade: 127 21 12 0)
		(switch (= local3 (Random 1 8))
			(1
				(lilJohn x: 108 y: 92)
				(johnHead x: 105 y: 104)
				(johnHand x: 84 y: 119)
				(friarTuck x: 169 y: 189)
				(tuckHead x: 175 y: 138)
				(tuckHand x: 153 y: 180)
				(alanDale x: 238 y: 189)
				(alanHead x: 228 y: 147)
				(alanHand x: 222 y: 189)
				(muchMiller x: 293 y: 189)
				(muchHead x: 297 y: 117)
				(willScarlet x: 44 y: 189)
				(willHead x: 41 y: 158)
			)
			(2
				(lilJohn x: 108 y: 92)
				(johnHead x: 105 y: 104)
				(johnHand x: 84 y: 119)
				(friarTuck x: 169 y: 189)
				(tuckHead x: 175 y: 138)
				(tuckHand x: 153 y: 180)
				(alanDale x: 238 y: 189)
				(alanHead x: 228 y: 147)
				(alanHand x: 222 y: 189)
				(muchMiller x: 293 y: 189)
				(muchHead x: 297 y: 117)
				(willScarlet x: 44 y: 189)
				(willHead x: 41 y: 158)
			)
			(3
				(lilJohn x: 33 y: 95)
				(johnHead x: 30 y: 111)
				(johnHand x: 7 y: 124)
				(friarTuck x: 286 y: 189)
				(tuckHead x: 291 y: 138)
				(tuckHand x: 270 y: 176)
				(alanDale x: 93 y: 189)
				(alanHead x: 84 y: 149)
				(alanHand x: 77 y: 189)
				(muchMiller x: 217 y: 189)
				(muchHead x: 221 y: 117)
				(willScarlet x: 160 y: 189)
				(willHead x: 158 y: 158)
			)
			(4
				(lilJohn x: 215 y: 92)
				(johnHead x: 212 y: 109)
				(johnHand x: 193 y: 120)
				(friarTuck x: 38 y: 189)
				(tuckHead x: 41 y: 139)
				(tuckHand x: 21 y: 176)
				(alanDale x: 278 y: 189)
				(alanHead x: 268 y: 149)
				(alanHand x: 260 y: 189)
				(muchMiller x: 105 y: 189)
				(muchHead x: 109 y: 117)
				(willScarlet x: 160 y: 189)
				(willHead x: 158 y: 158)
			)
			(5
				(lilJohn x: 283 y: 92)
				(johnHead x: 281 y: 107)
				(johnHand x: 260 y: 122)
				(friarTuck x: 230 y: 189)
				(tuckHead x: 234 y: 138)
				(tuckHand x: 214 y: 173)
				(alanDale x: 32 y: 189)
				(alanHead x: 21 y: 149)
				(alanHand x: 15 y: 189)
				(muchMiller x: 94 y: 189)
				(muchHead x: 98 y: 117)
				(willScarlet x: 160 y: 189)
				(willHead x: 158 y: 158)
			)
			(6
				(lilJohn x: 283 y: 92)
				(johnHead x: 281 y: 107)
				(johnHand x: 260 y: 122)
				(friarTuck x: 161 y: 189)
				(tuckHead x: 166 y: 138)
				(tuckHand x: 144 y: 175)
				(alanDale x: 221 y: 189)
				(alanHead x: 212 y: 149)
				(alanHand x: 206 y: 187)
				(muchMiller x: 94 y: 189)
				(muchHead x: 98 y: 117)
				(willScarlet x: 40 y: 189)
				(willHead x: 37 y: 158)
			)
			(7
				(lilJohn x: 283 y: 92)
				(johnHead x: 281 y: 107)
				(johnHand x: 260 y: 122)
				(friarTuck x: 37 y: 189)
				(tuckHead x: 42 y: 138)
				(tuckHand x: 20 y: 175)
				(alanDale x: 221 y: 189)
				(alanHead x: 212 y: 149)
				(alanHand x: 206 y: 187)
				(muchMiller x: 101 y: 189)
				(muchHead x: 105 y: 117)
				(willScarlet x: 162 y: 189)
				(willHead x: 159 y: 158)
			)
			(8
				(lilJohn x: 166 y: 92)
				(johnHead x: 163 y: 108)
				(johnHand x: 142 y: 123)
				(friarTuck x: 37 y: 189)
				(tuckHead x: 42 y: 138)
				(tuckHand x: 20 y: 175)
				(alanDale x: 105 y: 189)
				(alanHead x: 96 y: 149)
				(alanHand x: 88 y: 188)
				(muchMiller x: 293 y: 189)
				(muchHead x: 297 y: 117)
				(willScarlet x: 236 y: 189)
				(willHead x: 233 y: 158)
			)
		)
		(lilJohn init:)
		(johnHead init: startUpd:)
		(johnHand init:)
		(friarTuck init:)
		(tuckHead init: startUpd:)
		(tuckHand init: startUpd:)
		(alanDale init:)
		(alanHead init: startUpd:)
		(alanHand init: startUpd:)
		(muchMiller init:)
		(muchHead init: startUpd:)
		(willScarlet init:)
		(willHead init: startUpd:)
		(self setScript: talkArbitrator)
	)

	(method (dispose)
		(gRgnMusic fade: 60 30 12 1)
		(super dispose: &rest)
	)
)

(instance lilJohn of View
	(properties
		view 175
		loop 2
		priority 14
		signal 16
	)
)

(instance johnHead of Prop
	(properties
		view 175
		priority 15
		signal 16
	)
)

(instance johnHand of Prop
	(properties
		view 175
		loop 1
		priority 15
		signal 16
	)
)

(instance friarTuck of View
	(properties
		view 175
		loop 5
		priority 14
		signal 16
	)
)

(instance tuckHead of Prop
	(properties
		view 175
		loop 3
		priority 15
		signal 16
	)
)

(instance tuckHand of Prop
	(properties
		view 175
		loop 4
		priority 15
		signal 16
	)
)

(instance alanDale of View
	(properties
		view 175
		loop 8
		priority 14
		signal 16400
	)
)

(instance alanHead of Prop
	(properties
		view 175
		loop 6
		priority 15
		signal 16
	)
)

(instance alanHand of Prop
	(properties
		view 175
		loop 7
		priority 15
		signal 16400
	)
)

(instance muchMiller of View
	(properties
		view 175
		loop 12
	)
)

(instance muchHead of Prop
	(properties
		view 175
		loop 11
		priority 15
		signal 16
	)
)

(instance willScarlet of View
	(properties
		view 175
		loop 10
		priority 14
		signal 16400
	)
)

(instance willHead of Prop
	(properties
		view 175
		loop 9
	)
)

(instance queensKnight of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 99 self 80 {Will}) ; "As I said, I see no way we can help you in this rescue.  You alone have been to the Monastery and know the lay of it."
			)
			(1
				(= ticks 10)
			)
			(2
				(willHead setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 100 self 80 {John}) ; "If we had Caesar's army, we might be able to assault the place. Even then, it would be difficult."
			)
			(3
				(= ticks 10)
			)
			(4
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(SetMessageColor 0)
				(Say 1171 101 self 80 {Robin}) ; "We could not hope to take it by force, this is true."
			)
			(5
				(= ticks 10)
			)
			(6
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 102 self 80 {Tuck}) ; "This is a task best suited to you alone."
			)
			(7
				(= ticks 10)
			)
			(8
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 103 self 80 {Alan}) ; "And 'twill make a fine addition to tack onto the end of your ballads."
			)
			(9
				(= ticks 10)
			)
			(10
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(self dispose:)
			)
		)
	)
)

(instance rescueMarian3 of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMessageColor 0)
				(Say 1171 62 self 80 {Robin}) ; "I can spare no more time! We must commit to battle at once."
			)
			(1
				(= ticks 10)
			)
			(2
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 63 self 80 {Will}) ; "We'll repeat our strategies again and let you choose."
			)
			(3
				(= ticks 10)
			)
			(4
				(willHead setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 64 self 80 {John}) ; "Lead a two-part attack through the town. You lead half our men from the north..."
			)
			(5
				(= ticks 10)
			)
			(6
				(Say 1171 65 self 80 {John}) ; "...and Will can lead the other half from the south converging upon the Court, for I will stay at your side."
			)
			(7
				(= ticks 10)
			)
			(8
				(Say 1171 66 self 80 {John}) ; "We'll outflank the soldiers and trap them between our two lines."
			)
			(9
				(= ticks 10)
			)
			(10
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 67 self 80 {Alan}) ; "Both the Sheriff and Abbot will be there, will they not?"
			)
			(11
				(= ticks 10)
			)
			(12
				(Say 1171 68 self 80 {Alan}) ; "Let us concentrate all our force not toward the Lady, as they expect, but towards taking them prisoner."
			)
			(13
				(= ticks 10)
			)
			(14
				(Say 1171 69 self 80 {Alan}) ; "Once we have such hostages, we can demand that Marian be set free and even guarantee us safe passage to the forest."
			)
			(15
				(= ticks 10)
			)
			(16
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 70 self 80 {Tuck}) ; "I would incite the mob to riot, for the Abbot is feared and hated by the common folk."
			)
			(17
				(= ticks 10)
			)
			(18
				(Say 1171 71 self 80 {Tuck}) ; "Set them to create confusion and draw the soldiers into the streets..."
			)
			(19
				(= ticks 10)
			)
			(20
				(Say 1171 72 self 80 {Tuck}) ; "... where we can attack in full force outside the Court while you slip inside rescue your Lady."
			)
			(21
				(= ticks 10)
			)
			(22
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 73 self 80 {Will}) ; "One strong wedge driving straight through the nearest town gate will serve us best, with you in the lead."
			)
			(23
				(= ticks 10)
			)
			(24
				(Say 1171 74 self 80 {Will}) ; "We'll cover you while you reach Marian and free her from the stake."
			)
			(25
				(= ticks 10)
			)
			(26
				(willHead setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 75 self 80 {Much}) ; "Let's attack the soldiers and taunt them and then pretend to run away in all directions."
			)
			(27
				(= ticks 10)
			)
			(28
				(Say 1171 76 self 80 {Much}) ; "The soldiers will split up and run all over the town after us."
			)
			(29
				(= ticks 10)
			)
			(30
				(Say 1171 77 self 80 {Much}) ; "Then you, Robin, with maybe 5 men, can go after Marian while we keep the soldiers busy running after us."
			)
			(31
				(= ticks 10)
			)
			(32
				(muchHead setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance rescueMarian2 of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMessageColor 0)
				(Say 1171 60 self 80 {Robin}) ; "The day wears on and I despair of finding a safe way to enter Nottingham in secret."
			)
			(1
				(= ticks 10)
			)
			(2
				(Say 1171 61 self 80 {Robin}) ; "Give me your counsel again and let me think once more upon what I should do."
			)
			(3
				(= ticks 10)
			)
			(4
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 44 self 80 {Alan}) ; "Both the Sheriff and Abbot will be there, will they not?"
			)
			(5
				(= ticks 10)
			)
			(6
				(Say 1171 45 self 80 {Alan}) ; "Let us concentrate all our force not toward the Lady, as they expect, but towards taking them prisoner."
			)
			(7
				(= ticks 10)
			)
			(8
				(Say 1171 46 self 80 {Alan}) ; "Once we have such hostages, we can demand that Marian be set free and even guarantee us safe passage to the forest."
			)
			(9
				(= ticks 10)
			)
			(10
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 47 self 80 {Tuck}) ; "I would incite the mob to riot, for the Abbot is feared and hated by the common folk."
			)
			(11
				(= ticks 10)
			)
			(12
				(Say 1171 48 self 80 {Tuck}) ; "Set them to create confusion and draw the soldiers into the streets..."
			)
			(13
				(= ticks 10)
			)
			(14
				(Say 1171 49 self 80 {Tuck}) ; "... where we can attack in full force outside the Court while you slip inside and rescue your Lady."
			)
			(15
				(= ticks 10)
			)
			(16
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 50 self 80 {John}) ; "My counsel is to try subterfuge."
			)
			(17
				(= ticks 10)
			)
			(18
				(Say 1171 51 self 80 {John}) ; "By whatever means you can, enter the Court secretly so that you can seize the Lady from the fire unhindered."
			)
			(19
				(= ticks 10)
			)
			(20
				(Say 1171 52 self 80 {John}) ; "When it seems certain you've found a way in, I'll lead a two-part attack through the town."
			)
			(21
				(= ticks 10)
			)
			(22
				(Say 1171 53 self 80 {John}) ; "Half our men from the north and half from the south converging upon the Court."
			)
			(23
				(= ticks 10)
			)
			(24
				(Say 1171 54 self 80 {John}) ; "I'll take your horn and when you hear me signal you upon it, you'll know the moment is upon you to act."
			)
			(25
				(= ticks 10)
			)
			(26
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 55 self 80 {Will}) ; "One strong wedge driving straight through the nearest town gate will serve us best, with you in the lead."
			)
			(27
				(= ticks 10)
			)
			(28
				(Say 1171 56 self 80 {Will}) ; "We'll cover you while you reach Marian and free her from the stake."
			)
			(29
				(= ticks 10)
			)
			(30
				(willHead setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 57 self 80 {Much}) ; "Let's attack the soldiers and taunt them and then pretend to run away in all directions."
			)
			(31
				(= ticks 10)
			)
			(32
				(Say 1171 58 self 80 {Much}) ; "The soldiers will split up and run all over the town after us."
			)
			(33
				(= ticks 10)
			)
			(34
				(Say 1171 59 self 80 {Much}) ; "Then you, Robin, with maybe 5 men, can go after Marian while we keep the soldiers busy running after us."
			)
			(35
				(= ticks 10)
			)
			(36
				(muchHead setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance rescueSonsOfWidow2 of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMessageColor 0)
				(Say 1171 21 self 80 {Robin}) ; "Twice I've entered the town without freeing Hal, Hob and Dicken. I fear it's beyond my means."
			)
			(1
				(= ticks 10)
			)
			(2
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 22 self 80 {Will}) ; "Nonsense. I've seen you perform wonders in the grimmest of times."
			)
			(3
				(= ticks 10)
			)
			(4
				(Say 1171 23 self 80 {Will}) ; "There is just enough time before sunset to return again."
			)
			(5
				(= ticks 10)
			)
			(6
				(willHead setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 24 self 80 {Much}) ; "Aye, we have faith in you."
			)
			(7
				(= ticks 10)
			)
			(8
				(muchHead setScript: 0)
				(SetMessageColor 0)
				(Say 1171 25 self 80 {Robin}) ; "Your faith gives me new hope. Yet I fear the worst may happen should I fail again."
			)
			(9
				(= ticks 10)
			)
			(10
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 26 self 80 {John}) ; "I agree with Will and Much. You still have a chance, but let us give you our counsel and you can decide."
			)
			(11
				(= ticks 10)
			)
			(12
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 27 self 80 {Will}) ; "You know I don't shirk from battle, but I'm of a mind that you should go to Nottingham once again..."
			)
			(13
				(= ticks 10)
			)
			(14
				(Say 1171 28 self 80 {Will}) ; "...and find a means to rescue the lads by your wits and cunning."
			)
			(15
				(= ticks 10)
			)
			(16
				(willHead setScript: 0)
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 29 self 80 {Alan}) ; "I say we fire flaming arrows over the gates, set the place afire and free the lads during the confusion that follows."
			)
			(17
				(= ticks 10)
			)
			(18
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 30 self 80 {Tuck}) ; "Create a loud diversion just outside the gates."
			)
			(19
				(= ticks 10)
			)
			(20
				(Say 1171 31 self 80 {Tuck}) ; "When the soldiers come to investigate, set 10 men to fight them and let the rest carry the battle inside."
			)
			(21
				(= ticks 10)
			)
			(22
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 32 self 80 {Much}) ; "Let's all charge in screaming and yelling like madmen and shoot as many as we can."
			)
			(23
				(= ticks 10)
			)
			(24
				(Say 1171 33 self 80 {Much}) ; "They'll think we have a whole army behind us and retreat."
			)
			(25
				(= ticks 10)
			)
			(26
				(Say 1171 34 self 80 {Much}) ; "Then we'll grab my cousins and run like rabbits before the soldiers figure out there aren't any more of us."
			)
			(27
				(= ticks 10)
			)
			(28
				(muchHead setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 35 self 80 {John}) ; "Send inside 6 of your best men with swords,..."
			)
			(29
				(= ticks 10)
			)
			(30
				(Say 1171 36 self 80 {John}) ; "...and let them enter the town disguised as peasants and get close to the gallows."
			)
			(31
				(= ticks 10)
			)
			(32
				(Say 1171 37 self 80 {John}) ; "They must strike swiftly and depend upon speed and surprise to protect them."
			)
			(33
				(= ticks 10)
			)
			(34
				(Say 1171 38 self 80 {John}) ; "The rest of us, the best archers, will be positioned just outside the gates to clear the way for their retreat."
			)
			(35
				(= ticks 10)
			)
			(36
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(self dispose:)
			)
		)
	)
)

(instance rescueSonsOfWidow1 of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 0 self 80 {Tuck}) ; "That you've entered Nottingham once and returned safely means that your disguise is convincing."
			)
			(1
				(= ticks 10)
			)
			(2
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 1 self 80 {John}) ; "Aye, we've enough time for you to return and seek a means of rescue..."
			)
			(3
				(= ticks 10)
			)
			(4
				(Say 1171 2 self 80 {John}) ; "... before we plunge headlong into a desperate and deadly battle."
			)
			(5
				(= ticks 10)
			)
			(6
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(SetMessageColor 0)
				(Say 1171 3 self 80 {Robin}) ; "If only I could be more certain that I could bring them out myself, unaided."
			)
			(7
				(= ticks 10)
			)
			(8
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 4 self 80 {Will}) ; "Come, nothing in this life is certain. We are all prepared to take risks."
			)
			(9
				(= ticks 10)
			)
			(10
				(Say 1171 5 self 80 {Will}) ; "If you think it's time for battle, you have but to say the word,..."
			)
			(11
				(= ticks 10)
			)
			(12
				(Say 1171 6 self 80 {Will}) ; "... though I agree with John and Tuck that there's yet time to make another foray into town disguised as a monk."
			)
			(13
				(= ticks 10)
			)
			(14
				(willHead setScript: 0)
				(SetMessageColor 0)
				(Say 1171 7 self 80 {Robin}) ; "Let me hear your plans and I'll decide."
			)
			(15
				(= ticks 10)
			)
			(16
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 8 self 80 {Tuck}) ; "I urge you strongly to try your Monk disguise in town once more. There is still time to find a clever subterfuge."
			)
			(17
				(= ticks 10)
			)
			(18
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 9 self 80 {Much}) ; "Let's all charge in screaming and yelling like madmen and shoot as many as we can."
			)
			(19
				(= ticks 10)
			)
			(20
				(Say 1171 10 self 80 {Much}) ; "They'll think we have a whole army behind us and retreat."
			)
			(21
				(= ticks 10)
			)
			(22
				(Say 1171 11 self 80 {Much}) ; "Then we'll grab my cousins and run like rabbits before the soldiers figure out there aren't any more of us."
			)
			(23
				(= ticks 10)
			)
			(24
				(muchHead setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 12 self 80 {John}) ; "The Sheriff will expect a rescue and be suspicious even of the peasants who come to watch."
			)
			(25
				(= ticks 10)
			)
			(26
				(Say 1171 13 self 80 {John}) ; "I counsel that we attack with a feint of 10 men, enough to draw the body of his men outside."
			)
			(27
				(= ticks 10)
			)
			(28
				(Say 1171 14 self 80 {John}) ; "There the rest of our men must be ready to attack with a lethal volley and clear a path..."
			)
			(29
				(= ticks 10)
			)
			(30
				(Say 1171 15 self 80 {John}) ; "...so that we may fight our way to the gallows and retreat with the numbers against us reduced."
			)
			(31
				(= ticks 10)
			)
			(32
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 16 self 80 {Alan}) ; "I'm not much for battle strategies, but I say we fire flaming arrows over the gates,..."
			)
			(33
				(= ticks 10)
			)
			(34
				(Say 1171 17 self 80 {Alan}) ; "...set the place afire and free the lads during the confusion that follows."
			)
			(35
				(= ticks 10)
			)
			(36
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 18 self 80 {Will}) ; "Send inside 5 of your best men with swords, and let them enter the town disguised as peasants and get close to the gallows."
			)
			(37
				(= ticks 10)
			)
			(38
				(Say 1171 19 self 80 {Will}) ; "They must strike swiftly and depend upon speed and surprise to protect them."
			)
			(39
				(= ticks 10)
			)
			(40
				(Say 1171 20 self 80 {Will}) ; "The rest of us, the best archers, will be positioned just outside the gates to clear the way for their retreat."
			)
			(41
				(= ticks 10)
			)
			(42
				(willHead setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance headShake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 (Random 1 2))
				(client cycleSpeed: (* local4 6) cel: 0 setCycle: End self)
			)
			(1
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance tuckHeadShake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 (Random 1 2))
				(client cycleSpeed: (* local8 6) cel: 0 setCycle: End self)
			)
			(1
				(client cel: 0)
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance handShake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 (Random 1 2))
				(client cycleSpeed: (* local5 6) cel: 0 setCycle: End self)
			)
			(1
				(= state -1)
				(= ticks (* (= local5 (Random 4 9)) 12))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance johnHandShake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 (Random 1 2))
				(client cycleSpeed: (* local6 6) cel: 0 setCycle: End self)
			)
			(1
				(= ticks (* (= local6 (Random 5 9)) 50))
			)
			(2
				(= local6 (Random 1 2))
				(client cycleSpeed: (* local6 6) setCycle: Beg self)
			)
			(3
				(= state -1)
				(= ticks (* (= local6 (Random 4 8)) 40))
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance alanHandShake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 (Random 1 2))
				(client cycleSpeed: (* local7 6) cel: 0 setCycle: End self)
			)
			(1
				(= ticks (* (= local7 (Random 5 9)) 50))
			)
			(2
				(= local7 (Random 1 2))
				(client cycleSpeed: (* local7 6) setCycle: Beg self)
			)
			(3
				(= state -1)
				(= ticks (* (= local7 (Random 4 8)) 40))
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance walkThePlank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= ticks 6)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 803 10)
				(= ticks 12)
			)
			(2
				(switch global142
					(1
						(Display 171 0 dsCOORD 55 60 dsCOLOR global185) ; "I donned the Monk's robes,"
						(Display 171 1 dsCOORD 55 70 dsCOLOR global185) ; "took what I might need with me,"
						(Display 171 2 dsCOORD 55 80 dsCOLOR global185) ; "and hurried back to Nottingham."
					)
					(2
						(Display 171 3 dsCOORD 55 65 dsCOLOR global185) ; "I took leave of my men and"
						(Display 171 4 dsCOORD 55 75 dsCOLOR global185) ; "hurried back to Nottingham."
					)
				)
				(= seconds 10)
			)
			(3
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance robTreasureTrain of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMessageColor 0)
				(Say 1171 78 self 80 {Robin}) ; "Our scout has reported that the Baron's treasure train has entered Sherwood upon the north."
			)
			(1
				(= ticks 10)
			)
			(2
				(Say 1171 79 self 80 {Robin}) ; "Baron LeFevre rides in the fore. The treasure is carried upon 3 mules in line behind him."
			)
			(3
				(= ticks 10)
			)
			(4
				(Say 1171 80 self 80 {Robin}) ; "Upon each side of the mules he has 20 heavily armed men, of which 10 are crossbowmen and 10 carry shields and spears."
			)
			(5
				(= ticks 10)
			)
			(6
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 81 self 80 {Will}) ; "So we face 40 well-armed men in all, plus the Baron. What do we know of this Baron?"
			)
			(7
				(= ticks 10)
			)
			(8
				(willHead setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 82 self 80 {John}) ; "If he's in the service of Prince John, he must be a man of dubious honour."
			)
			(9
				(= ticks 10)
			)
			(10
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 83 self 80 {Will}) ; "But no less dangerous. If he rides in the fore, he is no coward."
			)
			(11
				(= ticks 10)
			)
			(12
				(Say 1171 84 self 80 {Will}) ; "Shall we present our strategies?"
			)
			(13
				(= ticks 10)
			)
			(14
				(willHead setScript: 0)
				(SetMessageColor 0)
				(Say 1171 85 self 80 {Robin}) ; "Aye, let me hear them all."
			)
			(15
				(= ticks 10)
			)
			(16
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 86 self 80 {Will}) ; "Let us concentrate all of our fire from the Overlook where we're best protected."
			)
			(17
				(= ticks 10)
			)
			(18
				(Say 1171 87 self 80 {Will}) ; "We'll strike without warning and simply keep firing relentlessly until they are scattered or surrender."
			)
			(19
				(= ticks 10)
			)
			(20
				(willHead setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 88 self 80 {John}) ; "This battle will cost us men, no matter what tactic we choose."
			)
			(21
				(= ticks 10)
			)
			(22
				(Say 1171 89 self 80 {John}) ; "We should demand a surrender first in case this Baron has more sense than courage,..."
			)
			(23
				(= ticks 10)
			)
			(24
				(Say 1171 90 self 80 {John}) ; "...but set upon them from all sides if they refuse."
			)
			(25
				(= ticks 10)
			)
			(26
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 91 self 80 {Alan}) ; "There's no glory in an ambush. I couldn't even make a simple song out of it!"
			)
			(27
				(= ticks 10)
			)
			(28
				(Say 1171 92 self 80 {Alan}) ; "We should show our strength from the Overlook..."
			)
			(29
				(= ticks 10)
			)
			(30
				(Say 1171 93 self 80 {Alan}) ; "...with a blare of horns and beating of drums, singing the praises of Richard Lionheart!"
			)
			(31
				(= ticks 10)
			)
			(32
				(Say 1171 94 self 80 {Alan}) ; "If they fail to surrender on the spot, then we open fire and let fall a deadly rain of arrows."
			)
			(33
				(= ticks 10)
			)
			(34
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 95 self 80 {Tuck}) ; "Against such trained soldiers we have but one advantage--surprise."
			)
			(35
				(= ticks 10)
			)
			(36
				(Say 1171 96 self 80 {Tuck}) ; "It must be a sudden ambush and we must fall upon them equally from both the Overlook and the far side of the road."
			)
			(37
				(= ticks 10)
			)
			(38
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 97 self 80 {Much}) ; "Let's round up some wild boars and drive them into the road."
			)
			(39
				(= ticks 10)
			)
			(40
				(Say 1171 98 self 80 {Much}) ; "The horse and mules will panic, the boars will gore some of the soldiers and then we can move in and take over."
			)
			(41
				(= ticks 10)
			)
			(42
				(muchHead setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance talkArbitrator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gDay
					(5
						(if (IsFlag 55)
							(switch global142
								(1
									(= global146 10)
								)
								(else
									(= global146 20)
								)
							)
						)
					)
					(6
						(if (IsFlag 55)
							(switch global142
								(1
									(= global146 10)
								)
								(else
									(= global146 20)
								)
							)
						)
					)
					(10
						(switch global159
							(0
								(= global146 30)
							)
							(1
								(= global146 40)
							)
							(else
								(= global146 50)
							)
						)
					)
					(11
						(= global146 60)
					)
					(13
						(= global146 70)
					)
				)
				(= local0 global146)
				(switch global146
					(70
						(self setScript: queensKnight self)
					)
					(60
						(self setScript: robTreasureTrain self)
					)
					(50
						(self setScript: rescueMarian3 self)
					)
					(40
						(self setScript: rescueMarian2 self)
					)
					(30
						(self setScript: rescueMarian1 self)
					)
					(20
						(self setScript: rescueSonsOfWidow2 self)
					)
					(10
						(self setScript: rescueSonsOfWidow1 self)
					)
				)
			)
			(1
				(= ticks 6)
			)
			(2
				(SetMessageColor 0)
				(switch global146
					(70
						(gCurRoom newRoom: 100)
					)
					(60
						(= global146
							(= local2
								(PrintD
									26
									{ }
									81
									{John: Demand surrender, attack from all sides.}
									60
									106
									26
									{ }
									81
									{Will: Ambush from Overlook only.}
									61
									106
									26
									{ }
									81
									{Alan: Demand surrender with fanfare.}
									62
									106
									26
									{ }
									81
									{Tuck: Surprise ambush from two sides.}
									64
									106
									26
									{ }
									81
									{Much: Create panic with wild boars.}
									63
									67
									70
									25
								)
							)
						)
						(switch local2
							(60
								(SetScore 200)
								(if (<= gOutlaws 16)
									(gCurRoom newRoom: 176) ; robscrewed
								else
									(gCurRoom newRoom: 174) ; johnswobat
								)
							)
							(61
								(SetScore 400)
								(if (<= gOutlaws 15)
									(gCurRoom newRoom: 176) ; robscrewed
								else
									(gCurRoom newRoom: 173) ; wobat
								)
							)
							(62
								(SetScore 100)
								(if (<= gOutlaws 18)
									(gCurRoom newRoom: 176) ; robscrewed
								else
									(gCurRoom newRoom: 174) ; johnswobat
								)
							)
							(64
								(SetScore 500)
								(gCurRoom newRoom: 172) ; tuckwobat
							)
							(63
								(gCurRoom newRoom: 175) ; muchswobat
							)
							(0
								(= global146 local0)
								(= state 1)
								(self cue:)
							)
						)
					)
					(50
						(= global146
							(= local2
								(PrintD
									26
									{ }
									81
									{John: Two part flanking attack.}
									50
									106
									26
									{ }
									81
									{Will: Robin to lead a wedge attack in force.}
									51
									106
									26
									{ }
									81
									{Alan: Seek to take Sheriff and Abbot hostage.}
									52
									106
									26
									{ }
									81
									{Tuck: Incite riot, attack in streets, Robin to slip in alone.}
									54
									106
									26
									{ }
									81
									{Much: Try to lead soldiers away, Robin to enter Witch's Court with 5 men.}
									53
									67
									70
									25
								)
							)
						)
						(switch local2
							(50
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(51
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(52
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(54
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(53
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(0
								(= global146 local0)
								(= state 1)
								(self cue:)
							)
						)
					)
					(40
						(= global146
							(= local2
								(PrintD
									26
									{ }
									81
									{John: Subterfuge. John leads two part attack and winds horn for Robin to act.}
									40
									106
									26
									{ }
									81
									{Will: Robin to lead a wedge attack in force.}
									41
									106
									26
									{ }
									81
									{Alan: Seek to take Sheriff and Abbot hostage.}
									42
									106
									26
									{ }
									81
									{Tuck: Incite riot, attack in streets, Robin to slip in alone.}
									44
									106
									26
									{ }
									81
									{Much: Try to lead soldiers away, Robin to enter Witch's Court with 5 men.}
									43
									67
									70
									25
								)
							)
						)
						(switch local2
							(40
								(gCurRoom newRoom: 260)
							)
							(41
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(42
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(44
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(43
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(0
								(= global146 local0)
								(= state 1)
								(self cue:)
							)
						)
					)
					(30
						(= global146
							(= local2
								(PrintD
									26
									{ }
									81
									{John: Subterfuge. John leads two part attack and winds horn for Robin to act.}
									30
									106
									26
									{ }
									81
									{Will: Robin to lead a wedge attack in force.}
									31
									106
									26
									{ }
									81
									{Alan: Seek to take Sheriff and Abbot hostage.}
									32
									106
									26
									{ }
									81
									{Tuck: Incite riot, attack in streets, Robin to slip in alone.}
									34
									106
									26
									{ }
									81
									{Much: Try to lead soldiers away, Robin to enter Witch's Court with 5 men.}
									33
									67
									70
									25
								)
							)
						)
						(switch local2
							(30
								(gCurRoom newRoom: 260)
							)
							(31
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(32
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(34
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(33
								(gCurRoom newRoom: 501) ; jwitchct
							)
							(0
								(= global146 local0)
								(= state 1)
								(self cue:)
							)
						)
					)
					(20
						(= global146
							(= local2
								(PrintD
									26
									{ }
									81
									{John: 6 men inside, surprise attack, 16 outside to cover retreat.}
									20
									106
									26
									{ }
									81
									{Will: Return to Nottingham in disguise.}
									24
									106
									26
									{ }
									81
									{Alan: Set a fire and rush in.}
									22
									106
									26
									{ }
									81
									{Tuck: Create diversion with 10 men, send 12 men inside.}
									21
									106
									26
									{ }
									81
									{Much: 22 outlaws, charge the gates.}
									23
									67
									70
									25
								)
							)
						)
						(switch local2
							(20
								(gCurRoom newRoom: 177) ; willCas
							)
							(21
								(gCurRoom newRoom: 177) ; willCas
							)
							(22
								(gCurRoom newRoom: 177) ; willCas
							)
							(23
								(gCurRoom newRoom: 177) ; willCas
							)
							(24
								(gEgo put: 1 140) ; horn
								(HandsOn)
								(= gDisguiseNum 5) ; abbey monk
								(gCurRoom setScript: walkThePlank)
							)
							(0
								(= global146 local0)
								(= state 1)
								(self cue:)
							)
						)
					)
					(10
						(= global146
							(= local2
								(PrintD
									26
									{ }
									81
									{John: 10 men feint outside, then          full scale attack.}
									11
									106
									26
									{ }
									81
									{Will: 5 men inside, surprise attack, 17 outside to cover retreat.}
									10
									106
									26
									{ }
									81
									{Alan: Set a fire and rush in.}
									12
									106
									26
									{ }
									81
									{Tuck: Return to Nottingham in disguise.}
									14
									106
									26
									{ }
									81
									{Much: 22 outlaws, charge the gates.}
									13
									67
									70
									25
								)
							)
						)
						(switch local2
							(10
								(gCurRoom newRoom: 177) ; willCas
							)
							(11
								(gCurRoom newRoom: 177) ; willCas
							)
							(12
								(gCurRoom newRoom: 177) ; willCas
							)
							(13
								(gCurRoom newRoom: 177) ; willCas
							)
							(14
								(gEgo put: 1 140) ; horn
								(HandsOn)
								(= gDisguiseNum 5) ; abbey monk
								(gCurRoom setScript: walkThePlank)
							)
							(0
								(= global146 local0)
								(= state 1)
								(self cue:)
							)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance rescueMarian1 of Script
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 39 self 80 {Tuck}) ; "I could scourge myself for giving away your disguises!"
			)
			(1
				(= ticks 10)
			)
			(2
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(SetMessageColor 0)
				(Say 1171 40 self 80 {Robin}) ; "Set aside your guilt. Even did I have those disguises, they would now be watching warily for them."
			)
			(3
				(= ticks 10)
			)
			(4
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 41 self 80 {John}) ; "It occurs to me that all the Sheriff's men and Abbot's Monks will be at the Witch's Court to watch the burning."
			)
			(5
				(= ticks 10)
			)
			(6
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(alanHead setScript: headShake)
				(alanHand setScript: handShake)
				(SetMessageColor 4)
				(Say 1171 42 self 80 {Alan}) ; "They may well suspect a rescue, if they've learned of Marian's connection with Robin."
			)
			(7
				(= ticks 10)
			)
			(8
				(alanHead setScript: 0)
				(alanHand setScript: 0)
				(SetMessageColor 0)
				(Say 1171 43 self 80 {Robin}) ; "Let me hear all your thoughts before I decide."
			)
			(9
				(= ticks 10)
			)
			(10
				(alanHead setScript: headShake)
				(alanHand setScript: alanHandShake)
				(SetMessageColor 4)
				(Say 1171 44 self 80 {Alan}) ; "Both the Sheriff and Abbot will be there, will they not?"
			)
			(11
				(= ticks 10)
			)
			(12
				(Say 1171 45 self 80 {Alan}) ; "Let us concentrate all our force not toward the Lady, as they expect, but towards taking them prisoner."
			)
			(13
				(= ticks 10)
			)
			(14
				(Say 1171 46 self 80 {Alan}) ; "Once we have such hostages, we can demand that Marian be set free and even guarantee us safe passage to the forest."
			)
			(15
				(= ticks 10)
			)
			(16
				(alanHead setScript: 0 setCycle: Beg)
				(alanHand setScript: 0 setCycle: Beg)
				(tuckHead setScript: tuckHeadShake)
				(tuckHand setScript: handShake)
				(SetMessageColor 3)
				(Say 1171 47 self 80 {Tuck}) ; "I would incite the mob to riot, for the Abbot is feared and hated by the common folk."
			)
			(17
				(= ticks 10)
			)
			(18
				(Say 1171 48 self 80 {Tuck}) ; "Set them to create confusion and draw the soldiers into the streets..."
			)
			(19
				(= ticks 10)
			)
			(20
				(Say 1171 49 self 80 {Tuck}) ; "... where we can attack in full force outside the Court while you slip inside and rescue your Lady."
			)
			(21
				(= ticks 10)
			)
			(22
				(tuckHead setScript: 0 setCycle: Beg)
				(tuckHand setScript: 0)
				(johnHead setScript: headShake)
				(johnHand setScript: johnHandShake)
				(SetMessageColor 1)
				(Say 1171 50 self 80 {John}) ; "My counsel is to try subterfuge."
			)
			(23
				(= ticks 10)
			)
			(24
				(Say 1171 51 self 80 {John}) ; "By whatever means you can, enter the Court secretly so that you can seize the Lady from the fire unhindered."
			)
			(25
				(= ticks 10)
			)
			(26
				(Say 1171 52 self 80 {John}) ; "When it seems certain you've found a way in, I'll lead a two-part attack through the town."
			)
			(27
				(= ticks 10)
			)
			(28
				(Say 1171 53 self 80 {John}) ; "Half our men from the north and half from the south converging upon the Court."
			)
			(29
				(= ticks 10)
			)
			(30
				(Say 1171 54 self 80 {John}) ; "I'll take your horn and when you hear me signal you upon it, you'll know the moment is upon you to act."
			)
			(31
				(= ticks 10)
			)
			(32
				(johnHead setScript: 0)
				(johnHand setScript: 0 setCycle: Beg)
				(willHead setScript: headShake)
				(SetMessageColor 2)
				(Say 1171 55 self 80 {Will}) ; "One strong wedge driving straight through the nearest town gate will serve us best, with you in the lead."
			)
			(33
				(= ticks 10)
			)
			(34
				(Say 1171 56 self 80 {Will}) ; "We'll cover you while you reach Marian and free her from the stake."
			)
			(35
				(= ticks 10)
			)
			(36
				(willHead setScript: 0)
				(muchHead setScript: headShake)
				(SetMessageColor 5)
				(Say 1171 57 self 80 {Much}) ; "Let's attack the soldiers and taunt them and then pretend to run away in all directions."
			)
			(37
				(= ticks 10)
			)
			(38
				(Say 1171 58 self 80 {Much}) ; "The soldiers will split up and run all over the town after us."
			)
			(39
				(= ticks 10)
			)
			(40
				(Say 1171 59 self 80 {Much}) ; "Then you, Robin, with maybe 5 men, can go after Marian while we keep the soldiers busy running after us."
			)
			(41
				(= ticks 10)
			)
			(42
				(muchHead setScript: 0)
				(self dispose:)
			)
		)
	)
)

