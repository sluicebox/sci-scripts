;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm78 0
)

(local
	local0
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm78 of Rm
	(properties
		picture 78
		style 8
	)

	(method (dispose)
		(startScript dispose:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 190)
		(if (== gPrevRoomNum 101)
			(Load rsVIEW 50)
			(Load rsVIEW 20)
		)
		(super init:)
		(if (== (gContinuousMusic state:) 3)
			(gContinuousMusic stop:)
		)
		(NormalEgo)
		(HandsOn)
		(if (IsFlag 140)
			(ClearFlag 140)
		)
		((Prop new:)
			view: 190
			posn: 151 115
			loop: 0
			setCycle: Fwd
			init:
			startUpd:
		)
		((View new:)
			view: 190
			posn: 48 188
			loop: 1
			cel: 0
			init:
			stopUpd:
			addToPic:
		)
		(switch gPrevRoomNum
			(79
				(gEgo
					posn: 102 111
					view: (if (not global204) 0 else 6)
					init:
					setMotion: MoveTo 102 189
					startUpd:
				)
			)
			(12 ; phone
				(gEgo init:)
			)
			(else
				((= local0 (Act new:))
					view: 50
					loop: 1
					posn: 164 200
					init:
					stopUpd:
				)
				((= global112 (Act new:))
					view: 20
					loop: 0
					posn: 110 200
					init:
					stopUpd:
				)
				(gEgo view: 0 loop: 0 posn: 144 200 init: stopUpd:)
				(HandsOff)
				(local0 setScript: startScript)
			)
		)
	)

	(method (doit)
		(cond
			(global236
				(= global236 0)
				(localproc_0 78 0) ; "The mugger seems to have split. Perhaps he won't come too close to the Park entrance."
			)
			((< (gEgo y:) 110)
				(gCurRoom newRoom: 79)
			)
			((< (gEgo x:) 3)
				(gEgo setMotion: MoveTo 150 (gEgo y:))
			)
			((and (>= (gEgo x:) 180) (> (gEgo y:) 190))
				(gEgo setMotion: MoveTo 180 190)
			)
			((> (gEgo y:) 215)
				(localproc_0 78 1) ; "Wait a minute," you think to yourself. "I can't leave the park now. I'd better get back and keep looking around."
				(gEgo setMotion: MoveTo (gEgo x:) 180)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/(park,scenery)]')
								(localproc_0 78 2) ; "Burt Park is not unlike many other city parks around the country. The trees, lawn, and other greenery set forth a peaceful mood."
							)
							((Said '/chamber')
								(localproc_0 78 3) ; "You're outdoors. There are no rooms here."
							)
							((Said '/tree')
								(localproc_0 78 4) ; "The trees provide shade and beauty."
							)
							((Said '/bush,brush,bush')
								(localproc_0 78 5) ; "You admire the beauty of the shrubbery, but you see nothing out of the ordinary."
							)
							((Said '[<up,at][/air]')
								(localproc_0 78 6) ; "You gaze into the expanses of the upper atmosphere, and ponder the wonder of it all."
							)
							((Said '[<down,at][/dirt,grass,lawn,path]')
								(localproc_0 78 7) ; "It makes you think of gravity and Isaac Newton."
							)
							((Said '/flower')
								(localproc_0 78 8) ; "You see a beautiful assortment of marigolds."
							)
							((Said '/marigold')
								(localproc_0 78 9) ; "It could be any one of a genus of herbaceous composite plants with showy yellow or red and yellow flower heads."
							)
							((Said '/light,lamp')
								(localproc_0 78 10) ; "The street lamp lights the entrance to the park."
							)
							((Said '/cloud')
								(localproc_0 78 11) ; "You look at the majestic clouds and wonder..."
								(localproc_0 78 12) ; "Will it rain?"
							)
							((Said '/booth')
								(localproc_0 78 13) ; "Yes, it's a public telephone."
							)
							((Said '/phone,number')
								(if (gEgo inRect: 185 170 240 189)
									(localproc_0 78 14) ; "You look at the public telephone and lo and behold, the number matches the one given to you by the Lieutenant!"
								else
									(localproc_0 78 13) ; "Yes, it's a public telephone."
								)
							)
							((Said '/fountain,water')
								(localproc_0 78 15) ; "It's a combination bird bath and wishing well. Nothing special about it."
							)
							((Said '/(bath<bird),birdbath')
								(localproc_0 78 16) ; "It's a combination fountain and wishing well. Nothing special about it."
							)
							((Said '/well<wish')
								(localproc_0 78 17) ; "It's a combination bird bath and fountain. Nothing special about it."
							)
							((Said '/sign')
								(localproc_0 78 18) ; "It's a wooden sign with carved letters."
							)
							((Said '/friend')
								(if (> (global112 x:) 0)
									(localproc_0 78 19) ; "Homely, ain't he?"
								else
									(localproc_0 78 20) ; "He's not around to look at."
								)
							)
							((Said '/sidewalk')
								(localproc_0 78 21) ; "Don't step on a crack!"
							)
						)
					)
					(
						(or
							(Said 'call,extender/backup,friend')
							(Said 'use/extender,(walkie<talkie)')
						)
						(if (gEgo has: 30) ; walkie_talkie
							(switch (Random 1 4)
								(1
									(localproc_0 78 22) ; "You key the walkie-talkie trying to raise Keith....you pause to listen, and then you hear..."
									(localproc_0 78 23) ; "SCReech, SQuawk, SQuelch, SQuawk, SCReech..."
									(localproc_0 78 24) ; "A lot of noise and no answer...you can't seem to get him."
								)
								(2
									(localproc_0 78 25) ; "The only thing you hear is..."Shhhh! Don't call unless you need me!""
								)
								(3
									(localproc_0 78 26) ; "You listen but he doesn't answer."
								)
								(4
									(localproc_0 78 27) ; "After trying to raise Keith and getting a lot of static, you think to yourself...."WHEW! This is one sorry radio.""
								)
							)
						else
							(localproc_0 78 28) ; "You don't have a radio."
						)
					)
					((Said 'make/wish')
						(localproc_0 78 29) ; "You close your eyes...you make a wish...you wait...and then..."
						(localproc_0 78 30) ; "You find out it didn't help a bit."
					)
					((Said 'dial,use,pick[<up]/phone')
						(if (& (gEgo onControl: 1) $0002)
							(localproc_0 78 31) ; "Someone appears to have ripped the receiver off of the wall."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'open,close/booth,door')
						(if (gEgo inRect: 185 170 240 189)
							(localproc_0 78 32) ; "The door seems to be jammed open."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'drink/water,fountain,(well[<wish]),(bath[<bird])')
						(localproc_0 78 33) ; "Considering the added bird droppings, it wouldn't be a good idea."
					)
					((Said 'climb/tree')
						(localproc_0 78 34) ; "Unless you're a monkey, bear, squirrel, chipmunk, or some other tree dwelling animal, you don't need to do that."
					)
					((Said 'pick/flower')
						(localproc_0 78 35) ; "We don't want you to UNbeautify the area!"
					)
					(
						(or
							(Said 'dig[/hole,dirt,grass]')
							(Said 'lie,lay[<down]/dirt,grass,lawn')
						)
						(localproc_0 78 36) ; "You don't have a shovel, and besides....why would you want to do that?"
					)
					((Said 'get,get/grass,lawn')
						(localproc_0 78 37) ; "Nowhere in the game will grass help you."
					)
					((Said 'dust')
						(cond
							((not (gEgo has: 10)) ; field_kit
								(localproc_0 78 38) ; "You don't have your field kit."
							)
							((& (gEgo onControl: 1) $0002)
								(localproc_0 78 39) ; "It wouldn't do you any good. At least a million fingers have punched those buttons at one time or another."
							)
							(else
								(localproc_0 78 40) ; "There's no future in doing that."
							)
						)
					)
				)
			)
		)
	)
)

(instance startScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(localproc_0 78 41 83) ; "As you approach the park entrance, the patrol car's radio crackles: "Unit S56...we have a burglary in progress at 10th and Violet. Request you respond immediately. Over.""
				(self cue:)
			)
			(2
				(local0 loop: 2 cel: 0 startUpd:)
				(= cycles 10)
			)
			(3
				(local0 loop: 1 cel: 0)
				(localproc_0 78 42 83) ; "Well, boys..." says Officer Pitman, "I gotta go. I doubt you'll find anything, but go ahead and look around the park."
				(localproc_0 78 43 83) ; "Right here's the telephone booth Bains used to make that call."
				(localproc_0 78 44 83) ; "Call us when you need to be picked up, or if you need any kind of assistance. Good luck!"
				(self cue:)
			)
			(4
				(local0 setMotion: MoveTo 164 240 self)
			)
			(5
				(if (gEgo has: 30) ; walkie_talkie
					(localproc_0 78 45) ; "Keith looks around and says..."I think we should split up Sonny. Call me on the two-way if you need me.""
				else
					(localproc_0 78 46) ; "Keith looks around and says..."I think we should split up Sonny. I'll check the park perimeter. Holler if you need me.""
				)
				(self cue:)
			)
			(6
				(global112 setCycle: Fwd setMotion: MoveTo 0 240 startUpd:)
				(= global211 0)
				(= global212 1)
				(gEgo startUpd:)
				(HandsOn)
				(local0 setScript: 0)
			)
		)
	)
)

