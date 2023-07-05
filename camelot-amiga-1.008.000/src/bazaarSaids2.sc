;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use Bazaar)
(use Interface)
(use System)

(public
	bazaarSaids2 0
)

(instance bazaarSaids2 of Script
	(properties)

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
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said '/hierophant')
						(Print 155 0) ; "How can you tell a man is a hierophant merely by looking? You must seek words or deeds for such a judgment."
					)
					((Said '//hierophant')
						(Print 155 1) ; "It is a word from ancient Greece meaning one who has knowledge of sacred mysteries."
					)
					(
						(or
							(Said '/gutter,shit,excrement')
							(Said '//gutter,shit,excrement')
						)
						(Print 155 2) ; "The gutter which runs down the center of the Street of David is most unsavory."
					)
					((or (Said '/water') (Said '//water'))
						(Print 155 3) ; "The water in the gutter is unfit for any use."
					)
					(
						(or
							(Said '<down[/dirt,street,cobblestones]')
							(Said '/street,cobblestones,dirt')
							(Said '//street,cobblestones,dirt')
						)
						(Print 155 4) ; "The street is paved of ancient stones, many hundreds of years older than Camelot."
					)
					((or (Said '/slab') (Said '//slab'))
						(Print 155 5) ; "Nearly all of Jerusalem is made of the same, buff- coloured stone."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 155 6) ; "The walls are mainly of the buff-coloured stone predominant here, or brick and plaster."
					)
					((or (Said '/awning') (Said '//awning'))
						(Print 155 7) ; "There is nothing unusual about it."
					)
					(
						(or
							(Said '/ione,girl')
							(Said '//ione,girl')
							(and
								(IsFlag 139)
								(or (Said '/birdcage') (Said '//birdcage'))
							)
						)
						(if (IsFlag 139)
							(Print 155 8) ; "You mean that girl with the cage of doves? Pretty little thing, was she not?"
						else
							(Print 155 9) ; "What girl? Did I miss something?"
						)
					)
					((Said '//coin,dinar,dirham,copper')
						(Print 155 10) ; "The coins of Jerusalem are the dinar which is gold, the dirham which is silver, and the fals which is copper."
					)
					((Said '//fatima')
						(if (IsFlag 137)
							(Print 155 11) ; "I can add nothing more to what you already know."
						else
							(Print 155 12) ; "I shall know who and what she is when you do."
						)
					)
					((Said '//merchant')
						(Print 155 13) ; "You are not standing near that merchant."
					)
					((Said '//guard[<city]')
						(Print 155 14) ; "The city guards roam the bazaar, restless for any excuse to use their swords."
					)
					(
						(and
							(not (gEgo has: 3)) ; purse
							(or (Said '/moneybag') (Said '//moneybag'))
						)
						(Print 155 15) ; "You no longer have a purse, Arthur. You are alone in a strange city in a distant land without so much as a single copper coin."
					)
					((or (Said '/bandit') (Said '//bandit'))
						(Print 155 16) ; "I doubt if that thief would dare to show his face here again."
					)
					((Said '//ass')
						(Print 155 17) ; "I have said all I ever care to say about the mule."
					)
					((Said '/ass')
						(cond
							((IsFlag 20)
								(Print 155 18) ; "She continues to follow you."
							)
							((!= global202 3)
								(Print 155 19) ; "She was with you when you entered Jerusalem. You had better look for her."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((or (Said '/turban') (Said '//turban'))
						(Print 155 20) ; "It is a common form of headdress in such a hot climate."
					)
					((or (Said '/sky,sun') (Said '//sky,sun'))
						(Print 155 21) ; "The sun bakes the streets of Jerusalem."
					)
				)
			)
			((or global140 (Said '/ass>'))
				(cond
					((Said 'give')
						(if (== (gCurRoom notify:) 1)
							(Print 155 22) ; "Please attempt to control this rampage of excessive generosity."
						else
							(Print 155 23) ; "There is no one here."
						)
					)
					((Said 'sell,bargain')
						(if (== (gCurRoom notify:) 1)
							(Print 155 24) ; "I do not think that will be of interest to this merchant. Usually merchants wish to sell, not buy."
						else
							(Print 155 25) ; "You must have a buyer first."
						)
					)
					((Said 'buy')
						(if (== (gCurRoom notify:) 1)
							(Talk 155 26) ; "I do not have that for sale."
						else
							(Print 155 27) ; "Difficult, since you are not dealing with anyone at the moment."
						)
					)
					((Said 'use/*>')
						(cond
							((Said '/lodestone')
								(event claimed: 0)
							)
							((and global140 (gEgo has: global140))
								(event claimed: 1)
								(Print 155 28) ; "It might be of better use elsewhere."
							)
							(else
								(event claimed: 1)
								(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
							)
						)
					)
				)
			)
			((and (not (Said '/ass,merlin>')) (Said 'talk,ask/*'))
				(Print 155 29) ; "Perhaps you should move closer."
			)
			((Said 'hit,press/*>')
				(if (Said '/wall,window')
					(Print 155 30) ; "That would avail you nothing."
				else
					(event claimed: 1)
					(Print 155 31) ; "That would be cruel, Arthur."
				)
			)
			((Said 'fuck,kiss,hug')
				(switch (Random 0 3)
					(0
						(proc152_1 155 32) ; "Kus em'ak."
					)
					(1
						(proc152_1 155 33) ; "Yesh l'cha chara l'sechel."
					)
					(2
						(proc152_1 155 34) ; "Ta'sim et ze b'tachat!"
					)
					(else
						(proc152_1 155 35) ; "Ta'chel chara."
					)
				)
			)
		)
		(DisposeScript 155)
	)
)

