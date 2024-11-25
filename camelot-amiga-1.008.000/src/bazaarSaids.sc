;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 153)
(include sci.sh)
(use Main)
(use Bazaar)
(use Interface)
(use System)

(public
	bazaarSaids 0
)

(instance bazaarSaids of Script
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
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(cond
					((IsFlag 140)
						(Print 153 0) ; "Often great wisdom and power may be hidden in a most ordinary guise."
					)
					((IsFlag 135)
						(Print 153 1) ; "Waste no time. Go to Fatima at once."
					)
					((IsFlag 134)
						(Print 153 2) ; "The Truth Spell of the Seeress provides you with the means to learn what a person wants. How you act upon that knowledge is the test placed before you."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'go,enter,(walk<in)/business')
				(Print 153 3) ; "In Camelot, you may go anywhere you like, but not in Jerusalem."
			)
			((Said 'get,buy/*')
				(Print 153 4) ; "Are you sure you have the right merchant for that?"
			)
			((Said 'talk/hierophant')
				(Print 153 5) ; "No-one answers to that title here."
			)
			((Said 'look,eat/falafel')
				(if (IsFlag 138)
					(Print 153 6) ; "She warned you it was delicate. Since you failed to eat it, it has fallen apart."
				else
					(Print 153 7) ; "You need to buy one, before you can eat it."
				)
			)
			((and (IsFlag 139) (Said 'talk/ione,girl'))
				(Print 153 8) ; "I do not think she heard you."
			)
			((Said 'look,read,read/graffiti')
				(Print 153 9) ; "Most of it is written in Hebrew, of which I know very little."
			)
			((Said 'look,read,read/arabic')
				(Print 153 10) ; "My Arabic is not quite good enough to translate that."
			)
			((Said 'look,read,read/greek')
				(Print 153 11) ; "Alas, I have let my Greek fade with disuse and cannot translate."
			)
			((Said 'look,read,read/hebrew')
				(Print 153 12) ; "I cannot quite tell precisely what the Hebrew graffiti says, but some of it, I believe, mentions dysentery."
			)
			((Said 'read/habib')
				(Print 153 13) ; ""Habib" means simply "friend", but "habibi" is a warmer greeting, like saying "my friend"."
			)
			((Said 'sell,bargain/excaliber')
				(Print 153 14) ; "Do not even consider it."
			)
			((Said 'sell,bargain/shield,armor')
				(Print 153 15) ; "In this dangerous land, that would be as good as death."
			)
			((Said 'get/job')
				(Print 153 16) ; "You are fit only to be a warrior in this land and Jerusalem has all the warriors it needs."
			)
			((Said 'get/coin')
				(if (== gGold gSilver gCopper 0)
					(Print 153 17) ; "You must use your wits if you hope to obtain money."
				else
					(Print 153 18) ; "Use carefully what you have. That is more important than how much you can accumulate."
				)
			)
			((and (gEgo has: 5) (Said 'use,drink/elixer')) ; sleeve | elixir
				(PutItem 5 0) ; sleeve | elixir
				(Print 153 19) ; "That was a bloody waste."
			)
			(
				(and
					(gEgo has: 6) ; iron_key | broom | grail
					(or (Said 'sweep/street,cobblestones') (Said 'use/broom'))
				)
				(Print 153 20) ; "That is beneath your dignity."
			)
			((and (gEgo has: 7) (Said 'use,burn/charcoal')) ; crystal_heart | charcoal | helm
				(Print 153 21) ; "You have neither the means nor the need."
			)
			((and (gEgo has: 11) (Said 'annihilate/mirror')) ; mirror | golden_apple
				(Print 153 22) ; "It is made of metal. You cannot break it."
			)
			((and (gEgo has: 13) (Said 'use,wear/veil')) ; veil
				(Print 153 23) ; "It would not suit you."
			)
			((Said 'use/grail')
				(Print 153 24) ; "I challenge you to find a use for this piece of cheap tin you have bought so dearly."
			)
			(
				(or
					(Said 'use,scatter,throw,drop/grain')
					(Said 'give/grain/bird')
					(and (gEgo has: 8) (Said 'feed/bird')) ; boar_spear | grain | medallion
				)
				(cond
					((not (gEgo has: 8)) ; boar_spear | grain | medallion
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((or (== gCurRoomNum 58) (== gCurRoomNum 61))
						(Print 153 25) ; "The birds already eat their fill from the grain merchant's spillage."
					)
					(else
						(Print 153 26) ; "It is a foolish man who scatters grain upon barren ground for no reason."
					)
				)
			)
			((and (gEgo has: 8) (Said 'eat/grain')) ; boar_spear | grain | medallion
				(Print 153 27) ; "I do not think you would enjoy eating raw grain."
			)
			((Said 'eat/lamb,meat')
				(Print 153 28) ; "Eat raw meat? In THIS climate? I think not."
			)
			((Said 'get,buy/food,drink,pack')
				(if (== gGold gSilver gCopper 0)
					(Print 153 29) ; "First, you must have money."
				else
					(Print 153 30) ; "You should be able to find what you need within this bazaar."
				)
			)
			((Said 'smell')
				(Print 153 31) ; "The many and varied smells of Jerusalem are, uhm, interesting, to say the least."
			)
			((Said 'rob/*')
				(Print 153 32) ; "Nay! Jerusalem is ruled by the laws of Islam where they will cut off the hand of a thief."
			)
			((Said 'call,yell')
				(Print 153 33) ; "There is no answer."
			)
			((Said '(pick[<up]),get/fragment,debris')
				(Print 153 34) ; "Do not be disgusting."
			)
			((Said 'greet')
				(proc152_1 153 35) ; "Sa'alam aleikem. Peace be unto you."
			)
		)
		(DisposeScript 153)
	)
)

