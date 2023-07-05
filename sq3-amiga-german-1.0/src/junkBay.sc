;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	junkBay 0
)

(instance junkBay of Locale
	(properties)

	(method (handleEvent event &tmp [temp0 50])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					(
						(Said
							'get,get,get[<up]/iro,scrap,junk,debris,heap[<sharp]'
						)
						(Print 700 0) ; "It's junk. You don't need junk. Now, think of something better and let's get on with the game!"
					)
					(
						(Said
							'get,get,move,freeze,manipulate,feel/(edge[<jagged]),(protrusion[<barbed])'
						)
						(Print 700 1) ; "I wouldn't mess with them. They look dangerous."
					)
					((Said 'eat,eat/iro,scrap,junk,debris,heap[<sharp]')
						(Print 700 2) ; "What a great way to die a slow and painful death. As appetizing as that sounds, you wisely opt against it."
					)
					((Said 'expectorate,expectorate')
						(Print 700 3) ; "How crude."
					)
					((Said 'write,swing')
						(Print 700 4) ; "No time for that."
					)
					((Said 'listen')
						(Print 700 5) ; "You hear nothing of note."
					)
					((Said 'kiss,kiss')
						(Print 700 6) ; "Your taste is in serious question."
					)
					((Said 'clean')
						(Print 700 7) ; "It's against your nature to do that."
					)
					((Said 'eat,eat/fuck,shit')
						(Print 700 8) ; "Ah! You're one of those!"
					)
					((Said 'hit')
						(Print 700 9) ; "You'd do more harm than good."
					)
					(
						(Said
							'press,move,freeze,manipulate,roll/iro,scrap,junk,debris,heap[<sharp]'
						)
						(Print 700 10) ; "There are matters more pressing than debris relocation at this juncture in time. Besides, that stuff looks sharp and heavy. You're no poster child for manual labor."
					)
					((Said 'yell,yell,whistle,whistle,laugh[<out]')
						(Print 700 11) ; "Your utterance echoes about the metallic confines of the area. No answer is forthcoming."
					)
					((Said 'cry[<out]')
						(Print 700 12) ; "Hey! Don't be a baby!"
					)
					((Said 'use/wire,cable')
						(if (gEgo has: 1) ; Wire
							(Print 700 13) ; "Not now."
						else
							(Print 700 14) ; "You don't have that."
						)
					)
					((Said 'tie')
						(Print 700 15) ; "You won't be doing that here."
					)
					((Said 'climb/iro,building,heap,junk,debris,scrap[<sharp]')
						(Print 700 16) ; "All terrain nearby is chock-full of jagged edges and barbed protrusions. I wouldn't try that here."
					)
					((Said 'use,climb,stand,stand,erect,erect,lean/ladder')
						(if (gEgo has: 2) ; Ladder
							(Print 700 17) ; "It won't help you at this time."
						else
							(DontHave) ; "You don't have it."
						)
					)
					((Said 'look,look>')
						(cond
							(
								(or
									(Said '[<up,above,at]/ceiling')
									(Said '<up,above,at[/ceiling]')
								)
								(Print 700 18) ; "You stare at the ceiling which, as usual, is overhead. You see nothing particularly unique about the structure except some kind of track running high above you. It seems to run the length of the freighter."
							)
							(
								(and
									(!= global149 gCurRoomNum)
									(or
										(Said '[<down,below,at]/dirt,deck')
										(Said '<down,below,at[/dirt,deck]')
									)
								)
								(Print 700 19) ; "The floor is composed of a mosaic of overlapping welded steel plates. The menage of used metal appears to have been cut from a variety of sources."
							)
							((Said '/console')
								(Print 700 20) ; "They look like pieces of metal which have been welded together."
							)
							((Said '/banister,banister,beam')
								(Print 700 21) ; "Not much about it can be learned from down here."
							)
							((Said '/partition,console[<north,s,e,west]')
								(Print 700 22) ; "The walls are made of metal and very strong composite materials commonly used in spacecraft."
							)
							(
								(Said
									'[<in,at,through]/junk,debris,heap,iro,junk,debris,spaceware,debris,scrap'
								)
								(Print 700 23) ; "The steep piles of scrap metal are chock-full of jagged edges and barbed protrusions."
							)
							((Said '/(edge[<jagged]),(protrusion[<barbed])')
								(Print 700 24) ; "I wouldn't mess with them. They look dangerous."
							)
							((Said '/dirt')
								(Print 700 25) ; "You'll find nothing ground-like in this synthetic environment."
							)
							((Said '/paint,paint,coolant')
								(Print 700 26) ; "The walls and most other objects in the area seem to be randomly splattered with a zesty brew of coolants, lubricants, propellants, and other types of spaceship squeezings."
							)
							((Said '/light,lamp')
								(Print 700 27) ; "All available light is being ported into the room via a series of vents in the ceiling."
							)
							((Said '/conduit,frame,frame')
								(Print 700 28) ; "Strewn about are the totally gutted carcasses of many a formerly worthy craft."
							)
							((Said '/console')
								(Print 700 29) ; "There are various useless plates of metal scattered about the ship. I wouldn't mess with them."
							)
							((Said '/self')
								(Print 700 30) ; "A quick self-appraisal suggests that you are not horribly ugly. You guess you'd be a good catch."
							)
							((Said '/appendage,head,leg,body,self')
								(Print 700 31) ; "An inspection of yourself reveals nothing outstanding."
							)
						)
					)
					((Said 'nap,(lie,lie<down)[/deck]')
						(Print 700 32) ; "Are you crazy? You've got adventuring to do."
					)
					((Said '/wire,cable')
						(Print 700 33) ; "That won't help you now."
					)
					((Said 'drop,halt,hold[<in]/crystal[<glowing]/mouth')
						(Print 700 34) ; "That's only helpful in Space Quest II."
					)
					((Said 'eat,eat,break/crystal[<glowing]')
						(Print 700 35) ; "That won't help you."
					)
					((Said 'dig[/cavity]')
						(Print 700 36) ; "What do you think you are, a metallic gopher?"
					)
					((Said 'climb/banister,beam,banister<up<to')
						(Print 700 37) ; "Unless you are capable of defying artificial gravity, forget it."
					)
					((Said 'climb')
						(Print 700 38) ; "You are unable to scale anything here."
					)
					((Said 'jump,jump/craft')
						(Print 700 39) ; "Dream on."
					)
					(
						(Said
							'hoist,hoist,open,move,freeze,manipulate,press,pull,bend/deck,console'
						)
						(Print 700 40) ; "They are too rigid and heavy for you to manipulate."
					)
					((Said 'get,get/tile[<mosaic,deck]')
						(Print 700 41) ; "Sorry. They're welded in place."
					)
				)
				(if
					(and
						(== global149 gCurRoomNum)
						(Said 'use,(turn<on)/motivator,artifact,machine')
					)
					(Print 700 42) ; "You have no effect on the motivator."
				)
			)
		)
	)
)

