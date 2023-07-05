;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 109)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	Rm0Said2 0
)

(instance Rm0Said2 of Script
	(properties)

	(method (handleEvent event &tmp [temp0 4])
		(cond
			((Said 'draw/blade')
				(if (IsFlag 3)
					(Print 109 0) ; "There is no reason to draw your sword here."
				else
					(Print 109 1) ; "That is rather difficult, since you do not have your sword."
				)
			)
			((Said 'sheath/blade')
				(if (IsFlag 3)
					(Print 109 2) ; "Pay attention, Arthur. Your sword is sheathed."
				else
					(Print 109 3) ; "You could, if you but had your sword."
				)
			)
			((Said 'love//shield<my<are')
				(if (and (< gCurRoomNum 34) (gEgo has: 4)) ; Voyage, rose | apple | green_apple
					(Print 109 4) ; "The incantation works no magick upon the rose. It awaits a time when its spell of guiding will be of the most use."
				else
					(Print 109 5) ; "Most poetic, Arthur. And if you had Gwenhyver's rose, the incantation might even have been useful."
				)
			)
			((Said 'annihilate,drop,throw,(get<off)/*>')
				(cond
					((and (IsFlag 3) (Said 'throw/shield'))
						(Print 109 6) ; "You are a warrior-king, not a discus thrower."
					)
					((and (IsFlag 3) (Said 'throw/blade,excaliber'))
						(if (gEgo has: global140)
							(Print 109 7) ; "That is not how one uses a sword, as if I needed to tell you that."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((and (IsFlag 3) (Said '/shield'))
						(Print 109 8) ; "The shield could be vital to your continued existence. Which may not continue much longer with foolish notions like these."
					)
					((and (IsFlag 3) (Said '/armor,tunic'))
						(Print 109 9) ; "Life is dangerous enough without tempting fate by rampant stupidity."
					)
					((and (IsFlag 3) (Said '/blade,excaliber'))
						(Print 109 10) ; "Excaliber is an extension of your very soul. To abandon it is unthinkable."
					)
					(
						(or
							(and global140 (gEgo has: global140))
							(Said '/coin,dinar,dirham,copper')
						)
						(event claimed: 1)
						(Print 109 11) ; "What a truly mindless idea."
					)
					((Said 'annihilate')
						(Print 109 12) ; "What a foolish notion."
					)
					(else
						(event claimed: 1)
						(Print 109 13) ; "That is not only stupid, it is impossible since you do not have it."
					)
				)
			)
			((Said 'greet')
				(Print 109 14) ; "There is no need to greet me, Arthur. I am here."
			)
			((Said 'sat')
				(Print 109 15) ; "This is no time to be sitting around."
			)
			((Said 'hello,hello')
				(Print 109 16) ; "Is that some sort of odd Gaelic word?"
			)
			((Said 'kill,attack/*')
				(Print 109 17) ; "Deeds of mindless violence will make you unworthy of the Grail."
			)
			((Said 'kiss/*')
				(Print 109 18) ; "This is hardly the time or place."
			)
			((Said 'hug/*')
				(Print 109 19) ; "Some other time, mayhaps."
			)
			((Said 'genuflect')
				(Print 109 20) ; "There is no need for that here."
			)
			((Said 'consult,read,open/book')
				(Print 109 21) ; "Please do."
			)
			((Said 'get,open/pack')
				(Print 109 22) ; "That has gone with the mule. A serious setback, but one which must not deter you from your mission."
			)
			((or (Said 'drink/water') (Said 'eat/food,pack'))
				(Print 109 23) ; "That is in the pack which is with the mule.....wherever she is."
			)
			((Said 'ask,beg,have,get/absolution')
				(Print 109 24) ; "Only your deeds can determine your fate and it shall not be Merlin that renders the final judgment."
			)
			((Said 'thank[/merlin,you]')
				(Print 109 25) ; "No need to thank me. My service is its own reward."
			)
			((Said '/sorry')
				(Print 109 26) ; "Very well."
			)
			((and (IsFlag 3) (or (Said 'get,have/piss') (Said 'piss')))
				(Print 109 27) ; "It IS a problem with armour. I am sure you will manage somehow."
			)
			((or (Said 'fuck,blow,shit') (Said 'eat,get/shit[/*]'))
				(Print 800 (Random 0 4))
			)
			((or (Said 'make/love') (Said 'fuck'))
				(switch (Random 0 1)
					(0
						(Print 109 28) ; "The knight who wins the Grail must be pure of heart, mind, spirit and body. You seem determined to fail."
					)
					(1
						(Print 109 29) ; "Here? In front of god and everybody?"
					)
				)
			)
			((Said 'get/shield')
				(if (IsFlag 3)
					(Print 109 30) ; "It is ready upon your arm."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'smell/rose')
				(if (and (< gCurRoomNum 34) (gEgo has: 4)) ; Voyage, rose | apple | green_apple
					(Print 109 31) ; "The sweet heady smell of the rose reminds you, inevitably, of Gwenhyver."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'stop,stay,halt,halt')
				(Print 109 32) ; "What is it you wish to do instead?"
			)
			((Said 'pray')
				(Print 109 33) ; "This is not the Chapel of the Two Gods. Here, you can only hope that whatever god or goddess is listening will heed your prayers."
			)
			((Said '*[/!*][/!*]')
				(Print 109 34) ; "A mysterious request. Try to rephrase it more clearly."
			)
			((Said '/animal')
				(Print 109 35) ; "That is rather vague. Which animal?"
			)
			((or (Said '*/knight') (Said '*//knight'))
				(Print 109 36) ; "There are many knights in the world. You must name the one for which you seek."
			)
		)
		(DisposeScript 109)
	)
)

