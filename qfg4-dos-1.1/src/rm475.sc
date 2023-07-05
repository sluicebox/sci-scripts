;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 475)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm475 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-- temp0))
		(Palette 2 0 255 temp0) ; PalIntensity
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((++ temp0))
		(Palette 2 0 65 temp0) ; PalIntensity
		(Palette 2 86 255 temp0) ; PalIntensity
	)
)

(procedure (localproc_2)
	(gTheIconBar enable: 2)
	(gUser canInput: 1)
	(gTheIconBar advanceCurIcon:)
)

(instance rm475 of GloryRm
	(properties)

	(method (init)
		(gGlory handsOff:)
		(SetFlag 50)
		(gEgo x: 1000 y: 1000 init:)
		(if (not (IsFlag 300))
			(vDeck1 init:)
			(vDeck2 init:)
			(vDeck3 init:)
		)
		(theDeck init:)
		(proc0_16)
		(proc0_13)
		(if
			(not
				(OneOf
					gCurRoomNum
					551
					552
					553
					554
					555
					556
					557
					558
					559
					560
					561
					562
					563
					564
					565
					566
					567
					568
					569
					570
					571
					572
					573
					574
					575
					576
					577
					578
					579
					580
					581
					582
					583
					584
					585
					586
					587
					588
					589
					590
					591
					592
					593
					810 ; combat
					720
					800
					632
				)
			)
			(= global470
				(= gCombatMonsterNum
					(= global366 (= global462 (= global463 (= global464 0))))
				)
			)
		)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
		(UpdatePlane ((gCurRoom plane:) back: 29 picture: -1 yourself:))
		(RemapColors 2 254 50) ; ByPercent
		(cond
			((IsFlag 300)
				(SetFlag 301)
				(gCurRoom setScript: sFifthReading)
			)
			((IsFlag 299)
				(SetFlag 300)
				(gCurRoom setScript: sFourthReading)
			)
			((IsFlag 298)
				(SetFlag 299)
				(gCurRoom setScript: sThirdReading)
			)
			((IsFlag 297)
				(SetFlag 298)
				(gCurRoom setScript: sSecondReading)
			)
			(else
				(SetFlag 297)
				(gCurRoom setScript: sFirstReading)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if gNight
			(Palette 1 475 2) ; PalLoad
		)
	)

	(method (dispose)
		(ClearFlag 50)
		(super dispose:)
	)
)

(instance sFirstReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 1 6 1 0 self) ; "You listen to the words of the gypsy fortuneteller."
			)
			(2
				(localproc_2)
			)
			(3
				(switch gHeroType
					(0 ; Fighter
						(= local0 1044)
					)
					(1 ; Magic User
						(= local0 1001)
					)
					(3 ; Paladin
						(= local0 1002)
					)
					(2 ; Thief
						(= local0 1003)
					)
				)
				(= local2 1)
				(gEgo setScript: sShowCard self)
			)
			(4
				(local1 setPri: 0)
				(switch gHeroType
					(0 ; Fighter
						(gMessager say: 1 6 2 0 self) ; "The first card is the Significator. It is the symbol of the subject of the Reading."
					)
					(2 ; Thief
						(gMessager say: 1 6 3 0 self) ; "The first card is the Significator. It is the symbol of the subject of the Reading."
					)
					(1 ; Magic User
						(gMessager say: 1 6 4 0 self) ; "The first card is the Significator. It is the symbol of the subject of the Reading."
					)
					(3 ; Paladin
						(gMessager say: 1 6 5 0 self) ; "The first card is the Significator. It is the symbol of the subject of the Reading."
					)
				)
			)
			(5
				(gMessager say: 1 6 6 0 self) ; "The cards which surround the Significator represent the influences which affect your current situation."
			)
			(6
				(localproc_2)
			)
			(7
				(= local0 1011)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(8
				(local1 setPri: 0)
				(gMessager say: 1 6 7 0 self) ; "This card is the High Priestess. It is inverted, which means the meanings too are turned upside down."
			)
			(9
				(localproc_2)
			)
			(10
				(= local0 1012)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(11
				(local1 setPri: 1)
				(gMessager say: 1 6 8 0 self) ; "The Four of Coins is the card of the miser. This woman of your past has power, but uses it selfishly. This is a person who cares only of her own needs and wants, and does not care what she does or how she influences others."
			)
			(12
				(localproc_2)
			)
			(13
				(= local0 1007)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(14
				(local1 setPri: 0)
				(gMessager say: 1 6 9 0 self) ; "This is the inverted King of Coins. This is an old and vicious man, someone who is willing to use any means to attain his desires. Someone who is dangerous, and cannot be trusted or underestimated."
			)
			(15
				(localproc_2)
			)
			(16
				(= local0 1008)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(17
				(local1 setPri: 1)
				(gMessager say: 1 6 10 0 self) ; "The Devil! This is indeed an ill omen. This person is influenced by black magic, a man of power and dark desires. Yet the Devil is a sign of bondage and subservience, and this person has faced unexpected failure of some sort."
			)
			(18
				(localproc_2)
			)
			(19
				(= local0 1009)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(20
				(local1 setPri: 0)
				(gMessager say: 1 6 11 0 self) ; "The Queen of Cups -- again there is a female influencing your present. This is a woman of wisdom and love. She is kind, generous, and virtuous."
			)
			(21
				(localproc_2)
			)
			(22
				(= local0 1010)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(23
				(local1 setPri: 1)
				(gMessager say: 1 6 12 0 self) ; "The Star is a symbol of hope and spiritual influence. This is a woman in touch with her magical nature. She is gentle and loving, yet there is great strength within."
			)
			(24
				(localproc_2)
			)
			(25
				(= local0 1005)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(26
				(local1 setPri: 0)
				(gMessager say: 1 6 13 0 self) ; "The Queen of Swords is a woman of wit and skill. Yet she has suffered through terrible hardship, and she is marked by her suffering."
			)
			(27
				(localproc_2)
			)
			(28
				(= local0 1006)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(29
				(local1 setPri: 1)
				(gMessager say: 1 6 14 0 self) ; "The Moon is the card of deception. This woman is a deceiver, or is deceived by her own beliefs. This card also reveals the magical nature of the woman -- this is the strength which sustains her."
			)
			(30
				(localproc_2)
			)
			(31
				(= local0 1004)
				(gEgo setScript: sTurnTheCard self)
			)
			(32
				(gMessager say: 1 6 15 0 self) ; "The Void! About this card, I will not speak. I must meditate upon its meaning."
			)
			(33
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance sSecondReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 1 6 16 0 self) ; "The cards have again been shuffled and cut, so reveal now the subject of this Reading."
			)
			(2
				(localproc_2)
			)
			(3
				(= local0 1007)
				(= local2 1)
				(gEgo setScript: sShowCard self)
			)
			(4
				(local1 setPri: 0)
				(gMessager say: 1 6 17 0 self) ; "This Reading is of the ill-omened man. We shall learn more of his purpose and past."
			)
			(5
				(localproc_2)
			)
			(6
				(= local0 1005)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(7
				(local1 setPri: 0)
				(gMessager say: 1 6 19 0 self) ; "The Queen of Swords. Some time in the past, this man has met the mystery lady of your present. He may have been betrayed by her, or perhaps he is the betrayer of the lady."
			)
			(8
				(localproc_2)
			)
			(9
				(= local0 1013)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(10
				(local1 setPri: 1)
				(gMessager say: 1 6 20 0 self) ; "Ah, the Magician. The woman of mystery has magic also. One is the teacher of the other."
			)
			(11
				(localproc_2)
			)
			(12
				(switch gHeroType
					(0 ; Fighter
						(= local0 1044)
					)
					(1 ; Magic User
						(= local0 1001)
					)
					(3 ; Paladin
						(= local0 1002)
					)
					(2 ; Thief
						(= local0 1003)
					)
				)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(13
				(local1 setPri: 0)
				(gMessager say: 1 6 22 0 self) ; "Ah, this is your own influence upon the man. It seems you were as important to his history as he was to your own."
			)
			(14
				(localproc_2)
			)
			(15
				(= local0 1014)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(16
				(local1 setPri: 1)
				(gMessager say: 1 6 21 0 self) ; "Death, the card of transformation. You are the agent of this man's failure and loss. You altered his life irrevocably."
			)
			(17
				(localproc_2)
			)
			(18
				(= local0 1015)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(19
				(local1 setPri: 0)
				(gMessager say: 1 6 25 0 self) ; "In the present, the Eight of Swords. This is the card of conflict and domination."
			)
			(20
				(localproc_2)
			)
			(21
				(= local0 1016)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(22
				(local1 setPri: 1)
				(gMessager say: 1 6 26 0 self) ; "This is the card of conflict and struggle. This man does not take his bondage lightly."
			)
			(23
				(localproc_2)
			)
			(24
				(= local0 1017)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(25
				(local1 setPri: 0)
				(gMessager say: 1 6 27 0 self) ; "The Chariot represents triumph and vengeance. There is a strong need to gain control of the situation, of his life."
			)
			(26
				(localproc_2)
			)
			(27
				(= local0 1018)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(28
				(local1 setPri: 1)
				(gMessager say: 1 6 28 0 self) ; "This time the Devil is inverted. The meanings may differ, but this is a card that bodes no good whichever way it lies."
			)
			(29
				(localproc_2)
			)
			(30
				(= local0 1004)
				(gEgo setScript: sTurnTheCard self)
			)
			(31
				(gMessager say: 1 6 29 0 self) ; "The dark card of the Void. The influence of the Dark One overshadows all. No more shall be revealed, nor shall things be spoken at this time."
			)
			(32
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance sThirdReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 1 6 30 0 self) ; "Again, we ask the cards to reveal what was, what is, and what might be."
			)
			(2
				(localproc_2)
			)
			(3
				(= local0 1009)
				(= local2 1)
				(gEgo setScript: sShowCard self)
			)
			(4
				(local1 setPri: 0)
				(gMessager say: 1 6 31 0 self) ; "Ah, the mystery woman will now be revealed. Let us see that which was her distant past."
			)
			(5
				(localproc_2)
			)
			(6
				(= local0 1015)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(7
				(local1 setPri: 1)
				(gMessager say: 1 6 32 0 self) ; "In her past, she has been dominated and defeated. Her Significator card reinforces this impression of tragedy, of some cruel event that shaped her life."
			)
			(8
				(localproc_2)
			)
			(9
				(= local0 1020)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(10
				(local1 setPri: 0)
				(gMessager say: 1 6 33 0 self) ; "Strength is the card of courage and defiance. That which bound her in the past could not break her. She gained her freedom not through luck, but through her own actions."
			)
			(11
				(localproc_2)
			)
			(12
				(= local0 1001)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(13
				(local1 setPri: 1)
				(gMessager say: 1 6 34 0 self) ; "The sign of the Magus, the master of magic and self. She has great power and self-confidence."
			)
			(14
				(localproc_2)
			)
			(15
				(= local0 1018)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(16
				(local1 setPri: 0)
				(gMessager say: 1 6 35 0 self) ; "An inverted Death! This signifies stagnation. She has not grown beyond the past. Rather, she is trapped by immobility."
			)
			(17
				(localproc_2)
			)
			(18
				(= local0 1022)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(19
				(local1 setPri: 1)
				(gMessager say: 1 6 36 0 self) ; "This card shows that she is working towards some goal, some desire that has yet to be fulfilled."
			)
			(20
				(localproc_2)
			)
			(21
				(= local0 1023)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(22
				(local1 setPri: 2)
				(gMessager say: 1 6 37 0 self) ; "This is the card of love! Her present is influenced by affection for another."
			)
			(23
				(localproc_2)
			)
			(24
				(= local0 1024)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(25
				(local1 setPri: 0)
				(gMessager say: 1 6 38 0 self) ; "The World is the summation of all desires and goals. It can represent the reward of all one's actions, or the admiration of others."
			)
			(26
				(localproc_2)
			)
			(27
				(= local0 1025)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(28
				(local1 setPri: 1)
				(gMessager say: 1 6 39 0 self) ; "This is truly the card of illusionary goals. That which she seeks to gain is only a delusion."
			)
			(29
				(localproc_2)
			)
			(30
				(= local0 1004)
				(gEgo setScript: sTurnTheCard self)
			)
			(31
				(gMessager say: 1 6 40 0 self) ; "The Dark One plays a part in her present and future as well. Somehow her goals are linked to it."
			)
			(32
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance sFourthReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 1 6 41 0 self) ; "Again, the cards are prepared, and they shall reveal what they will."
			)
			(2
				(localproc_2)
			)
			(3
				(= local0 1009)
				(= local2 1)
				(gEgo setScript: sShowCard self)
			)
			(4
				(local1 setPri: 0)
				(gMessager say: 1 6 42 0 self) ; "The woman of loving shall be revealed. What may we now learn of her distant past?"
			)
			(5
				(localproc_2)
			)
			(6
				(= local0 1001)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(7
				(local1 setPri: 1)
				(gMessager say: 1 6 43 0 self) ; "This is the sign of magic and creativity. She, as the others who influence your life, has the power. She is one to whom magic has been the strongest influence upon her life. She is a master weaver of spells. What next can we learn?"
			)
			(8
				(localproc_2)
			)
			(9
				(= local0 1026)
				(= local2 2)
				(gEgo setScript: sShowCard self)
			)
			(10
				(local1 setPri: 2)
				(gMessager say: 1 6 44 0 self) ; "The Ace of Cups is the sign of overflowing joy and happiness. This is a woman who uses her power joyfully, giving gracefully and lovingly to others."
			)
			(11
				(localproc_2)
			)
			(12
				(= local0 1015)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(13
				(local1 setPri: 0)
				(gMessager say: 1 6 45 0 self) ; "Ah, your gentle woman, too, has been bound by something. A crisis has occurred, a defeat, or imprisonment by someone. What more can we learn?"
			)
			(14
				(localproc_2)
			)
			(15
				(= local0 1050)
				(= local2 3)
				(gEgo setScript: sShowCard self)
			)
			(16
				(local1 setPri: 1)
				(gMessager say: 1 6 46 0 self) ; "This is a sign of balanced force, a stalemate, of things not coming to a resolution."
			)
			(17
				(localproc_2)
			)
			(18
				(= local0 1027)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(19
				(local1 setPri: 0)
				(gMessager say: 1 6 47 0 self) ; "The Hanged Man is the symbol of sacrifice. The conflict in the past required this woman to give up something of great value. She has paid some great price, but the outcome is uncertain."
			)
			(20
				(localproc_2)
			)
			(21
				(= local0 1028)
				(= local2 4)
				(gEgo setScript: sShowCard self)
			)
			(22
				(local1 setPri: 1)
				(gMessager say: 1 6 48 0 self) ; "Alas, this card shows a tomb and someone at final rest. The woman's sacrifice was exile or possibly even death."
			)
			(23
				(localproc_2)
			)
			(24
				(= local0 1029)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(25
				(local1 setPri: 0)
				(gMessager say: 1 6 49 0 self) ; "The Dark One! This is the first time in these readings that the Darkness-which-lies-waiting has been active rather than merely a major influence."
			)
			(26
				(localproc_2)
			)
			(27
				(switch gHeroType
					(0 ; Fighter
						(= local0 1047)
					)
					(1 ; Magic User
						(= local0 1013)
					)
					(3 ; Paladin
						(= local0 1045)
					)
					(2 ; Thief
						(= local0 1046)
					)
				)
				(= local2 5)
				(gEgo setScript: sShowCard self)
			)
			(28
				(local1 setPri: 1)
				(gMessager say: 1 6 50 0 self) ; "You! Then you are not only a friend to the gypsies, but a great hero as well. Your destiny shall affect the world, my young friend."
			)
			(29
				(localproc_2)
			)
			(30
				(= local0 1004)
				(gEgo setScript: sTurnTheCard self)
			)
			(31
				(gMessager say: 1 6 51 0 self) ; "So, the Darkness still covers all. I had hoped that you might be spared... that you might not have to face the Darkness. But that is the way of the Hero, is it not? To face that which others fear and dread?"
			)
			(32
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance sFifthReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 1 6 52 0 self) ; "The Dark One is not something of which the gypsies speak. It was an ill day when our tribe traveled to this valley. We used to trade freely with the people of the castle years ago."
			)
			(2
				(= local0 1036)
				(gEgo setScript: sSetTheSignificator)
			)
			(3
				(local1 setPri: 0)
				(gMessager say: 1 6 53 0 self) ; "The first image I saw was that of a bone. I heard in my dreams the words, 'Bring me to life!' Let us see what the cards will say of this."
			)
			(4
				(= local0 1040)
				(gEgo setScript: sSetTheSignificator)
			)
			(5
				(local1 setPri: 1)
				(gMessager say: 1 6 54 0 self) ; "Somehow, I do not think this is a premonition, although it fits this situation. No, rather, I think this is a place. A tomb or cenotaph somewhere. What more can we learn?"
			)
			(6
				(= local0 1041)
				(gEgo setScript: sSetTheSignificator)
			)
			(7
				(local1 setPri: 2)
				(gMessager say: 1 6 55 0 self) ; "Of all the cards, this is the most watery. The tomb lies in or near some water. The lake, perhaps? No, rather I believe this is the swamp."
			)
			(8
				(gMessager say: 1 6 56 0 self) ; "But I sense that you already have the answer to that problem, so perhaps you know more of this than I."
			)
			(9
				(gEgo setScript: sFadeIt)
			)
			(10
				(gMessager say: 1 6 57 0 self) ; "In my dream, I seemed to move deeper into the darkness."
			)
			(11
				(= local0 1039)
				(gEgo setScript: sSetTheSignificator)
			)
			(12
				(local1 setPri: 0)
				(gMessager say: 1 6 58 0 self) ; "The next image I saw in my dream was that of blood. I felt my own blood go cold as it, too, spoke the words, 'Bring me to Life.' What do the cards say of this?"
			)
			(13
				(= local0 1031)
				(gEgo setScript: sSetTheSignificator)
			)
			(14
				(local1 setPri: 1)
				(gMessager say: 1 6 61 0 self) ; "The Tower. At all times, this is an ill-omen. I believe it represents a building of some sort. Let us learn more."
			)
			(15
				(= local0 1004)
				(gEgo setScript: sSetTheSignificator)
			)
			(16
				(local1 setPri: 2)
				(gMessager say: 1 6 59 0 self) ; "The Dark One! The building is dedicated to the Dark One itself. Somewhere within there lies the puzzle piece for the Blood."
			)
			(17
				(gMessager say: 1 6 60 0 self) ; "However, I sense that you already contain that piece."
			)
			(18
				(gEgo setScript: sFadeIt)
			)
			(19
				(gMessager say: 1 6 62 0 self) ; "In the dream, I seemed to get colder. I felt the icy breath of something huge before me. It got louder and stronger, and I seemed to be pulled by it."
			)
			(20
				(= local0 1035)
				(gEgo setScript: sSetTheSignificator)
			)
			(21
				(local1 setPri: 0)
				(gMessager say: 1 6 63 0 self) ; "Before me was the image of Breath. I felt myself pounded by the words, 'Bring me to Life!' I tried to run, but was caught in the wind. I... but the dream is over. Let us discover now what we can."
			)
			(22
				(= local0 1011)
				(gEgo setScript: sSetTheSignificator)
			)
			(23
				(local1 setPri: 1)
				(gMessager say: 1 6 64 0 self) ; "Ah, this one is not a place. No, I believe this is the woman (or perhaps, female is a better term) from your past. The self-centered one of power has the secrets to the Breath."
			)
			(24
				(gMessager say: 1 6 65 0 self) ; "But you already have dealt with her, for the puzzle piece of the Breath now lies with you."
			)
			(25
				(gEgo setScript: sFadeIt)
			)
			(26
				(gMessager say: 1 6 66 0 self) ; "Then in my dream, I felt myself blown along. All sound died, and I felt as if I had lost my body. I could not see, hear, smell, or feel anything."
			)
			(27
				(= local0 1049)
				(gEgo setScript: sSetTheSignificator)
			)
			(28
				(local1 setPri: 0)
				(gMessager say: 1 6 67 0 self) ; "Then I saw the symbol of the Senses. I was again overwhelmed by the words, 'Bring me to life.' Then the image faded. Shall we learn more?""
			)
			(29
				(= local0 1031)
				(gEgo setScript: sSetTheSignificator)
			)
			(30
				(gMessager say: 1 6 69 0 self) ; "Another place of Darkness. Some building, or perhaps only a structure. The next card may help us."
			)
			(31
				(= local0 1048)
				(gEgo setScript: sSetTheSignificator)
			)
			(32
				(local1 setPri: 1)
				(gMessager say: 1 6 68 0 self) ; "The Six of Swords? This is a sign of travel. Could it be a building far away? No, it cannot be."
			)
			(33
				(gEgo setScript: sFadeIt)
			)
			(34
				(gMessager say: 1 6 70 0 self) ; "To return to my dream... I soon could hear a tremendous pounding noise. I found myself swept forward, deeper into Darkness."
			)
			(35
				(= local0 1034)
				(gEgo setScript: sSetTheSignificator)
			)
			(36
				(local1 setPri: 0)
				(gMessager say: 1 6 71 0 self) ; "There before me was the symbol of the Heart. It, too, commanded, 'Bring me to Life!' What will the cards tell of this?"
			)
			(37
				(if (> [gEgoStats 12] 0) ; magic
					(= local0 1032)
				else
					(= local0 1043)
				)
				(gEgo setScript: sSetTheSignificator)
			)
			(38
				(local1 setPri: 1)
				(if (> [gEgoStats 12] 0) ; magic
					(gMessager say: 1 6 72 0 self) ; "This is an inverted Queen of Rods -- a jealous and deceitful woman, one who harbors no goodwill towards you. There are many women in your life right now. This one is not to be trusted."
				else
					(gMessager say: 1 6 74 0 self) ; "An inverted Death -- something or someone in stagnation. Not dead, yet not quite living, perhaps? Show the next card."
				)
			)
			(39
				(if (> [gEgoStats 12] 0) ; magic
					(= local0 1033)
				else
					(= local0 1012)
				)
				(gEgo setScript: sSetTheSignificator)
			)
			(40
				(local1 setPri: 2)
				(if (> [gEgoStats 12] 0) ; magic
					(gMessager say: 1 6 73 0 self) ; "This woman also has magic. But the Magician card is inverted. That implies that she is one who is willing to use her skills for bad purposes. She is opposed to you, and will not give this puzzle piece freely."
				else
					(gMessager say: 1 6 75 0 self) ; "The Four of Coins is the symbol of the miser and hoarder. Someone who will not let go of his possessions. Thus, together the cards speak of some Undead creature who jealously guards this puzzle piece."
				)
			)
			(41
				(gMessager say: 1 6 76 0 self) ; "I can tell that this part of the puzzle has already been gained by you. Let us continue."
			)
			(42
				(gCast eachElementDo: #hide)
				(localproc_0)
				(= seconds 2)
			)
			(43
				(gEgo setScript: sFadeIt)
			)
			(44
				(gMessager say: 1 6 77 0 self) ; "Again, the dream filled me with fear, and I struggled to awaken from its depths. I could not resist against its force, though, and found myself in the center of Darkness."
			)
			(45
				(= local0 1038)
				(gEgo setScript: sSetTheSignificator)
			)
			(46
				(local1 setPri: 0)
				(gMessager say: 1 6 78 0 self) ; "I saw before me this symbol, and heard the voice demand, 'Give me Life!' I awoke and lay trembling for the rest of the night."
			)
			(47
				(= local0 1042)
				(gEgo setScript: sSetTheSignificator)
			)
			(48
				(local1 setPri: 1)
				(gMessager say: 1 6 79 0 self) ; "The Hierophant -- the sign of a spiritual leader. This person is one who serves another willingly. There are many possible interpretations here; let us see what the next card will explain."
			)
			(49
				(= local0 1004)
				(gEgo setScript: sSetTheSignificator)
			)
			(50
				(local1 setPri: 2)
				(gMessager say: 1 6 80 0 self) ; "The Dark One. This is a priest of the Dark One, or someone trapped by the Dark One, or perhaps both. You will have to enter into Darkness itself to find this piece."
			)
			(51
				(gEgo setScript: sFadeIt)
			)
			(52
				(gMessager say: 1 6 81 0 self) ; "These last cards will reveal the point of all these visions and dreams."
			)
			(53
				(= local0 1029)
				(gEgo setScript: sSetTheSignificator)
			)
			(54
				(local1 setPri: 0)
				(gMessager say: 1 6 82 0 self) ; "The Dark One."
			)
			(55
				(= local0 1030)
				(gEgo setScript: sSetTheSignificator)
			)
			(56
				(local1 setPri: 1)
				(gMessager say: 1 6 84 0 self) ; "The Lady of Power and Magic."
			)
			(57
				(gEgo setScript: sFadeIt)
			)
			(58
				(gMessager say: 1 6 83 0 self) ; "The Dark One is the ultimate source of all the problems here. It drew those with ties to Dark Magic and those with ties to Good. It is a thing not of this world, yet linked to it."
			)
			(59
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance sSetTheSignificator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UpdatePlane ((gCurRoom plane:) back: 29 picture: -1 yourself:))
				((= local1 (aTurnCard new:))
					view: local0
					posn: 148 189
					init:
					moveSpeed: 0
					setPri: 12
					setStep: 30 10
					setScaler: Scaler 100 100 189 0
				)
				(= seconds 2)
			)
			(1
				(local1
					moveSpeed: 0
					setStep: 30 10
					setScaler: Scaler 100 35 189 110
					setMotion: MoveTo 145 110 self
				)
			)
			(2
				(= seconds 1)
			)
			(3
				((gCurRoom script:) cue:)
				(sSetTheSignificator dispose:)
			)
		)
	)
)

(instance sFadeIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #hide)
				(localproc_0)
				(= seconds 2)
			)
			(1
				(= ticks 12)
			)
			(2
				(localproc_1)
				(= seconds 2)
			)
			(3
				((gCurRoom script:) cue:)
				(self dispose:)
			)
		)
	)
)

(instance sShowCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((= local1 (aTurnCard new:))
					view: local0
					init:
					moveSpeed: 0
					setPri: 250
					setStep: 30 10
					setMotion: MoveTo 148 150 self
				)
			)
			(1
				(= seconds 5)
			)
			(2
				(switch local2
					(1
						(local1
							moveSpeed: 0
							setStep: 30 10
							setScaler: Scaler 100 35 150 110
							setMotion: MoveTo 145 110 self
						)
					)
					(2
						(local1
							moveSpeed: 0
							setStep: 30 10
							setScaler: Scaler 100 35 150 110
							setMotion: MoveTo 80 110 self
						)
					)
					(3
						(local1
							moveSpeed: 0
							setStep: 30 10
							setScaler: Scaler 35 100 170 150
							setMotion: MoveTo 144 170 self
						)
					)
					(4
						(local1
							moveSpeed: 0
							setStep: 30 10
							setScaler: Scaler 100 35 150 110
							setMotion: MoveTo 210 110 self
						)
					)
					(5
						(local1
							moveSpeed: 0
							setStep: 30 10
							setScaler: Scaler 100 35 150 50
							setMotion: MoveTo 144 50 self
						)
					)
				)
			)
			(3
				(sndPlace play: self)
			)
			(4
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance sTurnTheCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local1 (aTurnCard new:))
					view: local0
					init:
					moveSpeed: 0
					setStep: 60 60
					setMotion: MoveTo 148 150 self
				)
				(switch (vDeck1 x:)
					(255
						(vDeck1 x: 258)
						(vDeck1 x: 261)
						(vDeck1 x: 255)
					)
					(258
						(vDeck1 x: 261)
						(vDeck1 x: 255)
						(vDeck1 x: 258)
					)
					(261
						(vDeck1 x: 255)
						(vDeck1 x: 258)
						(vDeck1 x: 261)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance aTurnCard of Actor
	(properties
		x 253
		y 50
		priority 196
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 setScaler: Scaler 100 35 150 50)
	)
)

(instance vDeck1 of View
	(properties
		x 245
		y 50
		scaleX 46
		scaleY 46
		priority 152
		fixPriority 1
		view 1000
		signal 16385
		scaleSignal 1
	)
)

(instance vDeck2 of View
	(properties
		x 249
		y 50
		scaleX 46
		scaleY 46
		priority 153
		fixPriority 1
		view 1000
		signal 16385
		scaleSignal 1
	)
)

(instance vDeck3 of View
	(properties
		x 253
		y 50
		scaleX 46
		scaleY 46
		priority 154
		fixPriority 1
		view 1000
		signal 16385
		scaleSignal 1
	)
)

(instance theDeck of Feature
	(properties
		nsLeft 215
		nsTop 7
		nsRight 276
		nsBottom 55
		x 270
		y 190
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			((gCurRoom script:) cue:)
		)
	)
)

(instance sndPlace of Sound
	(properties
		number 969
	)
)

