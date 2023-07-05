;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	forestPerilous 0
)

(local
	local0
)

(instance forestPerilous of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 0)
			(= global116 1)
		)
		(if (or (== global116 1) (and (== global116 2) (== global115 gCurRoomNum)))
			(gCurRoom setRegions: 113) ; horseReg
		else
			(gEgo view: 3 looper: 0)
		)
		(if (IsFlag 20)
			(gCurRoom setRegions: 115) ; muleReg
			(gMuleObj setScript: muleActions)
		)
		(= global148 30)
		(gRegMusic number: 12 loop: -1 play:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((& (gEgo onControl:) $0020)
				(if (not local0)
					(= local0 1)
					(Print 102 0) ; "The forest and undergrowth are too thick to go that way."
				)
			)
			(else
				(= local0 0)
			)
		)
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
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said '<in,in/tree')
						(Print 102 1) ; "I do not have the ability to look inside a solid tree. I doubt that you have."
					)
					((Said '<through/tree')
						(Print 102 2) ; "The forest grows thicker and darker. It is impossible to see very far."
					)
					((Said '<below/tree')
						(Print 102 3) ; "There are roots under the trees."
					)
					((Said '<above/tree')
						(Print 102 4) ; "Most of them are too tall for that."
					)
					((or (Said '/tree') (Said '//tree'))
						(Print 102 5) ; "Aye, 'tis a forest and therefore filled with trees."
					)
					((Said '<up')
						(Print 102 6) ; "Overhead is a thick canopy of leaves and interwoven branches filled with dappled light."
					)
					((or (Said '/leaf,leaf') (Said '//leaf,leaf'))
						(Print 102 7) ; "Trees are generally adorned with leaves. Indeed, the trees here are quite thick with them."
					)
					((or (Said '/root') (Said '//root'))
						(Print 102 8) ; "Most trees of my acquaintance have roots. They are no threat to you, unless you are particularly clumsy."
					)
					((Said '<in/bush,undergrowth')
						(Print 102 9) ; "It is too thick to see through."
					)
					((or (Said '/bush,undergrowth') (Said '//bush,undergrowth'))
						(Print 102 10) ; "The undergrowth of this forest protects many animals, but is the bane of travelers."
					)
					((or (Said '<down[/!*]') (Said '/dirt'))
						(Print 102 11) ; "The rich forest floor is covered with centuries of fallen leaves and thick grasses which muffle the sound of your passage."
					)
					((or (Said '/grass') (Said '//grass'))
						(Print 102 12) ; "It is a thick, hardy type of wild grass."
					)
					((Said '<below/boulder,slab,boulder')
						(Print 102 13) ; "The only thing you would find under these stones is forest soil and a few worms perhaps."
					)
					(
						(or
							(Said '/boulder,slab,boulder')
							(Said '//boulder,slab,boulder')
						)
						(Print 102 14) ; "There is much good stone in the forest, though some stones are more dangerous than others."
					)
					((or (Said '<up[/!*]') (Said '/sky'))
						(Print 102 15) ; "There are only glimpses of the sky through the thick canopy of leaves overhead."
					)
					((Said '<down')
						(if (== global116 1)
							(Print 102 16) ; "It should not surprise you to see your knees, saddle and horse."
						else
							(Print 102 17) ; "There is nothing more exciting to see than your own booted feet."
						)
					)
					((Said '<in,in,in/log')
						(Print 102 18) ; "Aside from some very ordinary beetles, there is nothing of interest there."
					)
					((or (Said '/log') (Said '//log'))
						(Print 102 19) ; "Once it was a tree, now it is a log. Someday, it will be peat. Such is the cycle of life."
					)
					((or (Said '/beetles') (Said '//beetles'))
						(Print 102 20) ; "Forget the beetles. Think about your sacred mission."
					)
					((or (Said '/berries') (Said '//berries'))
						(Print 102 21) ; "There are no berries in the Forest Perilous. Or certainly none you would dare to eat."
					)
					((or (Said '/amanita') (Said '//amanita'))
						(Print 102 22) ; "There are none here, but avoid the forest mushrooms at all costs."
					)
					(
						(or
							(Said '/wolf,bear,hare,squirrel')
							(Said '//wolf,bear,hare,squirrel')
						)
						(Print 102 23) ; "They hear you and smell you and stay well away."
					)
					(
						(or
							(Said '/bird,blackbird,blackbird')
							(Said '//bird,blackbird,blackbird')
						)
						(Print 102 24) ; "The birds are all but invisible in the dense trees."
					)
					((or (Said '/charger') (Said '//charger'))
						(if
							(or
								(== global116 1)
								(and (== global116 2) (== global115 gCurRoomNum))
							)
							(Print 102 25) ; "He looks much the same as he did a moment ago."
						else
							(Print 102 26) ; "What horse?"
						)
					)
					((or (Said '/knight<black') (Said '//knight<black'))
						(Print 102 27) ; "He is part of the spirit of the forest and dwells in the heart of it. You will not see him here."
					)
					((or (Said '/gawain') (Said '//gawain'))
						(cond
							((== global200 2)
								(Print 102 28) ; "There are prints of your horse heading toward Camelot. You may assume he is safe."
							)
							((< global200 3)
								(Print 102 29) ; "Gawaine will never be seen upon this earth again."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'look>') 0)
					((Said '//boar')
						(if (IsFlag 24)
							(Print 102 30) ; "Have you not seen enough boars for one quest?"
						else
							(Print 102 31) ; "The giant boars of the Forest Perilous are particularly dangerous. How fortunate there are none around at the moment."
						)
					)
				)
			)
			((Said 'carve/slab,boulder,boulder')
				(Print 102 32) ; "You would need chisels for that. You do not have time to play at being a stonemason."
			)
			((and (!= gCurRoomNum 17) (not (IsFlag 20)) (Said 'call,ass[<for]'))
				(Print 102 33) ; "Your mule does not answer."
			)
			((Said 'get,eat>')
				(cond
					((Said '/beetles')
						(Print 102 20) ; "Forget the beetles. Think about your sacred mission."
					)
					((Said '/berries')
						(Print 102 21) ; "There are no berries in the Forest Perilous. Or certainly none you would dare to eat."
					)
					((Said '/amanita')
						(Print 102 22) ; "There are none here, but avoid the forest mushrooms at all costs."
					)
					((Said '/leaf,grass,bush,bush,plant')
						(Print 102 34) ; "It is not edible. Nor does it look appetizing."
					)
				)
			)
			((Said 'smell')
				(Print 102 35) ; "It smells of green growing things, of musty mouldering things beneath the earth, of ash and oak, the passage of wolf and bear, squirrel and hare -- a thousand mingled scents of life and decay."
			)
			((Said 'get,kill,chase/bird,blackbird,blackbird')
				(Print 102 36) ; "Almost impossible to do unless you have a net and many helpers. Which you do not."
			)
			((Said 'help/*')
				(Print 102 37) ; "There is no-one here to help."
			)
			((Said 'listen')
				(Print 102 38) ; "There is the rush of wind through the leaves, the scurry and scitter of the squirrels and small creatures, the bell-like notes of the birds. The creaking of your leather and metallic jingle of your gear sets you apart from this forest world."
			)
			((Said 'cut/bush,undergrowth,path')
				(Print 102 39) ; "You could spend the rest of your life trying to cut your way through this forest. Use your head and find the easiest path."
			)
			((Said 'cut,cut,cut,cut/tree,log')
				(Print 102 40) ; "For that you want an axe and you have none."
			)
			((Said 'climb/tree')
				(Print 102 41) ; "You don't feel particularly inclined to climb trees. Anyway, what do you expect if you did? A golden egg or a magick bird or something?"
			)
			(
				(and
					(or
						(== global116 0)
						(and (== global116 2) (!= global115 gCurRoomNum))
					)
					(Said 'mount,(get<on)[/charger]')
				)
				(Print 102 42) ; "Rather like trying to ride the air, I would think."
			)
			(
				(and
					(or
						(== global116 0)
						(and (== global116 2) (!= global115 gCurRoomNum))
					)
					(Said 'dismount,(get<off)[/charger]')
				)
				(Print 102 43) ; "Is this some strange delusion you have that you are riding a horse, O' Arthur, King of all the Britons?"
			)
			(
				(or
					(Said 'get,kill,chase/wolf,bear,hare,squirrel')
					(Said 'go/chase')
				)
				(Print 102 44) ; "You have no time to spare for hunting."
			)
			((Said 'get,kill,chase/boar')
				(if (IsFlag 24)
					(Print 102 45) ; "The surviving boars have retreated far from this part of the forest. They fear you now."
				else
					(Print 102 46) ; "Face the giant boars only if you must. They are the most deadly of the wild creatures here."
				)
			)
			((Said 'get,have/piss')
				(Print 102 47) ; "I am sure you will find a likely tree when the need is great enough."
			)
			((Said 'talk/slab')
				(Print 102 48) ; "From the deafening silence, I would say there are no talking stones here."
			)
			((Said 'talk/tree')
				(Print 102 49) ; "This is not a talking tree."
			)
		)
	)
)

(instance muleActions of Script
	(properties)

	(method (doit)
		(cond
			((gMuleObj mover:) 0)
			((> (- (gMuleObj x:) (gEgo x:)) (+ global148 20))
				(gMuleObj
					setMotion: MoveTo (+ (gEgo x:) global148) (gMuleObj y:)
				)
			)
			((> (- (gEgo x:) (gMuleObj x:)) (+ global148 20))
				(gMuleObj
					setMotion: MoveTo (- (gEgo x:) global148) (gMuleObj y:)
				)
			)
		)
		(super doit:)
	)
)

