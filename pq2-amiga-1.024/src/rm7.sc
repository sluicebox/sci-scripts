;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm7 0
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
	local13
	local14
)

(procedure (localproc_0)
	(= local12 1)
	(gCurRoom drawPic: 90 3)
	(switch local1
		(local2
			(mugShot loop: 2 cel: 0 y: 60 init:)
			(local11 posn: 31 28)
			(if (IsItemAt 23) ; old_mug_shot
				(local10 posn: 57 66)
			)
			(RedrawCast)
			(Display 7 0 dsCOORD 120 15 dsWIDTH 200 dsFONT 0) ; "CASE#:M10251983. Name:Bains, Jessie Hiram. ALIAS:Sloan, Frank nmn."
			(Display 7 1 dsCOORD 20 75 dsWIDTH 300) ; "SCARS/TATTOOS: Abdominal scars caused by bullets. DOB: 11/30/51. PHYS: wht/male, 5'8", blk, brn, 150. ASSIGNED TO: Hamilton A/O: Sonny Bonds ARREST RECORD:  Count #1 - MURDER.   VICTIM - Taselli, Jason  Count #2 - ATTEMPT MURDER   VICTIM - Bonds, Sonny             <1>"
		)
		(local3
			(mugShot loop: 1 cel: 0 y: 60 init:)
			(RedrawCast)
			(Display 7 2 dsCOORD 120 10 dsWIDTH 200 dsFONT 0) ; "CASE#: M03151985. Name: Botts, Rambus. ALIAS: none."
			(Display 7 3 dsCOORD 20 65 dsWIDTH 300) ; "SCARS/TATTOOS: None. DOB: 8/22/56. PHYS: blk/male, 5'11", blk, brn, 195. ASSIGNED TO: Pierson A/O: Same ARREST RECORD:   First degree murder   First degree burglary   VICTIM - Smith, Kenneth SUMMARY: Victim was strangled during the commission of burglary to his home. Eyewitness testimony convicted Botts of murder, and burglary in the first degree.             <1>"
		)
		(local4
			(mugShot loop: 1 cel: 1 y: 160 init:)
			(RedrawCast)
			(Display 7 4 dsCOORD 20 10 dsWIDTH 300 dsFONT 0) ; "CASE#: M12161984.  NAME: Loofin, Mary. DECEASED: 12/16/1984. ALIAS: none. SCARS/TATTOOS: none. DOB: 2/10/30. PHYS: wht/fem, 5'03", gry, blu, 115. ASSIGNED TO: Pierson A/O: None METHOD OF MURDER   - beating - ----------------------------------------"
			(Display 7 5 dsCOORD 120 90 dsWIDTH 180) ; "SUSPECT:  NAME: Loofin, Jasper(husband)  ALIAS: none.  SCARS/TATTOOS: Anchor on left forearm.  DOB: 1/2/30  PHYS: wht/male, 5'11", gry, blu, 145.    <1>"
		)
		(local5
			(mugShot loop: 0 cel: 0 y: 160 init:)
			(RedrawCast)
			(Display 7 6 dsCOORD 20 10 dsWIDTH 300 dsFONT 0) ; "CASE#: M08022086.  NAME: Martinez, Richard. DECEASED: 02/20/1986. ALIAS: none. SCARS/TATTOOS: none. DOB: 6/21/65. PHYS: mex/male, 5'8", blk, brn, 155. ASSIGNED TO: Pierson A/O: Same METHOD OF MURDER   - Dagger - ----------------------------------------"
			(Display 7 7 dsCOORD 120 100 dsWIDTH 180) ; "SUSPECT:  NAME : Granandez, Chico.  ALIAS: "Peppy".   SCARS/TATTOOS: Cross on back of left hand  DOB: 6/19/63.  PHYS: mex/male, 5'8", blk, brn, 150.    <1>"
		)
		(local6
			(mugShot loop: 0 cel: 1 y: 160 init:)
			(RedrawCast)
			(Display 7 8 dsCOORD 20 10 dsWIDTH 300 dsFONT 0) ; "CASE#: M09151983.  Name: South, Julia DECEASED: 09/15/1983. ALIAS: none. SCARS/TATTOOS: 8" scar on abdomen. DOB: 4/22/49. PHYS: wht/fem, 5'4", red, brn, 135. ASSIGNED TO: Hall A/O: Same METHOD OF MURDER   - Poison - ----------------------------------------"
			(Display 7 9 dsCOORD 120 100 dsWIDTH 180) ; "SUSPECT:  Name : South, Lorin.  ALIAS: None.  SCARS/TATTOOS: None  DOB: 11/13/45.  PHYS: wht/male, 5'9", gry, brn, 170.    <1>"
		)
		(local7
			(mugShot loop: 2 cel: 0 y: 170 init:)
			(RedrawCast)
			(Display 7 10 dsCOORD 20 10 dsWIDTH 280 dsFONT 0) ; "CASE#: M09091983.  NAME: Taselli, Jason. DECEASED: 09/09/1983. ALIAS: Marvin Hoffman. ALIAS: Leroy Pierson. SCARS/TATTOOS: Flower above left nipple. DOB: 3/1/39. PHYS: wht/male, 5'11", blk, brn, 195. ASSIGNED TO: Hamilton A/O: None METHOD OF MURDER   - hand gun - ----------------------------------------"
			(Display 7 11 dsCOORD 120 110 dsWIDTH 180) ; "SUSPECT:  NAME:Bains, Jessie Hiram.  ALIAS:Sloan, Frank nmn.  SCARS/TATTOOS: None.  DOB: 11/30/51.  PHYS: wht/male, 5'8",     blk, brn, 150.    <1>"
		)
		(local8
			(mugShot loop: 0 cel: 2 y: 160 init:)
			(RedrawCast)
			(Display 7 12 dsCOORD 20 10 dsWIDTH 280 dsFONT 0) ; "CASE #: M08151983.  NAME: West, Lonny. DECEASED: 09/15/1983. ALIAS: none. SCARS/TATTOOS: None DOB: 2/10/63. PHYS: wht/male, 6'0", bln, blu, 190. ASSIGNED TO: Hamilton A/O: No arrest METHOD OF MURDER  - hand gun - ----------------------------------------"
			(Display 7 13 dsCOORD 120 100 dsWIDTH 180) ; "SUSPECT:  Name : Taselli, Jason  ALIAS: None.  SCARS/TATTOOS: Flower, above left nipple.  DOB: 3/1/39.  PHYS: wht/male, 5'11", blk, brn, 195.   <1>"
		)
	)
	(= local13 0)
)

(procedure (localproc_1)
	(= local12 0)
	(= local13 1)
	(gCurRoom drawPic: 90 2)
	(switch local1
		(local2
			(mugShot posn: 60 -30)
			(local11 posn: 0 0)
			(if (IsItemAt 23) ; old_mug_shot
				(local10 posn: 0 0)
			)
			(Animate (gCast elements:) 0)
			(Display 7 14 dsCOORD 20 7 dsWIDTH 300) ; "SUMMARY:   After a lengthy investigation, Officer Sonny Bonds successfully infiltrated the illegal gambling operation at the Hotel Delphoria. A confrontation with Bains ended in a shootout and his subsequent arrest. Suspect was convicted of first degree murder. Further: testimony provided by Woody Roberts, Marie Wilkans, and Don Colby was instrumental in convicting subject Bains on additional counts of narcotics trafficking and illegal gambling activities.   CONVICTED: 10/25/1983.  INCARCERATED: State Pen.  LOCATION: Foolsum.  SENTENCE: 97 years.  PAROLE DATE: None.  CASE STATUS: Closed END FILE:              (2)"
		)
		(local3
			(mugShot posn: 60 -30)
			(Animate (gCast elements:) 0)
			(Display 7 15 dsCOORD 20 10 dsWIDTH 300) ; "CONVICTED: 4/25/1986. INCARCERATED: State Pen. LOCATION: Foolsum. SENTENCE: 34 years. PAROLE DATE: None. CASE STATUS: Closed. END FILE:                   <2>"
		)
		(local4
			(mugShot posn: 60 -30)
			(Animate (gCast elements:) 0)
			(Display 7 16 dsCOORD 20 10 dsWIDTH 300) ; "SUMMARY:   Victim murdered by multiple blows to the head with a baseball bat. The suspect, who has a history of wife beating, is still outstanding and believed to have left the state. CASE STATUS: Open END FILE:                   <2>"
		)
		(local5
			(mugShot posn: 60 -30)
			(Animate (gCast elements:) 0)
			(Display 7 17 dsCOORD 20 10 dsWIDTH 300) ; "SUMMARY:   The victim, R. Martinez, received multiple stab wounds during a gang war between the "Z84's" and "P59's". The suspect, C. Granandez, was arrested and convicted for second degree murder. He was sentenced to serve 25 years in the State Pen without possibility of parole. CASE STATUS: Non-active. END FILE:                 <2>"
		)
		(local6
			(mugShot posn: 60 -30)
			(Animate (gCast elements:) 0)
			(Display 7 18 dsCOORD 20 10 dsWIDTH 300) ; "SUMMARY:   Prior to murder, the victim received a $200,000.00 inheritance. The suspect slowly and systematically poisoned his wife, knowing he would become sole heir to all of their possessions. Overwhelming evidence convicted the suspect of murder in the 1st degree. Subject Lorin South, was sentenced to death by lethal injection. CASE STATUS: Closed. END FILE:                 <2>"
		)
		(local7
			(mugShot posn: 60 -30)
			(Animate (gCast elements:) 0)
			(Display 7 19 dsCOORD 20 10 dsWIDTH 300) ; "SUMMARY:   Victim's body recovered from Clearwater River. Evidence recovered from suspect's hotel room led to his conviction of first degree murder. At the time of death, this victim was under investigation for suspicion of murder, auto theft & narcotics. It is believed this victim was employed by the suspect as a hit man. CASE STATUS: Closed. END FILE:                 <2>"
		)
		(local8
			(mugShot posn: 60 -30)
			(Animate (gCast elements:) 0)
			(Display 7 20 dsCOORD 20 10 dsWIDTH 300) ; "SUMMARY:   The victim was ambushed while operating his vehicle S/B on Fourth St. The suspect vehicle without warning, pulled along side victims car and shot him with a hand gun. Jason Taselli was under investigation for the murder of West, when he himself became the victim of murder. CASE STATUS: Closed. END FILE:                  <2>"
		)
	)
)

(instance rm7 of Rm
	(properties)

	(method (dispose)
		(fileScript dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(HandsOff)
		(User canInput: 1)
		((= local10 (View new:))
			view: 204
			loop: 2
			cel: 0
			posn: 0 0
			setPri: 12
			init:
		)
		((= local11 (View new:))
			view: 204
			loop: 2
			cel: 3
			posn: 0 0
			setPri: 14
			init:
		)
		(self setScript: fileScript)
	)
)

(instance mugShot of View
	(properties
		x 60
		view 204
	)
)

(instance fileScript of Script
	(properties)

	(method (init)
		(self changeState: 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 7 6)
				((= local9 (View new:))
					view: 60
					posn: 156 110
					loop: 2
					cel: 0
					setPri: 15
					stopUpd:
					init:
				)
				((= local2 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 99
					loop: 0
					cel: 0
					setPri: 14
					init:
					stopUpd:
				)
				((= local3 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 93
					loop: 0
					cel: 1
					setPri: 12
					init:
					stopUpd:
				)
				((= local4 (Act new:))
					view: 60
					ignoreActors:
					posn: 161 87
					loop: 0
					cel: 2
					setPri: 10
					init:
					stopUpd:
				)
				((= local5 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 78
					loop: 0
					cel: 3
					setPri: 8
					init:
					stopUpd:
				)
				((= local6 (Act new:))
					view: 60
					ignoreActors:
					posn: 160 74
					loop: 0
					cel: 4
					setPri: 6
					init:
					stopUpd:
				)
				((= local7 (Act new:))
					view: 60
					ignoreActors:
					posn: 161 67
					loop: 0
					cel: 5
					setPri: 4
					init:
					stopUpd:
				)
				((= local8 (Act new:))
					view: 60
					ignoreActors:
					posn: 161 61
					loop: 0
					cel: 6
					setPri: 2
					init:
					stopUpd:
				)
			)
			(1
				(User canInput: 0)
				(if (< global110 30)
					(self cue:)
				else
					(local1
						setMotion: MoveTo (local1 x:) (- (local1 y:) 20) self
					)
				)
			)
			(2
				(local2 hide:)
				(local3 hide:)
				(local4 hide:)
				(local5 hide:)
				(local6 hide:)
				(local7 hide:)
				(local8 hide:)
				(local9 hide:)
				(SetMenu 513 112 0)
				(User canInput: 1)
				(HandsOn)
				(self cue:)
			)
			(3
				(= local12 1)
				(= local13 0)
				(= local14 1)
				(localproc_0)
			)
			(5
				(User canInput: 0)
				(mugShot dispose:)
				(if (== local1 local2)
					(local11 posn: 0 0)
					(if (not (gEgo has: 23)) ; old_mug_shot
						(local10 posn: 0 0)
					)
				)
				(= local14 0)
				(self cue:)
			)
			(6
				(gCurRoom drawPic: 7 6)
				(local2 show:)
				(local3 show:)
				(local4 show:)
				(local5 show:)
				(local6 show:)
				(local7 show:)
				(local8 show:)
				(local9 show:)
				(SetMenu 513 112 1)
				(if (< global110 30)
					(self cue:)
				else
					(local1
						setMotion: MoveTo (local1 x:) (+ (local1 y:) 20) self
					)
				)
			)
			(7
				(User canInput: 1)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) KEY_F6)
						(== (event message:) KEY_F8)
						(== (event message:) KEY_F10)
					)
					(event claimed: 1)
					(proc0_10) ; "You can't do that now."
				)
			)
			(evSAID
				(cond
					(local14
						(cond
							((Said 'get/mugshot,painting,shot[<mug]')
								(if (== local1 local2)
									(if (IsItemAt 23) ; old_mug_shot
										(local10 dispose:)
										(gEgo get: 23) ; old_mug_shot
										(SetScore 1)
									else
										(Print 7 21) ; "You already have that particular photograph."
									)
								else
									(Print 7 22) ; "You can't take the only mug shot in the file!"
								)
							)
							((Said 'look/painting,mugshot,shot[<mug]')
								(if local12
									(Print 7 23) ; "You're already looking at it."
								else
									(Print 7 24) ; "Look at page one of the file."
								)
							)
							(
								(or
									(Said '[turn,go,look]/2[<page]')
									(Said '[turn,go,look]/page<next,second')
									(Said
										'read,look,see,turn/page[<next,second]'
									)
								)
								(if local12
									(localproc_1)
								else
									(Print 7 25 #at -1 140) ; "This is the end of the file!"
								)
							)
							(
								(or
									(Said '[read,turn,go,look]/1,1[<page]')
									(Said
										'[read,turn,go,look]/page<first,preceding'
									)
									(Said 'turn,go<back[/1,1<page]')
									(Said 'turn,go<back[/page<first,preceding]')
									(Said '/back')
								)
								(if local13
									(localproc_0)
								else
									(Print 7 26 #at -1 140) ; "This is the beginning of the file!"
								)
							)
							(
								(or
									(Said
										'[turn,go,look]/(page<next,third),(3<page)'
									)
									(Said
										'read,look,see,turn/(page[<third]),(3<page)'
									)
								)
								(Print 7 27 #at -1 140) ; "There is no third page in this file."
							)
							(
								(Said
									'[read,see,look,get,open,pull]/file,bains,loofin,botts,martinez,julia,jason,lonny'
								)
								(Print 7 28 #at -1 140) ; "You can only look at one file at a time."
							)
							(
								(Said
									'exit,close,exit,close/(drawer,cabinet)[<file]'
								)
								(Print 7 29 #at -1 140) ; "If you value your hide in Homicide, you won't leave files lying around loose. Put it back!"
							)
							(
								(or
									(Said 'close,replace[/file]')
									(Said 'drop[<back,away]/file')
								)
								(Print 7 30) ; "You replace the file."
								(fileScript changeState: 5)
							)
						)
					)
					((or (Said 'look[<in]/drawer,cabinet') (Said 'look<around'))
						(Print 7 31) ; "You are looking into the file drawer which you just opened. It has folders arranged in alphabetical order."
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<bains[<bains]'
							)
							(Said '[read,see,look,get,open,pull]/bains[<bains]')
						)
						(= local1 local2)
						(fileScript changeState: 1)
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<botts[<botts]'
							)
							(Said '[read,see,look,get,open,pull]/botts[<botts]')
						)
						(= local1 local3)
						(fileScript changeState: 1)
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<loofin[<loofin]'
							)
							(Said
								'[read,see,look,get,open,pull]/loofin[<loofin]'
							)
						)
						(= local1 local4)
						(fileScript changeState: 1)
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<martinez[<martinez]'
							)
							(Said
								'[read,see,look,get,open,pull]/martinez[<martinez]'
							)
						)
						(= local1 local5)
						(fileScript changeState: 1)
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<julia[<julia]'
							)
							(Said '[read,see,look,get,open,pull]/julia[<julia]')
						)
						(= local1 local6)
						(fileScript changeState: 1)
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<jason[<jason]'
							)
							(Said '[read,see,look,get,open,pull]/jason[<jason]')
						)
						(= local1 local7)
						(fileScript changeState: 1)
					)
					(
						(or
							(Said
								'[read,see,look,get,open,pull]/file<lonny[<lonny]'
							)
							(Said '[read,see,look,get,open,pull]/lonny[<lonny]')
						)
						(= local1 local8)
						(fileScript changeState: 1)
					)
					((Said 'look/painting,mugshot,shot[<mug]')
						(Print 7 32) ; "Open a file and look at the photo."
					)
					((Said 'read,see,look,get,open,pull/file')
						(Print 7 33) ; "Which file would you like to open?"
					)
					((Said 'exit,close[/drawer,cabinet,file]')
						(gCast eachElementDo: #dispose)
						(gCurRoom newRoom: 4)
					)
				)
			)
		)
	)
)

