;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	scrolls 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2)
	(gCast eachElementDo: #perform hideMe)
	(= local0 gCast)
	(= local1 gFeatures)
	(= local2 gAddToPics)
	(= local3 gMouseDownHandler)
	(= gMouseDownHandler (= gCast (= gFeatures (= gAddToPics 0))))
	(gCurRoom drawPic: param1 param2)
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	((= gMouseDownHandler newMDH) add: gFeatures)
)

(procedure (localproc_1)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures dispose:)
	(gMouseDownHandler dispose:)
	(gCurRoom drawPic: (gCurRoom picture:) 10)
	(= gCast local0)
	(= gFeatures local1)
	((= gAddToPics local2) doit:)
	(= gMouseDownHandler local3)
	(gCast eachElementDo: #perform showMe)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMDH of EventHandler
	(properties)
)

(instance hideMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (+ (param1 z:) 1000))
	)
)

(instance showMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance scrolls of Code
	(properties)

	(method (doit)
		((gTheIconBar at: 0) message: 11)
		(gTheIconBar disable: 3 4 5 6 7)
		(localproc_0 660 10)
		(if (gEgo has: 17) ; handScroll
			(emptyATP init:)
		)
		(gFeatures
			add:
				wholeRoom
				one
				two
				three
				four
				five
				six
				seven
				eight
				scroll1
				scroll2
				scroll3
				scroll4
				scroll5
				scroll6
				scroll7
				scroll8
				scroll9
				scroll10
				scroll11
				scroll12
				scroll13
				scroll14
				scroll15
			eachElementDo: #init
		)
	)

	(method (dispose)
		(localproc_1)
		((gTheIconBar at: 0) message: 1)
		(gTheIconBar enable: 3 6 7)
		(DisposeScript 660)
	)
)

(class scrollSlots of Feature
	(properties
		x 10
		y 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1660 0) ; "That slot is empty."
			)
			(3 ; Do
				(Say 1660 1) ; "There is nothing to take."
			)
			(11 ; iconMap
				(scrolls dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance one of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 63 40 67 40 79 50 62 63
			yourself:
		)
		(super init:)
	)
)

(instance two of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 63 83 78 94 62 108
			yourself:
		)
		(super init:)
	)
)

(instance three of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 62 126 65 128 68 136 73 138 76 135 78 137 66 146 62 146
			yourself:
		)
		(super init:)
	)
)

(instance four of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 75 146 82 140 91 146
			yourself:
		)
		(super init:)
	)
)

(instance five of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 131 145 138 139 149 146 130 146
			yourself:
		)
		(super init:)
	)
)

(instance six of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 109 118 114 121 109 121 108 124 113 130 124 130 135 137 124 146 99 146 88 136
			yourself:
		)
		(super init:)
	)
)

(instance seven of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 263 40 263 74 254 83 229 64 259 40
			yourself:
		)
		(super init:)
	)
)

(instance eight of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 138 89 115 71 133 57 135 60 151 58 164 68
			yourself:
		)
		(super init:)
	)
)

(instance scroll1 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 128 40 139 47 134 50 132 50 130 52 129 55 112 69 87 51 101 40
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 1)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll2 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 188 40 194 43 168 65 166 63 163 63 159 62 156 56 137 60 134 57 131 56 129 54 131 51 144 51 144 49 155 40
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 2)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll3 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 253 40 225 62 201 44 206 40
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 3)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll4 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 107 72 82 92 62 78 62 67 82 53
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 4)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll5 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 222 65 213 72 206 72 204 74 201 78 186 78 172 67 197 46
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 5)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 5)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll6 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 133 92 129 92 128 93 128 98 108 112 85 94 110 74
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 6)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 6)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll7 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 180 79 184 87 189 87 192 89 167 109 154 101 139 101 133 103 128 99 128 94 129 92 142 92 168 70
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 7)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 7)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll8 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 251 86 248 87 226 87 219 91 208 91 204 87 184 87 180 78 202 78 206 72 218 72 225 67
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 8)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 8)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll9 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 225 107 213 99 202 99 198 97 199 93 205 92 200 88 203 87 208 91 218 91 226 87 250 87
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 9)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 9)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll10 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 105 115 79 136 70 137 66 132 67 124 63 121 63 112 81 97
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 10)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll11 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 164 112 139 134 135 131 113 130 109 123 122 122 112 114 130 101 133 103 138 101 148 101
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 11)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 11)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll12 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 223 111 198 133 171 112 196 91 199 93 198 97 201 99 207 99
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 12)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 12)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll13 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 263 96 263 128 256 133 244 123 234 124 229 121 237 118 229 111 254 88
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 13)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 13)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll14 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 194 136 184 146 156 146 142 136 167 116
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (gEgo has: 17)) ; handScroll
					(gCurRoom setScript: showScroll 0 14)
				else
					(Say 1660 0) ; "That slot is empty."
				)
			)
			(3 ; Do
				(if (not (gEgo has: 17)) ; handScroll
					(gCurRoom setScript: showScroll 0 14)
				else
					(Say 1660 1) ; "There is nothing to take."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scroll15 of scrollSlots
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 231 119 229 121 233 125 238 124 253 137 242 146 203 146 199 142 200 136 225 113
			yourself:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: showScroll 0 15)
			)
			(3 ; Do
				(gCurRoom setScript: showScroll 0 15)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wholeRoom of Feature
	(properties
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; iconMap
				(scrolls dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scrollATP of View
	(properties
		x 35
		y 35
		view 771
		cel 3
		priority 15
	)
)

(instance emptyATP of View
	(properties
		x 152
		y 138
		view 660
		priority 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1660 0) ; "That slot is empty."
			)
			(3 ; Do
				(Say 1660 1) ; "There is nothing to take."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance showScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 14)
					(scrollATP cel: 5 z: 0 init:)
				else
					(scrollATP cel: 3 z: 0 init:)
				)
				(= cycles 1)
			)
			(1
				(switch register
					(1
						(SayModeless 1660 2) ; "This scroll contains a piece of history written by Paulus Orosius in the 5th century. It deals with Vesores, King of Egypt in 480 anno Domini."
						(SayModeless 1660 3) ; "Vesores declared war upon the Scythians and sent an envoy with the terms of submission. This only angered the Scythians."
						(SayModeless 1660 4) ; "Thinking Vesores both rich and stupid, the Scythians warned him to beware the uncertainties of war. Then, to forestall the attack on them, they marched forth and attacked Vesores."
						(SayModeless 1660 5) ; "They drove Vesores out of his own realm, but the Egyptian army forced them to retreat until they were too severely hampered by marches to continue their war."
						(SayModeless 1660 6) ; "Thereupon, the Scythians instead subdued Asia in war lasting 15 years. They were only forced to return to their homeland by the demands of their wives who threatened that if they did not return, the women would have children by men of other tribes."
					)
					(2
						(SayModeless 1660 7) ; "This scroll tells of Amazons. These were wives whose husbands were killed in war. Deeply affected, they rose up and killed all the men who remained, so that all the women would be equally affected."
						(SayModeless 1660 8) ; "They then turned and destroyed the enemy who had first slain their husbands. They burned off the right breasts of the girl children so that they would not be hampered in shooting the bow."
						(SayModeless 1660 9) ; "The Amazons had two queens, Marpesia and Lampeto, and they would draw lots to see who would go to war and who would remain to protect their home."
						(SayModeless 1660 10) ; "The Amazons conquered most of Europe, took many cities in Asia and founded other cities and became rich with plunder."
						(SayModeless 1660 11) ; "Such fear did they spread, that at last Hercules came with nine warships and assaulted them by surprise and massacred the two sister-Queens who ruled then, Antiope and Orithya."
						(SayModeless 1660 12) ; "Penthesilea then became Queen and fought heroically in the Trojan War. Thus reads the history of Paulus Orosius of the 5th century."
					)
					(3
						(SayModeless 1660 13) ; "This scroll describes the death of Attila, as written by Jordanes in the 6th century. Attila had an endless number of wives, as was the custom of his race."
						(SayModeless 1660 14) ; "But the excess of his indulgences in women, combined with too much wine, caused him to fall asleep upon his back, whereupon a bloody flux from his nose flowed into his throat and killed him."
						(SayModeless 1660 15) ; "The people of his race mourned him with great clamour. The men cut deep wounds into their faces so they would weep manly blood instead of tears."
						(SayModeless 1660 16) ; "The women wept and wailed and cut their hair. Yet so terrible was Attila, that his death can only be counted a blessing."
					)
					(4
						(SayModeless 1660 17) ; "From the Vita Karoli written by Einhard in the 9th century is a description of the habits of Charlemagne, ruler of the Franks."
						(SayModeless 1660 18) ; "It says that he was extremely temperate in partaking of food and drink, especially drink, and abhorred drunkenness, especially in himself or any of his family."
						(SayModeless 1660 19) ; "He ate only four courses in his daily meal and most dearly loved hunted meat roasted over a spit. During the meal, he would hear some sort of recital or entertainment of history and stories of ancient deeds."
						(SayModeless 1660 20) ; "Often in summer, after a light meal of fruit, he would sleep for two or three hours, for he would wake four or five times during the night."
						(SayModeless 1660 21) ; "He would admit friends, litigants and do other business even while dressing if the need was urgent. He knew many foreign tongues and was exceedingly skilled in Latin."
						(SayModeless 1660 22) ; "He valued scholars and had many learned teachers, and studied also rhetoric and astronomy. He would fill his bed with tablets and notebooks, attempting to learn the art of writing, though he advanced not far in this, having started late in life."
					)
					(5
						(SayModeless 1660 23) ; "Isidore of Seville of the 7th century wrote the 'Etymologies'. Herein is a writing upon the origin of glass."
						(SayModeless 1660 24) ; "It says glass came from Phoenicia next to Judea. There is a swamp from which comes the river Belus at the base of Mt. Carmel, and it flows for five miles into the sea."
						(SayModeless 1660 25) ; "The sands are washed clean from the river and where meals were prepared along the beach, and have no stones to place under utensils, they put down lumps of the mineral natron from their ships."
						(SayModeless 1660 26) ; "When the natron burned, it mixed with the sand and the new liquid flowed but was translucent. Soon, by experimentation with other substances, they developed this art and learned to melt copper and natron within and afterward to blow the lumps into shapes."
						(SayModeless 1660 27) ; "A legend says that a man brought a glass phial to Tiberius Caesar and threw it upon the ground. It did not shatter, but dented like metal. The man could hammer it back into shape like metal, yet it was glass."
						(SayModeless 1660 28) ; "Caesar asked if anyone else knew of this secret. The man said only he knew, whereupon Caesar had him decapitated, saying that if glass could be made that did not break, then gold and all metals would be worth no more than mud."
					)
					(6
						(SayModeless 1660 29) ; "Here is a description of a palace in Constantinople called Magnaura or Magna Aula meaning The Great Court."
						(SayModeless 1660 30) ; "The Emperor's chair within this palace was so constructed that it could be raised to a great height, even unto the ceiling, and lowered again."
						(SayModeless 1660 31) ; "Before the seat was a tree made of gilded bronze in whose branches were birds of gilded bronze which would utter notes to match their species."
						(SayModeless 1660 32) ; "Gigantic lions of gilded wood or bronze had tails that would lash the ground, jaws that opened to emit roars with quivering tongues."
						(SayModeless 1660 33) ; "This was written by Liudprand in his 'Antapodosis' in the 10th century."
					)
					(7
						(SayModeless 1660 34) ; "Herein is a most amazing account of the siege of Jerusalem. Christians, Greeks and Syrians were joined in the assault. Count Raymund, Duke Godefrey, also Robert Count of Normandy and Robert of Flanders were there."
						(SayModeless 1660 35) ; "They built a siege tower of small pieces of wood, all that was to be had, and bound it with leather thongs. They attacked with catapults and other contraptions and daring soldiers launched stones and arrows from the siege tower."
						(SayModeless 1660 36) ; "The Saracens within hurled from their slings torches and flaming brands soaked in oil and fat and thus many died upon both sides."
						(SayModeless 1660 37) ; "By noon of the day dedicated to Venus, the walls were breached and taken. Franks and others poured in and pursued the Saracens so that the enemy were driven to take refuge inside the holy places."
						(SayModeless 1660 38) ; "Within the Temple of Solomon, 10,000 Saracens were decapitated. Not a soul was spared, neither the women nor children."
						(SayModeless 1660 39) ; "The squires and poorest soldiers slit the bellies to search for jewels that had been swallowed, then burnt the bodies to thus search in the ashes for coins."
						(SayModeless 1660 40) ; "After the massacre, the Crusaders sacked the homes and took whatever they found there, rich or poor."
						(SayModeless 1660 41) ; "However, Count Raymund allowed Turks, Arabs and some 500 dark Ethiopians who had taken refuge in the Temple of David to depart alive, after leaving all their money within the citadel."
						(SayModeless 1660 42) ; "This is written by Geoffrey of Monmouth in his 'Historia Regum Britanniae'."
					)
					(8
						(SayModeless 1660 43) ; "William of Newburgh reports this, in the 'Historia Rerum Anglicarum'. It tells of a village at the mouth of the river Tweed in the northern regions."
						(SayModeless 1660 44) ; "A poor, but very evil man was buried, but at night would leave his grave and walk again. At his side would run a pack of barking dogs."
						(SayModeless 1660 45) ; "This sight and sound threw the people into great terror until he returned to his grave at dawn. Those unlucky to be caught would have their blood sucked by this creature."
						(SayModeless 1660 46) ; "The elders consulted, having heard other tales. Thus they hired ten bold young men to dig up the horrible corpse and chop it to pieces, then burn it."
						(SayModeless 1660 47) ; "Yet after it was destroyed, still a plague came and killed most of the people, and it was said the plague came from the walking dead."
					)
					(9
						(SayModeless 1660 48) ; "There is no notation of the writer of this scroll, yet it seems to speak of the history of this very fortress, turned monastery."
						(SayModeless 1660 49) ; "It speaks of the Ignis Fatuus, the will-o'- the-wisps, whose name means 'foolish fire'. These, it says, are the spirits of the dead, those who have drown'd in this fens."
						(SayModeless 1660 50) ; "It speaks also of The Guardians of the Gate and names them thusly: COGITO the Thinker, MALITIA the Malicious, INEPTUS the Foolish, VOCALIS the Speaker, IEIUNUS the Hungry, HILARIS the Jolly, and DEFORMIS the Ugly."
						(SayModeless 1660 51) ; "It ends with this: 'When you've touched the face of wisdom and the face of that which hungers, then will the fool's tongue be loosened and the path made clear.'"
					)
					(10
						(SayModeless 1660 52) ; "'Tis from an Anglo-Saxon Manual of Astronomy written but a century ago. It notes how the sea flows according to the rising of the moon, and that a tree cut down during a full moon will be harder against worm-eating than those cut down under a new moon."
						(SayModeless 1660 53) ; "It is not stars, but fire that falls from the sky, being fire which flies from heavenly bodies, for stars are fixed as God placed them in the firmament and cannot fall as long as this world endures."
						(SayModeless 1660 54) ; "Yet the moon, sun, evening and day star and three other stars are not fixed and move in their courses through the heavens. 'Septem planetae' these seven are called."
					)
					(11
						(SayModeless 1660 55) ; "This scroll speaks of what philosophers call atoms, which are so minute that they are indivisible and cannot be cut or divided or further broken down."
						(SayModeless 1660 56) ; "It is believed that these atoms sweep through the void of the universe, restlessly, going in all directions. Some ancient philosophers considered that all things-- grass, crops, trees, fire, water--spring from and are composed from these atoms."
						(SayModeless 1660 57) ; "In Greek 'tomos' means division; 'atomos' means indivisibility. Thus writes Isidore of Seville in the 'Etymologies' in the 7th century."
					)
					(12
						(SayModeless 1660 58) ; "Herein Sulpicius Severus of the 5th century writes of the power of St. Martin, who had gone to a pagan village and destroyed an ancient temple."
						(SayModeless 1660 59) ; "He began then to cut down a sacred pine tree, but the priests of the place objected. St. Martin explained that it was not holy, but the boldest of them challenged him."
						(SayModeless 1660 60) ; "He said 'If you have such faith in this God you worship, we will ourselves cut down this tree if you will allow yourself to be bound to the ground where it will fall, trusting only to your God to save you.'"
						(SayModeless 1660 61) ; "This St. Martin allowed and was made fast onto the ground where the pagans thought no doubt could be that the tree would fall. As they cut, they cried out joyously drawing a crowd."
						(SayModeless 1660 62) ; "St. Martin had no fear and waited patiently, with full faith in the Lord. As the tree fell crashing he lifted up his hand and the tree was driven back to fall in the opposite direction, nearly falling upon those who had cut it."
						(SayModeless 1660 63) ; "Thus were the pagans dismayed and the village brought under the salvation of God."
					)
					(13
						(SayModeless 1660 64) ; "The duties of the Cellarer of a monastery are described: he must be intelligent, mature of character, sober, have no greed nor be lazy or insulting, nor boisterous."
						(SayModeless 1660 65) ; "He should do nothing without the Abbot's orders and do whatever he is ordered. He should not offend the brothers, and should answer with humility and reason any untoward request."
						(SayModeless 1660 66) ; "He should care for children, guests, the sick and poor, for by his treatment of them will he be weighed on the Day of Judgement."
						(SayModeless 1660 67) ; "He is to look after the vessels and all sacred articles of the monastery. He is to give out equally and fairly the apportioned provisions to all brothers."
						(SayModeless 1660 68) ; "This is written by Benedict of Nursia in the 6th century in his 'Regula'."
					)
					(14
						(SayModeless 1660 69) ; "Ah, this fits the description Marian gave me."
						(SayModeless 1660 70) ; "I'll tuck it into my sleeve."
						(emptyATP init:)
						(gEgo get: 17) ; handScroll
						(SetScore 100 142)
					)
					(15
						(SayModeless 1660 71) ; "By Venatius Honorius Clementianus Fortunatus, taken from 'Opera: Patrologia Latina' in the 6th century."
						(SayModeless 1660 72) ; "'Tis a poem entitled 'Curse on the Chef!'"
						(SayModeless 1660 73) ; "'Blackhearted wretch, all caked in smoke, Face like a stewpot, smeared with soot, Like your utensils, filthy black, You three-legged pot, you slimy pan, You don't deserve these verses mine, I'll make a charcoal sketch instead, Whose shameful likeness will recall A pitch-blackhearted man withal.'"
						(SayModeless 1660 74) ; "And 'tis followed by 'Take It Easy' which reads as follows:"
						(SayModeless 1660 75) ; "'Drop business and lawsuits on the Palatine. This festive table bids you dine and wine. Let din of law and wrangling cases rest, The day is joyous. To relax is best.'"
					)
				)
				(= cycles 1)
			)
			(2
				(scrollATP dispose:)
				(self dispose:)
			)
		)
	)
)

