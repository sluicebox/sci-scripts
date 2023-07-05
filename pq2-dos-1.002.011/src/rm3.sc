;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm3 0
)

(synonyms
	(cop detective)
	(steve jones)
	(dooley lieutenant)
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
	local8
	local9
	local10
	local11
	local12
)

(procedure (localproc_0)
	(switch local11
		(0
			(mugShot loop: 2 cel: 0 init:)
			(RedrawCast)
			(Display 3 67 dsCOORD 120 10 dsWIDTH 180 dsFONT 0) ; "CASE#: N5553232 Name: Donald J. Colby. ALIAS: none. ADDRESS: As of 4/2/86       23110 Union St.       Steelton, USA"
			(Display 3 68 dsCOORD 20 65 dsWIDTH 280) ; "SCARS/TATTOOS: none  DOB: 2/19/48. PHYS: wht/male, 5'7", blk, brn, 145. ASSIGNED TO: Watts, Laura A/O: Bonds & Watts ARREST RECORD: Narcotics for sale  CONVICTED: 10/5/83  INCARCERATED: none.  LOCATION: none.  SENTENCE: 1 year suspended sentence         1 year probation  PAROLE DATE: None. CASE STATUS: Closed. NOTE: Provided testimony in murder trial    against Jessie Bains."
		)
		(1
			(mugShot loop: 1 cel: 2 init:)
			(RedrawCast)
			(Display 3 69 dsCOORD 120 10 dsWIDTH 180 dsFONT 0) ; "CASE#: N5550001 Name: Moffet Dickey ALIAS: none ADDRESS: 329 E. Peach St.       Lytton City, USA"
			(Display 3 70 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: none  DOB: 3/20/28. PHYS: wht/male, 6'0", bln, blu, 150. ASSIGNED TO: Pratt A/O: Pratt ARREST RECORD:  Narcotics possession  CONVICTED: 10/3/86  INCARCERATED: none.  LOCATION: none  SENTENCE: 1 year suspended sentence         with 6 mo probation  PAROLE DATE: none. CASE STATUS: Closed"
		)
		(2
			(mugShot loop: 0 cel: 2 init:)
			(RedrawCast)
			(Display 3 71 dsCOORD 120 10 dsWIDTH 180 dsFONT 0) ; "CASE#: N5554999 Name: Robin Jones. ALIAS: none. ADDRESS:302 Parkway Drive      Lytton City, USA."
			(Display 3 72 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: 3" scar left forehead. DOB: 2/26/67. PHYS: blk/male, 6'3", blk, hzl, 225. ASSIGNED TO: Jones A/O: Pratt & Jones ARREST RECORD:  Narcotics possession  CONVICTED: 6/6/87  INCARCERATED: none.  LOCATION: none.  SENTENCE: 1 year suspended sentence.         3 years probation. PAROLE DATE: None. CASE STATUS: Closed."
		)
		(3
			(mugShot loop: 0 cel: 0 init:)
			(RedrawCast)
			(Display 3 73 dsCOORD 120 10 dsWIDTH 180 dsFONT 0) ; "CASE#: N555J212. NAME: Victor Simms. ALIAS: none. ADDRESS: 304 Second St.        Lytton City, USA."
			(Display 3 74 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: none DOB: 4/14/66. PHYS: wht/male, 5'7", blk, brn, 145. ASSIGNED TO: Watts, Laura A/O: Bonds & Watts ARREST RECORD:  Narcotics for sale   CONVICTED: 10/5/83 Juvenile Court   INCARCERATED: none. LOCATION: none.   SENTENCE: 1 year suspended sentence.   PAROLE DATE: None.   PROBATION: 1 yr. CASE STATUS: Closed"
		)
		(4
			(mugShot loop: 0 cel: 1 init:)
			(RedrawCast)
			(Display 3 75 dsCOORD 120 10 dsWIDTH 200) ; "CASE#: N5553339 Name: Wilma Snider. ALIAS: Big Snort Snider. ADDRESS: 203 Oak St.       Lytton City, USA."
			(Display 3 76 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: none DOB: 7/19/60. PHYS: blk/fem, 5'7", blk, brn, 145. ASSIGNED TO: Pratt A/O: Pratt ARREST RECORD:  Narcotics for sale  CONVICTED: 8/5/85  INCARCERATED: local  LOCATION: Lytton Jail  SENTENCE: 1 year suspended sent.         3 year probation.  PAROLE DATE: None. CASE STATUS: Closed"
		)
		(5
			(mugShot loop: 1 cel: 0 init:)
			(RedrawCast)
			(Display 3 77 dsCOORD 120 10 dsWIDTH 200) ; "CASE#: N5555678 Name: George Snow. ALIAS: Ice Man ADDRESS: transient"
			(Display 3 78 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: tattoo of panther on back DOB: 3/15/56. PHYS: wht/male, 6'0", blk, grn, 206. ASSIGNED TO: Jones A/O: Pratt ARREST RECORD:  Narcotics for sale  CONVICTED: 6/6/86  INCARCERATED: State Pen.  LOCATION: Foolsum  SENTENCE: 1 year with 3 years probation.  PAROLE DATE: 12/6/86. CASE STATUS: Closed"
		)
		(6
			(mugShot loop: 1 cel: 1 init:)
			(RedrawCast)
			(Display 3 79 dsCOORD 120 10 dsWIDTH 180 dsFONT 0) ; "CASE#: N5554657 NAME: Jose Valencia ALIAS: none ADDRESS: 25112 Staton Court      Century, USA"
			(Display 3 80 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: none  DOB: 3/15/63. PHYS: mex/male, 6'0", blk, brn, 190. ASSIGNED TO: Pratt A/O: Pratt, Jones ARREST RECORD: Narcotics for sale           Poss of paraphernalia           Assault on police officer  CONVICTED: 5/5/82  INCARCERATED: State Pen.  LOCATION: Foolsum  SENTENCE: 2 year with 5 year probation  PAROLE DATE: none. CASE STATUS: Closed Update: 3/2/87 probation. violation pending."
		)
	)
)

(instance Kim of Feature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(!= (event type:) evSAID)
					(!= (gCurRoom script:) rm3Script)
				)
				(return)
			)
			((not (gEgo inRect: 100 134 141 156))
				(if (Said '/(kim,woman)')
					(proc0_7) ; "You're not close enough."
				else
					(event claimed: 0)
				)
			)
			((Said 'look/desk')
				(Print 3 0) ; "This is Kim Walters' desk."
			)
			((Said 'look/kim,woman,cop')
				(Print 3 1) ; "Kim Walters is a young, attractive detective."
			)
			((or (Said 'talk/kim,woman,cop') (Said '/hello'))
				(switch (Random 0 2)
					(0
						(Print 3 2) ; "What can I do for you, Bonds?"
					)
					(1
						(Print 3 3) ; ""Have you heard the latest album from Blam? It's great!"
					)
					(else
						(Print 3 4) ; "So it seems like you and Marie are getting kind of serious. She seems really nice."
					)
				)
			)
			((Said '*/kim,woman')
				(switch (Random 0 2)
					(0
						(Print 3 5) ; "Why Sonny, I didn't know you cared!"
					)
					(1
						(Print 3 6) ; "Thanks for asking, but the chemistry just ain't there."
					)
					(2
						(Print 3 7) ; "Your mother must have dropped you on your head!"
					)
				)
			)
			((Said '[ask][/help]')
				(switch (Random 0 2)
					(0
						(Print 3 8) ; "I don't have time."
					)
					(1
						(Print 3 9) ; "If you want to look at the files, ask the Lieutenant."
					)
					(2
						(Print 3 10) ; "The Homicide Office is down the hall."
					)
				)
			)
			((Said 'ask')
				(Print 3 11) ; "I'm sorry, but I can't help you with that."
			)
		)
	)
)

(instance Pratt of Feature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(!= (event type:) evSAID)
					(!= (gCurRoom script:) rm3Script)
				)
				(return)
			)
			((not (gEgo inRect: 38 130 100 156))
				(if (Said '/lloyd')
					(proc0_7) ; "You're not close enough."
				else
					(event claimed: 0)
				)
			)
			((Said 'look/desk')
				(Print 3 12) ; "This is Lloyd Pratt's desk."
			)
			((>= global100 8)
				(if (Said '/lloyd,man,cop')
					(Print 3 13) ; "Lloyd Pratt is not here today."
				else
					(return)
				)
			)
			((Said 'look/lloyd,man,cop')
				(Print 3 14) ; "Lloyd Pratt looks like he needs more sleep."
			)
			(
				(or
					(Said 'help/lloyd,man')
					(Said
						'talk,ask/lloyd,man/investigation,cocaine,(complaint<cocaine)'
					)
					(Said 'talk,ask/investigation,cocaine,(complaint<cocaine)')
				)
				(cond
					((== global167 1)
						(Print 3 15) ; "You already have."
					)
					((IsFlag 56)
						(Print 3 16) ; "You quietly tell Lloyd about the on-going Internal Affairs investigation, and you beg him to stop using drugs."
						(Print 3 17) ; "In a clear voice, Lloyd responds to you..."
						(Print 3 18) ; "Sonny, you are a true friend. I didn't realize how bad off I was until I woke up yesterday morning and didn't know where I was."
						(Print 3 19) ; "I've made my mind up." Lloyd continues, "Today, I'm putting in for a leave of absence. Then I'm going to check myself into a rehabilitation center!"
						(Print 3 20) ; "Leaving Lloyd, you wish him all the luck in the world. You know he has made the correct decision."
						(SetScore 5 85)
						(= global167 1)
					)
					(else
						(Print 3 21) ; "Lloyd says, "Isn't life terrible sometimes. You wish it would go one way but it doesn't.""
					)
				)
			)
			((Said 'ask')
				(Print 3 22) ; "I'm sorry, but I'm busy here and can't help you with that."
			)
			((or (Said 'talk/lloyd,man,cop') (Said '/hello'))
				(cond
					((== global167 1)
						(Print 3 23) ; "Lloyd says, "Thanks Sonny.""
					)
					((not local1)
						(= local1 1)
						(Print 3 24) ; "Appearing slightly out of touch with his surroundings, your old friend Detective Lloyd Pratt slowly looks up and says..."
						(switch (Random 0 2)
							(0
								(Print 3 25) ; "Hey duuuude, what's happening?"
							)
							(1
								(Print 3 26) ; "Wellll, if it ain't Mr. Homicide, himself!"
							)
							(2
								(Print 3 27) ; "Well, slap me some tracks and feed me a line! Mr. Bonds, what's up?"
							)
						)
					)
					(else
						(Print 3 28) ; "Lloyd does not respond. He looks like he wants to be left alone."
					)
				)
			)
		)
	)
)

(instance Poet of Feature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(!= (event type:) evSAID)
					(!= (gCurRoom script:) rm3Script)
				)
				(return)
			)
			((not (gEgo inRect: 168 134 240 156))
				(if (Said '/steve')
					(proc0_7) ; "You're not close enough."
				else
					(event claimed: 0)
				)
			)
			((Said 'look/desk')
				(Print 3 29) ; "This is Steve Jones' desk."
			)
			((Said 'look/steve,man,cop')
				(Print 3 30) ; "Steve Jones eagerly works away on...?"
			)
			((or (Said 'talk,ask/steve,man,cop') (Said '/hello'))
				(switch local0
					(0
						(Print 3 31) ; "Narcotics Detective Steve Jones looks up and says... "Hello Sonny! Would you like to hear one of my famous poems?""
						(= local0 1)
					)
					(1
						(Print 3 32) ; "Well, Sonny? Do you want to hear my poem?"
					)
					(else
						(Print 3 33) ; "Hi, Sonny."
					)
				)
			)
			(
				(or
					(and (== local0 1) (Said 'yes'))
					(Said 'ask,tell,listen/poem,steve')
				)
				(switch (Random 0 3)
					(0
						(Print 3 34) ; "A grievance form...you want to begin it Because you've been hassled by the Lieutenant. It makes its way through the required channels, And is finally heard by the review board panel. The envelope you open...you read...you quiver! You've earned a footbeat...DOWN BY THE RIVER!"
					)
					(1
						(Print 3 35) ; "I search for the pusher with drugs for sale. I hook him and book him and take him to jail. The court hears the case and I'm sad to say he's back on the streets the very next day."
					)
					(2
						(Print 3 36) ; "My father done told me a long time ago, 'Son, save your money and climb out of the hole.' He gave me a dime, and with a big smile I put it on my dresser to save for awhile. Inflation taught me with the years I spent, The dime I saved was only worth five cents."
					)
					(3
						(Print 3 37) ; "Soap Suds Sadie yelled out,'Hey y'all! Get out of my way while I'm mopping the hall.' She mopped and she slopped 'til the cows came home, Now she's mopping and slopping at home all alone."
					)
				)
				(= local0 2)
			)
			((Said 'ask')
				(Print 3 11) ; "I'm sorry, but I can't help you with that."
			)
			((Said 'yes')
				(Print 3 38) ; "What are you talking about, Sonny?"
			)
			((Said 'no')
				(if (== local0 1)
					(Print 3 39) ; "OK. Fine, Sonny. I won't. Leave me alone."
					(= local0 0)
				else
					(Print 3 38) ; "What are you talking about, Sonny?"
				)
			)
		)
	)
)

(instance Dooley of Feature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(!= (event type:) evSAID)
					(!= (gCurRoom script:) rm3Script)
				)
				(return)
			)
			((not (gEgo inRect: 158 120 220 134))
				(if (Said '/dooley')
					(proc0_7) ; "You're not close enough."
				else
					(event claimed: 0)
				)
			)
			((Said 'look/desk')
				(Print 3 40) ; "This is Lieutenant Dooley's desk."
			)
			((Said 'look/dooley,man,cop')
				(Print 3 41) ; "Lieutenant Dooley looks like he is in deep thought."
			)
			((or (Said 'talk/dooley,man,cop') (Said '/hello'))
				(switch (Random 0 2)
					(0
						(Print 3 42) ; "I'm busy, Bonds."
					)
					(1
						(Print 3 43) ; "It sure is nice weather we're having."
					)
					(else
						(Print 3 44) ; "You should join the narcotics division. It sure beats dead bodies."
					)
				)
			)
			((Said 'ask')
				(Print 3 45) ; "I'm sorry, but I'm too busy for your questions."
			)
			((Said 'help')
				(if (Said '/cabinet,file')
					(Print 3 46) ; "Be my guest."
				else
					(Print 3 47) ; "Shaking his head, Dooley says..."I'm sorry, but I can't help you with that.""
				)
			)
		)
	)
)

(instance Computer of Feature
	(properties)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(!= (event type:) evSAID)
					(!= (gCurRoom script:) rm3Script)
				)
				(return)
			)
			(
				(not
					(or
						(gEgo inRect: 75 120 120 130)
						(& (gEgo onControl:) $e000)
					)
				)
				(if (Said '/computer')
					(proc0_7) ; "You're not close enough."
				else
					(event claimed: 0)
				)
			)
			((Said 'look/desk')
				(Print 3 48) ; "A computer sits on the desk."
			)
			((Said 'turn<on/computer')
				(Print 3 49) ; "Look at it first."
			)
			((Said 'look,use/computer')
				(gCurRoom newRoom: 8)
			)
		)
	)
)

(instance rm3 of Rm
	(properties
		picture 3
		style 0
	)

	(method (dispose)
		(gFeatures eachElementDo: #dispose 84)
		(fileScript dispose:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 1)
		(Load rsVIEW 61)
		(super init:)
		(gEgo
			posn:
				(if (== gPrevRoomNum 8) 120 else 180)
				(if (== gPrevRoomNum 8) 120 else 172)
			view:
				(cond
					((== gPrevRoomNum 8)
						(if (not global204) 0 else 6)
					)
					((not global204) 1)
					(else 7)
				)
		)
		(self setFeatures: Kim Pratt Poet Dooley Computer)
		(self setLocales: 153 156)
		(= global212 3)
		(HandsOn)
		(gCurRoom setScript: rm3Script)
	)
)

(instance rm3Script of Script
	(properties)

	(method (doit)
		(if (>= (gEgo y:) 175)
			(gCurRoom newRoom: 2)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init:)
				(if (== gPrevRoomNum 2)
					(gEgo setMotion: MoveTo 180 10)
					(User prevDir: 1)
				)
				((View new:)
					view: 61
					posn: 222 117
					loop: 0
					cel: 0
					init:
					addToPic:
				)
				((Prop new:)
					view: 61
					posn: 194 122
					loop: 1
					cycleSpeed: 4
					setPri: 11
					setCycle: Fwd
					init:
				)
				((View new:)
					view: 61
					posn: 135 146
					loop: 2
					cel: (Random 0 1)
					init:
					addToPic:
				)
				((View new:)
					view: 61
					posn: 178 104
					loop: 6
					cel: 0
					setPri: 9
					init:
					addToPic:
				)
				(if (< global100 8)
					((View new:)
						view: 61
						posn: 61 144
						loop: 3
						cel: (Random 0 1)
						init:
						addToPic:
					)
				)
				(if (and (>= global100 8) (not (IsFlag 57)))
					(SetFlag 57)
					(if (IsFlag 85)
						(Print 3 50) ; "Steve tells you..."
						(Print 3 51) ; "Lloyd has taken some time off...I guess he has problems at home or something."
					else
						(Print 3 52) ; "You're saddened as Steve tells you..."
						(Print 3 53) ; "Well they fired poor old Pratt!"
						(Print 3 54) ; "Continuing he says..."I guess Internal Affairs had a file open on him for illegal use of drugs. They just gave him his walking papers today.""
					)
				)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '(look,frisk)/(coat,pocket)')
						(if (gEgo inRect: 200 150 270 170)
							(Print 3 55) ; "You do not find anything of interest in the coat on the coatrack."
						else
							(event claimed: 0)
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/(!*,chamber,office)]')
								(Print 3 56) ; "The Narcotics office is equipped with five desks, a file cabinet, and various items hanging on the wall. On one of the desks is a computer."
							)
							((Said '/coatrack,coatrack<coat')
								(Print 3 57) ; "The coatrack has a coat and hat on it."
							)
							((Said '/hat')
								(Print 3 58) ; "You see nothing special."
							)
						)
					)
					((Said 'get/coat,hat')
						(Print 3 59) ; "It's not yours."
					)
					((Said 'open/drawer,cabinet,file')
						(if
							(or
								(== (gEgo onControl: 1) 8192)
								(== (gEgo onControl: 1) -24576)
							)
							(gCurRoom setScript: fileScript)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
				)
			)
		)
	)
)

(instance mugShot of View
	(properties
		y 60
		x 75
		view 205
	)
)

(instance fileScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 205)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 7 6)
				((= local9 (View new:))
					view: 60
					setPri: 15
					posn: 155 113
					loop: 2
					cel: 1
					stopUpd:
					init:
				)
				((= local2 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 99
					loop: 1
					cel: 0
					setPri: 14
					stopUpd:
					init:
				)
				((= local3 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 93
					loop: 1
					cel: 1
					setPri: 12
					stopUpd:
					init:
				)
				((= local4 (Act new:))
					view: 60
					ignoreActors:
					posn: 161 87
					loop: 1
					cel: 2
					setPri: 10
					stopUpd:
					init:
				)
				((= local5 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 78
					loop: 1
					cel: 3
					setPri: 8
					stopUpd:
					init:
				)
				((= local6 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 74
					loop: 1
					cel: 4
					setPri: 6
					stopUpd:
					init:
				)
				((= local7 (Act new:))
					view: 60
					ignoreActors:
					posn: 161 67
					loop: 1
					cel: 5
					setPri: 4
					stopUpd:
					init:
				)
				((= local8 (Act new:))
					view: 60
					ignoreActors:
					posn: 161 61
					loop: 1
					cel: 6
					setPri: 2
					stopUpd:
					init:
				)
			)
			(1
				(= local12 1)
				(User canInput: 0)
				(if (< global110 30)
					(self cue:)
				else
					(local10
						setMotion: MoveTo (local10 x:) (- (local10 y:) 20) self
					)
				)
			)
			(2
				(SetMenu 513 112 0)
				(User canInput: 1)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 90 8)
				(localproc_0)
			)
			(3
				(User canInput: 0)
				(SetMenu 513 112 1)
				(gCurRoom drawPic: 7 6)
				(gCast eachElementDo: #show)
				(mugShot dispose:)
				(if (< global110 30)
					(self cue:)
				else
					(local10
						setMotion: MoveTo (local10 x:) (+ (local10 y:) 20) self
					)
				)
			)
			(4
				(local10 stopUpd:)
				(User canInput: 1)
				(if local12
					(self changeState: 1)
				)
			)
			(5
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 3 7)
				(gCurRoom setScript: rm3Script)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said '[turn,go,look]/2[<page]')
							(Said '[turn,go,look]/page<next,second')
							(Said 'read,look,see,turn/page[<next,second]')
						)
						(Print 3 60 #at -1 150) ; "There is no second page in this file."
					)
					((Said 'look[<in,around][/(drawer,cabinet)]')
						(if local12
							(Print 3 61) ; "Right now, you need to concentrate on this file."
						else
							(Print 3 62) ; "You are looking into the file drawer which you just opened. It is an ordinary file drawer, with folders organized in alphabetical order."
						)
					)
					(
						(or
							(Said
								'read,see,look,get,open,pull/(colby,dickey,steve,simms,snider,george,jose)>'
							)
							(Said
								'/(colby,dickey,steve,simms,snider,george,jose)>'
							)
						)
						(cond
							(local12
								(event claimed: 1)
								(Print 3 63 #at -1 150 #time 7) ; "You'd better put this file away first. You know how picky they are here in Narcotics."
							)
							((or (Said '/colby') (Said '/<colby'))
								(= local10 local2)
								(= local11 0)
								(self changeState: 1)
							)
							((or (Said '/dickey') (Said '/<dickey'))
								(= local10 local3)
								(= local11 1)
								(self changeState: 1)
							)
							((or (Said '/steve') (Said '/<steve'))
								(= local10 local4)
								(= local11 2)
								(self changeState: 1)
							)
							((or (Said '/simms') (Said '/<simms'))
								(= local10 local5)
								(= local11 3)
								(self changeState: 1)
							)
							((or (Said '/snider') (Said '/<snider'))
								(= local10 local6)
								(= local11 4)
								(self changeState: 1)
							)
							((or (Said '/george') (Said '/<george'))
								(= local10 local7)
								(= local11 5)
								(self changeState: 1)
							)
							((or (Said '/jose') (Said '/<jose'))
								(= local10 local8)
								(= local11 6)
								(self changeState: 1)
							)
							(else
								(event claimed: 1)
								(Print 3 64 #at -1 150) ; "Which file do you want to see?"
							)
						)
					)
					((Said 'exit,close,exit,close/(drawer,cabinet)[<file]')
						(if local12
							(Print 3 63 #at -1 150 #time 7) ; "You'd better put this file away first. You know how picky they are here in Narcotics."
						else
							(self changeState: 5)
						)
					)
					(
						(or
							(Said 'close,replace[/file]')
							(Said 'drop[<back,away]/file')
						)
						(if local12
							(Print 3 65) ; "You replace the file."
							(= local12 0)
							(self changeState: 3)
						else
							(Print 3 66 #at -1 150) ; "You don't have a file open now."
						)
					)
				)
			)
		)
	)
)

