;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use n001)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	selChar 0
)

(local
	whichChar
	firstTime = 1
	savedSpeed
	[charScripts 3]
	[charButtons 3]
)

(procedure (allocatePoints)
	(= gHeroType whichChar)
	(cls)
	(gCurRoom newRoom: 810) ; chAlloc
)

(instance selChar of Rm
	(properties
		picture 800
		style 8
	)

	(method (dispose)
		(charSound stop: dispose:)
		(gCSound stop:)
		(LockoutMenus 0)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 800 801 802 803 804)
		(ClearFlag 2) ; fInMainGame
		(gCSound number: 800 loop: -1 priority: 2 playBed:)
		(charSound init:)
		(super init: &rest)
		(fighterButton init: stopUpd:)
		(wizardButton init: stopUpd:)
		(thiefButton init: stopUpd:)
		(chooser init: stopUpd:)
		(theHero init:)
		(holeInWall init: hide:)
		(rubble init: hide:)
		(leftBlind init:)
		(rightBlind init:)
		(= [charScripts 0] showFighter)
		(= [charButtons 0] fighterButton)
		(= [charScripts 1] showWizard)
		(= [charButtons 1] wizardButton)
		(= [charScripts 2] showThief)
		(= [charButtons 2] thiefButton)
		(LockoutMenus 1)
		(HandsOff)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(if (>= gHowFast 1)
			(theHero cycleSpeed: 1 moveSpeed: 1)
		)
		(redRect init:)
		(gAddToPics doit:)
		(Display
			{Press '?' to learn about this hero type.}
			dsCOORD
			35
			170
			dsALIGN
			alCENTER
			dsFONT
			300
			dsCOLOR
			14
			dsBACKGROUND
			4
			dsWIDTH
			250
		)
		(self setScript: showFighter)
	)

	(method (handleEvent event &tmp eType msg)
		(= eType (event type:))
		(= msg (event message:))
		(switch eType
			(evKEYBOARD
				(event claimed: 1)
				(switch msg
					(KEY_RETURN
						(allocatePoints)
					)
					(KEY_TAB
						(= whichChar (mod (+ whichChar 1) 3))
						(self setScript: [charScripts whichChar])
					)
					(KEY_SHIFTTAB
						(= whichChar (mod (+ whichChar 2) 3))
						(self setScript: [charScripts whichChar])
					)
					(KEY_QUESTION
						([charButtons whichChar] doVerb: 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(event claimed: 1)
				(cond
					((fighterButton onMe: event)
						(= whichChar 0)
						(chooser posn: 44 109 setCycle: Fwd)
						(fighterButton setScript: pushButton)
					)
					((wizardButton onMe: event)
						(= whichChar 1)
						(chooser posn: 160 33)
						(wizardButton setScript: pushButton)
					)
					((thiefButton onMe: event)
						(= whichChar 2)
						(chooser posn: 276 109)
						(thiefButton setScript: pushButton)
					)
					((or (leftBlind onMe: event) (rightBlind onMe: event))
						(allocatePoints)
					)
				)
			)
		)
	)
)

(instance showFighter of Script
	(properties)

	(method (dispose)
		(holeInWall hide:)
		(rubble hide:)
		(charSound stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= whichChar 0)
				(if register
					(fighterButton setScript: pushButton)
				)
				(chooser posn: 44 109)
				(theHero view: 801 setLoop: 0 setCel: 0 posn: 159 132)
				(self setScript: openBlinds self)
			)
			(1
				(if firstTime
					(= firstTime 0)
					(gGame setCursor: gNormalCursor 1)
				)
				(charSound number: 801 play:)
				(theHero setCycle: End self)
			)
			(2
				(if register
					(allocatePoints)
				else
					(self setScript: closeBlinds self)
				)
			)
			(3
				(client setScript: showWizard)
			)
		)
	)
)

(instance showWizard of Script
	(properties)

	(method (dispose)
		(theHero cycleSpeed: savedSpeed)
		(charSound stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= whichChar 1)
				(if register
					(wizardButton setScript: pushButton)
				)
				(chooser posn: 160 33)
				(= savedSpeed (theHero cycleSpeed:))
				(theHero
					view: 802
					setLoop: 0
					setCel: 0
					posn: 159 132
					cycleSpeed: 0
				)
				(self setScript: openBlinds self)
			)
			(1
				(charSound number: 802 play:)
				(theHero setCycle: End self)
			)
			(2
				(theHero setLoop: 1 setCel: 0 cycleSpeed: savedSpeed)
				(= cycles (+ (theHero cycleSpeed:) 1))
			)
			(3
				(theHero setCycle: End self)
			)
			(4
				(theHero setLoop: 2 setCel: 0)
				(= cycles (+ (theHero cycleSpeed:) 1))
			)
			(5
				(theHero setCycle: End self)
			)
			(6
				(if register
					(allocatePoints)
				else
					(theHero setLoop: 3 setCel: 0)
					(= seconds 2)
				)
			)
			(7
				(theHero setCycle: End self)
			)
			(8
				(self setScript: closeBlinds self)
			)
			(9
				(client setScript: showThief)
			)
		)
	)
)

(instance showThief of Script
	(properties)

	(method (dispose)
		(charSound stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= whichChar 2)
				(if register
					(thiefButton setScript: pushButton)
				)
				(chooser posn: 276 109)
				(theHero view: 803 setLoop: 0 setCel: 0 posn: 129 67)
				(self setScript: openBlinds self)
			)
			(1
				(charSound number: 803 play:)
				(theHero posn: 129 86 setCel: 1)
				(= cycles 3)
			)
			(2
				(theHero posn: 129 130 setCel: 2)
				(= cycles 3)
			)
			(3
				(theHero setLoop: 1 setCel: 0)
				(= cycles (+ (theHero cycleSpeed:) 1))
			)
			(4
				(theHero setCycle: End self)
			)
			(5
				(if register
					(allocatePoints)
				else
					(theHero setLoop: 2 setCel: 0)
					(= cycles (+ (theHero cycleSpeed:) 1))
				)
			)
			(6
				(theHero xStep: 7 setCycle: End setMotion: MoveTo 93 130 self)
			)
			(7
				(self setScript: closeBlinds self)
			)
			(8
				(client setScript: showFighter)
			)
		)
	)
)

(instance openBlinds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 1)
				(self cue:)
			)
			(1
				(leftBlind palette: register forceUpd:)
				(rightBlind palette: register forceUpd:)
				(= cycles 1)
				(if (== gHowFast 3)
					(++ cycles)
				)
			)
			(2
				(if (<= (++ register) 6)
					(self changeState: 1)
				else
					(leftBlind stopUpd:)
					(rightBlind stopUpd:)
					(self dispose:)
				)
			)
		)
	)
)

(instance closeBlinds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 6)
				(= seconds 2)
			)
			(1
				(leftBlind palette: register forceUpd:)
				(rightBlind palette: register forceUpd:)
				(= cycles 1)
			)
			(2
				(if (> (-- register) 0)
					(self changeState: 1)
				else
					(= seconds 2)
				)
			)
			(3
				(leftBlind stopUpd:)
				(rightBlind stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance pushButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 1)
				(= cycles 2)
			)
			(1
				(client setCel: 0)
				(= cycles 1)
			)
			(2
				(allocatePoints)
			)
		)
	)
)

(instance selTitle of PicView ; UNUSED
	(properties
		x 158
		y 178
		description {the title}
		lookStr {Use the Enter key or the left mouse button to choose a character type.}
		view 800
		loop 5
		signal 16384
	)
)

(instance chooser of Prop
	(properties
		x 44
		y 109
		shiftClick 0
		view 800
		loop 1
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance fighterButton of Prop
	(properties
		x 45
		y 109
		description {the fighter button}
		lookStr {Fighters tend to be rough, tough, and rowdy.__Choose the Fighter if you want to take the direct approach to your problems.}
		view 800
		loop 2
		priority 15
		signal 16400
	)
)

(instance wizardButton of Prop
	(properties
		x 160
		y 33
		description {the wizard button}
		lookStr {Wizards are known for their powerful spells and subtle, indirect solutions to problems.}
		view 800
		loop 3
		signal 16384
	)
)

(instance thiefButton of Prop
	(properties
		x 277
		y 109
		description {the thief button}
		lookStr {Thieves have a variety of special skills, such as picking locks, hiding, and climbing walls.__The thief tends to work around problems rather than attacking them directly.}
		view 800
		loop 4
		signal 16384
	)
)

(instance holeInWall of View
	(properties
		x 159
		y 124
		description {the hole}
		lookStr {Gee, that wall wasn't so tough, was it?__At least, not so tough that a Fighter couldn't handle it!}
		view 800
		signal 16384
	)
)

(instance theHero of Actor
	(properties
		x 159
		y 132
		description {the Hero}
		view 801
		signal 16384
		illegalBits 0
	)

	(method (doit)
		(if (== view 801)
			(switch (theHero cel:)
				(2
					(holeInWall show:)
				)
				(4
					(rubble show:)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			([charButtons whichChar] doVerb: 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rubble of View
	(properties
		x 153
		y 130
		description {the crumbled stone from the wall}
		lookStr {You sure taught that wall a lesson!}
		view 801
		loop 1
		signal 16384
	)
)

(instance leftBlind of Prop
	(properties
		x 131
		y 146
		shiftClick 0
		view 804
		priority 15
		signal 16400
		palette 1
		cycleSpeed 1
	)
)

(instance rightBlind of Prop
	(properties
		x 190
		y 146
		shiftClick 0
		view 804
		loop 1
		priority 15
		signal 16400
		palette 1
		cycleSpeed 1
	)
)

(instance charSound of Sound
	(properties
		number 801
		priority 5
	)
)

(instance redRect of PicView
	(properties
		x 35
		y 169
		view 800
		loop 6
	)
)

