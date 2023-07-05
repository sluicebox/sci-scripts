;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm80 0
)

(local
	[local0 3]
	local3
	local4
	local5
	local6
	local7
	[local8 4]
	local12
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm80 of Rm
	(properties
		picture 80
		style 0
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(= local7 (Random 100 400))
		(if (and (not global237) (not global236))
			(= local12 (Random 30 60))
		)
		(User canInput: 1)
		(= global211 0)
		(= global212 1)
		(Load rsVIEW 0)
		(Load rsVIEW 4)
		(Load rsVIEW 6)
		(Load rsVIEW 261)
		(Load rsVIEW 191)
		(if (not global237)
			(Load rsVIEW 88)
			(Load rsVIEW 32)
			(Load rsVIEW 46)
			(Load rsVIEW 52)
		)
		(gEgo
			posn: 311 169
			view: (if (not global204) 0 else 6)
			setPri: -1
			init:
			setMotion: MoveTo 0 169
			startUpd:
		)
	)

	(method (doit)
		(if (and global236 (== (gCurRoom script:) 0))
			(self setScript: (ScriptID 77)) ; muggerScript
		)
		(if (> local7 0)
			(-- local7)
		)
		(if (and (not global237) (> local12 1))
			(-- local12)
		)
		(if
			(and
				(== local12 1)
				(not global204)
				(gEgo inRect: 121 106 319 189)
				(not global106)
			)
			(self setScript: (ScriptID 77)) ; muggerScript
			(= local3 1)
			(= local12 0)
		)
		(if (> (gEgo x:) 312)
			(gCurRoom newRoom: 79)
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
								(localproc_0 80 0) ; "Whoops! That's a mighty fast poodle."
							)
							(local6
								(localproc_0 80 1) ; "That doggone dog's gone!"
							)
							(else
								(localproc_0 80 2) ; "What dog? Where?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/chamber')
								(localproc_0 80 3) ; "Mighty big room, this park!"
							)
							((Said '/man,mugger')
								(localproc_0 80 4) ; "There's nobody there."
							)
							((Said '/sand')
								(localproc_0 80 5) ; "It used to be part of the 15th hole at the old Steelton Golf Links. It's very nice sand, but you see nothing unusual."
							)
							((Said '[<at,around][/!*,park]')
								(localproc_0 80 6) ; "It's pretty, but you see nothing unusual in this area of the park."
							)
							((Said '/tree')
								(localproc_0 80 7) ; "You look closely at a tree, but you can't find anything that even resembles a clue."
							)
							((Said '/fence')
								(localproc_0 80 8) ; "The chain-link fence delineates the park's boundary."
							)
							((Said '/bush,brush,bush')
								(localproc_0 80 9) ; "You admire the beauty of the shrubbery, but you see nothing out of the ordinary."
							)
							((or (Said '<up') (Said '/air'))
								(localproc_0 80 10) ; "Yep, it's still there."
							)
							((or (Said '<down') (Said '/dirt,grass,lawn,path'))
								(localproc_0 80 11) ; "More dirt. More grass. No clues"
							)
							((Said '/pond')
								(localproc_0 80 12) ; "The pond really adds to the scenery, but that's all it does in this game."
							)
							((Said '/cloud')
								(localproc_0 80 13) ; "Let's see...those are cumulo-nimbus clouds....no, they're cirrus clouds....no...."
								(localproc_0 80 14) ; "You wonder if it's going to rain."
							)
							((Said '/rock')
								(localproc_0 80 15) ; "You look all around the rock. You find nothing."
							)
							((Said '/flower')
								(localproc_0 80 16) ; "You see a beautiful assortment of pansies."
							)
							((Said '/pansy')
								(localproc_0 80 17) ; "It's a garden plant derived chiefly from the wild pansy of Europe, a type of wild violet."
							)
						)
					)
					((Said 'pick/flower')
						(localproc_0 80 18) ; "We don't want you to UNbeautify the area."
					)
					((Said 'get/grass,lawn')
						(localproc_0 80 19) ; "Nowhere in the game will grass help you."
					)
					((Said 'dig[/hole,dirt]')
						(localproc_0 80 20) ; "You don't have a shovel, and besides....why would you want to do that?"
					)
					((Said 'lie,lay[/lawn,grass,dirt]')
						(localproc_0 80 21) ; "You took your vitamins this morning. Why would you want to do that?"
					)
					((Said 'drink/water')
						(localproc_0 80 22) ; "Leave it for the ducks."
					)
					((Said 'get/rock')
						(localproc_0 80 23) ; "The rocks are buried in the ground, and you don't have either the time or the earth-moving equipment."
					)
					((Said 'climb/tree')
						(localproc_0 80 24) ; "There isn't a need to do that...so don't!"
					)
					((Said 'climb,jump/fence')
						(localproc_0 80 25) ; "You haven't finished your search of the park yet."
					)
					((Said 'hoist,move/rock')
						(localproc_0 80 26) ; "It's only the tip of a large granite boulder. You couldn't move it."
					)
					((Said 'show/badge,badge')
						(localproc_0 80 27) ; "Nobody can see your badge right now."
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
										(localproc_0 80 28) ; "You key the walkie-talkie, trying to raise Keith....you pause to listen, and then you hear..."
										(localproc_0 80 29) ; "SCReech, SQuawk, SQuelch, SQuawk, SCReech..."
										(localproc_0 80 30) ; "A lot of noise and no answer...you can't seem to get him."
									)
									(2
										(localproc_0 80 31) ; "The only thing you hear is..."Shhhh! Don't call unless you need me!""
									)
									(3
										(localproc_0 80 32) ; "You listen but he doesn't answer."
									)
									(4
										(localproc_0 80 33) ; "After trying to raise Keith and getting a lot of static, you think to yourself...."WHEW! This is one sorry radio.""
									)
								)
							else
								(localproc_0 80 34) ; "The mugger's gone, Sonny. What's your story?"
							)
						)
					)
					((Said 'read/right,miranda,miranda')
						(localproc_0 80 4) ; "There's nobody there."
					)
					((Said 'interrogate,talk/man,mugger')
						(if global238
							(localproc_0 80 35) ; "He's off to jail, now. Besides, he wasn't a brilliant conversationalist the first time, anyway."
						else
							(localproc_0 80 4) ; "There's nobody there."
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
				(local5 posn: 100 188 setMotion: MoveTo 320 179 self)
			)
			(1
				(local5 loop: 0)
				(self cue:)
			)
			(2
				(local5 dispose:)
				(= local4 0)
				(= local6 1)
			)
		)
	)
)

