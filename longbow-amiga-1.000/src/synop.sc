;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 179)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use Game)
(use System)

(public
	synop 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(gSFX2 number: 916 loop: 1 play:)
	(+= gScore param1)
	((ScriptID 0 1) doit:) ; statLine
)

(procedure (localproc_1)
	(cond
		((<= gOutlaws 22)
			(AddOutlaws -7)
		)
		((<= gOutlaws 24)
			(AddOutlaws -5)
		)
		((<= gOutlaws 27)
			(AddOutlaws -3)
		)
		((<= gOutlaws 30)
			(AddOutlaws -2)
		)
		((<= gOutlaws 33)
			(AddOutlaws -1)
		)
		(else
			(AddOutlaws 0)
		)
	)
	((ScriptID 0 1) doit:) ; statLine
)

(procedure (localproc_2)
	(cond
		((<= gOutlaws 24)
			(AddOutlaws -6)
		)
		((<= gOutlaws 30)
			(AddOutlaws -5)
		)
		((<= gOutlaws 33)
			(AddOutlaws -4)
		)
		(else
			(AddOutlaws -2)
		)
	)
	((ScriptID 0 1) doit:) ; statLine
)

(procedure (localproc_3)
	(cond
		((<= gOutlaws 25)
			(AddOutlaws -7)
		)
		((<= gOutlaws 27)
			(AddOutlaws -8)
		)
		((<= gOutlaws 30)
			(AddOutlaws -6)
		)
		((<= gOutlaws 33)
			(AddOutlaws -5)
		)
		(else
			(AddOutlaws -3)
		)
	)
	((ScriptID 0 1) doit:) ; statLine
)

(procedure (localproc_4)
	(cond
		((<= gOutlaws 27)
			(AddOutlaws -8)
		)
		((<= gOutlaws 30)
			(AddOutlaws -9)
		)
		((<= gOutlaws 33)
			(AddOutlaws -7)
		)
		(else
			(AddOutlaws -5)
		)
	)
	((ScriptID 0 1) doit:) ; statLine
)

(instance synop of Rm
	(properties
		picture 803
		style 8
	)

	(method (init)
		(super init:)
		(= local1 0)
		(if (== gPrevRoomNum 176) ; robscrewed
			(= local1 1)
		)
		(self setScript: whatHappened)
	)

	(method (dispose)
		(DisposeScript 806)
		(super dispose: &rest)
	)
)

(instance whatHappened of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global146
					(10
						(AddOutlaws -2)
						(SetScore 200)
						(Say 1179 0 self) ; "We cleared the gates and slew many enemies. Will's plan was sound and our men, with Hal, Hob and Dicken running for their lives, raced into the gap we created. Alas, we lost two good men of the five who dared make the surprise attack from within."
					)
					(11
						(AddOutlaws -3)
						(SetScore 150)
						(Say 1179 1 self) ; "We drew many of the Sheriff's men outside and the killing seemed endless. Then we charged, myself in the lead spearheading the drive towards the gallows.  Barely in time we fought our way to that hideous post and freed Hal, Hob and Dicken. We retreated as the Sheriff's men recovered their wits. In all, we lost three brave men."
					)
					(12
						(AddOutlaws -5)
						(SetScore 50)
						(Say 1179 2 self) ; "Although the cover of fire created some confusion, there was less to burn than we had hoped inside that stone courtyard. The fighting was fierce and we were as hampered by the smoke as were our foes. We saved Hal, Hob and Dicken and escaped, but lost five men."
					)
					(13
						(AddOutlaws -7)
						(SetScore 25)
						(Say 1179 3 self) ; "The soldiers were quite put off at our mad charge and it seemed we would easily carry the day as we raced screaming like Picts and freed our friends from the gallows. But our foes were quick to recover when they saw our true numbers. The fight to retreat was slow and bloody and we were nearly lost. We escaped, but seven men died."
					)
					(20
						(AddOutlaws -2)
						(SetScore 200)
						(Say 1179 4 self) ; "We fired scores of arrows until we'd cleared a path for our men to retreat. Our men inside the courtyard struck. With Hal, Hob and Dicken free, they raced into the gap we created. But in the retreat, we lost two good men, though in sooth 'tis a miracle our losses were not greater."
					)
					(21
						(AddOutlaws -3)
						(SetScore 150)
						(Say 1179 5 self) ; "The pretense of a drunken brawl allowed us to draw out many of the Sheriff's men from within the Witch's Court. These we dispatched quietly until a larger force came out to see what was amiss. Then the battle began in earnest. I led a charge into the courtyard where we freed the three lads and began our retreat. In all, we lost three men."
					)
					(22
						(AddOutlaws -5)
						(SetScore 50)
						(Say 1179 2 self) ; "Although the cover of fire created some confusion, there was less to burn than we had hoped inside that stone courtyard. The fighting was fierce and we were as hampered by the smoke as were our foes. We saved Hal, Hob and Dicken and escaped, but lost five men."
					)
					(23
						(AddOutlaws -7)
						(SetScore 25)
						(Say 1179 3 self) ; "The soldiers were quite put off at our mad charge and it seemed we would easily carry the day as we raced screaming like Picts and freed our friends from the gallows. But our foes were quick to recover when they saw our true numbers. The fight to retreat was slow and bloody and we were nearly lost. We escaped, but seven men died."
					)
					(30
						(AddOutlaws 0)
						(SetScore 500)
						(Say 1179 24) ; "Little John's flanking attacks decimated the soldiers and cleared the way long enough to free Marian from the stake. Thanks to his bold attack and the element of surprise, we escaped with no loss of life."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(31
						(AddOutlaws -3)
						(SetScore 400)
						(Say 1179 13) ; "Will's plan was quick and brutal, but effective. I was able to rescue Marian at the cost of 3 men."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(32
						(AddOutlaws -5)
						(SetScore 300)
						(Say 1179 14) ; "Neither the Sheriff nor the Abbot remained more than a second once our attack began. A special force of guards spirited them away to safety. We had a pitched battle with those that remained. We won the day, but lost five men."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(34
						(AddOutlaws -6)
						(SetScore 100)
						(Say 1179 15) ; "Though many of the common folk did rally to our aid, it was scarcely enough. Only a small force of soldiers came to deal with it and though we dispatched them easily enough, it set off the alarm. We left a bloody path in our wake and while my men fought to cover me, I freed Marian from the stake. By the time we fought our way free, 6 brave men were dead."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(33
						(AddOutlaws -7)
						(SetScore 50)
						(Say 1179 16) ; "Alas, we lost 7 good men, though we fought like cornered animals. Our taunts did little except alert the soldiers to our presence and we were forced to make a direct frontal attack with no element of surprise. The fighting was merciless and the streets dark with blood before we escaped Nottingham town."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(40
						(AddOutlaws -2)
						(SetScore 500)
						(Say 1179 12) ; "Little John's flanking attacks decimated the soldiers and cleared the way long enough to free Marian from the stake. So efficient was his plan, we lost only 2 men, though we shall feel their loss dearly."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(41
						(AddOutlaws -3)
						(SetScore 400)
						(Say 1179 13) ; "Will's plan was quick and brutal, but effective. I was able to rescue Marian at the cost of 3 men."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(42
						(AddOutlaws -5)
						(SetScore 300)
						(Say 1179 14) ; "Neither the Sheriff nor the Abbot remained more than a second once our attack began. A special force of guards spirited them away to safety. We had a pitched battle with those that remained. We won the day, but lost five men."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(44
						(AddOutlaws -6)
						(SetScore 100)
						(Say 1179 15) ; "Though many of the common folk did rally to our aid, it was scarcely enough. Only a small force of soldiers came to deal with it and though we dispatched them easily enough, it set off the alarm. We left a bloody path in our wake and while my men fought to cover me, I freed Marian from the stake. By the time we fought our way free, 6 brave men were dead."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(43
						(AddOutlaws -7)
						(SetScore 50)
						(Say 1179 16) ; "Alas, we lost 7 good men, though we fought like cornered animals. Our taunts did little except alert the soldiers to our presence and we were forced to make a direct frontal attack with no element of surprise. The fighting was merciless and the streets dark with blood before we escaped Nottingham town."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(50
						(AddOutlaws -2)
						(SetScore 200)
						(Say 1179 12) ; "Little John's flanking attacks decimated the soldiers and cleared the way long enough to free Marian from the stake. So efficient was his plan, we lost only 2 men, though we shall feel their loss dearly."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(51
						(AddOutlaws -3)
						(SetScore 150)
						(Say 1179 13) ; "Will's plan was quick and brutal, but effective. I was able to rescue Marian at the cost of 3 men."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(52
						(AddOutlaws -5)
						(SetScore 75)
						(Say 1179 14) ; "Neither the Sheriff nor the Abbot remained more than a second once our attack began. A special force of guards spirited them away to safety. We had a pitched battle with those that remained. We won the day, but lost five men."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(54
						(AddOutlaws -6)
						(SetScore 50)
						(Say 1179 15) ; "Though many of the common folk did rally to our aid, it was scarcely enough. Only a small force of soldiers came to deal with it and though we dispatched them easily enough, it set off the alarm. We left a bloody path in our wake and while my men fought to cover me, I freed Marian from the stake. By the time we fought our way free, 6 brave men were dead."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(53
						(AddOutlaws -7)
						(SetScore 25)
						(Say 1179 16) ; "Alas, we lost 7 good men, though we fought like cornered animals. Our taunts did little except alert the soldiers to our presence and we were forced to make a direct frontal attack with no element of surprise. The fighting was merciless and the streets dark with blood before we escaped Nottingham town."
						(Say 1179 11 self) ; "Once we reached the edge of the forest, I parted ways with my men. They drew the attention of our pursuers and took them on a merry chase into Sherwood. Some instinct led me to the nearest place where I might tend to Marian, for I couldn't carry her much further."
					)
					(60
						(localproc_3)
						(if local1
							(Say 1179 23 self) ; "Our numbers were too small. Now they are even less and we've lost our one chance to gain the treasure. This is a grim and unhappy day."
						else
							(localproc_0 500)
							(AddRansom -15536)
							(Say 1179 19 self) ; "Though Little John's plan was not without merit, the Baron refused to consider surrender and we lost the advantage of surprise. The battle raged fiercely.  Too many died, for the Baron's soldiers fought to the last man.        We grieved for those we lost, but death is the fate that awaits all outlaws. At least they died fighting to save King Richard."
						)
					)
					(61
						(localproc_2)
						(if local1
							(Say 1179 23 self) ; "Our numbers were too small. Now they are even less and we've lost our one chance to gain the treasure. This is a grim and unhappy day."
						else
							(localproc_0 500)
							(AddRansom -15536)
							(Say 1179 18 self) ; "The ambush was effective. We took one man prisoner and released him unharmed, for he fought bravely.  How I would love to see the expression on the Abbot's face when the survivor arrives in Nottingham with the news that we have taken Prince John's treasure!"
						)
					)
					(62
						(localproc_4)
						(if local1
							(Say 1179 23 self) ; "Our numbers were too small. Now they are even less and we've lost our one chance to gain the treasure. This is a grim and unhappy day."
						else
							(localproc_0 500)
							(AddRansom -15536)
							(Say 1179 20 self) ; "I fear Alan will find little to sing about. The Baron scorned our challenge and fought to the last man. We lost many, many good men. Only the knowledge that this treasure can free the King eases the pain of their loss."
						)
					)
					(64
						(localproc_1)
						(localproc_0 500)
						(AddRansom -15536)
						(Say 1179 17 self) ; "Caught from both sides by surprise, the Baron and his men were quickly vanquished. Only two of the soldiers chose to surrender. We stripped them of armour and weapons and set them free. Truly, this has been a proud day in the history of the outlaws of Sherwood Forest!"
					)
					(65
						(AddOutlaws -7)
						(= ticks 6)
					)
				)
			)
			(1
				(cond
					((<= 30 global146 54)
						(gCurRoom newRoom: 210)
					)
					((<= global146 23)
						(gCurRoom newRoom: 250)
					)
					(else
						(gCurRoom newRoom: 160)
					)
				)
				(self dispose:)
			)
		)
	)
)

