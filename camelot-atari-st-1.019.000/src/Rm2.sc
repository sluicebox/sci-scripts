;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm2 0
)

(synonyms
	(potion beaker)
	(read study)
	(box chest)
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
)

(instance merlin of Act
	(properties
		view 320
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((or (Said 'look/merlin') (MouseClaimed self event))
				(Print 2 0) ; "I am as I appear."
			)
			((Said 'ask/merlin/*<for')
				(Print 2 1) ; "If I mean for you to have it, you shall know."
			)
		)
	)
)

(instance leftBlock of Blk
	(properties
		top 185
		bottom 220
		right 135
	)
)

(instance rightBlock of Blk
	(properties
		top 185
		left 215
		bottom 220
		right 320
	)
)

(instance lid of Prop
	(properties
		y 149
		x 304
		view 102
	)
)

(instance mapFeat of Feature
	(properties
		y 94
		x 105
	)
)

(instance oneFlame of Prop
	(properties
		y 134
		x 132
		z 50
		view 102
		loop 2
	)
)

(instance candles of Prop
	(properties
		y 74
		x 233
		view 102
		loop 1
	)
)

(instance merlRect of Code
	(properties)

	(method (doit param1)
		(param1 brTop: (- (param1 y:) (+ (param1 yStep:) 4)))
		(param1 brBottom: (param1 y:))
		(param1 brLeft: (- (param1 x:) (param1 xStep:)))
		(param1 brRight: (+ (param1 x:) (param1 xStep:)))
	)
)

(instance Rm2 of Rm
	(properties
		picture 2
	)

	(method (init)
		(Load rsVIEW 102)
		(Load rsVIEW 320)
		(Load rsVIEW 15)
		(global59 brTop: 140)
		(if (not (gEgo has: 2)) ; lodestone
			(Load rsVIEW 33)
		)
		(super init:)
		(gEgo
			view: (if (IsFlag 3) 0 else 2)
			setLoop: -1
			init:
			observeBlocks: leftBlock rightBlock
		)
		(if (!= gPrevRoomNum 3)
			(gEgo loop: 3 posn: 172 186)
		else
			(gEgo loop: 3 posn: 123 129)
		)
		(lid setCel: 0 init: stopUpd:)
		(candles init: cycleSpeed: 2 setCycle: Fwd)
		(oneFlame init: cycleSpeed: 2 setCycle: Fwd)
		(merlin
			setLoop: 0
			setCel: 6
			posn: 196 133
			init:
			baseSetter: merlRect
			setScript: merlinActions
		)
		(proc0_13 256)
		(gAddToPics doit:)
		(gRmMusic number: 15 loop: -1 play:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said '/sorry')
					(Said 'give/apology')
					(Said 'apologize')
					(Said '/me/apologize')
					(Said '/me/sorry')
					(Said 'am/sorry')
					(Said 'forgive/me')
				)
				(if local3
					(Print 2 2) ; "That pathetic whine tells me you are sorry. But do not do it again!"
					(merlinActions changeState: 13)
				else
					(Print 2 3) ; "What for?"
				)
			)
			((and local3 (Said 'bark,bark'))
				(Print 2 4) ; "That did not sound like an apology."
			)
			((and local3 (Said 'bite'))
				(Print 2 5) ; "Try that and I shall turn you into a slug!"
			)
			(local3
				(Print 2 6) ; "I am waiting for your apology."
				(event claimed: 1)
			)
			((or (Said 'talk[/merlin]') (Said 'greet'))
				(cond
					(local3
						(Print 2 7) ; "You attempt a whine, but Merlin just sneers at you."
					)
					((and (IsFlag 3) (IsFlag 0) (IsFlag 1) (IsFlag 2))
						(Print 2 8) ; "The search for the Grail will be long and difficult. Though I will not physically travel with you, my spirit will be with you to guide and advise as I am able."
						(Print 2 9) ; "Choose carefully where your search will take you, for once you leave Camelot, you may not return."
					)
					((and (IsFlag 3) (IsFlag 0) (IsFlag 2))
						(Print 2 10) ; "Arthur, might it not be wise to make your farewell to Gwenhyver? Let it be so before I impart what you must know for the journey."
					)
					((and (IsFlag 3) (IsFlag 1) (IsFlag 2))
						(Print 2 11) ; "You are nearly ready, but on a journey such as this you will require money. I will await you while you visit the Treasury."
					)
					((and (IsFlag 0) (IsFlag 1) (IsFlag 2))
						(Print 2 12) ; "Your clothing will not do for a long journey. And what of Excaliber? Truly, I have much to tell you, but not until you are fully prepared."
					)
					((and (IsFlag 3) (IsFlag 0) (IsFlag 1))
						(Print 2 13) ; "Surely you would not dream of beginning a journey of such magnitude without the blessings of the gods? See to this, then return."
					)
					(
						(or
							(and (IsFlag 3) (IsFlag 0))
							(and (IsFlag 1) (IsFlag 2))
						)
						(Print 2 14) ; "Only half your preparations are complete. Return to me when you are in complete readiness."
					)
					((or (IsFlag 3) (IsFlag 0) (IsFlag 1) (IsFlag 2))
						(Print 2 15) ; "Your preparations are only begun. Finish what you must do. Then I will have more to tell you."
					)
					(else
						(Print 2 16) ; "There is much I must tell you before you leave, but first, you have other preparations to make."
						(Print 2 17) ; "When you are more fully prepared, return to this room. I will await you."
					)
				)
			)
			((Said '/man')
				(Print 2 18) ; "I am no mere man. I am Merlin."
			)
			((Said 'thank')
				(Print 2 19) ; "You are most welcome."
			)
			((or (Said 'love<does<guenevere') (Said 'ask//love'))
				(Print 2 20) ; "Ah...hrmm....I am not the one to ask, Arthur. I know much of the world, but little about women."
				(Print 2 21) ; "It is, ahem, virgin territory for me. So to speak."
			)
			(
				(or
					(Said 'read/document,translation')
					(Said 'ask//translation,margin,scribble')
				)
				(if (gEgo inRect: 185 141 233 157)
					(SetScore 226 1 1)
					(Print 2 22) ; "According to the writer of this scroll, a mule is of great value in Jerusalem. The writer says, 'so great is the value of a mule that is sure of foot and gentle of nature that it is above all the gold and treasures of the earth.' Sounds a bit exaggerated to me, but that is the gist of it."
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'consult,read,open/book')
				(Print 2 23) ; "My books are not for you to touch. However, feel free to consult your own Liber ex Doctrina (known in the vulgar as the Book of Lore) whenever you like."
			)
			((or (Said 'look,read/chart') (OnButton event 81 57 123 109))
				(if (not (gEgo inRect: 75 128 135 134))
					(merlinActions changeState: 2)
				else
					(HandsOff)
					(SetScore 224 1 1)
					(gCurRoom newRoom: 3)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((or (Said '/experiment') (Said '//experiment'))
						(Print 2 24) ; "I seek the ultimate answer to life, the universe and everything."
					)
					((Said '//curse')
						(Print 2 25) ; "Your land is cursed and only the Grail can cure it."
					)
					(
						(or
							(Said '/labarum')
							(Said '//labarum')
							(Said '/design<mithra')
							(Said '//design<mithra')
							(and (Said '//mithra>') (Said '/design'))
						)
						(SetScore 231 1 1)
						(Print 2 26) ; "This symbol, the labarum, was commonly used by Roman soldiers with whom the worship of Mithras was extremely popular."
					)
					(
						(or
							(Said '/design<venus')
							(Said '//design<venus')
							(and (Said '//venus>') (Said '/design'))
						)
						(SetScore 231 1 1)
						(Print 2 27) ; "The circle with descending cross is the symbol of the goddess, Venus. She is mentioned, I believe, in your Liber ex Doctrina."
					)
					(
						(or
							(Said '/carpet/floor')
							(Said '/carpet<(round,big)')
							(Said '//carpet<(round,big)')
							(and
								(& (gEgo onControl:) $0008)
								(or
									(Said '<down[/!*]')
									(Said '/<down[/!*]')
									(Said '/carpet')
									(Said '//carpet')
								)
							)
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (OnControl CONTROL (event x:) (event y:)) $0008)
							)
						)
						(event claimed: 1)
						(SetScore 231 1 1)
						(global59 brTop: 100)
						(Print 2 28) ; "This rug contains mystic symbols, primarily the pentangle - the five-pointed star. Because it is made of a single unbroken line, it affords strong protection from spirits who cannot find a place to enter in."
						(global59 brTop: 140)
					)
					(
						(or
							(Said '/carpet<(square,little)')
							(Said '//carpet<(square,little)')
							(and
								(& (gEgo onControl:) $0004)
								(or
									(Said '<down[/!*]')
									(Said '/<down[/!*]')
									(Said '/carpet')
									(Said '//carpet')
								)
							)
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (OnControl CONTROL (event x:) (event y:)) $0004)
							)
						)
						(event claimed: 1)
						(SetScore 231 1 1)
						(Print 2 29) ; "There is a decorative pattern in the small rug."
					)
					((or (Said '/design') (Said '//design'))
						(SetScore 231 1 1)
						(Print 2 30) ; "There are a number of symbols in my room. Upon the tapestry is a fylfot and labarum, the symbol of Mithras. Upon the small square rug is another fylfot. Upon the large round rug is a pentacle and the symbol of Venus and a few others not worth mentioning."
					)
					((Said '<down[/!*]')
						(Print 2 31) ; "There are two rugs upon my floor."
					)
					(
						(or
							(Said '/ceiling,beam')
							(Said '//ceiling,beam')
							(Said '/up')
						)
						(Print 2 32) ; "The beams are part of the roof structure of this tower."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
						)
						(Print 2 33) ; "As you see, my room is quite full.  Take care that you do not disturb any of the objects within."
					)
					((OnButton event 218 110 240 124)
						(Print 2 34) ; "The scroll is written in ancient Aramaic which I am attempting to decipher. It seems to be a dissertation upon the value of mules."
					)
					(
						(Said
							'ask//jute,saxon,celt,angle,roman,pict,pict,scot,scot,tribe'
						)
						(Print 2 35) ; "England is a land of many tribes: Celts from Eire to the west and untamed Bretogne to the east, Jutes and Angles and Saxons settled in the south and east, wild Picts and Scots to the north, but alas, little is left of the conquering Romans."
					)
					(
						(or
							(Said
								'/document,lettering,aramaic,lettering,translation,margin,scribble'
							)
							(Said
								'//document,lettering,aramaic,lettering,translation,margin,scribble'
							)
						)
						(SetScore 225 1 1)
						(Print 2 36) ; "The scroll is from Jerusalem, written in Aramaic. You may read my translation of it, scribbled there in the margins."
					)
					((or (Said '/ass,charger') (Said '//ass,charger'))
						(Print 2 37) ; "Both your horse and a pack mule are being readied for your journey."
					)
					((Said '//chart')
						(SetScore 224 1 1)
						(merlinActions changeState: 2)
					)
					(
						(or
							(Said '/table')
							(Said '//table')
							(OnButton event 62 113 145 123)
						)
						(Print 2 38) ; "Here I conduct my delicate experiments in alchemy. The table is covered with beakers and flasks."
					)
					(
						(or
							(Said '/desk')
							(Said '//desk')
							(OnButton event 208 109 258 131)
						)
						(Print 2 39) ; "Upon my desk is a scroll recently brought to me from the Far East."
					)
					((Said '//jerusalem')
						(Print 2 40) ; "It is in the Far East, a very long way from here."
					)
					(
						(or
							(Said '/bowl,sulfur,mercury,arsenic')
							(Said '//bowl,sulfur,mercury,arsenic')
						)
						(Print 2 41) ; "I have bowls of elements used in my alchemy experiments. They contain such things as sulfur, arsenic and mercury."
					)
					((or (Said '/floor') (Said '//floor'))
						(Print 2 31) ; "There are two rugs upon my floor."
					)
					(
						(or
							(Said '/bookshelf,bookcase,cabinet,book')
							(Said '//bookshelf,bookcase,cabinet,book')
							(OnButton event 154 72 191 128)
						)
						(Print 2 42) ; "That is a small dragon's skull and a large crystal on top of the shelves. My books fill the shelves below. The other objects are no affair of yours."
					)
					((or (Said '/crystal') (Said '//crystal'))
						(Print 2 43) ; "It is simply a large and beautiful chunk of quartz, nothing more."
					)
					(
						(or
							(Said
								'look/herb,plant,mint,basil,marjoram,sage,bay'
							)
							(OnButton event 62 46 76 85)
						)
						(Print 2 44) ; "I dry herbs for both medicinal and culinary purposes.  If you truly wish to know more, please feel free to ask about them."
					)
					((Said '//herb,plant,mint,basil,marjoram,sage,bay')
						(global59 brTop: 70)
						(Print 2 45) ; "There is mint, which some believe can cure the bite of mad dogs. It comes from the legend of Minthe, a river nymph."
						(Print 2 46) ; "Pluto, lord of the underworld, made love to her, whereupon Pluto's jealous queen, Proserpine, changed Minthe into a plant."
						(Print 2 47) ; "And basil, which the untutored mistakenly believe causes scorpions to breed. In India, it is sacred to the gods Vishnu and Krishna. Delicious with beans, peas and other vegetables."
						(Print 2 48) ; "And marjoram, thought useful in healing wounds and many other illnesses, though I like its delicate flavor with fowl and in sausages."
						(Print 2 49) ; "And sage, which the Egyptians believe will make women fertile, and others think it gives immortality. Personally, I like the flavor it imparts to beer and sausages."
						(Print 2 50) ; "And no collection would be complete without bay. To the Greeks and Romans it was the laurel and they would crown their victors with laurel wreaths."
						(Print 2 51) ; "Young girls have been known to burn leaves to make lovers return to them. Prophets, diviners and the priests of Apollo considered it to have magical properties. The dry leaves make an excellent flavoring in stews."
						(global59 brTop: 140)
					)
					((or (Said '/pentacle,star') (Said '//pentacle,star'))
						(Print 2 52) ; "The pentangle, the five-pointed star, is considered strong protection from spirits who cannot find a place to enter in because it is made of a single unbroken line."
					)
					(
						(or
							(Said '/tapestry')
							(Said '//tapestry')
							(Said '/carpet/wall')
							(and
								(gEgo inRect: 239 147 318 188)
								(== (gEgo loop:) 0)
								(or (Said '/carpet') (Said '//carpet'))
							)
							(OnButton event 286 29 312 136)
						)
						(Print 2 53) ; "In the center is a labarum, the symbol of Mithras. The circle with the descending cross is the symbol of Venus."
					)
					((or (Said '/carpet') (Said '//carpet'))
						(Print 2 54) ; "Which rug?"
					)
					(
						(or
							(Said '/candelabra')
							(Said '//candelabra')
							(OnButton event 220 65 247 85)
							(OnButton event 129 75 136 103)
						)
						(Print 2 55) ; "I am sure you have seen enough candles in your life to realize that mine are no different."
					)
					(
						(or
							(Said '/pot')
							(Said '//pot')
							(OnButton event 24 127 44 145)
							(OnButton event 42 144 75 167)
						)
						(Print 2 56) ; "It is a lovely, but empty pot."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 25 45 37 108)
							(OnButton event 246 59 261 115)
						)
						(Print 2 57) ; "From either window you see the grounds and outer bastion of Camelot."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 2 58) ; "Upon one wall are drying herbs, a map of Britain and Ireland. Upon the other wall is my sword and a tapestry."
					)
					((or (Said '/potion,jar') (Said '//potion,jar'))
						(Print 2 59) ; "I use it for my experiments in alchemy in which I seek to unravel the mysteries of the elements and life itself."
					)
					(
						(or
							(Said '/box')
							(Said '//box')
							(OnButton event 259 135 305 160)
						)
						(cond
							((gEgo has: 2) ; lodestone
								(Print 2 60) ; "You have kindly closed it for me."
							)
							((not (lid cel:))
								(Print 2 61) ; "That is my personal chest. I keep various odds and ends in there. Look inside, if you like."
							)
							(else
								(Print 2 62) ; "The other items are personal mementos and do not concern you. Do not touch them."
							)
						)
					)
					((or (Said '/memento') (Said '//memento'))
						(if (lid cel:)
							(Print 2 63) ; "We have no time to waste on trivia. Take the lodestone and turn your attention to your mission."
						else
							(Print 2 64) ; "I have many mementos, but you have no time to waste on trivia."
						)
					)
					((or (Said '/lodestone') (Said '//lodestone'))
						(cond
							((gEgo has: 2) ; lodestone
								(Print 2 65) ; "These mysterious stones may come from the stars.  Always some part of a lodestone will point to true north. It is therefore a very useful thing to have on a long journey."
							)
							((lid cel:)
								(Print 2 66) ; "If you take it with you, you can look at it all you like."
							)
							(else
								(Print 2 67) ; "Ah, so glad you reminded me. Did I put it on the....nay...perhaps it is on top of....nay."
								(Print 2 68) ; "Forgive me, Arthur. I seem to have forgotten where I put it. It must be around here somewhere."
							)
						)
					)
					(
						(or
							(Said '/blade')
							(Said '//blade')
							(OnButton event 265 75 281 118)
						)
						(Print 2 69) ; "That is my sword and perfectly ordinary. My weapons are of a less physical nature."
					)
					((or (Said '/weapon') (Said '//weapon'))
						(Print 2 70) ; "That is rather a vague request. There are many kinds of weapons, yet knowledge can be the most potent weapon of all."
					)
					((or (Said '/skull,george') (Said '//skull,george'))
						(Print 2 71) ; "It is the skull of a small dragon, a gift from St. George."
					)
					(
						(or
							(Said '/chair')
							(Said '//chair')
							(OnButton event 201 124 227 148)
						)
						(Print 2 72) ; "Aye, that is where I sit to study my scrolls and books."
					)
					((or (Said '/charger,ass') (Said '//charger,ass'))
						(Print 2 73) ; "Here? Are you sure you are in your right mind?"
					)
					((or (Said '/dog') (Said '//dog'))
						(Print 2 74) ; "What dog? I keep no dog."
					)
					((or (Said '/object') (Said '//object'))
						(Print 2 75) ; "I have a cluttered room, never enough space for everything."
						(Print 2 76) ; "I have my table of beakers and flasks, my shelves of books and also a small dragon skull and a large crystal, a map of your kingdom, my desk with a scroll I am studying upon it, my personal chest, and various other items."
					)
					((Said 'look>') 0)
					((Said '//alchemy')
						(Print 2 77) ; "It is the study of the nature of elements, their interactions and transmutations. The name "alchemy" traces back to "Khemennu" which means "Land of the Moon", an ancient name for Egypt."
						(Print 2 78) ; "The Arabs learned of alchemy from the Egyptians, though also at the same time it was developed in China. However, the best tract I have read to date is by the Arab scholar, Jabir ibn Hayyam, for the Arabs are quite advanced in this science."
					)
					((Said '//advice')
						(Print 2 79) ; "Ask me not for advice in love, for I know little of women. Ask me not for advice about battle or war, for you know more than I of these matters."
						(Print 2 80) ; "Ask me not for advice about the obvious, for I am short-tempered. But if you seek advice about that which is mystic, obscure, arcane, or simply puzzling, then I shall do my best to help you."
					)
					((Said '//vision')
						(if (IsFlag 6)
							(Print 2 81) ; "It was a reminder that your moral and spiritual choices during your search will be as important as finding the Grail itself."
						)
						(if (IsFlag 5)
							(Print 2 82) ; "It is your sacred duty, as vital as the search for the Grail itself, that you find and rescue your three Knights."
						)
						(if (and (not (IsFlag 6)) (not (IsFlag 5)))
							(Print 2 83) ; "If you seek visions, you must go to the Chapel of the Two Gods."
						)
					)
					((or (Said '/grail') (Said '//grail'))
						(SetScore 227 1 1)
						(Print 2 84) ; "I can add nothing to what is written in your Liber ex Doctrina. You should have it with you at all times."
					)
					((or (Said '/gawain') (Said '//gawain'))
						(SetScore 228 1 1)
						(Print 2 85) ; "I believe the Treasurer is a good friend of Sir Gawaine and would have the latest news, if any."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(SetScore 229 1 1)
						(Print 2 86) ; "I do not wish to be indelicate, but the Queen might be the best person to ask."
					)
					((or (Said '/galahad') (Said '//galahad'))
						(SetScore 230 1 1)
						(Print 2 87) ; "He is very popular among your guards and they would be first to hear rumour of him."
					)
					((or (Said '/guenevere') (Said '//guenevere'))
						(Print 2 88) ; "She is usually to be found in her bower about this time of day."
					)
					((Said '//enchantment')
						(Print 2 89) ; "What would you have me tell you? You are a warrior, a man of the real world. You must rely upon your wits, skill, strength and virtue of character to combat any magick that you might encounter."
					)
					((Said '//guard')
						(Print 2 90) ; "I am sure you can find one of your own guards in your own stronghold."
					)
					((or (Said '/treasurer') (Said '//treasurer'))
						(Print 2 91) ; "He is where a Treasurer usually is. In the Treasury."
					)
					((Said '//christ')
						(Print 2 92) ; "Worship of the Christ god arose in the Far East about 700 years ago and has spread west ever since. To some he is a prophet, to others the son of God. He preached much of love, of compassion, and forgiveness for the sins of others."
					)
					((Said '//mithra')
						(Print 2 93) ; "Mithras is a warrior-god which only men are allowed to worship and in great secret. He was most popular among the Roman soldiers who brought this worship with them to our island centuries ago."
					)
					((Said '//glastenbury')
						(Print 2 94) ; "Glastonbury Tor has been a sacred hill for centuries. The legend of Joseph of Arimathea claims the Grail is hidden there."
						(SetScore 306 1 1)
					)
					((Said '//ot,moor')
						(Print 2 95) ; "It is a body of water to the north where currently the Lady of the Lake dwells."
						(SetScore 307 1 1)
					)
					((Said '//hampton')
						(Print 2 96) ; "It is your major port in the south where you must go to take the ship to other lands."
						(SetScore 308 1 1)
					)
					((Said '//perilous[<forest]')
						(Print 2 97) ; "This dark and dangerous forest borders Glastonbury Tor and you must pass through it to reach the sacred hill."
					)
					((Said '//forest,adjust,avebury')
						(Print 2 98) ; "If you wish to know more about that place, study the map, and I shall instruct you."
					)
					((Said '//merlin')
						(Print 2 0) ; "I am as I appear."
					)
					((Said '//minthe,apollo,greek,roman')
						(Print 2 99) ; "Let us leave discussion of that for another time."
					)
				)
			)
			((Said 'sat/chair,box')
				(Print 2 100) ; "I know you would not be so rude."
			)
			((or (Said 'bye') (Said '/bye'))
				(Print 2 101) ; "Say rather godspeed, for I shall be with you in spirit-voice throughout your mission."
			)
			((or (Said 'godspeed') (Said '/godspeed'))
				(Print 2 102) ; "Aye, may the god you worship speed you to your destiny, Arthur."
			)
			((Said 'close/box,lid')
				(if (lid cel:)
					(gEgo setScript: CloseChest)
				else
					(Print 2 103) ; "Use your eyes, Arthur, it's already closed."
				)
			)
			((or (Said 'open/box') (Said 'lift/lid'))
				(cond
					((gEgo has: 2) ; lodestone
						(Print 2 104) ; "You have taken the only thing I wish you to have."
					)
					((lid cel:)
						(Print 2 105) ; "Use your eyes, Arthur. It IS open."
					)
					((not (gEgo inRect: 220 150 310 183))
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(gEgo setScript: OpenChest)
					)
				)
			)
			((Said 'get,remove/lodestone')
				(cond
					((gEgo has: 2) ; lodestone
						(Print 2 106) ; "It is in your possession."
					)
					((not (lid cel:))
						(Print 2 107) ; "Hmmm....it is around here somewhere. I simply cannot remember where I put it."
					)
					((not (gEgo inRect: 245 150 310 170))
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(SetScore 0 0 3)
						(gEgo get: 2 setScript: CloseChest) ; lodestone
					)
				)
			)
			((Said 'get,remove,poke,move>')
				(cond
					((Said '/chart')
						(Print 2 108) ; "It is attached to my wall."
					)
					(
						(Said
							'/object,potion,skull,crystal,document,blade,box,book,candelabra,herb,mint,basil,marjoram,sage,bay,pot,bowl,sulfur,arsenic,mercury'
						)
						(switch local1
							(0
								(if (gEgo has: 2) ; lodestone
									(Print 2 109) ; "King you may be, but do not lay hands upon that which belongs to Merlin the enchanter."
								else
									(Print 2 110) ; "The lodestone is the only object in this room which you may take. The rest belongs to Merlin the Enchanter and you are not to lay hands upon them."
									(if (not (IsFlag 14))
										(Print 2 111) ; "But....you must excuse an old man. I have forgotten where I put the lodestone. It is around here somewhere."
									)
									(Print 2 112) ; "Search if you like, but DO NOT TOUCH ANYTHING ELSE!"
								)
							)
							(1
								(Print 2 113) ; "By the Red Dragon, I will not warn you again! Do not lay hands upon anything that is not meant for you."
							)
							(else
								(merlinActions changeState: 6)
							)
						)
						(++ local1)
					)
				)
			)
			((Said 'kill,cut,hit,hit,kill,goose/merlin')
				(Print 2 114) ; "You were thinking of spending the rest of your life as a toad, perhaps?"
			)
			((Said 'fuck,crescent/merlin')
				(Print 2 115) ; "My darling boy, I did not know you cared."
			)
			((Said 'kiss/merlin')
				(Print 2 116) ; "I never kiss men with beards."
			)
			((Said 'shave/beard')
				(Print 2 117) ; "What a completely ridiculous notion."
			)
			((Said 'smell')
				(Print 2 118) ; "I enjoy the mingling of scents: the fumes of alchemy, the herbs drying upon my wall, burning candles, even the musty odor of the old scroll I am studying."
			)
			((Said 'give,show/rose')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(Print 2 119) ; "Ah, the symbol of love."
					(Print 2 120) ; "You had best keep it."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give/lodestone')
				(if (gEgo has: 2) ; lodestone
					(Print 2 121) ; "Now why would you want to give me something that I have given you?"
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give/moneybag')
				(if (gEgo has: 3) ; purse
					(Print 2 122) ; "You have greater need of it than I."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give/*[/merlin]')
				(Print 2 123) ; "A most gracious gesture, but I have no need of it."
			)
			((Said 'help/merlin')
				(Print 2 124) ; "If I am ever in need of help, rest assured you will be the first to know."
			)
			((Said 'draw/blade')
				(if (not (IsFlag 3))
					(Print 2 125) ; "You do not have your sword."
				else
					(= global125 2)
					(switch local6
						(0
							(Print 2 126) ; "There will be time enough for that later and I am not fond of cold steel in my presence."
						)
						(1
							(Print 2 127) ; "Truly, I think your hearing is impaired. Have I not warned you against this once?"
						)
						(else
							(Print 2 128) ; "I am your mentor and advisor, but I will not tolerate being threatened in this fashion."
							(gCurRoom setScript: takeAwaySword)
							(return)
						)
					)
					(++ local6)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo y:) 188)
			(gCurRoom newRoom: 1)
		)
	)
)

(instance OpenChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 14)
				(gEgo illegalBits: 0 setMotion: MoveTo 262 156 self)
			)
			(1
				(gEgo loop: 0)
				(= cycles 2)
			)
			(2
				(= local7 (gEgo view:))
				(gEgo
					view: 33
					loop: (if (IsFlag 3) 0 else 1)
					cel: 0
					setMotion: 0
					cycleSpeed: (+ global103 1)
					setCycle: End self
				)
			)
			(3
				(lid setCycle: End self)
			)
			(4
				(lid stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(5
				(Print 2 129 #icon 504 0 1) ; "Inside my chest is a lodestone, a magical stone that will always show you where true north lies. This one is shaped like a tiny sword, the tip of which will point to north as it dangles from a string attached to its center."
				(Print 2 130) ; "Take it, Arthur.  I prepared it especially for you."
				(gEgo
					cycleSpeed: 0
					view: local7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					loop: 0
					cel: 1
					illegalBits: -32768
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance CloseChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 260 156 self)
			)
			(1
				(= local7 (gEgo view:))
				(gEgo
					cycleSpeed: (+ global103 1)
					view: 33
					setMotion: 0
					setLoop: (if (IsFlag 3) 0 else 1)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(lid setCycle: Beg self)
			)
			(4
				(HandsOn)
				(lid stopUpd:)
				(gEgo
					view: local7
					cycleSpeed: 0
					setLoop: -1
					loop: 0
					cel: 1
					setCycle: Walk
					illegalBits: -32768
					setScript: 0
				)
			)
		)
	)
)

(instance merlinActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(if (== gPrevRoomNum 3)
					(merlin setLoop: 0 setCel: 0)
				else
					(merlin setLoop: 0 setCel: 5 setCycle: Beg)
				)
			)
			(2
				(= cycles 0)
				(Face gEgo mapFeat)
				(HandsOff)
				(merlin setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(global59 brTop: 158)
				(Print 2 131) ; "It is a map of the Summer Lands, as your kingdom is often known;"
				(Print 2 132) ; "Cornwall to the west, and some lands beyond, including the island of Eire."
				(Print 2 133) ; "However, you should study it very closely before you leave and determine where your search for the Grail should take you."
				(global59 brTop: 140)
				(= seconds 2)
			)
			(4
				(merlin setCycle: Beg self)
			)
			(5
				(merlin setLoop: 0 setCel: 0)
				(HandsOn)
			)
			(6
				(HandsOff)
				(= cycles (= seconds 0))
				(merlin
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 3 1 self
				)
				(if (< (gEgo x:) (merlin x:))
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(if (IsFlag 3)
					(= local4 0)
					(= local5 4)
				else
					(= local4 2)
					(= local5 2)
				)
			)
			(7
				(merlin setCycle: End self)
				(gSFX number: 56 loop: 1 play:)
			)
			(8
				(= local0 (gEgo loop:))
				(gEgo
					view: 15
					setLoop: (+ local0 local4)
					cycleSpeed: 2
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(merlin setLoop: 0 setCel: 0 cycleSpeed: 0)
				(= local3 1)
				(RedrawCast)
				(gEgo setLoop: (+ (gEgo loop:) local5))
				(= seconds 2)
			)
			(10
				(if (not local2)
					(Print 2 134) ; "Since you cannot keep your hands to yourself, you can do without them for awhile."
					(Print 2 135) ; "When you apologize, I will consider returning you to your native form."
					(HandsOff)
					(gGame setCursor: gNormalCursor (HaveMouse))
					(User canInput: 1)
				)
				(gEgo setScript: DogActions)
				(= seconds 2)
			)
			(11
				(if local2
					(EgoDead 2 136) ; "It would seem you refuse to learn a lesson. Be gone from my sight."
				else
					(= local2 1)
					(= seconds 50)
				)
			)
			(12
				(EgoDead 2 137) ; "Your stubbornness defies belief. I will waste no more time upon you, fool of a king."
			)
			(13
				(= local3 (= cycles (= seconds 0)))
				(merlin
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 3 1 self
				)
			)
			(14
				(merlin setCycle: End self)
				(gSFX number: 56 loop: 1 play:)
			)
			(15
				(gEgo
					view: 15
					setLoop: (+ local0 local4)
					setCel: 5
					cycleSpeed: 2
					setCycle: Beg self
				)
				(gSFX stop:)
				(User blocks: 0)
			)
			(16
				(gEgo
					view: (if (IsFlag 3) 0 else 2)
					setLoop: -1
					loop: local0
					cycleSpeed: 0
					setCel: -1
					setCycle: Walk
					setScript: 0
				)
				(merlin setLoop: 0 setCel: 0 cycleSpeed: 0)
				(= local1 2)
				(HandsOn)
				(self changeState: 5)
			)
		)
	)
)

(instance takeAwaySword of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (== global125 0))
			(HandsOff)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global125 2)
			)
			(1
				(merlin
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: CT 3 1 self
				)
			)
			(2
				(merlin setCycle: End self)
				(gSFX number: 56 loop: 1 play:)
			)
			(3
				(ClearFlag 3)
				(gEgo view: 2)
				(= seconds 1)
			)
			(4
				(merlin setLoop: 0 setCel: 0 cycleSpeed: 2)
				(SetMenu 1283 112 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance DogActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local3
					(gEgo setCycle: End self)
					(User blocks: 1)
					(gSFX number: (proc0_20 19) loop: -1 play:)
				)
			)
			(1
				(if (Random 1 2)
					(gEgo setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(2
				(User blocks: 0)
				(gSFX stop:)
				(gEgo setCel: 0)
				(= seconds (Random 6 12))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

