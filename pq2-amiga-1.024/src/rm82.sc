;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
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
	rm82 0
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	[local8 4]
	local12
	local13
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance rm82 of Rm
	(properties
		picture 82
		style 0
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(if (and (not global237) (not global236))
			(= local12 (Random 30 60))
		)
		(= local7 (Random 100 400))
		(User canInput: 1)
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
		(= global211 0)
		(= global212 1)
		(gEgo
			posn: 130 189
			view: (if (not global204) 0 else 6)
			init:
			setMotion: MoveTo 130 175
			setPri: -1
			startUpd:
		)
		((View new:)
			view: 261
			loop: 0
			cel: 2
			posn: 58 127
			setPri: 8
			brTop: 112
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 261
			loop: 0
			cel: 2
			posn: 191 110
			setPri: 7
			brTop: 95
			init:
			stopUpd:
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 261
			loop: 0
			cel: 0
			posn: 20 189
			setPri: 14
			init:
			stopUpd:
			addToPic:
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
				(not global106)
				(gEgo inRect: 119 116 207 142)
			)
			(self setScript: (ScriptID 77)) ; muggerScript
			(= local3 1)
			(= local12 0)
		)
		(if (and (> (gEgo y:) 189) (not global106))
			(gCurRoom newRoom: 79)
		)
		(if (and (== local7 0) global237 (not local4) (not local6))
			(doggieScript changeState: 0)
		)
		(cond
			((and (> (gEgo x:) 250) (not local13))
				(= local13 1)
				(localproc_0 82 0) ; "The willow tree's branches cover the ground. You look, but you see nothing interesting under or behind the tree."
				(gEgo setMotion: MoveTo 200 145)
			)
			((and (<= (gEgo x:) 250) local13)
				(= local13 0)
			)
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
								(localproc_0 82 1) ; "Whoops! That's a mighty fast poodle."
							)
							(local6
								(localproc_0 82 2) ; "That doggone dog's gone!"
							)
							(else
								(localproc_0 82 3) ; "What dog? Where?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/park,scenery]')
								(localproc_0 82 4) ; "You look around and see a willow tree, flowers, and a chain link fence delineating the park boundary."
							)
							((Said '/man,mugger')
								(localproc_0 82 5) ; "There's nobody there."
							)
							((Said '/chamber')
								(localproc_0 82 6) ; "Yes, there's lots of room outdoors."
							)
							((Said '/tree')
								(localproc_0 82 7) ; "The willow tree is beautiful. It is also a sanctuary for our feathered friends."
							)
							((Said '/earthworm')
								(localproc_0 82 8) ; "Mighty fast earthworm!"
							)
							((Said '/sand')
								(localproc_0 82 9) ; "It used to be part of the 18th hole at the old Steelton Golf Links. It's very nice sand, but you see nothing unusual."
							)
							((Said '/bird,friend')
								(localproc_0 82 10) ; "Don't stand underneath them....you know why!"
							)
							((Said '/bush,brush,bush')
								(localproc_0 82 11) ; "You admire the beauty of the shrubbery, but you see nothing out of the ordinary."
							)
							((Said '/friend')
								(if local0
									(localproc_0 82 12) ; "You've looked at your partner so often, you don't think about it too much. Is he getting a little paunchy?"
								else
									(localproc_0 82 5) ; "There's nobody there."
								)
							)
							((Said '/lamp,post')
								(localproc_0 82 13) ; "It's lighted at night to help prevent muggings."
							)
							((or (Said '<up') (Said '/air'))
								(localproc_0 82 14) ; "Good kite-flying weather."
							)
							((or (Said '<down') (Said '/dirt,grass,lawn,path'))
								(localproc_0 82 15) ; "Was that an earthworm?"
							)
							((Said '/flower')
								(localproc_0 82 16) ; "You see a beautiful assortment of nasturtiums."
							)
							((Said '/nasturtium')
								(localproc_0 82 17) ; "It's an herb with showy spurred flowers and pungent seeds."
							)
							((Said '/table')
								(localproc_0 82 18) ; "There are several reasonably new redwood picnic tables in this part of the park."
							)
							((Said '/fence')
								(localproc_0 82 19) ; "The chain link fence marks the park boundary."
							)
							((Said '/cloud')
								(localproc_0 82 20) ; "Its a white cloud. Definitely."
							)
							((Said '/rock')
								(localproc_0 82 21) ; "A typical park rock, of no value to you."
							)
						)
					)
					((Said 'climb/tree')
						(localproc_0 82 22) ; "You're not an Indian scout, Sonny Bonds. You're a homicide detective, remember?"
					)
					((Said 'sat/table')
						(localproc_0 82 23) ; "No time to relax, Sonny. Marie's life is in jeopardy."
					)
					((Said 'get/table')
						(localproc_0 82 24) ; "You think to yourself..."Hey! That table would look great next to my barbecue, and I could.....Darn it! My mind's wandering again!""
					)
					((Said 'pick,jump/flower')
						(localproc_0 82 25) ; "If you don't get on with it, Sonny, you'll be picking flowers for your girlfriend's grave."
					)
					((Said 'dig[/hole,dirt]')
						(localproc_0 82 26) ; "You don't have a shovel, and besides....why would you want to do that?"
					)
					((Said 'lie,lay[/dirt,grass,lawn]')
						(localproc_0 82 27) ; "You took your vitamins this morning. Why would you want to do that?"
					)
					((Said 'get/grass,lawn')
						(localproc_0 82 28) ; "Nowhere in the game will grass help you."
					)
					((Said 'climb/fence')
						(localproc_0 82 29) ; "It wouldn't help you in any way to climb the fence."
					)
					((Said 'move,hoist/rock')
						(localproc_0 82 30) ; "The only thing you might get by moving the rock is a hernia."
					)
					((Said 'get/rock')
						(localproc_0 82 31) ; "The rocks are buried in the ground, and you have neither the time nor the earth-moving equipment."
					)
					((Said 'climb,get,fire/lamp,post')
						(localproc_0 82 32) ; "You think to yourself..."Why not? I could take it home as a souvenir and mount it in my.....WAIT! What am I thinking about?""
					)
					((Said 'read/miranda,miranda')
						(if local0
							(SetScore 2)
							(localproc_0 82 33) ; "Keith's already done that."
						else
							(localproc_0 82 5) ; "There's nobody there."
						)
					)
					((Said 'show/badge,badge')
						(localproc_0 82 34) ; "Nobody can see your badge right now."
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
										(localproc_0 82 35) ; "You key the walkie-talkie trying to raise Keith....you pause to listen, and then you hear..."
										(localproc_0 82 36) ; "SCReech, SQuawk, SQuelch, SQuawk, SCReech..."
										(localproc_0 82 37) ; "A lot of noise and no answer...you can't seem to get him."
									)
									(2
										(localproc_0 82 38) ; "The only thing you hear is..."Shhhh! Don't call unless you need me!""
									)
									(3
										(localproc_0 82 39) ; "You listen but he doesn't answer."
									)
									(4
										(localproc_0 82 40) ; "After trying to raise Keith and getting a lot of static, you think to yourself...."WHEW! This is one sorry radio.""
									)
								)
							else
								(localproc_0 82 41) ; "The mugger's gone, Sonny. What's your story?"
							)
						)
					)
					((Said 'read/right,miranda,miranda')
						(localproc_0 82 5) ; "There's nobody there."
					)
					((Said 'interrogate,talk/man,mugger')
						(if global238
							(localproc_0 82 42) ; "He's off to jail, now. Besides, he wasn't a brilliant conversationalist the first time, anyway."
						else
							(localproc_0 82 5) ; "There's nobody there."
						)
					)
					((Said '/earthworm')
						(localproc_0 82 43) ; "They're good for fishing, but they don't catch crooks!"
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
				(local5 posn: 100 200 setMotion: MoveTo 170 170 self)
			)
			(1
				(local5 loop: 1 setMotion: MoveTo 100 200 self)
			)
			(2
				(local5 dispose:)
				(= local4 0)
				(= local6 1)
			)
		)
	)
)

