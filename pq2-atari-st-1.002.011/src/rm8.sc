;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm8 0
)

(local
	[local0 100]
	[local100 41]
	local141
	local142
	local143
	local144
	local145
	local146
	local147
	local148
	local149
	local150
	local151
	local152
	local153
	local154
)

(procedure (localproc_0 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1)
	(if (<= 97 param1 122)
		(return (- param1 32))
	else
		(return param1)
	)
)

(procedure (localproc_2)
	(Print &rest #font 7 #width 168 #at 70 10)
)

(procedure (localproc_3) ; UNUSED
	(Display &rest dsCOORD 73 local143 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
	(+= local143 10)
)

(instance compCursor of Prop
	(properties)
)

(instance fileCursor of Prop
	(properties)
)

(instance lite1 of View
	(properties)
)

(instance lite2 of View
	(properties)
)

(instance shaw of View
	(properties)
)

(instance rm8 of Rm
	(properties
		picture 8
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(User canInput: 1)
		(Load rsVIEW 9)
		(lite1 view: 9 loop: 2 cel: 0 posn: 256 178 init: stopUpd:)
		(lite2 view: 9 loop: 2 cel: 1 posn: 234 143 init: stopUpd:)
		(shaw view: 9 loop: 3 cel: 0 posn: 83 150 init: addToPic:)
		(Format @local100 8 0)
		(self setScript: rm8Script)
	)
)

(instance rm8Script of Script
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '/book,instruction,cocksucker')
						(Print 8 1) ; "It's your typical computer manual - completely unreadable by normal human beings. You're better off without it."
					)
					((Said 'look/switch,button,power')
						(Print 8 2) ; "You find the power switch on the back of the computer."
					)
					((Said 'look/computer')
						(Print 8 3) ; "The computer is turned off."
					)
					((Said 'exit,walk,go,quit')
						(gCurRoom newRoom: gPrevRoomNum)
					)
					((Said 'type,enter,cd,cd')
						(Print 8 4) ; "First, turn on the computer, then you can type it."
					)
					(
						(or
							(Said 'turn,log<on[/computer,power,button]')
							(Said 'activate,use,logon[/computer]')
							(Said
								'flip,press,activate,press[/button,power,switch]'
							)
						)
						(lite1 hide:)
						(lite2 hide:)
						(rm8 setScript: computerScript)
					)
					((Said '[<around,at][/(!*)]')
						(Print 8 5) ; "The new computer system is the latest in crime-fighting technology."
					)
				)
			)
		)
	)
)

(instance computerScript of Script
	(properties)

	(method (doit)
		(if (> local151 1)
			(-- local151)
		)
		(if (== local151 1)
			(= local151 0)
			(self cue:)
		)
		(if (and (not local149) (not local147) (gCast contains: fileCursor))
			(fileCursor dispose:)
			(self changeState: 1)
		)
		(cond
			((<= (compCursor x:) 123)
				(compCursor x: 123)
			)
			((>= (compCursor x:) 236)
				(compCursor x: 236)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(compCursor
					view: 9
					posn: 123 22
					cycleSpeed: 3
					setCycle: Fwd
					init:
				)
				(= local151 5)
			)
			(1
				(for ((= local143 24)) (<= local143 114) ((+= local143 10))
					(Display 8 6 dsCOORD 73 local143 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
				)
				(if (gCast contains: fileCursor)
					(fileCursor dispose:)
				)
				(if (not local146)
					(self cue:)
				)
			)
			(2
				(= local150 1)
				(Display 8 7 dsCOORD 73 14 dsFONT 7 dsCOLOR 0)
				(Display 8 8 dsCOORD 73 14 dsFONT 7 dsCOLOR 9 dsBACKGROUND 0) ; "COMMAND>"
			)
			(3
				(Display 8 9 dsCOORD 73 14 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
				(Display 8 9 dsCOORD 73 15 dsFONT 7 dsCOLOR 0 dsBACKGROUND 0)
				(Display 8 10 dsCOORD 73 14 dsFONT 7 dsCOLOR 14 dsBACKGROUND 0) ; "Session Complete."
				(= gNewRoomNum gPrevRoomNum)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 4])
		(switch (event type:)
			($0040 ; direction
				(if (or local147 local149)
					(event claimed: 1)
					(switch (event message:)
						(JOY_UP
							(cond
								((> (fileCursor y:) 40)
									(fileCursor
										posn:
											(fileCursor x:)
											(- (fileCursor y:) 10)
									)
									(-- local152)
								)
								((== (fileCursor x:) 71)
									(= local152 11)
									(fileCursor posn: 162 33)
								)
								(else
									(= local152 1)
									(fileCursor posn: 71 33)
								)
							)
						)
						(JOY_DOWN
							(cond
								((< (fileCursor y:) 114)
									(++ local152)
									(fileCursor
										posn:
											(fileCursor x:)
											(+ (fileCursor y:) 10)
									)
								)
								((== (fileCursor x:) 71)
									(= local152 20)
									(fileCursor posn: 162 123)
								)
								(else
									(= local152 10)
									(fileCursor posn: 71 123)
								)
							)
						)
						(else
							(if (== (fileCursor x:) 71)
								(+= local152 10)
								(fileCursor posn: 162 (fileCursor y:))
							else
								(-= local152 10)
								(fileCursor posn: 71 (fileCursor y:))
							)
						)
					)
				)
			)
			(evKEYBOARD
				(if
					(or
						(== (= local141 (event message:)) KEY_F6)
						(== local141 KEY_F8)
						(== local141 KEY_F10)
					)
					(Print 8 11) ; "Calm down. You have no need of your gun here."
					(event claimed: 1)
				)
				(if local150
					(event claimed: 1)
					(= local154 (StrLen @local100))
					(cond
						((and (< KEY_SPACE (event message:) $007f) (< local154 13))
							(StrAt @local100 local154 (localproc_1 local141))
							(++ local154)
							(StrAt @local100 local154 0)
							(Display
								(Format @temp0 {%c} local141)
								dsCOORD
								(compCursor x:)
								(- (compCursor y:) 8)
								dsFONT
								7
								dsCOLOR
								9
								dsBACKGROUND
								0
							)
							(compCursor x: (+ (compCursor x:) 6))
						)
						((and (== JOY_UPLEFT local141) local154)
							(-- local154)
							(StrAt @local100 local154 0)
							(compCursor x: (- (compCursor x:) 6))
							(Display
								8
								12
								dsCOORD
								(compCursor x:)
								(- (compCursor y:) 8)
								dsFONT
								7
								dsCOLOR
								0
								dsBACKGROUND
								0
							)
						)
						((== local141 KEY_RETURN)
							(Display 8 13 dsCOORD 123 14 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(Display 8 13 dsCOORD 123 15 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(= local154 0)
							(compCursor x: 123)
							(cond
								(local146
									(cond
										((not (StrCmp @local100 {CRIMINAL}))
											(= local145 3)
											(= local146 0)
											(self changeState: 1)
										)
										((not (StrCmp @local100 {SIERRA}))
											(= local145 1)
											(= local146 0)
											(self changeState: 1)
										)
										((not (StrCmp @local100 {PERSONNEL}))
											(= local144 2)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not
													(StrCmp @local100 {HOMICIDE})
												)
												(== local145 3)
											)
											(= local144 4)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not (StrCmp @local100 {VICE}))
												(== local145 3)
											)
											(= local144 7)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not
													(StrCmp @local100 {BURGLARY})
												)
												(== local145 3)
											)
											(= local144 5)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(
											(and
												(not
													(StrCmp @local100 {FIREARMS})
												)
												(== local145 3)
											)
											(= local144 6)
											(= local146 0)
											(= local148 1)
											(self changeState: 1)
										)
										(else
											(= local145 0)
											(= local146 0)
											(self changeState: 1)
										)
									)
									(if local148
										(Display
											8
											14
											dsCOORD
											73
											14
											dsCOLOR
											0
											dsFONT
											7
											dsBACKGROUND
											0
										)
										(Display ; "PASSWORD:"
											8
											15
											dsCOORD
											73
											14
											dsCOLOR
											9
											dsFONT
											7
											dsBACKGROUND
											0
										)
									)
								)
								(local148
									(= local148 0)
									(cond
										(
											(and
												(not
													(StrCmp @local100 {ICECREAM})
												)
												(== local144 4)
											)
											(= local145 local144)
										)
										(
											(and
												(not
													(StrCmp
														@local100
														{PISTACHIO}
													)
												)
												(== local144 2)
											)
											(= local145 local144)
											(SetScore 2 120)
										)
										(
											(and
												(not (StrCmp @local100 {MIAMI}))
												(== local144 7)
											)
											(= local145 local144)
											(SetScore 2 121)
										)
										(else
											(Print 8 16 #time 3) ; "ACCESS DENIED!"
										)
									)
									(self changeState: 1)
								)
								(local149
									(switch local152
										(1
											(localproc_2 8 17) ; "POLICE QUEST In The Pursuit Of The Death Angel  Enter the brutal world of vice, drugs and homicide. Handle traffic violators, attend briefings. Stop the flood of illegal drugs that is destroying the community. Ages 18 and up."
										)
										(2
											(localproc_2 8 18) ; "KINGS QUEST I Quest For The Crown  The original history- making adventure game. Be Sir Graham, bravest of the Knights. Locate lost treasures. Return them to King Edward to restore kingdom's lost prosperity. In the end, you may inherit the throne."
										)
										(3
											(localproc_2 8 19) ; "KINGS QUEST II Romancing The Throne  Explore caves, eerie castle towers, and ocean wonderlands. Help King Graham unlock the secrets that will lead him to the enchanted maiden for whom he longs."
										)
										(4
											(localproc_2 8 20) ; "KINGS QUEST III To Heir is Human  Become Gwydion, young slave to the evil wizard Manannan of Llewdor. Discover the wizard's spells. Embark upon dangerous voyages to distant lands. Free a Kingdom from its ravages."
										)
										(5
											(localproc_2 8 21) ; "KINGS QUEST IV The Perils of Rosella  Travel with Rosella, the beautiful princess and heroine of King's Quest IV. Journey to a town far away. Search for the enchanted fruit that will restore life to her father and safely return her home. Meet creatures from ancient legend, from"
											(localproc_2 8 22) ; "beautiful unicorns to hideous ogres. Acquire treasures that are necessary to ensure your safety. Save Genesta from imminent death by destroying the evil Lolotte and returning the sacred talisman which once rested around her neck."
										)
										(6
											(localproc_2 8 23) ; "SILPHEED Defend the United Universe as the pilot of Silpheed, Super Dogfighter. Combine strategy with dexterity. Silpheed becomes even more powerful by acquiring new weapons and shields. The longer you survive, the stronger Silpheed (and the adversaries) become. 20 levels of action. 9 original musical scores."
										)
										(7
											(localproc_2 8 24) ; "MANHUNTER  This science fiction epic is a dark vision of our planet's future. Manhunter evolves around the life of a detective in New York City two years after alien invasion and consequent world takeover. The 'hero' of the story is contracted by the newly founded alien"
											(localproc_2 8 25) ; "dictatorship as a bounty hunter. His goal is to track down and destroy a ring of human saboteurs and militants out to end the alien rule. In the end, will you be on the side of evil, or good? You decide."
										)
										(8
											(localproc_2 8 26) ; "THEXDER Pilot an armored robot- jet transformer vehicle. Change from a robot to a jet instantly, as you fly through multiple attack scenarios. Go through innumerable mazes and secret passages while avoiding booby traps, mazes, and over twenty different types of alien machines."
										)
										(9
											(localproc_2 8 27) ; "GOLD RUSH! Join the Gold Rush! Sell your land, and grab the next ride out, because your fortune lies 2000 miles away. Relive America's most exciting era by traveling to the gold fields of California by any of the three perilous routes used at that time. Each of the trips is dangerous, historically and geographically accurate, and educational."
										)
										(10
											(localproc_2 8 28) ; "MIXED-UP MOTHER GOOSE  Go on an adventure in Mother Goose land. Find missing pieces to some of her most popular rhymes. When the pieces are found, the rhyme is acted out. No reading skills are required. Ages 4 and up"
										)
										(11
											(localproc_2 8 29) ; "SPACE QUEST The Sarien Encounter  Become Roger Wilco in this action-packed, tongue-in-cheek, space thriller. Recover the stolen Star Generator and save your home planet."
										)
										(12
											(localproc_2 8 30) ; "SPACE QUEST II Vohaul's Revenge  Come face to face with Sludge Vohaul, the mad scientist. Encounter Vohaul's wrath. Explore the jungle planet of Labion and much more! Many puzzles and strange creatures await you."
										)
										(13
											(localproc_2 8 31) ; "SPACE QUEST III  Battle the infamous Pirates of Pestulon as Roger Wilco continues his career as space-hero and part-time janitor. Help Roger survive the most bizarre dangers yet! The latest in the hit Space Quest series."
										)
										(14
											(localproc_2 8 32) ; "LEISURE SUIT LARRY IN THE LAND OF THE LOUNGE LIZARDS  Become the lovable nerd Larry, and spend one fabulous night in Lost Wages. You'll drink. You'll dance. And if you play your cards right, you might even meet the girl of your dreams. Ages 18 and up"
										)
										(15
											(localproc_2 8 33) ; "LEISURE SUIT LARRY II LOOKING FOR LOVE IN SEVERAL WRONG PLACES Become the lovable nerd Larry ONE MORE TIME! Win $1,000,000 a year for life! Win a fabulous cruise with a beautiful woman!! Wish you were back in Lost Wages counting your breath mints!!!"
										)
									)
								)
								(local147
									(switch local145
										(4
											(switch local152
												(1
													(localproc_2 8 34) ; "CASE#: M09091983.  NAME: Taselli, Jason. ADDRESS: 753 Third St. Lytton City, USA. DECEASED: 09/09/1986. METHOD OF MURDER:  Murder by handgun.  ALIAS: Marvin Hoffman. ALIAS: Leroy Pierson. SCARS/TATTOOS: Flower above left nipple."
													(localproc_2 8 35) ; "DOB: 3/1/39. PHYS: wht/male 5'11",blk,brn,195.  ARREST RECORD: no local. CONVICTIONS: unavailable. NOTE: at time of death, sub under investigation for suspicion of murder, auto theft, narcotics. END FILE."
												)
												(2
													(localproc_2 8 36) ; "NAME: Loofin, Jasper  ALIAS: "Jaz" SCARS/TATTOOS: Anchor - left forearm DOB: 1/2/30 PHYS: wht/male 5'11",gry,blu,198 CASE STATUS: Open under investigation ASSIGNED TO: Pierson Homicide Department END FILE."
												)
												(3
													(localproc_2 8 37) ; "CASE#: M08022086.  NAME: Martin, Richard. DECEASED: 02/20/1986. METHOD OF DEATH:  Murdered with Dagger.  ALIAS: none. SCARS/TATTOOS: none. DOB: 6/21/65. PHYS: wht/male 5'08",brn,brn,155."
													(localproc_2 8 38) ; "SUSPECT: NAME : Granandez, Jose. ALIAS: "Peppy". SCARS/TATTOOS: Cross on back of left hand DOB: 6/19/63. PHYS: mex/male 5'8",blk,brn,150. ARREST RECORD: Auto theft CONVICTED: 6/14/83. SENTENCE: suspended. END FILE."
												)
												(4
													(localproc_2 8 39) ; "CASE#: M03151985. NAME: Botts, Rambus. ALIAS: none. SCARS/TATTOOS: None. DOB: 8/22/56. PHYS: blk/male 5'11",blk,brn,195. ARREST RECORD: Murder CONVICTED: 11/12/85 INCARCERATED: State Pen LOCATION: Foolsum. SENTENCE: 30 years. PAROLE DATE: None END FILE."
												)
												(5
													(localproc_2 8 40) ; "CASE#:M08201984. NAME : Granandez, Jose. ALIAS: "Peppy". SCARS/TATTOOS: Cross on back of left hand DOB: 6/19/63. PHYS: mex/male 5'8",blk,brn,150. ARREST RECORD: Murder CONVICTED: 8/20/87 INCARCERATED: State Pen LOCATION: Foolsum. SENTENCE: 23 years. END FILE."
												)
												(6
													(localproc_2 8 41) ; "CASE#: M08201983.  NAME: Martinez, Chico ADDRESS: 303 Fifth St. Lytton City, USA. DECEASED: 08/20/1983. METHOD OF MURDER:  Murdered with ice pick. ALIAS: none.  SCARS/TATTOOS: none. DOB: 6/6/65."
													(localproc_2 8 42) ; "PHYS: mex/male 5'08",blk,brn,145.  ARREST RECORD: sale of narcotics. CONVICTED: 7/22/82. SENTENCE: suspended, three years probation.  NOTE: at time of death, sub under investigation for drug trafficking. END FILE."
												)
												(7
													(localproc_2 8 43) ; "CASE#: M09151983. NAME: South, Julia DECEASED: 09/15/1983. METHOD OF MURDER - poison - ALIAS: none. SCARS/TATTOOS: 8" scar on abdomen. DOB: 4/22/49. PHYS: wht/fem 5'04",red,brn,135. ARREST RECORD: None END FILE."
												)
												(11
													(localproc_2 8 44) ; "CASE#: M08151983.  NAME: West, Lonnie. ADDRESS: 523 Oak St. Lytton City, USA.  DECEASED: 08/15/1983. METHOD OF MURDER - hand gun -  ALIAS: none. SCARS/TATTOOS: none."
													(localproc_2 8 45) ; "DOB: 2/10/63. PHYS: wht/male 6'00",bln,blu,190.  ARREST RECORD: sale of narcotics. CONVICTED: mistrial. SENTENCE: none.  NOTE: at time of death, sub under investigation for drug trafficking. END FILE."
												)
												(12
													(localproc_2 8 46) ; "CASE#: M10251983.  NAME: Bains, Jessie Hiram. ALIAS: Sloan, Frank nmn. ADDRESS: 753 Third St.  Lytton City, USA. SCARS/TATTOOS:  Scar on chest. DOB: 11/30/51. PHYS: wht/male 5'8",blk,brn,150."
													(localproc_2 8 47) ; "ARREST RECORD: murder, attempted murder narcotics, gambling.  CONVICTED: 10/25/1987. INCARCERATED: State Pen. LOCATION: Foolsum. SENTENCE: 97 years. PAROLE DATE: None. END FILE."
												)
												(13
													(localproc_2 8 48) ; "CASE#: M03151985. NAME: Smith, Kenneth. ADDRESS: 1022 Rose St. Lytton City, USA. DOB: 11/30/35. DECEASED: 03/15/1985. METHOD OF MURDER - strangulation - ALIAS: none. SCARS/TATTOOS: none. PHYS: blk/male 5'10",bln,grn,185. ARREST RECORD: END FILE."
												)
												(14
													(localproc_2 8 49) ; "CASE#: M12161984. NAME: Loofin, Mary. ADDRESS: 1103 Lilly St. Lytton City, USA. DECEASED: 12/16/1984. METHOD OF MURDER - beating - ALIAS: none. SCARS/TATTOOS: none. DOB: 2/10/30. PHYS: wht/fem 5'03",gry,blu,115. ARREST RECORD: none END FILE."
												)
												(15
													(localproc_2 8 50) ; "CASE#: M10201986. NAME: Swift, Peter. ADDRESS: 123 Ninth St. Lytton City, USA. DECEASED: 10/20/1986. METHOD OF MURDER - shotgun - ALIAS: none. SCARS/TATTOOS: none. DOB: 4/19/34. PHYS: mex/male 6'02",blk,brn,200. ARREST RECORD: none END FILE."
												)
												(16
													(localproc_2 8 51) ; "CASE#:M09151983. NAME : South, Lorin. ALIAS: None. SCARS/TATTOOS: None DOB: 11/13/45. PHYS: wht/male 5'9",gry,brn,170. ARREST RECORD: Murder CONVICTED: 10/22/83 INCARCERATED: State Pen LOCATION: Foolsum. SENTENCE: 15 years. PAROLE DATE: 11/1/90 END FILE."
												)
											)
										)
										(2
											(switch local152
												(1
													(localproc_2 8 52) ; "NAME - Gelepsi, Mario. BADGE - 5557428. DOB - 4/10/45. DEPARTMENT- Traffic Div. POSITION - Traffic Off. APPOINTED - 12/15/70. STATUS - Active. DEPARTMENTAL ACTIONS Commendable citations 3/1/75-Officer Gelepsi was presented with the "Outstanding Effort" award, for the recovery"
													(localproc_2 8 53) ; "of 11 stolen vehicles in one 12 month period. Censurable Reports ALLEGATIONS: 2/3/73-The complaining party alleged that after being stopped for a traffic violation, Officer Gelepsi became belligerent and verbally abusive. FINDINGS: Not sustained: There was no supporting evidence."
												)
												(2
													(localproc_2 8 54) ; "NAME - Haines, Calvin BADGE - 5558013 DOB - 9/20/39 DEPARTMENT- Traffic Div. POSITION - Traffic Off. APPOINTED - 12/15/61 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations 3/1/77-While working alone, Officer Haines was dispatched to Cotton Cove to investigate a"
													(localproc_2 8 55) ; "report of one white male subject harassing fishermen in the area. Upon Haines' arrival, he observed one nude white male subject approaching his unit. Before Haines could react, the subject reached through the open drivers window and ripped Officer Haines' badge off his uniform. The subject then tossed the badge into"
													(localproc_2 8 56) ; "the river. Officer Haines successfully subdued and cuffed the subject, who was under the influence of PCP. NOTE: Several attempts at recovering Officer Haines' badge were unsuccessful. Censurable Reports: None."
												)
												(3
													(localproc_2 8 57) ; "NAME - Simpson, James. BADGE - 55510705 DOB - 4/22/63 DEPARTMENT- Burglary POSITION - Detective APPOINTED - 6/15/85 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations: 12/1/86-during the final quarter of 1986, Officer Simpson was assigned to traffic div. and was a"
													(localproc_2 8 58) ; "member of "B" sector team. Due to the combined effort of the team, reportable accidents were reduced a total of 20% compared to the same quarter the previous year. Censurable Reports 8/9/87 - Allegation - Conduct unbecoming of an officer."
													(localproc_2 8 59) ; "During physical arrest of a child beating suspect, officer Simpson verbally abused and, with malicious intent, spit into the face of the suspect. Findings - sustained Action - 2 day suspension without pay. END FILE"
												)
												(4
													(localproc_2 8 60) ; "NAME - Adams, Robert. BADGE - 5556503 DOB - 1/25/40 DEPARTMENT - Burglary POSITION - Lieutenant APPOINTED - 6/15/65 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations 6/2/73 - community involvement award for his outstanding effort in the founding and promotion"
													(localproc_2 8 61) ; "of the Lytton Police Scholarship Fund for high school seniors. 3/30/69 - Censurable Reports 5/5/78 - Allegation - Insubordination and failing to maintain himself in a professional manner. Sgt. Adams, (during the monthly staff meeting), proceeded to browbeat his superior"
													(localproc_2 8 62) ; "officers while using every four letter word known to man. Findings - sustained Action - written reprimand. END FILE"
												)
												(5
													(localproc_2 8 63) ; "NAME - Waters, Laura. BADGE - 55510680 DOB - 3/01/64 DEPARTMENT - Burglary POSITION - Detective APPOINTED - 3/15/85 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations 4/2/71 - Heroic Rescue - While jogging off duty, Officer Waters spotted a small child floating face"
													(localproc_2 8 64) ; "down in an irrigation ditch. Officer Waters pulled the child from the water and applied CPR. The child's survival was the direct result of her action. Censurable Reports None. END FILE"
												)
												(6
													(localproc_2 8 65) ; "NAME - Jerome, Willy. BADGE - 5559233 DOB - 4/22/50 DEPARTMENT - Narcotics POSITION - Detective APPOINTED - 6/15/78 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations 6/9/81 - Gold Medal - Shooting event Summer Police Olympics"
													(localproc_2 8 66) ; "Censurable Reports 4/14/85 - Allegation - misuse of sick time Findings - Sustained Action - Two day reduction in pay. END FILE"
												)
												(7
													(localproc_2 8 67) ; "NAME - Willis, John. BADGE - 5558813 DOB - 2/03/51 DEPARTMENT - Narcotics POSITION - Detective APPOINTED - 12/15/76 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations 2/2/80 - Outstanding Effort - Defensively Using his PR/24 in a departmentally"
													(localproc_2 8 68) ; "approved manner. Officer Willis single-handedly held off three members of an outlaw motorcycle gang during a barroom brawl. His efforts prevented further injury to bar patrons who had been attacked for no reason. Censurable Reports None END FILE"
												)
												(8
													(localproc_2 8 69) ; "NAME - Jones, Steve. BADGE - 5559023 DOB - 3/13/51 DEPARTMENT - Narcotics POSITION - Detective APPOINTED - 6/15/77 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations - 5/22/80 - On the above date, while assigned to Traffic Div., Officer Jones became"
													(localproc_2 8 70) ; "involved in a high speed pursuit of a stolen veh. During the pursuit, the suspect nearly collided with several other vehs before spinning out on a freeway offramp. As the suspect attempted to regain control of the veh. Officer Jones made the decision to terminate the pursuit by ramming the veh at low speed. The"
													(localproc_2 8 71) ; "suspect was placed under arrest without further incident. Censurable Reports None END FILE"
												)
												(9
													(localproc_2 8 72) ; "NAME - Walters, Kim. BADGE - 55510703 DOB - 4/22/63 DEPARTMENT - Narcotics POSITION - Detective APPOINTED - 6/15/85 STATUS - Active DEPARTMENTAL ACTIONS"
													(localproc_2 8 73) ; "Commendable citations 12/27/87 - Commendation Award - Since 8/1/85, Officer Walters has been team leader of the protective service unit assigned to Mayor Thomas G. Shmuck. Her outstanding effort in this area is duly noted. Censurable Reports None. END FILE"
												)
												(10
													(localproc_2 8 74) ; "NAME - Pratt, Lloyd. BADGE - 5557183 DOB - 6/12/48 DEPARTMENT - Narcotics POSITION - Detective APPOINTED - 12/15/71 STATUS - Active DEPARTMENTAL ACTIONS Medal of Valor 9/3/73-Officer Pratt was wounded in the line of duty while coming to the aid of a critically"
													(localproc_2 8 75) ; "wounded officer who had been hit with gunfire from a heavily armed fugitive. Pratt, after being hit in the right leg, returned fire and mortally wounded the suspect. Commendable citations 4/8/76-risked personal injury saving small child from burning vehicle."
													(localproc_2 8 76) ; "6/3/78-performed CPR, saving the life of a 45 year old heart attack victim. Censurable Reports 12/24/81-insubordination  CONFIDENTIAL: INTERNAL AFFAIRS DEPT. File: P3109 current/open ALLEGATION: On-duty drug consumption END FILE"
													(SetFlag 56)
												)
												(11
													(localproc_2 8 77) ; "NAME - Dooley, John. BADGE - 5556389 DOB - 7/27/28 DEPARTMENT - Narcotics POSITION - Lieutenant APPOINTED - 6/15/58 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations - 3/3/60 - Officer Dooley was instrumental in breaking up the largest auto theft"
													(localproc_2 8 78) ; "ring in the history of Lytton. Dooley arrested six suspects and recovered ten vehicles that were still outstanding. Censurable Reports None END FILE"
												)
												(12
													(localproc_2 8 79) ; "NAME - Watts, Laura BADGE - 5557344 DOB - 4/10/48 DEPARTMENT- Narcotics. POSITION - Detective. APPOINTED - 6/15/69 STATUS - Retired DEPARTMENTAL ACTIONS Commendable citations 3/1/72 - City of Lytton experienced unusually heavy rain, resulting in mud slides and road"
													(localproc_2 8 80) ; "closures. While working Traffic Division, Officer Watts moved into an area where commuter traffic had come to a stop. Officer Watts' professional and independent action was successful in diverting traffic to an alternate route, which cleared a potentially explosive situation."
													(localproc_2 8 81) ; "Censurable Reports 1/4/84-Being caught red handed making chicken tracks across the top of Sgt Dooley's desk with a rubber stamp. This brought to light the true identity of the infamous "gremlin", who went about antagonizing Sgt Dooley. FINDINGS: Sustained. ACTIONS: Written apology. Written reprimand."
												)
												(13
													(localproc_2 8 82) ; "NAME - Pierson, Jim. BADGE - 5557973 DOB - 10/30/48 DEPARTMENT - Homicide POSITION - Detective APPOINTED - 3/15/72 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations - 6/3/80 - While alone at the office writing reports, Officer Pierson encountered a"
													(localproc_2 8 83) ; "hysterical man who advised him that his wife was laying in the back seat of his car giving birth to a baby. After calming the man down, Officer Pierson successfully proceeded to aid in the birth of a healthy baby boy. The proud parents honored him by naming their new addition "James"."
													(localproc_2 8 84) ; "Censurable Reports - 4/16/73 - Allegation Involvement in three preventable traffic collisions during a 12 month period. FINDINGS: sustained. ACTION: Return to the Academy and successfully complete the defensive driving course."
													(localproc_2 8 85) ; "After completion of the course, Officer Pierson will be placed on 90 days probation. END FILE"
												)
												(14
													(localproc_2 8 86) ; "NAME - Robinson, Keith. BADGE - 5559645 DOB - 5/18/50 DEPARTMENT- Homicide POSITION - Detective APPOINTED - 6/15/79 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations - 12/8/81 - Superior effort in traffic management at the scene of a double fatal, chain"
													(localproc_2 8 87) ; "reaction collision on the Lytton Freeway. Officer Robinson's action quickly brought the scene under control and prevented further tragedy. Censurable Reports None END FILE"
												)
												(15
													(localproc_2 8 88) ; "NAME - Hall, Fletcher. BADGE - 5556619 DOB - 4/22/48 DEPARTMENT- Homicide POSITION - Captain APPOINTED - 12/15/66 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations - 6/5/78 - Outstanding investigative methods used in bringing about the arrest of mass"
													(localproc_2 8 89) ; "murderer Slinkard Pington. Censurable Reports - 3/7/85 - Failure to pass required physical performance test due to the excessive consumption of ice cream. END FILE"
												)
												(16
													(localproc_2 8 90) ; "NAME - Bonds, Sonny. BADGE - 5557763 DOB - 10/30/52 DEPARTMENT - Homicide POSITION - Detective APPOINTED - 12/15/71 STATUS - Active DEPARTMENTAL ACTIONS Commendable citations - 1/20/88 - While working Narcotics Division during 1987, Officer Bonds received"
													(localproc_2 8 91) ; "the Key to the City for his effort in the arrest of drug king Jessie Bains. Due to this effort, Bains was convicted and sent to prison for murder, drug trafficking, illegal gambling activities and attempted murder of a Police Officer. Censurable Reports: none. END FILE"
												)
												(17
													(localproc_2 8 92) ; "NAME - Mills, Kenneth. BADGE - 5557343 DOB - 3/26/40 DEPARTMENT- Traffic POSITION - Weapons Off. APPOINTED - 6/15/69 STATUS - Active DEPARTMENTAL ACTIONS - 6/9/81 - Bronze Medal Shooting event Summer Police Olympics Censurable Reports: none END FILE"
												)
											)
										)
										(7
											(switch local152
												(1
													(localproc_2 8 93) ; "CASE#: N555J212. NAME: Simms, Victor. ALIAS: none. ADDRESS: 304 2nd St. Lytton City, USA. SCARS/TATTOOS: none DOB: 4/14/66. PHYS: wht/male 5'7",blk,brn,145. ARREST RECORD: sale of narcotics CONVICTED: 10/5/83 Juvenile Court"
													(localproc_2 8 94) ; "INCARCERATED: none. LOCATION: none. SENTENCE: 1 year sentence suspended. PAROLE DATE: None. PROBATION: 1 yr. END FILE."
												)
												(2
													(localproc_2 8 95) ; "CASE#: N5553232 NAME: Colby, Donald. ALIAS: none. ADDRESS: CONFIDENTIAL SCARS/TATTOOS: none DOB: 2/19/48. PHYS: wht/male 5'7",blk,brn,145. ARREST RECORD: sale of narcotics CONVICTED: 10/5/83 INCARCERATED: none."
													(localproc_2 8 96) ; "SENTENCE: 1 year suspended sentence. PAROLE DATE: None. PROBATION: 1 yr. NOTE: turned states witness provided testimony in murder trial against Jessie Bains. CONFIDENTIAL: Subject relocated under State's witness protection program"
												)
												(3
													(localproc_2 8 97) ; "CASE#: N5553339 NAME: Snider, Wilma. ALIAS: Big Snort Snider ADDRESS: 203 Oak St. Lytton City, USA. SCARS/TATTOOS: none DOB: 7/19/60. PHYS: blk/fem 5'7",blk,brn,175. ARREST RECORD: sale of narcotics CONVICTED: 8/5/85"
													(localproc_2 8 98) ; "INCARCERATED: local LOCATION: Lytton Jail SENTENCE: 1 year suspended sentence. PAROLE DATE: None. PROBATION: 3 yr. END FILE."
												)
												(4
													(localproc_2 8 99) ; "CASE#: NT5552465 NAME: Mulkins, Jack ALIAS: Snow Man. ADDRESS: 111 Peach St. Lytton City, USA. SCARS/TATTOOS: none DOB: 8/17/64. PHYS: wht/male 5'9",blk,brn,170. ARREST RECORD: Under investigation for cocaine trafficking CONVICTED: None"
													(localproc_2 8 100) ; "INCARCERATED: N/A LOCATION: N/A SENTENCE: N/A PAROLE DATE: N/A PROBATION: N/A END FILE."
												)
												(5
													(localproc_2 8 101) ; "CASE#: NT5552467 NAME: Ramsey, Clyde ALIAS: None. ADDRESS: 212 10th St. Lytton City, USA. SCARS/TATTOOS: Numerous needle marks on both arms. DOB: 8/17/66. PHYS: wht/male 5'5",bln,blu,135. ARREST RECORD: Subject is known to"
													(localproc_2 8 102) ; "use and deal drugs. Has lengthy record of narcotics possession. Subject is now under surveillance. CONVICTED: Numerous convictions: possession INCARCERATED: N/A LOCATION: N/A SENTENCE: N/A PAROLE DATE: N/A PROBATION: Active END FILE."
												)
												(6
													(localproc_2 8 103) ; "CASE#: NT5552463 NAME: Quikel, Norma ALIAS: None. ADDRESS: 740 Fig St. Lytton City, USA. SCARS/TATTOOS: None DOB: 12/7/60. PHYS: blk/fem 5'5",blk,brn,135. ARREST RECORD: 6/18/87 possession, narcotics for sale."
													(localproc_2 8 104) ; "CONVICTED: Trial date has not been set. INCARCERATED: None LOCATION: N/A SENTENCE: N/A PAROLE DATE: N/A PROBATION: N/A END FILE."
												)
												(7
													(localproc_2 8 105) ; "CASE#: N5554999 NAME: Jones, Robin. ALIAS: none. ADDRESS: 302 Parkway Drive Lytton City, USA. SCARS/TATTOOS: 3" scar left forehead. DOB: 2/26/67. PHYS: blk/male 6'3",blk,hzl,225. ARREST RECORD: possession narcotics"
													(localproc_2 8 106) ; "CONVICTED: 6/6/87 INCARCERATED: none. LOCATION: none. SENTENCE: 1 year suspended sentence. PAROLE DATE: None. PROBATION: 3 yrs. END FILE."
												)
												(8
													(localproc_2 8 107) ; "CASE#: N5555678 NAME: Snow, George. ALIAS: Ice Man ADDRESS: transient SCARS/TATTOOS: tattoo of panther on back DOB: 3/15/56. PHYS: wht/male 6'0",blk,grn,206. ARREST RECORD: sale of narcotics CONVICTED: 6/6/86 INCARCERATED: State Pen"
													(localproc_2 8 108) ; "LOCATION: Foolsum SENTENCE: 1 year PAROLE DATE: 12/6/86. PROBATION: 3 yrs. END FILE."
												)
												(9
													(localproc_2 8 109) ; "CASE#: V5554433. NAME: Catskill, Frank. ALIAS: Fat Cat ADDRESS: transient. SCARS/TATTOOS: cat's paw on left forearm DOB: 2/14/40. PHYS: blk/male 5'10",bald,blu,115. ARREST RECORD: extortion, 2nd offense CONVICTED: 12/5/85 INCARCERATED: State Pen"
													(localproc_2 8 110) ; "LOCATION: Foolsum. SENTENCE: 2 years. PAROLE DATE: None. END FILE."
												)
												(11
													(localproc_2 8 111) ; "CASE#: N5554657 NAME: Valencia, Jose. ALIAS: none ADDRESS: 25112 Staton Court Century USA SCARS/TATTOOS: none DOB: 3/15/63. PHYS: mex/male 6'0",blk,brn,190. ARREST RECORD: Narcotics for sale. Possession of drug"
													(localproc_2 8 112) ; "paraphernalia. Assault on police officer. INCARCERATED: State Pen LOCATION: Foolsum SENTENCE: 2 year PAROLE DATE: none. PROBATION: 5 yrs. END FILE."
												)
												(12
													(localproc_2 8 113) ; "CASE#: N5550001 NAME: Dickey, Moffet. ALIAS: none ADDRESS: 293 Peach St. Lytton City, USA SCARS/TATTOOS: none DOB: 3/20/28. PHYS: wht/male 6'0",bln,blu,150. ARREST RECORD: possession of narcotics CONVICTED: 10/3/86 INCARCERATED: none."
													(localproc_2 8 114) ; "LOCATION: none SENTENCE: 1 year suspended sentence PAROLE DATE: none. PROBATION: 6 mo. END FILE."
												)
												(13
													(localproc_2 8 115) ; "CASE#: V5554321. NAME: Wilkans, Marie. ALIAS: Sweet Cheeks ADDRESS: 222 W Peach Lytton City, USA SCARS/TATTOOS: none. DOB: 2/14/53 PHYS: wht/fem 5'03",blk,blu,115. ARREST RECORD: solicitation CONVICTED: none"
													(localproc_2 8 116) ; "NOTE: provided assistance for Lytton PD in undercover operation leading to the arrest of murder suspect Jessie Bains. END FILE."
												)
												(14
													(localproc_2 8 117) ; "CASE#: V5551928. NAME: Roberts, Woodrow. ALIAS: Woody ADDRESS: 5556 Oak St. Lytton City, USA SCARS/TATTOOS: none. DOB: 2/14/61. PHYS: wht/male 5'08",brn,brn,210. ARREST RECORD: Illegal gambling CONVICTED: 10/25/83 SENTENCED: suspended,"
													(localproc_2 8 118) ; "4 year probation. NOTE: turned states witness provided testimony in murder trial against Jessie Bains. END FILE."
												)
												(15
													(localproc_2 8 119) ; "CASE#: V5553976. NAME: Fogg, Maynard. ALIAS: Dirty Man ADDRESS: 1121 E. Lilly Lytton City, USA. SCARS/TATTOOS: none DOB: 6/21/33. PHYS: wht/male 5'6",bald,brn,200. ARREST RECORD: PORNOGRAPHY 13th offense CONVICTED: 7/5/86 INCARCERATED: State Pen."
													(localproc_2 8 120) ; "LOCATION: Foolsum. SENTENCE: 112 years. PAROLE DATE: None. END FILE."
												)
												(16
													(localproc_2 8 121) ; "CASE#: V5554444. NAME: Bridford, Robert. ALIAS: Bobby the Bookie. ADDRESS: 502 Tenth St. Lytton City, USA. SCARS/TATTOOS: none DOB: 9/11/37. PHYS: blk/male 5'8",bln,brn,160. ARREST RECORD: BOOK MAKING 3rd offense CONVICTED: 6/5/87 INCARCERATED: local."
													(localproc_2 8 122) ; "LOCATION: Lytton Jail. SENTENCE: 1 year SUSPENDED sentence. PAROLE DATE: None. PROBATION: 2 yrs. END FILE."
												)
											)
										)
									)
								)
							)
							(Format @local100 8 0)
						)
					)
					(cond
						(
							(and
								(not (StrCmp @local100 {DIR}))
								(not local146)
								(not local148)
							)
							(Format @local100 8 0)
							(Display 8 13 dsCOORD 123 14 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(Display 8 13 dsCOORD 123 15 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(compCursor x: 123)
							(switch local145
								(0
									(Display 8 123 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Criminal (DIR)"
									(Display 8 124 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Sierra (DIR)"
									(Display 8 125 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Personnel (DIR)"
								)
								(1
									(Display 8 126 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "POLICE QUEST"
									(Display 8 127 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KING'S QUEST"
									(Display 8 128 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KQ II"
									(Display 8 129 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KQ III"
									(Display 8 130 dsCOORD 73 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "KQ IV"
									(Display 8 131 dsCOORD 73 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "SILPHEED"
									(Display 8 132 dsCOORD 73 84 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "MANHUNTER"
									(Display 8 133 dsCOORD 73 94 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "THEXDER"
									(Display 8 134 dsCOORD 73 104 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "GOLD RUSH"
									(Display
										(Format @local0 8 135) ; "MOTHER GOOSE"
										dsCOORD
										73
										114
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 136) ; "| SPACE QUEST"
										dsCOORD
										160
										24
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 137) ; "| SQ II"
										dsCOORD
										160
										34
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 138) ; "| SQ III"
										dsCOORD
										160
										44
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 139) ; "| LSL I"
										dsCOORD
										160
										54
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(Display
										(Format @local0 8 140) ; "| LSL II"
										dsCOORD
										160
										64
										dsCOLOR
										9
										dsFONT
										7
										dsBACKGROUND
										0
									)
									(= local149 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
								(2
									(Display
										(Format @local0 8 141) ; "Gelepsi, Mario"
										dsCOORD
										73
										24
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 142) ; "Haines, Calvin"
										dsCOORD
										73
										34
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 143) ; "Simpson, James"
										dsCOORD
										73
										44
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 144) ; "Adams, Robert"
										dsCOORD
										73
										54
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 145) ; "Waters, Laura"
										dsCOORD
										73
										64
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display
										(Format @local0 8 146) ; "Jerome, William"
										dsCOORD
										73
										74
										dsCOLOR
										9
										dsFONT
										7
									)
									(Display 8 147 dsCOORD 73 84 dsCOLOR 9 dsFONT 7) ; "Willis, John"
									(Display 8 148 dsCOORD 73 94 dsCOLOR 9 dsFONT 7) ; "Jones, Steve"
									(Display 8 149 dsCOORD 73 104 dsCOLOR 9 dsFONT 7) ; "Walters, Kim"
									(Display 8 150 dsCOORD 73 114 dsCOLOR 9 dsFONT 7) ; "Pratt, Lloyd"
									(Display 8 151 dsCOORD 155 24 dsCOLOR 9 dsFONT 7) ; "| Dooley, John"
									(Display 8 152 dsCOORD 155 34 dsCOLOR 9 dsFONT 7) ; "| Watts, Laura"
									(Display 8 153 dsCOORD 155 44 dsCOLOR 9 dsFONT 7) ; "| Pierson, James"
									(Display 8 154 dsCOORD 155 54 dsCOLOR 9 dsFONT 7) ; "| Robinson, Keith"
									(Display 8 155 dsCOORD 155 64 dsCOLOR 9 dsFONT 7) ; "| Hall, Fletcher"
									(Display 8 156 dsCOORD 155 74 dsCOLOR 9 dsFONT 7) ; "| Bonds, Sonny"
									(Display 8 157 dsCOORD 155 84 dsCOLOR 9 dsFONT 7) ; "| Mills, Kenneth"
									(= local147 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
								(3
									(Display 8 158 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Homicide (DIR)"
									(Display 8 159 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Vice (DIR)"
									(Display 8 160 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Burglary (DIR)"
									(Display 8 161 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "FireArms (DIR)"
								)
								(4
									(Display 8 162 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Taselli, Jason"
									(Display 8 163 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Loofin, Jasper"
									(Display 8 164 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Martin, Richard"
									(Display 8 165 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Botts, Rambus"
									(Display 8 166 dsCOORD 73 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Granandez, Jose"
									(Display 8 167 dsCOORD 73 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Martinez, Chico"
									(Display 8 168 dsCOORD 73 84 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "South, Julia"
									(Display 8 169 dsCOORD 158 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| West, Lonnie"
									(Display 8 170 dsCOORD 158 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Bains, Jessie"
									(Display 8 171 dsCOORD 158 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Smith, Kenneth"
									(Display 8 172 dsCOORD 158 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Loofin, Mary"
									(Display 8 173 dsCOORD 158 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Swift, Peter"
									(Display 8 174 dsCOORD 158 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| South, Lorin"
									(= local147 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
								(7
									(Display 8 175 dsCOORD 73 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Simms, Victor"
									(Display 8 176 dsCOORD 73 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Colby, Donald"
									(Display 8 177 dsCOORD 73 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Snider, Wilma"
									(Display 8 178 dsCOORD 73 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Mulkins, Jack"
									(Display 8 179 dsCOORD 73 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Ramsey, Clyde"
									(Display 8 180 dsCOORD 73 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Quikel, Norma"
									(Display 8 181 dsCOORD 73 84 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Jones, Robin"
									(Display 8 182 dsCOORD 73 94 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Snow, George"
									(Display 8 183 dsCOORD 73 104 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "Catskill, Frank"
									(Display 8 184 dsCOORD 154 24 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Valencia, Jose"
									(Display 8 185 dsCOORD 154 34 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Dickey, Moffit"
									(Display 8 186 dsCOORD 154 44 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Wilkans, Marie"
									(Display 8 187 dsCOORD 154 54 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Roberts, Woody"
									(Display 8 188 dsCOORD 154 64 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Fogg, Maynard"
									(Display 8 189 dsCOORD 154 74 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "| Bridford, R."
									(= local147 1)
									(= local152 1)
									(fileCursor
										view: 9
										loop: 1
										posn: 71 32
										init:
									)
								)
							)
							(localproc_0)
						)
						(
							(or
								(not (StrCmp @local100 {QUIT}))
								(not (StrCmp @local100 {LOGOUT}))
								(not (StrCmp @local100 {EXIT}))
								(not (StrCmp @local100 {BYE}))
							)
							(self changeState: 3)
						)
						((not (StrCmp @local100 {CD}))
							(Format @local100 8 0)
							(Display 8 14 dsCOORD 73 14 dsCOLOR 0 dsFONT 7 dsBACKGROUND 0)
							(Display 8 190 dsCOORD 73 14 dsCOLOR 9 dsFONT 7 dsBACKGROUND 0) ; "DIR? >"
							(= local149 0)
							(= local147 0)
							(= local146 1)
							(localproc_0)
						)
					)
				)
			)
		)
	)
)

