;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
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
	rm4 0
)

(synonyms
	(basket box)
	(hall captain)
	(cop detective)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0)
	(Print &rest #at -1 124)
)

(instance aTimer of Timer
	(properties)
)

(instance phone of Prop
	(properties)
)

(instance captain of Prop
	(properties)
)

(instance blab of Prop
	(properties)
)

(instance smoke of Prop
	(properties)
)

(instance rambo of View
	(properties)
)

(instance carKey of View
	(properties)
)

(instance bainsTheme of Sound
	(properties
		number 33
	)
)

(instance rm4 of Rm
	(properties
		picture 4
		style 6
	)

	(method (dispose)
		(drawerScript dispose:)
		(captainScript dispose:)
		(keithScript dispose:)
		(aTimer dispose: delete:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(HandsOn)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 65)
		(Load rsVIEW 62)
		(Load rsVIEW 3)
		(= global212 3)
		(NormalEgo)
		(if
			(and
				(< global100 1)
				(or
					(== global158 1)
					(and global166 (not (IsItemAt 0 5)) (not (IsItemAt 10 2))) ; hand_gun, field_kit
					(and (== global100 0) (== gPrevRoomNum 300))
				)
			)
			(= global162 0)
			(= global164 0)
			(SetFlag 32)
		)
		(if (< 5 global100 8)
			(= global161 1)
		)
		(= local4
			(cond
				((IsFlag 32)
					(ClearFlag 32)
					2
				)
				((and global127 (not (IsFlag 31))) 8)
				((== global100 8) 4)
				(global162 9)
				((== global100 0) 1)
				((== gPrevRoomNum 7) 9)
				((== gPrevRoomNum 12) 9) ; phone
				((== global138 1) 2)
				((== global138 2) 2)
				((== global100 12) 6)
				(global161 3)
				(else 0)
			)
		)
		(= global212 3)
		(self setScript: rm4Script)
		(self setLocales: 156)
		(gEgo view: (if (not global204) 1 else 7))
		(switch gPrevRoomNum
			(2
				(gEgo posn: 120 162 init: setMotion: MoveTo 120 10)
				(User prevDir: 1)
			)
			(7
				(gEgo posn: 238 148 loop: 3 init:)
			)
			(300
				(gEgo posn: 111 144 loop: 1 init:)
			)
			(12 ; phone
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					view: 3
					loop: 3
					cel: 255
					posn: 182 130
					init:
					setCycle: Beg
				)
				(User canInput: 1)
				(phone cel: 255 loop: 1 posn: 172 116 setCycle: Beg init:)
				(= local3 1)
				(if (and (!= global138 1) (== global100 7) (not (IsFlag 45)))
					(SetFlag 45)
					(captainScript changeState: 14)
				)
			)
			(else
				(gEgo posn: 198 146 init: setMotion: MoveTo 198 946)
			)
		)
	)
)

(instance rm4Script of Script
	(properties)

	(method (doit)
		(cond
			(local3 0)
			((<= (gEgo y:) 126)
				(if (!= (mod (gEgo view:) 2) 0)
					(gEgo view: (- (gEgo view:) 1))
				)
			)
			((!= (mod (gEgo view:) 2) 1)
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(cond
			((>= (gEgo y:) 165)
				(if (and (gEgo has: 3) (< 5 global100 8)) ; unmarked_car_keys
					(localproc_0 4 0) ; "As you pass his desk, Captain Hall says, "Wait, Bonds, leave the unmarked car keys here.""
					(localproc_0 4 1) ; "You drop the keys on his desk, and hurry out the door."
					(PutItem 3) ; unmarked_car_keys
					(= global133 1)
				)
				(= global162
					(if (and global164 (== global138 0))
						(or
							(== local4 2)
							(== local4 1)
							(== local4 6)
							(== local4 8)
							(== local4 9)
						)
					)
				)
				(if (and (!= global138 1) (== global100 6))
					(localproc_0 4 2) ; "You've done your work for today, Bonds," Captain Hall declares. "You're off duty as of now."
					(= global138 1)
				)
				(gCurRoom newRoom: 2)
			)
			(
				(and
					(== local4 1)
					(not global163)
					(< (gEgo distanceTo: global112) 27)
				)
				(keithScript changeState: 0)
			)
			(
				(and
					(== local4 1)
					global163
					(not global164)
					(< (gEgo distanceTo: captain) 64)
				)
				(captainScript changeState: 0)
			)
			((and (== local4 8) (not (IsFlag 31)))
				(captainScript changeState: 25)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and local6 (> local4 3))
					(= local4 9)
					(= local6 0)
				)
				(switch local4
					(1
						(= local2 2)
					)
					(2
						(= local2 3)
					)
					(4
						(= local2 2)
					)
					(6
						(= local2 5)
					)
					(7
						(= local2 3)
					)
					(8
						(= local2 1)
					)
					(else
						(= local2 (Random 1 6))
					)
				)
				(phone
					view: 3
					setLoop: 1
					setCel: 0
					posn: 172 116
					setPri: 9
					init:
					stopUpd:
				)
				(captain view: 65 posn: 53 134 cel: 0 setPri: 9 init:)
				(if (<= local2 3)
					(captain loop: 3 stopUpd:)
					(blab
						view: 65
						loop: 1
						posn: 48 112
						setPri: 12
						setCycle: Fwd
						cycleSpeed: 2
						init:
					)
				else
					(captain loop: 4 setCycle: Fwd cycleSpeed: 7)
				)
				((= global112 (View new:)) view: 65 init:)
				(switch local2
					(1
						(global112 view: 62 posn: 213 134 loop: 0 cel: 0)
					)
					(2
						(global112 posn: 210 136 loop: 6 cel: 0)
					)
					(3
						(global112 posn: 133 130 loop: 6 cel: 0)
					)
					(4
						(global112 posn: 163 148 loop: 6 cel: 0)
					)
					(5
						(global112 posn: 120 140 loop: 7 cel: 0)
					)
					(6
						(global112 posn: 214 148 loop: 7 cel: 0)
					)
				)
				(global112 stopUpd:)
				(if (!= local2 1)
					(smoke
						view: 65
						loop: 2
						posn:
							(if (> local2 4)
								(+ (global112 x:) 5)
							else
								(- (global112 x:) 5)
							)
							(- (global112 y:) 31)
						setPri: 9
						cycleSpeed: 3
						setCycle: Fwd
						init:
					)
				)
				(rambo
					view: 65
					posn: 111 110
					loop: 5
					cel: (if (== (mod local2 2) 0) 0 else 1)
					setPri: 7
					init:
					addToPic:
				)
				(carKey
					view: 65
					posn:
						(if (IsItemAt 3) 141 else 0) ; unmarked_car_keys
						(if (IsItemAt 3) 110 else 0) ; unmarked_car_keys
					loop: 5
					cel: 2
					init:
					stopUpd:
				)
				((View new:)
					view: 65
					posn: 183 135
					loop: 6
					cel: 1
					init:
					ignoreActors:
					addToPic:
				)
				(switch local4
					(2
						(cond
							((== global138 1)
								(captainScript changeState: 14)
							)
							((== global138 2)
								(captainScript changeState: 12)
							)
							(else
								(captainScript changeState: 5)
							)
						)
					)
					(4
						(captainScript changeState: 16)
					)
					(6
						(captainScript changeState: 19)
					)
				)
			)
			(1
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(rm4 setScript: drawerScript)
			)
			(3
				(HandsOff)
				(gEgo
					posn: 182 130
					view: 3
					loop: 2
					cel: 3
					setCycle: Beg self
					setMotion: 0
				)
				(gCurRoom drawPic: 4)
			)
			(4
				(gEgo loop: 0)
				(User canInput: 1)
			)
			(5
				(gEgo loop: 3 cel: 0 setCycle: End self)
				(phone setCel: -1 setCycle: End startUpd:)
			)
			(6
				(gCurRoom newRoom: 12) ; phone
			)
			(7
				(gEgo setCycle: Beg self)
				(phone setCycle: Beg)
			)
			(8
				(gEgo loop: 0 cel: 0)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said
								'show,give,tell/clue,list,note,threat,card,clue'
							)
							(Said
								'show,give,tell/hall/clue,list,note,threat,card,clue'
							)
						)
						(cond
							((not (gEgo inRect: 70 131 122 156))
								(proc0_7) ; "You're not close enough."
							)
							((not local7)
								(Print 4 3) ; "Captain Hall is too busy right now."
							)
							(
								(or
									(gEgo has: 13) ; hit_list
									(gEgo has: 35) ; Colby_s_business_card
									(IsFlag 136)
								)
								(captainScript changeState: 28)
							)
							(else
								(Print 4 4) ; "The captain says, "It doesn't seem you have anything yet.""
							)
						)
					)
					((Said 'look,read/file')
						(if (gEgo inRect: 71 130 124 157)
							(Print 4 5) ; "The folders are all closed, and you see nothing of interest."
						else
							(Print 4 6) ; "You see no folders here."
						)
					)
					((Said 'look,read/newspaper,flyer')
						(cond
							((gEgo inRect: 122 117 168 124)
								(Print 4 7) ; "You scan the bulletin board and see the shooting schedule. Below the board, is a rack of car keys."
								(Print 4 8) ; "The shooting schedule indicates you are behind on your scores."
								(SetScore 1 123)
							)
							(
								(and
									(gEgo inRect: 70 128 99 140)
									(== (gEgo loop:) 1)
								)
								(Print 4 9) ; "The papers on the board are a year old."
							)
							((gEgo inRect: 71 130 124 157)
								(Print 4 10) ; "Among the many papers on Captain Hall's desk, one catches your interest. You read:"
								(Print 4 11) ; "Passwords: MIAMI ICECREAM PISTACHIO"
								(SetScore 1 124)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					(
						(or
							(Said 'look,read/*<you<thank')
							(Said 'look,read/letter')
						)
						(if (and (gEgo has: 5) (!= local4 3)) ; thank_you_letter
							((gInventory at: 5) showSelf:) ; thank_you_letter
						else
							(event claimed: 0)
						)
					)
					((Said 'talk[/man,cop,person]')
						(cond
							((gEgo inRect: 70 131 122 156)
								(Print 4 12) ; "Captain Hall doesn't like to be interrupted."
							)
							((gEgo inRect: 90 117 137 132)
								(Print 4 13) ; "Jim is a muscular, quiet man. He has nothing to say to you."
							)
							((< (gEgo distanceTo: global112) 46)
								(Print 4 14) ; "Keith smiles and says, "Take it easy, partner.""
							)
							(else
								(Print 4 15) ; "Get closer to him."
							)
						)
					)
					((or (Said 'ask,get//order') (Said 'ask,get/order'))
						(Print 4 16) ; "You've been given your orders."
					)
					((Said 'talk,ask/hall')
						(if (!= global138 1)
							(if (== (captain loop:) 3)
								(Print 4 17) ; "The Captain is on the phone."
							else
								(Print 4 18) ; "With a slurp and a smack, the Captain says,"Not now please, I'm eating my ice cream!""
							)
						else
							(captainScript changeState: 14)
						)
					)
					((Said 'talk,ask/james,pierson')
						(if (gEgo inRect: 90 117 137 132)
							(Print 4 19) ; "Yo, Sonny," mumbles Detective Jim (Rambo) Pierson, "I'm on the phone."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((or (Said 'talk,get,ask/friend,friend') (Said 'let/go'))
						(if (< (gEgo distanceTo: global112) 40)
							(switch global138
								(2
									(Print 4 20) ; "You go ahead, partner," Keith says, "I'll be right out."
								)
								(1
									(Print 4 21) ; "Have fun, partner," Keith says, "I'll see you tomorrow."
								)
								(else
									(Print 4 22) ; "Keith apparently is lost in thought - but you know better."
								)
							)
						else
							(Print 4 23) ; "Keith doesn't appear to hear you. Maybe you should get closer?"
						)
					)
					((Said 'press,move/friend')
						(Print 4 24) ; "You did that once. He fell off his chair, hit his head, and he's never been the same since."
					)
					((Said 'get,remove,pick/')
						(if (gEgo inRect: 70 131 122 153)
							(Print 4 25) ; "The Captain doesn't like you messing with the things on his desk."
						else
							(event claimed: 0)
						)
					)
					((Said '/briefcase')
						(Print 4 26) ; "You can't use that right now."
					)
					((or (Said '/shot<mug') (Said '/mugshot'))
						(Print 4 27) ; "There are no mugshots here."
					)
					((Said 'turn<on/computer')
						(Print 4 28) ; "Look at it first."
					)
					((Said 'look,use/computer')
						(if
							(or
								(== (gEgo onControl:) 16384)
								(== (gEgo onControl:) -16384)
							)
							(gCurRoom newRoom: 8)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'look,read,frisk>')
						(cond
							((Said '/light,lamp')
								(Print 4 29) ; "It's just a lamp."
							)
							((Said '<in/drawer')
								(Print 4 30) ; "Open the drawer first."
							)
							((Said '/drawer')
								(Print 4 31) ; "All the drawers around here look the same."
							)
							((Said '/cone')
								(if (== (captain loop:) 3)
									(Print 4 32) ; "What ice cream? Captain Hall isn't eating ice cream."
								else
									(Print 4 33) ; "Captain Hall's favorite: pistachio."
								)
							)
							((Said '/locker')
								(Print 4 34) ; "The locker belongs to the Captain."
							)
							((Said '/key,coatrack')
								(Print 4 35) ; "The keys are for the unmarked cars."
							)
							((Said '/wall')
								(Print 4 36) ; "On the wall you see a map, two bulletin boards, and some keys."
							)
							((Said '/file,cabinet<in,in')
								(Print 4 37) ; "That's easier to do if you open it first."
							)
							((Said '/board[<bulletin]')
								(cond
									((gEgo inRect: 122 117 168 124)
										(Print 4 7) ; "You scan the bulletin board and see the shooting schedule. Below the board, is a rack of car keys."
										(Print 4 8) ; "The shooting schedule indicates you are behind on your scores."
										(SetScore 1 123)
									)
									(
										(and
											(gEgo inRect: 70 128 99 140)
											(== (gEgo loop:) 1)
										)
										(Print 4 38) ; "The papers on the board are a year old, and of no interest."
									)
									(else
										(Print 4 39) ; "Go up to it and take a look."
									)
								)
							)
							((Said '/score,schedule')
								(SetScore 1 123)
								(Print 4 8) ; "The shooting schedule indicates you are behind on your scores."
							)
							(
								(Said
									'[<at,around][/(!*,chamber,office,homicide)]'
								)
								(Print 4 40) ; "This is the Homicide Office."
								(Print 4 41) ; "The Homicide Office is equipped with five desks, a file cabinet, a locker, and various other items hanging on the wall. On one of the desks is a computer."
							)
						)
					)
				)
				(cond
					(
						(Said
							'look,get,read,check/basket,subpoena,note,envelope,finding,newspaper'
						)
						(event claimed: 0)
						(if (or (gEgo inRect: 130 123 188 144) local3)
							(cond
								(
									(and
										(< global100 6)
										(Said
											'/basket,subpoena,envelope,newspaper'
										)
									)
									(SetScore 1 64)
									(localproc_0 4 42) ; "In the basket you see a subpoena."
									(localproc_0 4 43) ; "You pick up and read the subpoena."
									(localproc_0 4 44 70 240) ; "You are commanded to appear in Division 4, Superior Court of the City of Lytton, as a witness for the People in the retrial matter against the defendant, Jessie Bains. Notification of time and date will follow."
									(Print 4 45 #at -1 120) ; "You can't believe what you just read! Just as the memory of this rat was passing into oblivion, he's back for a retrial."
								)
								(
									(and
										(>= global100 8)
										(Said
											'/basket,envelope,finding,newspaper'
										)
									)
									(if
										(or
											(IsFlag 128)
											(IsFlag 131)
											(IsFlag 132)
											(IsFlag 130)
											(IsFlag 134)
											(IsFlag 127)
											(IsFlag 133)
											(IsFlag 129)
										)
										(SetScore 3 65)
										(localproc_0 4 46) ; "In the basket you see a manila envelope."
										(localproc_0 4 47) ; "You remove the envelope, which is marked: "Crime Lab.""
										(Print 4 48 #at -1 40) ; "While opening the envelope, you think..."It's the test results on the evidence.""
										(if (IsFlag 128)
											(Print 4 49) ; "Fingerprint tape:   Location found:    Glove box of deceased jailer's car   Findings of forensic examination:    Positive match - Jessie H. Bains"
										)
										(if (IsFlag 129)
											(Print 4 50) ; "Fingerprint tape:   Location found:    Rear view mirror of stolen car   Findings of forensic examination:    Positive match - Jessie H. Bains"
										)
										(cond
											((IsFlag 131)
												(Print 4 51) ; "Coagulated Blood:   Location found:    River bank   Findings of forensic examination:    Blood type: A+ (same as jailer's)"
											)
											((IsFlag 132)
												(Print 4 52) ; "Footprint cast:   Location found:    River bank   Findings of examination    Size 10d (new)"
											)
											((IsFlag 130)
												(Print 4 53) ; "Makeshift knife:   Location found:    Bottom of River   Findings of examination    Weapon made from spoon    "New Floral Design"    By "Superior Dinner Ware MFG CO."    Same pattern is used at Lytton Jail."
											)
											((IsFlag 134)
												(Print 4 54) ; "Clothing:   Location found:    Approx. 300yds up river from footprints  Findings of examination    #1 shirt - jail issue. size, med.    #2 trousers - jail issue. size, 36"
											)
											((IsFlag 127)
												(Print 4 55) ; "Hand gun: Ser. Num. S/W 5557763       4" Smith&Wesson 38cal K-38   Location found:    Airport rest room (toilet tank)   Registered to:    Luis Pate (jailer)   Findings of forensic examination:    Fingerprints - Inconclusive    Ballistics - test round      (from glove box of jailer's car)       fired from this weapon,       match with bullet removed       from Jailers head."
											)
											((IsFlag 133)
												(Print 4 56) ; "Ammunition: (3 rounds)   Location found:    Glove box of jailer's car   Test findings:    Ballistics - (see above)      Lytton PD departmental issue      ammunition"
											)
										)
										(Print 4 57) ; "...END OF REPORT."
									else
										(Print 4 58) ; "Your basket is empty."
									)
								)
								(
									(and
										global161
										(Said '/basket,note,letter,newspaper')
									)
									(localproc_0 4 59) ; "You see a note in your basket."
									(localproc_0 4 60) ; "You pick up and read the note..."
									(localproc_0 4 61) ; "Bonds, Marie called while you were out. She wants you to call her as soon as possible."
								)
								(else
									(Print 4 62) ; "You don't see that in your basket."
									(event claimed: 1)
								)
							)
						else
							(Print 4 63) ; "It's not nice to look in other people's baskets."
							(event claimed: 1)
						)
					)
					((Said 'look/man,person,cop')
						(cond
							((gEgo inRect: 75 131 122 153)
								(Print 4 64) ; "Captain Fletcher Hall is a very large man with an over-powering presence."
							)
							((gEgo inRect: 90 117 142 132)
								(Print 4 65) ; "Although short, Detective Jim Pierson keeps himself in excellent physical condition. He rarely speaks unless spoken to."
							)
							((< (gEgo distanceTo: global112) 30)
								(Print 4 66) ; "Your partner, Keith Robinson, is an easy-going, veteran detective. He doesn't let his job interfere with his relaxation."
							)
							(else
								(Print 4 67) ; "Get closer."
							)
						)
					)
					((Said 'look/hall')
						(Print 4 64) ; "Captain Fletcher Hall is a very large man with an over-powering presence."
					)
					((Said 'look/james')
						(if (gEgo inRect: 90 117 142 132)
							(Print 4 65) ; "Although short, Detective Jim Pierson keeps himself in excellent physical condition. He rarely speaks unless spoken to."
						)
					)
					((Said 'look/friend')
						(Print 4 66) ; "Your partner, Keith Robinson, is an easy-going, veteran detective. He doesn't let his job interfere with his relaxation."
					)
					((Said 'look/desk')
						(cond
							((gEgo inRect: 71 131 122 156)
								(Print 4 68) ; "This is Captain Fletcher Hall's desk. On it, you see some folders and papers."
							)
							((gEgo inRect: 90 117 140 132)
								(Print 4 69) ; "This is Detective Jim Pierson's desk."
							)
							((gEgo inRect: 189 117 244 139)
								(Print 4 70) ; "This is your partner, Keith Robinson's desk."
							)
							((gEgo inRect: 154 140 235 200)
								(Print 4 71) ; "This desk is used for the computer, which is shared by everyone in the office."
							)
							(else
								(Print 4 72) ; "Your desk is equipped with drawers, a phone, a message basket, and a lamp."
							)
						)
					)
					((Said 'get,remove/subpoena')
						(if (< global100 6)
							(Print 4 73) ; "Leave it in the basket. The station's clerical staff is very good at filing these things away for you."
						else
							(Print 4 74) ; "The subpoena has been filed away."
						)
					)
					((Said 'get,remove/note')
						(if (== global100 6)
							(Print 4 75) ; "As you reach for the note, you think... "Nah, just one more piece of paper to carry around."
						else
							(Print 4 76) ; "The note is gone. Clerks periodically clean out your basket, so that important papers aren't allowed to sit."
						)
					)
					((Said 'get,remove/clue,finding,envelope')
						(if (>= global100 8)
							(Print 4 73) ; "Leave it in the basket. The station's clerical staff is very good at filing these things away for you."
						else
							(Print 4 77) ; "What? You see nothing like that here."
						)
					)
					((Said 'read,look/schedule[<fire]')
						(if (gEgo inRect: 122 117 168 124)
							(Print 4 8) ; "The shooting schedule indicates you are behind on your scores."
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'open,close/locker')
						(Print 4 78) ; "The Captain keeps it closed and locked."
					)
					(
						(or
							(Said 'open/cabinet[<file]')
							(and
								(gEgo inRect: 227 138 260 152)
								(Said 'open/drawer<file')
							)
						)
						(if (gEgo inRect: 232 138 260 152)
							(gCast eachElementDo: #startUpd)
							(gCurRoom newRoom: 7)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'close/(cabinet[<file]),file')
						(if (== gPrevRoomNum 7)
							(Print 4 79) ; "You closed it yourself."
						else
							(Print 4 80) ; "It's already closed."
						)
					)
					((Said 'get,remove/key')
						(if (gEgo inRect: 122 117 168 124)
							(if (gEgo has: 3) ; unmarked_car_keys
								(Print 4 81) ; "You already have them."
							else
								(gEgo get: 3) ; unmarked_car_keys
								(carKey posn: 0 0)
								(Print 4 82) ; "You remove the keys from the board."
								(SetScore 1 104)
							)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'drop,replace/key')
						(if (gEgo has: 3) ; unmarked_car_keys
							(if (gEgo inRect: 122 117 168 124)
								(PutItem 3) ; unmarked_car_keys
								(carKey posn: 141 110)
								(Print 4 83) ; "OK."
							else
								(proc0_7) ; "You're not close enough."
							)
						else
							(proc0_9) ; "You don't have it."
						)
					)
					((Said 'sat')
						(cond
							(local3
								(Print 4 84) ; "You're already sitting."
							)
							((gEgo inRect: 170 122 196 141)
								(HandsOff)
								(User canInput: 1)
								(= local3 1)
								(= global204 0)
								(gEgo
									view: 3
									loop: 0
									cel: 0
									setMotion: 0
									setCycle: 0
									ignoreActors:
									illegalBits: 0
									posn: 182 130
								)
							)
							(else
								(proc0_7) ; "You're not close enough."
							)
						)
					)
					((or (Said 'stand[<up]') (Said 'get<up'))
						(if local3
							(HandsOn)
							(NormalEgo)
							(gEgo view: 1 loop: 1 cel: 9 posn: 192 136)
							(= local3 0)
						else
							(Print 4 85) ; "You're standing already."
						)
					)
					((Said 'open/drawer,desk')
						(if local3
							(if (not (IsFlag 12))
								(self changeState: 1)
							else
								(Print 4 86) ; "You need to unlock it first."
							)
						else
							(Print 4 87) ; "Sit at your desk to open your desk drawer."
						)
					)
					((Said 'unlock/drawer,desk')
						(if local3
							(cond
								((not (IsFlag 12))
									(Print 4 88) ; "It's already unlocked."
								)
								((gEgo has: 2) ; key_ring
									(Print 4 89) ; "You unlock and open your drawer."
									(ClearFlag 12)
									(self changeState: 1)
								)
								(else
									(Print 4 90) ; "You don't have the key to the drawer."
								)
							)
						else
							(Print 4 91) ; "You must sit down first."
						)
					)
					((Said 'lock/drawer,desk')
						(if local3
							(cond
								((IsFlag 12)
									(Print 4 92) ; "It's already locked."
								)
								((gEgo has: 2) ; key_ring
									(Print 4 83) ; "OK."
									(SetFlag 12)
								)
								(else
									(Print 4 90) ; "You don't have the key to the drawer."
								)
							)
						else
							(Print 4 91) ; "You must sit down first."
						)
					)
					((or (Said 'lock,close/drawer') (Said 'stand'))
						(if local3
							(if (== (rm4 script:) drawerScript)
								(self changeState: 3)
							else
								(Print 4 93) ; "The drawer's already closed."
							)
						else
							(Print 4 94) ; "You should sit down first."
						)
					)
					((Said 'use,get,dial,(pick<up)/phone')
						(if local3
							(self changeState: 5)
							(= local5 1)
						else
							(Print 4 95) ; "Sit at your desk to use the phone."
						)
					)
					(
						(or
							(Said 'drop[<down]/phone')
							(Said 'replace/phone')
							(Said 'hang<up[/phone]')
						)
						(if (and local5 local3)
							(= local5 0)
							(self changeState: 7)
						else
							(Print 4 95) ; "Sit at your desk to use the phone."
						)
					)
					((and (Said 'call,phone/') (not local5))
						(Print 4 96) ; "Better use the phone."
					)
				)
			)
		)
	)
)

(instance drawerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 12)
				(if (IsItemAt 5 12) ; thank_you_letter
					((= local0 (View new:))
						view: 59
						loop: 0
						cel: 2
						posn: 146 115
						init:
						ignoreActors:
						stopUpd:
					)
				)
				(if (IsItemAt 7 12) ; wallet
					((= local1 (View new:))
						view: 59
						loop: 0
						cel: 0
						posn: 190 105
						init:
						ignoreActors:
						stopUpd:
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'get,remove/letter,card')
						(if (IsItemAt 5 12) ; thank_you_letter
							(local0 dispose:)
							(Print 4 83 #draw) ; "OK."
							(gEgo get: 5) ; thank_you_letter
							(SetScore 1 106)
						else
							(Print 4 97) ; "That isn't in the drawer."
						)
					)
					((Said 'get,remove/note')
						(if (IsItemAt 5 12) ; thank_you_letter
							(Print 4 98) ; "You see a letter, not a note in the drawer."
						else
							(Print 4 97) ; "That isn't in the drawer."
						)
					)
					((Said 'get/billfold')
						(if (IsItemAt 7 12) ; wallet
							(local1 dispose:)
							(Print 4 83 #draw) ; "OK."
							(gEgo get: 7) ; wallet
							(SetScore 1 105)
						else
							(Print 4 97) ; "That isn't in the drawer."
						)
					)
					((Said 'drop,replace/letter,card')
						(if (gEgo has: 5) ; thank_you_letter
							((= local0 (View new:))
								view: 59
								posn: 146 115
								loop: 0
								cel: 2
								init:
								ignoreActors:
								stopUpd:
							)
							(gEgo put: 5 12) ; thank_you_letter
						else
							(Print 4 99) ; "You don't have that."
						)
					)
					((Said 'drop,replace/billfold')
						(if (gEgo has: 7) ; wallet
							((= local1 (View new:))
								view: 59
								posn: 190 105
								loop: 0
								cel: 0
								init:
								stopUpd:
							)
							(gEgo put: 7 12) ; wallet
						else
							(proc0_9) ; "You don't have it."
						)
					)
					((Said 'look,frisk[/drawer]')
						(gInventory
							carrying: {Your desk drawer contains:}
							empty: {Your desk drawer is empty.}
							showSelf: 12
						)
					)
					(
						(or
							(Said 'look,read/*<you<thank')
							(Said 'look,read/letter')
						)
						(if (IsItemAt 5 12) ; thank_you_letter
							(Print 4 100) ; "You see it in the drawer."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/shot<mug') (Said '/mugshot'))
						(Print 4 27) ; "There are no mugshots here."
					)
					((Said 'close[/drawer]')
						(gCurRoom drawPic: (gCurRoom picture:))
						(gCast eachElementDo: #dispose)
						(gCast eachElementDo: #delete)
						(gEgo init:)
						(= local6 1)
						(rm4 setScript: rm4Script)
						(rm4Script changeState: 3)
					)
				)
			)
		)
	)
)

(instance captainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(User canInput: 0)
				(gEgo stopUpd:)
				(= global164 1)
				(captain setCycle: End)
				(aTimer setCycle: self 18)
			)
			(1
				(localproc_0 4 101) ; "The Captain speaks up and says..."
				(aTimer setCycle: self 18)
			)
			(2
				(localproc_0 4 102) ; "Well Bonds, no doubt you heard about Jessie Bains by now."
				(aTimer setCycle: self 18)
			)
			(3
				(localproc_0 4 103) ; "The District Attorney told me that the reason this jackass won a retrial was some technical BS about improper jury instruction."
				(aTimer setCycle: self 10)
			)
			(4
				(localproc_0 4 104) ; "It's a real shame, but that's life."
				(if local3
					(User canInput: 1)
				else
					(HandsOn)
				)
				(gEgo startUpd:)
				(captain setCycle: Beg)
			)
			(5
				(aTimer setReal: self 3)
			)
			(6
				(if (not local3)
					(gEgo loop: 1)
				)
				(HandsOff)
				(User canInput: 0)
				(= global100 1)
				(= global158 300)
				(= global138 2)
				(= global164 1)
				(captain setCycle: End)
				(aTimer setCycle: self 18)
			)
			(7
				(Print 4 105 #at -1 130 #draw) ; "Bonds, we have bad news. Jessie Bains has escaped Lytton City Jail!"
				(aTimer setCycle: self 18)
				(bainsTheme play:)
			)
			(8
				(localproc_0 4 106) ; "Not only has he escaped," the Captain says,"but he took the jailer as hostage!"
				(aTimer setCycle: self 18)
			)
			(9
				(localproc_0 4 107) ; ""Bonds, I've named you and your partner Keith, to a special task force with the code name of 'Target.'"
				(aTimer setCycle: self 18)
			)
			(10
				(localproc_0 4 108) ; "The Captain continues:"I want you boys to answer any and all calls that might be even remotely connected to this dirtbag!""
				(aTimer setCycle: self 18)
			)
			(11
				(localproc_0 4 109) ; "The Captain orders you: "Find a mug shot of that punk, and get on this immediately!""
				(if local3
					(User canInput: 1)
				else
					(HandsOn)
				)
				(= global138 2)
				(captain setCycle: Beg)
			)
			(12
				(HandsOff)
				(User canInput: 0)
				(if (not local3)
					(gEgo loop: 1)
				)
				(= global164 1)
				(captain setCycle: End)
				(aTimer setCycle: self 18)
			)
			(13
				(switch (Random 0 2)
					(0
						(localproc_0 4 110) ; "You have your orders, Bonds!"
					)
					(1
						(localproc_0 4 111) ; "You're wasting valuable time, Bonds!"
					)
					(2
						(localproc_0 4 112) ; "You're a detective. Start earning your money!"
					)
				)
				(if local3
					(User canInput: 1)
				else
					(HandsOn)
				)
				(gEgo startUpd:)
				(captain setCycle: Beg)
			)
			(14
				(HandsOff)
				(User canInput: 0)
				(if (not local3)
					(gEgo loop: 1)
				)
				(= global164 1)
				(= global138 1)
				(captain setCycle: End)
				(aTimer setCycle: self 18)
			)
			(15
				(switch (Random 0 1)
					(0
						(localproc_0 4 113) ; "Bonds," says the Captain, "go ahead and take off. You've earned your daily dollar."
					)
					(1
						(localproc_0 4 114) ; "You're on your own time boy....Go somewhere!"
					)
				)
				(if local3
					(User canInput: 1)
				else
					(HandsOn)
				)
				(captain setCycle: Beg)
			)
			(16
				(HandsOff)
				(User canInput: 0)
				(gEgo setMotion: MoveTo 60 134)
				(= global164 1)
				(= global138 2)
				(= global100 10)
				(= global158 600)
				(captain setCycle: End)
				(aTimer setCycle: self 18)
			)
			(17
				(gEgo loop: 1)
				(Print 4 115 #at -1 130 #draw) ; "Hey Bonds!" the Captain blurts. "We have a traffic cop standing by down in the old warehouse district with a 187 victim."
				(localproc_0 4 116) ; "Continuing, the Captain says: "The victim took it in the back of the head. Looks like it could be a professional hit.""
				(gEgo startUpd:)
				(aTimer setCycle: self 18)
			)
			(18
				(localproc_0 4 117) ; "Sonny! The address is 160 West Rose. Take Keith and get over there!"
				(captain setCycle: Beg)
				(if local3
					(User canInput: 1)
				else
					(HandsOn)
				)
				(gEgo setMotion: 0)
			)
			(19
				(HandsOff)
				(= global164 1)
				(captain setCycle: Beg)
				(blab
					view: 65
					loop: 1
					posn: 48 112
					setPri: 12
					setCycle: Fwd
					cycleSpeed: 2
					init:
				)
				(aTimer setCycle: self 18)
			)
			(20
				(gEgo loop: 1)
				(Print 4 118 #at -1 130 #draw) ; ""Keith just told me about the motel incident!" the Captain says in an excited voice."
				(localproc_0 4 119) ; "Good thing Keith was there with you, keeping a cool head and following procedures."
				(aTimer setCycle: self 18)
			)
			(21
				(localproc_0 4 120) ; "The Captain continues... "I've been thinking....I don't like what I see.""
				(localproc_0 4 121) ; "Point #1:" says Fletch, "The murder victim, Woody Roberts, testified against Bains at his trial last year."
				(aTimer setCycle: self 18)
			)
			(22
				(localproc_0 4 122) ; "Point #2:" he continues, "Bonds, you also testified against Bains last year."
				(aTimer setCycle: self 18)
			)
			(23
				(localproc_0 4 123) ; "Point #3: You were led into a booby trap at the motel. If you ask me," he says, "this whole thing is shaping up as a vendetta!"
				(aTimer setCycle: self 18)
			)
			(24
				(localproc_0 4 124) ; "In a worried tone of voice, the Captain says,"You boys better start digging. We appear to have a vengeful maniac on our hands!""
				(blab dispose:)
				(captain setCycle: Fwd)
				(HandsOn)
			)
			(25
				(SetFlag 31)
				(bainsTheme play:)
				(HandsOff)
				(gEgo loop: 1)
				(if (not (IsFlag 27))
					(Print 4 125 #at -1 130 #draw) ; "Barely able to contain your emotions, you quickly tell Captain Hall about the signs of a struggle at Marie's."
				)
				(captain setCycle: End)
				(aTimer setCycle: self 18)
			)
			(26
				(gEgo loop: 1)
				(Print 4 126 #at -1 130 #draw) ; ""Sorry to hear about Marie, Sonny," Captain Fletcher offers."
				(aTimer setCycle: self 8)
			)
			(27
				(localproc_0 4 127) ; "If you boys have a solid lead, now's the time to bring it up."
				(blab hide:)
				(HandsOn)
				(= local7 1)
			)
			(28
				(blab show: setCycle: Fwd)
				(aTimer setCycle: self 9)
			)
			(29
				(if (gEgo has: 13) ; hit_list
					(localproc_0 4 128) ; "The Captain takes the victim list from you and begins to read."
				else
					(localproc_0 4 129) ; "Captain Fletcher Hall says, "While you were out, I dug around in the files and came up with a list of folks who testified against Bains.""
					(localproc_0 4 130) ; "They are..." he says, reading the list, "Woody Roberts, Don Colby, Marie Wilkans, and Sonny Bonds."
				)
				(aTimer setCycle: self 12)
			)
			(30
				(Print 4 131 #at -1 120) ; "Huummm," the Captain mumbles. "Everyone on this list testified against Bains, and are now either dead or missing. Except you and Colby."
				(localproc_0 4 132) ; "The question is, Sonny: will he go after you or Colby next?"
				(aTimer setCycle: self 18)
			)
			(31
				(cond
					((gEgo has: 35) ; Colby_s_business_card
						(localproc_0 4 133) ; "Captain Hall takes the card from you. "So, Bains knows where Colby is!""
						(localproc_0 4 134) ; "This chump Bains," he continues, "most likely has kidnapped Marie to use her as a hostage. He's trying to sucker you into another set-up, Bonds."
						(localproc_0 4 135) ; "A maniac like Bains is hard to read, boys," Captain Hall muses. "You've got a blank check to proceed however you feel is best."
					)
					((IsFlag 136)
						(localproc_0 4 136) ; "I've looked over the evidence and see that Bains now knows where Colby is."
						(localproc_0 4 134) ; "This chump Bains," he continues, "most likely has kidnapped Marie to use her as a hostage. He's trying to sucker you into another set-up, Bonds."
						(localproc_0 4 135) ; "A maniac like Bains is hard to read, boys," Captain Hall muses. "You've got a blank check to proceed however you feel is best."
					)
					(else
						(localproc_0 4 137) ; "Colby's where-abouts are unknown to Bains," Captain Hall thinks aloud, "so Bains will probably stick around to take another crack at you, Sonny."
					)
				)
				(aTimer setCycle: self 18)
			)
			(32
				(if (or (gEgo has: 35) (IsFlag 136)) ; Colby_s_business_card
					(= global100 13)
				)
				(if (or (gEgo has: 35) (gEgo has: 13)) ; Colby_s_business_card, hit_list
					(if (gEgo has: 35) ; Colby_s_business_card
						(PutItem 35 2) ; Colby_s_business_card
					)
					(if (gEgo has: 13) ; hit_list
						(PutItem 13 2) ; hit_list
					)
					(localproc_0 4 138) ; "I'll book this evidence for you. You'd better decide what to do next... and FAST!"
				)
				(captain setCycle: Beg)
			)
		)
	)
)

(instance keithScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0 canControl: 0)
				(= global163 1)
				(Print 4 139 #at 110 40 #draw) ; "Your partner Keith takes a deep puff and says:"
				(Print 4 140 #at 110 40) ; "Say, Sonny...I heard that dirtbag you sent up the river last year is back in town for retrial. Isn't his name Bains, or something like that?"
				(Print 4 141 #at 110 40) ; "Maybe this time you can put him away for the duration."
				(Print 4 142 #at 110 40) ; "It just seems like the garbage of this world gets every chance known to man."
				(User canInput: 1 canControl: 1)
			)
		)
	)
)

