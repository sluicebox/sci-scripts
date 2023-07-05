;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	InvSaids 0
)

(instance InvSaids of Script
	(properties)

	(method (handleEvent event &tmp temp0 [temp1 50])
		(if (gEgo has: 3) ; oilcan
			(cond
				((Said 'get,get/oil<from/can')
					(Print 410 0) ; "That would be very messy."
				)
				((Said '(look<in),open/can[<oil]')
					(Print 410 1) ; "The old oilcan is half-filled with oil."
				)
				((Said 'oil[/*]')
					(Print 410 2) ; "You would just waste your oil."
				)
			)
		)
		(if
			(and
				(or
					(Said '/monocle>')
					(Said '//monocle>')
					(Said 'look<use<monocle>')
				)
				(not (Said 'look[<at]/monocle>'))
			)
			(cond
				((not (gEgo has: 1)) ; monocle
					(event claimed: 1)
					(Print 410 3) ; "You don't have the monocle."
				)
				((Said 'wear,(attach<on)')
					(Print 410 4) ; "You don't know how to wear a monocle; it keeps falling off!"
				)
				((Said 'look>')
					(cond
						((Said '<in')
							(Print 410 5) ; "Things appear larger and sharper when you look through the monocle; much like a magnifying glass."
						)
						((Said '/fingerprint')
							(event claimed: 0)
							(client setScript: 0)
							(return)
						)
						((not global224)
							(DontHave) ; "You don't have it."
						)
						(else
							(switch global171
								(23
									(Print 410 6 #icon 634 0 0) ; "You carefully examine the white handkerchief using Wilbur's monocle much like a magnifying glass. Why, what's this? You see a small "EP" in one corner of the white lace trim."
									(SetFlag 6)
								)
								(4
									(Print 410 7 #icon 639 0 0) ; "You scrutinize the entire rolling pin with Wilbur's monocle. Aha! You have discovered traces of blood on it!"
									(SetFlag 7)
								)
								(6
									(Print 410 8 #icon 632 0 0) ; "You examine the entire fireplace poker with the monocle. Oh, oh! There are traces of blood on it!"
									(SetFlag 8)
								)
								(9
									(Print 410 9 #icon 636 0 0) ; "Squinting into the monocle you carefully examine the piece of broken record. Closely situated to each other, you notice two different fingerprints."
									(SetFlag 9)
								)
								(19
									(Print 410 10 #icon 637 0 0) ; "Upon opening the diary you see a small inky fingerprint inside the front cover. You examine it more closely with Wilbur's monocle."
									(SetFlag 12)
								)
								(else
									(Print 410 11) ; "You examine it with the monocle, but don't see anything interesting."
								)
							)
						)
					)
					(event claimed: 1)
				)
			)
		)
		(if (event claimed:)
			(client setScript: 0)
			(return)
		)
		(= temp0 0)
		(cond
			((or (Said 'load/derringer') (Said 'attach,load/bullet/derringer'))
				(cond
					(global185
						(Print 410 12) ; "It's already loaded."
					)
					((gEgo has: 15) ; derringer
						(if (gEgo has: 14) ; bullet
							(Ok) ; "Okay."
							(gEgo put: 14 99) ; bullet
							(= global185 1)
						else
							(Print 410 13) ; "You have no bullet."
						)
					)
					(else
						(Print 410 14) ; "You have no gun."
					)
				)
			)
			(
				(or
					(Said 'detach,unload/bullet[/derringer<from]')
					(Said 'unload/derringer')
				)
				(cond
					(global185
						(Print 410 15) ; "That would probably be unwise."
					)
					((gEgo has: 15) ; derringer
						(Print 410 16) ; "It hasn't been loaded."
					)
					(else
						(Print 410 14) ; "You have no gun."
					)
				)
			)
			((Said 'open,(look<in)/derringer')
				(cond
					(global185
						(Print 410 17) ; "When you open the small derringer, you see there is one bullet in it."
					)
					((gEgo has: 15) ; derringer
						(Print 410 18) ; "Upon opening the derringer, you notice no bullets."
					)
					(else
						(Print 410 14) ; "You have no gun."
					)
				)
			)
			((and global224 (Said 'look/fingerprint>'))
				(cond
					((Said '//diary')
						(Print 410 10 #icon 637 0 0) ; "Upon opening the diary you see a small inky fingerprint inside the front cover. You examine it more closely with Wilbur's monocle."
						(SetFlag 12)
					)
					((Said '//record')
						(Print 410 9 #icon 636 0 0) ; "Squinting into the monocle you carefully examine the piece of broken record. Closely situated to each other, you notice two different fingerprints."
						(SetFlag 9)
					)
				)
			)
			((Said 'smoke/butt')
				(Print 410 19) ; "What an awful thought!"
			)
			((Said 'get>')
				(cond
					(global224
						(AlreadyTook) ; "You already took it."
						(event claimed: 1)
					)
					((!= (global219 owner:) gCurRoomNum)
						(NotHere) ; "You don't see it here."
						(event claimed: 1)
					)
				)
			)
			((or (Said 'ask/*<for') (Said 'ask//*<for'))
				(if global224
					(AlreadyTook) ; "You already took it."
				else
					(Print 410 20) ; "If you want it, just GET it."
				)
			)
			((Said 'ask,tell>')
				(client setScript: 0)
				(return)
			)
			((not global224)
				(event claimed: 1)
				(DontHave) ; "You don't have it."
			)
			((Said 'drop')
				(Print 410 21) ; "Better not! You might need it!"
			)
			((Said 'throw')
				(Print 410 22) ; "That wouldn't accomplish anything."
			)
			((and (not (Said 'look<in>')) (Said 'look'))
				(global219 showSelf:)
			)
			((Said 'use')
				(Format @temp1 410 23 (global219 name:)) ; "What do you want to do with the %s"
				(Format (- (StrEnd @temp1) 1) 410 24) ; "?"
				(Print @temp1)
			)
			((Said 'give,show>')
				(client setScript: 0)
				(return)
			)
			(else
				(switch global171
					(19
						(cond
							((Said 'write')
								(Print 410 25) ; "It's not your diary!"
							)
							((Said 'open,read,(look<in)')
								(Print 410 26) ; "Upon opening the diary, you casually notice an ink-stained fingerprint inside the front cover. Curiously, and a bit guiltily, you scan through the rest of the diary's pages. Nothing much captures your interest until you come to the latest entry. It reads..."
								(Print 410 27) ; "May 27th (that's today!) Dear Diary, I'm so terribly upset! I can't believe Uncle Henri would do this to me! I thought I was like a daughter to him and now I find out I'm no more important than any of those other creeps! They can't get away with it, you know...they just can't! Between you and me, Diary, you know they have to go..."
								(Print 410 28) ; "...because of what they all did to me. I KNOW they were all in it together to have me put away in the nuthouse. I was never crazy, they just wanted me out of the picture! Now they have to..."
								(Print 410 29) ; "That's it. The passage ends abruptly. Hmmmmm. What could Lillian mean by all this?!"
								(SetFlag 3)
							)
							(else
								(= temp0 1)
							)
						)
					)
					(22
						(if (Said 'open,(look<in)')
							(Print 410 30) ; "You open the leather pouch and peer inside. It's full of precious jewels! Carefully, you close it again so as not to lose any."
						else
							(= temp0 1)
						)
					)
					(11
						(cond
							((Said 'open,(look<in)/box')
								(switch global136
									(0
										(Print 410 31) ; "The cracker box is empty."
									)
									(1
										(Print 410 32) ; "There is only one cracker in the cracker box."
									)
									(else
										(Print
											(Format @temp1 410 33 global136) ; "There are %u crackers in the cracker box."
										)
									)
								)
							)
							((Said 'eat')
								(if (> global136 0)
									(Print 410 34) ; "You pop a cracker into your mouth. Mmmmmm. Quite tasty."
									(-- global136)
								else
									(Print 410 35) ; "The box of crackers is empty."
								)
							)
							(else
								(= temp0 1)
							)
						)
					)
					(16
						(if (Said 'ignite')
							(Print 410 36) ; "Okay. You light a match."
							(Print 410 37) ; "Ouch!! The match burned your fingers!"
						else
							(= temp0 1)
						)
					)
					(17
						(if (Said 'eat>')
							(Print 410 38) ; "Mmmmmmmm. You always love a good carrot."
							(gEgo put: 17 0) ; carrot
							(event claimed: 1)
						else
							(= temp0 1)
						)
					)
					(0
						(cond
							((Said 'wear,(attach<on)')
								(Print 410 39) ; "It wouldn't become you."
							)
							((Said 'polish')
								(Print 410 40) ; "That wouldn't do anything."
							)
							(else
								(= temp0 1)
							)
						)
					)
					(2
						(cond
							((Said 'open,(look<in)')
								(Print 410 41) ; "There appears to be kerosene in the lantern."
							)
							((Said 'ignite,(rotate<on)')
								(if (gEgo has: 16) ; matches
									(if global137
										(Print 410 42) ; "It's already lit."
									else
										(Print 410 43) ; "Using a match, you carefully light the lantern. It glows brightly."
										(= global137 1)
									)
								else
									(Print 410 44) ; "You don't have any matches."
								)
							)
							((Said 'extinguish,extinguish,(rotate<off)')
								(if global137
									(= global137 0)
									(Print 410 45) ; "You extinguish the lantern."
								else
									(Print 410 46) ; "It's already extinguished."
								)
							)
							(else
								(= temp0 1)
							)
						)
					)
					(10
						(cond
							(
								(or
									(Said 'read,open,(look<in)')
									(Said 'rotate/page')
								)
								(Print 410 47) ; "You open your notebook and skim through your many notes and observations."
							)
							((Said 'close')
								(Print 410 48) ; "It is closed."
							)
							((Said 'write')
								(Print 410 49) ; "From your detective father, you have learned to write down all your notes and observations."
							)
							(else
								(= temp0 1)
							)
						)
					)
				)
			)
		)
		(if temp0
			(CantDo) ; "You can't do that."
			(event claimed: 1)
		)
		(client setScript: 0)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 410)
	)
)

