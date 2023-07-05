;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm32 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(Print &rest #at -1 130)
)

(procedure (localproc_1)
	(Print &rest #at -1 114)
)

(instance mariesTheme of Sound
	(properties
		number 14
	)
)

(instance mariesBeenKidnapped of Sound
	(properties
		number 18
	)
)

(instance rm32 of Rm
	(properties
		picture 32
		style 8
	)

	(method (init)
		(super init:)
		(User canInput: 1 canControl: 1)
		(self setLocales: 153)
		(Load rsVIEW 271)
		(= local2 0)
		(= local3 0)
		(= local6 0)
		(if (< global100 8)
			((View new:)
				view: 271
				posn: 252 106
				loop: 1
				cel: 0
				setPri: 8
				init:
				stopUpd:
				addToPic:
			)
			((View new:)
				view: 271
				posn: 257 106
				loop: 0
				cel: 2
				setPri: 8
				init:
				stopUpd:
				addToPic:
			)
			((View new:)
				view: 271
				posn: 164 115
				loop: 0
				cel: 3
				setPri: 9
				init:
				stopUpd:
				addToPic:
			)
		else
			((View new:)
				view: 271
				posn: 274 128
				loop: 1
				cel: 1
				setPri: 9
				init:
				stopUpd:
				addToPic:
			)
			(if (IsItemAt 13) ; hit_list
				((View new:)
					view: 271
					posn: 247 127
					loop: 0
					cel: 1
					ignoreActors:
					setPri: 8
					init:
					stopUpd:
					addToPic:
				)
				(= local6 1)
			else
				((View new:)
					view: 271
					posn: 247 127
					loop: 0
					cel: 2
					setPri: 8
					init:
					stopUpd:
					addToPic:
				)
				(= local6 0)
			)
			((View new:)
				view: 271
				posn: 113 116
				loop: 0
				cel: 0
				setPri: 9
				init:
				stopUpd:
				addToPic:
			)
		)
		((View new:)
			view: 271
			posn: 35 96
			loop: 2
			cel: 0
			setPri: 6
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 271
			posn: 71 88
			loop: 2
			cel: 1
			setPri: 8
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 271
			posn: 236 87
			loop: 2
			cel: 2
			ignoreActors:
			setPri: 8
			init:
			stopUpd:
			addToPic:
		)
		((= local0 (Prop new:))
			view: 271
			loop: 3
			cel: 0
			posn: 198 105
			init:
			stopUpd:
		)
		(lampBlock top: 119 bottom: 127 left: 247 right: 288 init:)
		(self setScript: rm32Script)
	)
)

(instance rm32Script of Script
	(properties)

	(method (doit)
		(cond
			((<= (gEgo y:) 120)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(cond
			(
				(and
					(> (gEgo y:) 160)
					(gCast contains: global112)
					(not local4)
				)
				(= local4 1)
				(gEgo setMotion: 0)
				(User canControl: 0)
				(keithScript changeState: 6)
			)
			((> (gEgo y:) 165)
				(gCurRoom newRoom: 31)
			)
			((and (gEgo inRect: 190 95 222 110) (not local1))
				(local0 setScript: bathroomScript)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (>= global100 8) (== global131 13))
						((= global112 (Act new:))
							view: 20
							posn: 255 145
							observeBlocks: lampBlock
							setCycle: Walk
							setStep: 3 2
							setScript: keithScript
							init:
						)
						(gEgo
							view: 1
							posn: 239 155
							observeBlocks: lampBlock
							init:
						)
						(mariesBeenKidnapped play:)
					)
					((== gPrevRoomNum 12) ; phone
						(gEgo init:)
						(if (and (>= global100 8) (== global131 13))
							(global112 init:)
						)
					)
					(else
						(if (>= global100 8)
							(mariesBeenKidnapped play:)
						else
							(mariesTheme play:)
						)
						(gEgo
							view: 1
							posn: 240 131
							observeBlocks: lampBlock
							setMotion: MoveTo 184 120
							init:
						)
						(if (and (>= global100 8) (not global127))
							(= global127 1)
							(RedrawCast)
							(localproc_1 32 0) ; "The appearance of Marie's living room speaks for itself. Your heart sinks and your head starts swimming."
							(localproc_0 32 1) ; "Oh, Marie!" you think..."What has that maniac done to you??!"
						)
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '<below>')
								(cond
									((Said '/fridge,oven,cabinet,counter,basin')
										(if (gEgo inRect: 0 0 172 115)
											(localproc_0 32 2) ; "Nothing...it's not even dusty!"
										else
											(localproc_0 32 3) ; "You're in the wrong room to do that."
										)
									)
									((Said '/bed')
										(if (gEgo inRect: 215 95 275 111)
											(localproc_0 32 2) ; "Nothing...it's not even dusty!"
										else
											(localproc_0 32 3) ; "You're in the wrong room to do that."
										)
									)
									((Said '/*')
										(localproc_0 32 2) ; "Nothing...it's not even dusty!"
									)
								)
							)
							((Said '[<at,around][/!*,chamber]')
								(cond
									((gEgo inRect: 0 0 172 115)
										(if (>= global100 8)
											(localproc_0 32 4) ; "Somehow, in the middle of all the mess, the kitchen remains tidy and neat."
										else
											(localproc_0 32 5) ; "You look around an immaculately clean kitchen."
										)
									)
									((gEgo inRect: 215 95 275 111)
										(localproc_0 32 6) ; "The hall leads to the single bedroom. You see nothing out of the ordinary."
									)
									((>= global100 8)
										(localproc_0 32 7) ; "You look around an apparently empty living room. However, you can see definite signs of struggle."
									)
									(else
										(localproc_0 32 8) ; "You look around an apparently empty living room."
									)
								)
							)
							((Said '/bedroom,(chamber<bed)')
								(if (gEgo inRect: 215 95 275 111)
									(cond
										((gCast contains: global112)
											(localproc_0 32 9) ; "Keith is taking care of it."
										)
										((>= global100 8)
											(localproc_0 32 10) ; "You search her bedroom from top to bottom, but you come up empty-handed. You can still smell her perfume in the air."
										)
										(else
											(localproc_0 32 11) ; "The bed is neatly made and everything's put away nicely. You can smell her sweet perfume in the air."
										)
									)
								else
									(localproc_0 32 12) ; "You're not in the bedroom."
								)
							)
							((or (Said '<up') (Said '/ceiling'))
								(localproc_0 32 13) ; "As you stare blankly at the ceiling, thoughts of Marie dance through your head."
							)
							((Said '/dirt')
								(localproc_0 32 14) ; "The ground is outside. In here, it's called the floor."
							)
							((Said '[<at,down][/floor]')
								(if
									(and
										(not (gEgo inRect: 0 0 172 115))
										(not (gEgo inRect: 215 95 275 111))
									)
									(if (>= global100 8)
										(if (gEgo inRect: 214 110 290 138)
											(localproc_0 32 15) ; "You see a lamp turned over on the floor. An ashtray is next to it."
										else
											(localproc_0 32 16) ; "You see various items of furniture turned over on the floor."
										)
									else
										(localproc_0 32 17) ; "As usual, the floor is clean."
									)
								else
									(localproc_0 32 17) ; "As usual, the floor is clean."
								)
							)
							((Said '/couch')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(if (>= global100 8)
										(localproc_0 32 18) ; "The phone is on the sofa with the cord ripped from the wall."
									else
										(localproc_0 32 19) ; "This is Marie's favorite sofa."
									)
								else
									(localproc_0 32 20) ; "You're in the wrong room to be looking at the sofa."
								)
							)
							((Said '/wall')
								(localproc_0 32 21) ; "The walls are bright and freshly painted."
								(if (not (gEgo inRect: 0 0 172 115))
									(localproc_0 32 22) ; "There are paintings hung here and there."
								)
							)
							((Said '/hall')
								(if (gEgo inRect: 215 95 275 111)
									(localproc_0 32 6) ; "The hall leads to the single bedroom. You see nothing out of the ordinary."
								else
									(localproc_0 32 23) ; "Go into the hall."
								)
							)
							((Said '/bench')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(localproc_0 32 24) ; "Nothing unusual."
								else
									(localproc_0 32 25) ; "You're in the wrong room to be looking at the chair."
								)
							)
							((Said '/table')
								(cond
									((>= global100 8)
										(cond
											((gEgo inRect: 152 117 209 132)
												(localproc_0 32 26) ; "The table is bare. The phone was on it."
											)
											((gEgo inRect: 214 110 290 138)
												(localproc_0 32 27) ; "The table is bare. The lamp and ashtray were on it."
											)
											(else
												(localproc_0 32 28) ; "Go closer to the table."
											)
										)
									)
									((gEgo inRect: 152 117 209 132)
										(localproc_0 32 29) ; "The phone is on the table."
									)
									((gEgo inRect: 214 110 290 138)
										(localproc_0 32 30) ; "You see a lamp and an ashtray."
									)
									(else
										(localproc_0 32 28) ; "Go closer to the table."
									)
								)
							)
							((Said '/phone')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(if (>= global100 8)
										(localproc_0 32 18) ; "The phone is on the sofa with the cord ripped from the wall."
									else
										(localproc_0 32 31) ; "It's a pink Contel designer phone."
									)
								else
									(localproc_0 32 32) ; "You're in the wrong room to be looking at the telephone."
								)
							)
							((Said '/ashtray,(tray<ash)')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(if (gEgo inRect: 229 118 265 134)
										(if (>= global100 8)
											(if (not local6)
												(localproc_0 32 33) ; "You see an empty ashtray."
											else
												(localproc_0 32 34) ; "In the ashtray, you see a partially burned piece of paper."
											)
										else
											(localproc_0 32 35) ; "It is clean. Marie doesn't smoke."
										)
									else
										(proc0_7) ; "You're not close enough."
									)
								else
									(localproc_0 32 36) ; "You're in the wrong room to be looking at the ashtray."
								)
							)
							((Said '/light,lamp')
								(cond
									((gEgo inRect: 0 0 172 115)
										(localproc_0 32 37) ; "There is a fluorescent lamp overhead."
									)
									((gEgo inRect: 215 95 275 111)
										(localproc_0 32 38) ; "There is a single light in the hall."
									)
									(
										(and
											(> (gEgo x:) 160)
											(> (gEgo y:) 112)
										)
										(if (>= global100 8)
											(localproc_0 32 39) ; "It'll never work again."
										else
											(localproc_0 32 40) ; "An imported ceramic lamp from Mexico."
										)
									)
									(else
										(proc0_7) ; "You're not close enough."
									)
								)
							)
							((Said '/painting')
								(if (gEgo inRect: 0 0 172 115)
									(localproc_0 32 41) ; "There are no paintings in the kitchen."
								else
									(localproc_0 32 42) ; "Abstract art, by Sierra's very own graphic artist, "Vu"."
								)
							)
							((Said '/plant,flower')
								(cond
									((gEgo inRect: 0 0 172 115)
										(localproc_0 32 43) ; "The houseplants in the kitchen are flourishing."
									)
									((gEgo inRect: 215 95 275 111)
										(if (== ((gInventory at: 11) owner:) 30) ; potted_plant
											(localproc_0 32 44) ; "Glancing around her bedroom briefly, you glimpse the flowers you once gave her."
										else
											(localproc_0 32 45) ; "Yeah!" you think. "I ought to get Marie some flowers today."
										)
									)
									(else
										(localproc_0 32 46) ; "The little fake potted plant almost looks real."
									)
								)
							)
							((Said '/grass')
								(localproc_0 32 47) ; "There's no marijuana in here."
							)
							((Said '/pane')
								(localproc_0 32 48) ; "You look through the window into Marie's back yard.... You think to yourself, "Nothing unusual out there.""
							)
							((Said '/counter')
								(if
									(or
										(gEgo inRect: 103 113 182 123)
										(gEgo inRect: 0 0 172 115)
									)
									(localproc_0 32 49) ; "You see nothing on the counter here."
								else
									(localproc_0 32 50) ; "You should go into the kitchen."
								)
							)
							((Said '/kitchen')
								(if (gEgo inRect: 0 0 172 115)
									(if (>= global100 8)
										(localproc_0 32 4) ; "Somehow, in the middle of all the mess, the kitchen remains tidy and neat."
									else
										(localproc_0 32 5) ; "You look around an immaculately clean kitchen."
									)
								else
									(localproc_0 32 50) ; "You should go into the kitchen."
								)
							)
							((Said '/cabinet,basin,oven,fridge')
								(if (gEgo inRect: 0 0 172 115)
									(localproc_0 32 51) ; "You look, but find nothing that will help you."
								else
									(localproc_0 32 52) ; "You must be in the kitchen to get a good look."
								)
							)
							((Said '/television,set')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(localproc_0 32 53) ; "It's a 19-inch "DynaView" color portable."
								else
									(localproc_0 32 54) ; "You're in the wrong room to be looking at the television."
								)
							)
							((Said '/lampshade,(shade<lamp)')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(if (>= global100 8)
										(localproc_0 32 55) ; "Useless!"
									else
										(localproc_0 32 56) ; "Very pretty."
									)
								else
									(proc0_7) ; "You're not close enough."
								)
							)
							((Said '/bathroom,(chamber<bath)')
								(if (not local1)
									(localproc_0 32 57) ; "You must go over to the bathroom in order to look at it."
								else
									(localproc_0 32 58) ; "You've already looked there."
								)
							)
							((Said '/friend')
								(if (gCast contains: global112)
									(if
										(and
											(> (global112 x:) 215)
											(not
												(gEgo inRect: 215 95 275 111)
											)
										)
										(localproc_0 32 59) ; "He's down the hall."
									else
										(localproc_0 32 60) ; "Just good old Keith!"
									)
								else
									(localproc_0 32 61) ; "He's not here."
								)
							)
							((Said '/newspaper,list')
								(if (gEgo has: 13) ; hit_list
									(localproc_1 32 62 82 113) ; "You read over a list of names..."Roberts, Wilkans, Colby, Bonds.""
									(if (not local5)
										(= local5 1)
										(localproc_0 32 63) ; "Mercy, Mercy!" you think to yourself, as you realize... "This is Bains' hit list...and..."
										(localproc_0 32 64) ; "Now that murderous scumbag has Marie!"
									)
								else
									(localproc_0 32 65) ; "You don't have it."
								)
							)
						)
					)
					((Said 'frisk>')
						(cond
							((Said '/couch')
								(if
									(and
										(<= (gEgo x:) 152)
										(>= (gEgo y:) 119)
									)
									(if (not global193)
										(localproc_0 32 66) ; "You search the deep crevices of the sofa and find..."
										(localproc_0 32 67) ; "How about that!" you think to yourself, "a $2 bill."
										(localproc_0 32 68) ; "You slip the bill into your money clip."
										(+= global107 2)
										(= global193 1)
									else
										(localproc_0 32 69) ; "You search the deep crevices of the sofa, but there are no clues."
									)
								else
									(localproc_0 32 70) ; "Go closer to the sofa."
								)
							)
							((Said '/bench')
								(if (gEgo inRect: 160 117 209 137)
									(if (not global194)
										(localproc_0 32 71) ; "You search the deep crevices of the chair and find..."
										(localproc_0 32 72) ; "How about that!" you think to yourself, "a $1 bill."
										(localproc_0 32 68) ; "You slip the bill into your money clip."
										(+= global107 1)
										(= global194 1)
									else
										(localproc_0 32 73) ; "You search the deep crevices of the chair, but there are no clues."
									)
								else
									(localproc_0 32 74) ; "Go closer to the chair."
								)
							)
							((Said '/drawer,counter,basin,oven,fridge')
								(if (gEgo inRect: 0 0 172 115)
									(localproc_0 32 75) ; "You look through everything, but you see nothing that could help you."
								else
									(localproc_0 32 50) ; "You should go into the kitchen."
								)
							)
							((Said '/bedroom,(chamber<bed)')
								(if (gEgo inRect: 215 95 275 111)
									(cond
										((gCast contains: global112)
											(localproc_0 32 9) ; "Keith is taking care of it."
										)
										((>= global100 8)
											(localproc_0 32 10) ; "You search her bedroom from top to bottom, but you come up empty-handed. You can still smell her perfume in the air."
										)
										(else
											(localproc_0 32 76) ; "There's no reason to search it."
										)
									)
								else
									(localproc_0 32 12) ; "You're not in the bedroom."
								)
							)
							((Said '/ashtray,(tray<ash)')
								(if
									(and
										(not (gEgo inRect: 215 95 275 111))
										(not (gEgo inRect: 0 0 172 115))
									)
									(if (gEgo inRect: 229 118 265 134)
										(if (>= global100 8)
											(Print 32 34) ; "In the ashtray, you see a partially burned piece of paper."
										else
											(localproc_0 32 77) ; "Huh?"
										)
									else
										(proc0_7) ; "You're not close enough."
									)
								else
									(localproc_0 32 36) ; "You're in the wrong room to be looking at the ashtray."
								)
							)
							((Said '/hall')
								(if (>= global100 8)
									(if (gEgo inRect: 215 95 275 111)
										(localproc_0 32 78) ; "You don't see anything unusual."
									else
										(localproc_0 32 23) ; "Go into the hall."
									)
								else
									(localproc_0 32 79) ; "Why are you searching Marie's house?"
								)
							)
							((Said '/kitchen')
								(if (>= global100 8)
									(if (gEgo inRect: 215 95 275 111)
										(localproc_0 32 78) ; "You don't see anything unusual."
									else
										(localproc_0 32 80) ; "Go into the kitchen."
									)
								else
									(localproc_0 32 79) ; "Why are you searching Marie's house?"
								)
							)
							((Said '/bathroom,(chamber<bath)')
								(if (not local1)
									(localproc_0 32 57) ; "You must go over to the bathroom in order to look at it."
								else
									(localproc_0 32 58) ; "You've already looked there."
								)
							)
							((Said '/chamber')
								(if (>= global100 8)
									(if (gEgo has: 13) ; hit_list
										(localproc_0 32 81) ; "You find no more substantial evidence."
									else
										(localproc_0 32 82) ; "So far, you haven't seen any substantial evidence."
									)
								else
									(localproc_0 32 79) ; "Why are you searching Marie's house?"
								)
							)
							((Said '/*')
								(localproc_0 32 83) ; "No clues there."
							)
						)
					)
					((Said '/cheeks')
						(localproc_0 32 84) ; "Marie is not here."
					)
					((Said 'enter,go[<in]/bedroom,(chamber<bed)')
						(if (gEgo inRect: 215 95 275 111)
							(cond
								((gCast contains: global112)
									(localproc_0 32 9) ; "Keith is taking care of it."
								)
								((>= global100 8)
									(localproc_0 32 10) ; "You search her bedroom from top to bottom, but you come up empty-handed. You can still smell her perfume in the air."
								)
								(else
									(localproc_0 32 11) ; "The bed is neatly made and everything's put away nicely. You can smell her sweet perfume in the air."
								)
							)
						else
							(localproc_0 32 12) ; "You're not in the bedroom."
						)
					)
					((Said 'smell/perfume')
						(if (gEgo inRect: 215 95 275 111)
							(localproc_0 32 85) ; "It's Marie's favorite, "Silky Lace"."
						else
							(localproc_0 32 86) ; "The fragrance is too faint to smell."
						)
					)
					((Said 'get,pick[<up]>')
						(cond
							((Said '/ashtray')
								(localproc_0 32 87) ; "You don't need to take the ashtray."
							)
							((Said '/table')
								(if
									(or
										(gEgo inRect: 214 110 290 138)
										(gEgo inRect: 152 117 209 132)
									)
									(localproc_0 32 88) ; "The table wouldn't help you."
								else
									(localproc_0 32 28) ; "Go closer to the table."
								)
							)
							((Said '/newspaper,list')
								(cond
									((gEgo has: 13) ; hit_list
										(localproc_0 32 89) ; "You already have it."
									)
									((not local6)
										(localproc_0 32 90) ; "You don't see it here."
									)
									((not (gEgo inRect: 229 118 265 134))
										(localproc_0 32 91) ; "Go closer to it."
									)
									(else
										((View new:)
											view: 271
											posn: 247 127
											loop: 0
											cel: 2
											setPri: 8
											init:
											stopUpd:
											addToPic:
										)
										(SetScore 3 91)
										(localproc_0 32 92 83) ; "You pick it up and carefully unfold it."
										(localproc_1 32 62 83 82 113) ; "You read over a list of names..."Roberts, Wilkans, Colby, Bonds.""
										(if (not local5)
											(= local5 1)
											(localproc_0 32 63 83) ; "Mercy, Mercy!" you think to yourself, as you realize... "This is Bains' hit list...and..."
											(localproc_0 32 64 83) ; "Now that murderous scumbag has Marie!"
										)
										(gEgo get: 13) ; hit_list
										(= local6 0)
									)
								)
							)
							((Said '/painting')
								(if (not (gEgo inRect: 0 0 172 115))
									(localproc_0 32 93) ; "You're on the wrong track."
								else
									(localproc_0 32 91) ; "Go closer to it."
								)
							)
							((Said '/lamp')
								(if (gEgo inRect: 214 110 290 138)
									(localproc_0 32 94) ; "Nothing about the lamp will help."
								else
									(localproc_0 32 91) ; "Go closer to it."
								)
							)
							((Said '/plant')
								(if (gEgo inRect: 214 110 290 138)
									(localproc_0 32 95) ; "It's not big enough to hide behind, and you would look funny carrying it around."
								else
									(localproc_0 32 91) ; "Go closer to it."
								)
							)
							((Said '/phone')
								(localproc_0 32 96) ; "You don't need it."
							)
							(
								(Said
									'/couch,bench,television,fridge,oven,cabinet,grass,cabinet'
								)
								(Print 32 97) ; "You've got to be kidding!"
							)
						)
					)
					((Said 'move>')
						(cond
							((Said '/painting')
								(if (gEgo inRect: 44 118 63 135)
									(localproc_0 32 93) ; "You're on the wrong track."
								else
									(localproc_0 32 91) ; "Go closer to it."
								)
							)
							((Said '/lamp')
								(if (gEgo inRect: 214 110 290 138)
									(localproc_0 32 94) ; "Nothing about the lamp will help."
								else
									(localproc_0 32 91) ; "Go closer to it."
								)
							)
							((Said '/plant')
								(if (gEgo inRect: 214 110 290 138)
									(localproc_0 32 95) ; "It's not big enough to hide behind, and you would look funny carrying it around."
								else
									(localproc_0 32 91) ; "Go closer to it."
								)
							)
							((Said '/couch,bench,television,ashtray,table')
								(localproc_0 32 98) ; "There's no need to do that."
							)
						)
					)
					((Said 'read/newspaper,list')
						(if (gEgo has: 13) ; hit_list
							(localproc_1 32 62 82 113) ; "You read over a list of names..."Roberts, Wilkans, Colby, Bonds.""
							(if (not local5)
								(= local5 1)
								(localproc_0 32 63) ; "Mercy, Mercy!" you think to yourself, as you realize... "This is Bains' hit list...and..."
								(localproc_0 32 64) ; "Now that murderous scumbag has Marie!"
							)
						else
							(localproc_0 32 65) ; "You don't have it."
						)
					)
					((Said 'turn[<on,off]/light,lamp')
						(localproc_0 32 99) ; "That isn't necessary."
					)
					((Said 'talk,call/friend')
						(if (gCast contains: global112)
							(localproc_0 32 100) ; "Keith simply grunts in reply."
						else
							(localproc_0 32 101) ; "You're talking to yourself again... Keith's not here."
						)
					)
					((Said 'open/door')
						(if (gEgo inRect: 190 95 222 110)
							(localproc_0 32 102) ; "Don't bother. You've already looked in there."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'open/fridge,cabinet')
						(if (gEgo inRect: 0 0 172 115)
							(if (>= global100 8)
								(localproc_0 32 103) ; "There are no clues, and you're not hungry."
							else
								(localproc_0 32 104) ; "Hmmmm..." you say to yourself. "Marie sure stocks a mean kitchen!"
								(localproc_0 32 105) ; "You munch down a piece of fruit."
							)
						else
							(localproc_0 32 106) ; "You're not in the right room."
						)
					)
					(
						(or
							(Said 'get/fingerprint,print')
							(Said 'dust/fingerprint,print')
						)
						(if (gEgo has: 10) ; field_kit
							(localproc_0 32 107) ; "Specify where you want to apply the powder."
						else
							(localproc_0 32 108) ; "You don't have your field kit."
						)
					)
					((or (Said 'dust>') (Said 'powder>') (Said 'apply/powder>'))
						(cond
							((not (gEgo has: 10)) ; field_kit
								(event claimed: 1)
								(localproc_0 32 108) ; "You don't have your field kit."
							)
							(
								(Said
									'/table,couch,bench,counter,cabinet,phone,ashtray'
								)
								(if (gEgo has: 10) ; field_kit
									(global122 setPri: 0)
									(global120 setPri: 0)
									(localproc_0 32 109 83) ; "Carefully, you apply the fingerprint powder ... you examine the powder and think to yourself... "Not worth processing.""
									(global122 setPri: 15)
									(global120 setPri: 14)
									(= local2 1)
								else
									(localproc_0 32 108) ; "You don't have your field kit."
								)
							)
							((Said '/*')
								(localproc_0 32 110) ; "A wasted effort."
							)
						)
					)
					(
						(or
							(Said 'use/tape[<fingerprint]')
							(Said 'get,hoist/print,clue')
						)
						(if (gEgo has: 10) ; field_kit
							(cond
								((== local2 2)
									(global123 setPri: 0)
									(localproc_0 32 111 83) ; "Using the tape, you carefully transfer the print to a 3x5 card."
									(global123 setPri: 15)
									(gEgo get: 22) ; fingerprint
								)
								(local2
									(localproc_0 32 112) ; "There aren't any prints."
								)
								(else
									(localproc_0 32 113) ; "Don't you know the correct way to get fingerprints?"
								)
							)
							(global122 setPri: 15)
							(global120 setPri: 14)
						else
							(localproc_0 32 108) ; "You don't have your field kit."
						)
					)
					((or (Said 'use,dial,pick[<up]/phone') (Said 'make/call'))
						(if (< global100 8)
							(if (gEgo inRect: 150 117 178 135)
								(gCurRoom newRoom: 12) ; phone
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(localproc_0 32 114) ; "It's been torn from the wall. It's inoperative."
						)
					)
					((Said 'use,go/bathroom,(chamber<bath)')
						(if local1
							(localproc_0 32 115) ; "You can hold it."
						else
							(localproc_0 32 116) ; "First, go into the bathroom."
						)
					)
					((Said 'use/basin,oven,fridge')
						(localproc_0 32 117) ; "You don't need to do that now."
					)
					((Said 'clock,use,(turn<on)/television,set')
						(localproc_0 32 118) ; "You don't have time to watch TV."
					)
					((Said 'sat[<down]')
						(if (>= global100 8)
							(localproc_0 32 119) ; "You're too upset to sit and relax."
						else
							(localproc_0 32 120) ; "You have business to take care of, Bonds."
						)
					)
				)
			)
		)
	)
)

(instance keithScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= global100 8)
					(User canControl: 0)
					(global112 setMotion: MoveTo 255 140 self)
				)
			)
			(1
				(global112 setMotion: MoveTo 240 135 self)
			)
			(2
				(if (not global127)
					(localproc_0 32 0) ; "The appearance of Marie's living room speaks for itself. Your heart sinks and your head starts swimming."
					(localproc_0 32 1) ; "Oh, Marie!" you think..."What has that maniac done to you??!"
					(localproc_0 32 121) ; "Trying to keep your composure, you say to Keith..."
					(localproc_0 32 122) ; "OK, Keith, why don't you go check out the back of the house? I'll look around here."
				)
				(= cycles 5)
				(User canControl: 1)
				(= global127 1)
			)
			(3
				(global112 setMotion: MoveTo 210 109 self)
			)
			(4
				(global112 setMotion: MoveTo 275 109)
			)
			(5
				(global112 stopUpd:)
			)
			(6
				(localproc_0 32 123) ; "Hearing you open the door, Keith hollers: "Hey, Sonny! Wait up!""
				(gEgo setLoop: 3)
				(global112 startUpd: setMotion: MoveTo 213 109 self)
			)
			(7
				(global112 setMotion: MoveTo 215 135 self)
			)
			(8
				(gEgo setLoop: 2)
				(global112 setMotion: MoveTo 238 135 self)
			)
			(9
				(global112 setMotion: MoveTo 238 145 self)
			)
			(10
				(gEgo setLoop: -1)
				(gCurRoom newRoom: 31)
			)
		)
	)
)

(instance lampBlock of Blk
	(properties)
)

(instance bathroomScript of Script
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 stopUpd: setPri: 8)
				(local0 setCycle: End)
				(= local1 1)
				(= seconds 2)
			)
			(1
				(if (< global100 8)
					(localproc_0 32 124 83) ; "This is Marie's bathroom. As usual, it is neat and tidy. Marie is not here. You close the door."
				else
					(localproc_0 32 125 83) ; "There are signs of a struggle in Marie's bathroom. Marie is not here. You close the door."
				)
				(= seconds 2)
			)
			(2
				(local0 setCycle: Beg self)
			)
			(3
				(local0 stopUpd:)
				(gEgo setPri: -1)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

