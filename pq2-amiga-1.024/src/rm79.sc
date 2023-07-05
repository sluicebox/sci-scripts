;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm79 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 3]
	local13
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm79 of Rm
	(properties
		picture 79
		style 0
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(= local7 (Random 100 400))
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 261)
		(Load rsVIEW 191)
		(Load rsVIEW 264)
		(if (not global237)
			(Load rsVIEW 88)
			(Load rsVIEW 32)
			(Load rsVIEW 46)
			(Load rsVIEW 52)
		)
		(super init:)
		(if (and (not global237) (not global236))
			(= local13 (Random 90 120))
		)
		(User canInput: 1)
		(= global211 0)
		(= global212 1)
		(gEgo
			setPri: -1
			view: (if (not global204) 0 else 6)
			setCycle: Walk
			init:
		)
		(switch gPrevRoomNum
			(78
				(gEgo posn: 117 199 setMotion: MoveTo 117 107)
			)
			(80
				(gEgo posn: 6 167 setMotion: MoveTo 315 167)
			)
			(81
				(gEgo posn: 316 159 setMotion: MoveTo 0 159)
			)
			(82
				(gEgo posn: 90 108 setMotion: MoveTo 93 189)
			)
		)
		((= local0 (Act new:))
			view: 264
			posn: 192 119
			init:
			setStep: 2 1
			setCycle: Walk
			moveSpeed: 2
			setMotion: Wander
		)
		((= local1 (Act new:))
			view: 264
			posn: 279 114
			init:
			setStep: 2 1
			setCycle: Walk
			moveSpeed: 2
			setMotion: Wander
		)
	)

	(method (doit)
		(cond
			((> (gEgo y:) 200)
				(gCurRoom newRoom: 78)
			)
			((< (gEgo y:) 107)
				(gCurRoom newRoom: 82)
			)
			((> (gEgo x:) 317)
				(gCurRoom newRoom: 81)
			)
			((< (gEgo x:) 5)
				(gCurRoom newRoom: 80)
			)
		)
		(if (and global236 (== (gCurRoom script:) 0))
			(self setScript: (ScriptID 77)) ; muggerScript
		)
		(if (> local7 0)
			(-- local7)
		)
		(if (and (not global237) (> local13 1))
			(-- local13)
		)
		(if (== local13 1)
			(if
				(and
					(not global204)
					(not global106)
					(gEgo inRect: 37 148 166 189)
				)
				(self setScript: (ScriptID 77)) ; muggerScript
				(= local9 1)
			)
			(= local13 0)
		)
		(if (and (== local7 0) global237 (not local4) (not local6))
			(doggieScript changeState: 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '[*]/dog')
						(cond
							(local4
								(localproc_0 79 0) ; "Whoops! That's a mighty fast poodle."
							)
							(local6
								(localproc_0 79 1) ; "That doggone dog's gone!"
							)
							(else
								(localproc_0 79 2) ; "What dog? Where?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/chamber')
								(localproc_0 79 3) ; "Yeah! Look at all the room in this park!"
							)
							((Said '[<at,around][/scenery,park]')
								(localproc_0 79 4) ; "You look around this section of the park and see a beautiful pond."
							)
							((Said '/tree')
								(localproc_0 79 5) ; "The trees provide shade and beauty."
							)
							((Said '/bush,brush,bush')
								(localproc_0 79 6) ; "You admire the beauty of the shrubbery, but you see nothing out of the ordinary."
							)
							((Said '<up,air')
								(localproc_0 79 7) ; "You gaze into the expanses of the upper atmosphere, and ponder the wonder of it all."
							)
							((Said '[<at,down][/dirt,grass,lawn,path]')
								(localproc_0 79 8) ; "Dirt. Grass. No clues."
							)
							((Said '/flower')
								(localproc_0 79 9) ; "You see a beautiful assortment of jonquils."
							)
							((Said '/jonquil')
								(localproc_0 79 10) ; "It's a Mediterranean perennial bulbous herb."
							)
							((Said '/light,lamp')
								(localproc_0 79 11) ; "The street lamp lights the entrance to the park."
							)
							((Said '/cloud')
								(localproc_0 79 12) ; "You look at the majestic clouds and wonder..."
								(localproc_0 79 13) ; "Will it rain, sleet, or snow?"
							)
							((Said '/rock')
								(localproc_0 79 14) ; "The rock is of no value to you...it's just a rock."
							)
							((Said '/pond,water')
								(localproc_0 79 15) ; "The pond really adds to the scenery... but that's all it does in this game."
							)
							((Said '/sidewalk')
								(localproc_0 79 16) ; "What sidewalk? Where?"
							)
							((Said '/man,mugger')
								(localproc_0 79 17) ; "There's nobody there."
							)
							((Said '/duck,bird')
								(localproc_0 79 18) ; "The little brown ducks will almost eat out of your hand."
							)
							((Said '/egg')
								(localproc_0 79 19) ; "Quit thinking of omelets!"
							)
							((Said '/sand')
								(localproc_0 79 20) ; "It used to be part of the 14th hole at the old Steelton Golf Links. It's very nice sand, but you see nothing unusual."
							)
						)
					)
					(
						(or
							(Said 'get,jump,swim,walk,wade[<in]/pond,water')
							(Said 'swim[<go]')
						)
						(localproc_0 79 21) ; "Look here, Detective Bonds....this isn't a picnic, there's an ordinance prohibiting swimming in city parks, and besides all that, Sweet Cheeks is in deep trouble. Get going!"
					)
					((Said 'pick/flower')
						(localproc_0 79 22) ; "I suppose that next you'll want to tiptoe through the tulips!"
					)
					((Said 'get/grass,lawn')
						(localproc_0 79 23) ; "Nowhere in the game will grass help you."
					)
					((Said 'dig[/hole,grass,lawn,dirt]')
						(localproc_0 79 24) ; "Are you nuts?"
					)
					((Said 'lay,lie[/dirt,grass,lawn]')
						(localproc_0 79 25) ; "You took your vitamins this morning. Why would you want to do that?"
					)
					((Said 'make/wish')
						(localproc_0 79 26) ; "You close your eyes...you make a wish...you wait...and then..."
						(localproc_0 79 27) ; "You realize that wishing just isn't getting it done."
					)
					((Said 'drink/water')
						(localproc_0 79 28) ; "Leave it for the ducks."
					)
					((Said 'climb/tree')
						(localproc_0 79 29) ; "Unless you're a monkey, bear, squirrel, chipmunk, or some other tree dwelling animal, you don't need to do that."
					)
					((Said 'feed/duck')
						(localproc_0 79 30) ; "You really don't have time. Besides, you don't have anything to feed them."
					)
					((Said 'get,kill,fire,eat/duck,egg')
						(localproc_0 79 31) ; "Planning a barbecue while your girlfriend's kidnapped? C'mon Sonny! Where's your sense of proportion?"
					)
					((Said 'talk/duck,egg')
						(localproc_0 79 32) ; "You're overwrought, Sonny!"
					)
					((Said 'move,hoist,get/rock')
						(localproc_0 79 33) ; "You try, but you might as well try moving the USS Enterprise."
					)
					((Said 'show/badge,badge')
						(localproc_0 79 34) ; "Nobody can see your badge right now."
					)
					(
						(or
							(Said 'call,extender/backup,friend')
							(Said '(key<up),use/extender,(talkie<walkie)')
						)
						(if (gEgo has: 30) ; walkie_talkie
							(if (not global237)
								(switch (Random 1 4)
									(1
										(localproc_0 79 35) ; "You key the walkie-talkie trying to raise Keith....you pause to listen, and then you hear..."
										(localproc_0 79 36) ; "SCReech, SQuawk, SQuelch, SQuawk, SCReech..."
										(localproc_0 79 37) ; "A lot of noise and no answer...you can't seem to get him."
									)
									(2
										(localproc_0 79 38) ; "The only thing you hear is..."Shhhh! Don't call unless you need me!""
									)
									(3
										(localproc_0 79 39) ; "You listen but he doesn't answer."
									)
									(4
										(localproc_0 79 40) ; "After trying to raise Keith and getting a lot of static, you think to yourself.... "WHEW! This is one sorry radio.""
									)
								)
							else
								(localproc_0 79 41) ; "The mugger's gone, Sonny. What's your story?"
							)
						)
					)
					((Said 'read/right,miranda,miranda')
						(localproc_0 79 17) ; "There's nobody there."
					)
					((Said 'interrogate,talk/man,mugger')
						(if global238
							(localproc_0 79 42) ; "He's off to jail, now. Besides, he wasn't a brilliant conversationalist the first time, anyway."
						else
							(localproc_0 79 17) ; "There's nobody there."
						)
					)
				)
			)
		)
	)
)

(instance doggieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 1)
				((= local5 (Act new:))
					view: 191
					loop: 0
					setStep: 6 4
					init:
					setCycle: Fwd
					setAvoider: (Avoid new:)
				)
				(local5 posn: 0 200 setMotion: MoveTo 120 161 self)
			)
			(1
				(local5 loop: 1 setMotion: MoveTo 0 170 self)
			)
			(2
				(local5 dispose:)
				(= local4 0)
				(= local6 1)
			)
		)
	)
)

