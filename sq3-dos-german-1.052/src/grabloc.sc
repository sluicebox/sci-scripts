;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	grabloc 0
)

(instance grabloc of Locale
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(and
					(> global132 3)
					(or
						(Said 'look,look/grabber,control,control,machine')
						(Said
							'look,look/button,button<claw,claw,grabber,machine'
						)
					)
				)
				(Print 703 0) ; "From your seat you see a handle (presently being gripped by you) which controls motion, and a button marked CLAW."
			)
			((Said 'expectorate,expectorate')
				(Print 703 1) ; "How crude."
			)
			((Said 'shit/hosebag')
				(Print 703 2) ; "Not with your crank!"
			)
			((Said 'kiss,kiss')
				(Print 703 3) ; "Your taste is in serious question."
			)
			((Said 'use/wire,cable')
				(if (gEgo has: 1) ; Wire
					(Print 703 4) ; "Not now."
				else
					(Print 703 5) ; "You don't have that."
				)
			)
			((Said 'tie')
				(Print 703 6) ; "You won't be doing that here."
			)
			((Said 'yell,yell,whistle,whistle,laugh[<out]')
				(Print 703 7) ; "Your utterance echoes about the metallic confines of the area. No answer is forthcoming."
			)
			((Said 'listen')
				(Print 703 8) ; "You hear nothing of note."
			)
			((Said 'cry[<out]')
				(Print 703 9) ; "Hey! Don't be a baby!"
			)
			((Said 'clean')
				(Print 703 10) ; "It's against your nature to do that."
			)
			((Said 'write')
				(Print 703 11) ; "No time for that."
			)
			((Said 'climb[<up,down]/banister,beam[<iro]')
				(Print 703 12) ; "You would be unable to climb safely. Don't even try it."
			)
			(
				(Said
					'use,climb,stand,stand,(stand,stand<up),erect,erect,lean/ladder'
				)
				(if (gEgo has: 2) ; Ladder
					(Print 703 13) ; "It won't help you at this time."
				else
					(DontHave) ; "You don't have it."
				)
			)
			((Said 'hit')
				(Print 703 14) ; "You'd do more harm than good."
			)
			((Said 'hang<from/banister,beam[<iro]')
				(Print 703 15) ; "You would be unwise."
			)
			((Said 'climb<down')
				(Print 703 16) ; "It would only result in a death so horrible that the mere description would cause you to revisit your last calorie download."
			)
			((Said 'look,look>')
				(cond
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(Print 703 17) ; "Looking down makes you dizzy."
					)
					((Said '/appendage,head,leg,body,self')
						(Print 703 18) ; "An inspection of yourself reveals nothing outstanding."
					)
					((Said '/iro,scrap,junk,debris,heap,junk,debris,fuck,shit')
						(Print 703 19) ; "It's way down there and not very pretty."
					)
					((Said '/conduit')
						(Print 703 20) ; "A number of pipes run through the area. They are of no significance."
					)
					(
						(or
							(Said '[<up,above,at]/ceiling')
							(Said '<up,above,at[/ceiling]')
						)
						(Print 703 21) ; "The ceiling looks closer from up here. It looks no more spectacular, however."
					)
					((Said '/claw,claw[<grabber]')
						(if (or (== global132 4) (== global132 5))
							(Print 703 22) ; "Your viewing angle doesn't allow that."
						else
							(event claimed: 0)
						)
					)
					((Said '/motivator')
						(if (== global135 3)
							(cond
								((or (== global132 4) (== global132 5))
									(Print 703 22) ; "Your viewing angle doesn't allow that."
								)
								((== gCurRoomNum 13)
									(Print 703 23) ; "It's hanging peacefully under the grabber."
								)
								(else
									(Print 703 24) ; "That's not here to see."
								)
							)
						else
							(Print 703 25) ; "That's not here to see."
						)
					)
					((Said '/partition,console[<west,e,north,west]')
						(Print 703 26) ; "The walls are made of the same composite material as in other locations around this junk-strewn hell-hole."
					)
					((Said '/banister,banister,beam[<iro]')
						(if (< global132 4)
							(Print 703 27) ; "The rail is supported by beams hanging from the ceiling. It's probably used by some sort of scrap transport equipment."
						else
							(Print 703 28) ; "The rail is supported by beams hanging from the ceiling. The grabber hangs beneath it."
						)
					)
					((Said '/light,lamp')
						(Print 703 29) ; "All available light is being ported into the room via a series of vents in the ceiling."
					)
					((Said '/grate')
						(Print 703 30) ; "Light is pouring in from small vents around the ship."
					)
				)
			)
			((Said 'drop,halt,hold[<in]/crystal/mouth')
				(Print 703 31) ; "That's only helpful in Space Quest II."
			)
			((Said 'eat,eat,break/crystal[<glowing]')
				(Print 703 32) ; "That won't help you."
			)
			(
				(Said
					'sit,crawl,(get,get<off)[<down,on]/banister,banister,beam,conduit,bar'
				)
				(Print 703 33) ; "That wouldn't be helpful."
			)
			((Said 'use,get,get/motivator<motivator')
				(if (== global135 3)
					(Print 703 34) ; "Leave it alone. It has no human interface capability."
				else
					(Print 703 35) ; "That isn't here."
				)
			)
			((Said 'nap,(lie,lie<down)[/deck]')
				(Print 703 36) ; "Are you crazy? You've got adventuring to do."
			)
			((or (== global132 4) (== global132 5))
				(cond
					((Said 'look,look/chair[<grabber,machine]')
						(Print 703 37) ; "You seem to be covering all available seat surface area making viewing impossible."
					)
					((Said 'stand,stand,(stand,stand<up),(get,get<up,out,off)')
						(Print 703 38) ; "Please remain seated while riding the grabber."
					)
					((Said 'look,look/button,button[<claw,claw]')
						(Print 703 39) ; "A grimy button on the panel reads "CLAW.""
					)
					((Said 'get,get[<up]/motivator')
						(if (== global135 3)
							(Print 703 40) ; "Leave that to the grabber."
						else
							(Print 703 41) ; "You can't do that yourself."
						)
					)
					(
						(Said
							'look,look/control,control,console[<machine,grabber]'
						)
						(Print 703 42) ; "Your view of the grabber from here reveals a Forward/Reverse control stick (currently grasped), and a button marked 'CLAW'"
					)
					(
						(or
							(Said
								'pull,press,use,move,freeze,manipulate,go[<forward,backward,back,back,back,back][/handle,stick,throttle,control,control,knob]'
							)
							(Said
								'start,move,freeze,manipulate,drive[<forward,backward,back,back,back,back]/grabber,machine'
							)
						)
						(Print 703 43) ; "Just move as you've been moving."
					)
					(
						(Said
							'release,release[/throttle,handle,stick,control,control]'
						)
						(Print 703 44) ; "That's not necessary."
					)
					((Said 'look,look/claw,claw[<grabber,machine]')
						(Print 703 45) ; "Your viewing angle doesn't allow that."
					)
					((Said 'climb')
						(Print 703 46) ; "You are unable to scale anything here."
					)
					(
						(or
							(Said 'get,climb[<on,on,to]/banister,beam')
							(Said 'get,get<up,on/banister,beam')
						)
						(Print 703 47) ; "That won't help."
					)
					(
						(Said
							'get,jump,jump,leap,leap,climb[<on,on,to]/conduit,bar'
						)
						(Print 703 48) ; "That wouldn't be safe."
					)
					(
						(Said
							'stand,stand,climb,get,get[<up,on,off,down,on,out]/grabber,machine,claw,claw,banister,beam'
						)
						(Print 703 49) ; "You aren't able to do that presently."
					)
					((Said 'open/grate')
						(Print 703 50) ; "You can't."
					)
					((Said 'jump,jump/craft')
						(Print 703 51) ; "Dream on."
					)
					((Said 'jump,jump[<down,up]')
						(Print 703 52) ; "That isn't currently one of your options."
					)
				)
			)
		)
	)
)

