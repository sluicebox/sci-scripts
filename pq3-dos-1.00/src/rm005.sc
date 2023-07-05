;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use eRS)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm005 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(JHead cel: 0 setCycle: 0)
	(JOpenHand cel: 0)
)

(instance rm005 of PQRoom
	(properties
		picture 5
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 103 104 101 100)
		(gLongSong number: 51 play:)
		(JHead init:)
		(JHand setScript: handScript init:)
		(JOpenHand setScript: openHandScript init:)
		(JArm setScript: armScript init:)
		(JEye setScript: eyeScript init:)
		(self setRegions: 127 setScript: jimTalk) ; intro
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance jimTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(= cycles 1)
			)
			(2
				(if (<= (gLongSong prevSignal:) 0)
					(-- state)
				else
					(JHead setCycle: RandCycle)
					(= cycles 1)
				)
			)
			(3
				(= local0
					(Display 5 0 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Hello. I'm Jim Walls, retired California Highway Patrol Officer and designer of the Police Quest series."
				)
				(= cycles 1)
			)
			(4
				(= cycles 1)
			)
			(5
				(if (<= (gLongSong prevSignal:) 1)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(localproc_0)
				(= seconds 2)
			)
			(7
				(= cycles 5)
			)
			(8
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(9
				(= local1 1)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 2 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "With Police Quest, you're not just watching some movie star portraying the glamourous part of police work. As Detective Sonny Bonds, YOU'RE the man behind the badge."
				)
				(= cycles 1)
			)
			(10
				(= cycles 1)
			)
			(11
				(if (<= (gLongSong prevSignal:) 2)
					(-- state)
				)
				(= cycles 1)
			)
			(12
				(localproc_0)
				(= seconds 2)
			)
			(13
				(= cycles 5)
			)
			(14
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(15
				(= local1 0)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 3 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "It's up to you to learn and follow correct police procedure - to make the right decisions in life and death situations."
				)
				(= cycles 1)
			)
			(16
				(= cycles 1)
			)
			(17
				(if (<= (gLongSong prevSignal:) 3)
					(-- state)
				)
				(= cycles 1)
			)
			(18
				(localproc_0)
				(= seconds 2)
			)
			(19
				(= cycles 5)
			)
			(20
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(21
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 4 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "In REAL police work, you have to know when to be a hero and when to rely on caution and use the other team players on the force."
				)
				(= cycles 1)
			)
			(22
				(= cycles 1)
			)
			(23
				(if (<= (gLongSong prevSignal:) 4)
					(-- state)
				)
				(= cycles 1)
			)
			(24
				(localproc_0)
				(= seconds 2)
			)
			(25
				(= cycles 5)
			)
			(26
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(27
				(= local1 1)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 5 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Some of the incidents in Police Quest 3 are based on actual events that occurred during the course of my career. I managed to survive them. Let's see if YOU can do as well under pressure."
				)
				(= cycles 1)
			)
			(28
				(= cycles 1)
			)
			(29
				(if (<= (gLongSong prevSignal:) 5)
					(-- state)
				)
				(= cycles 1)
			)
			(30
				(localproc_0)
				(= seconds 2)
			)
			(31
				(= cycles 5)
			)
			(32
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(33
				(= local1 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 6 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Here's the scene you're about to be walking into..."
				)
				(= seconds 5)
			)
			(34
				(client setScript: scene1Script)
			)
		)
	)
)

(instance scene1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= (gLongSong prevSignal:) 6)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(scene1 init: setCycle: End)
				(= cycles 1)
				(localproc_0)
			)
			(2
				(= cycles 1)
			)
			(3
				(if (<= (gLongSong prevSignal:) 7)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(= local1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(JHead cycleSpeed: 7 setCycle: RandCycle)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 7 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Lytton, once a quiet and peaceful little town, has been growing like a weed. There's new industry, good jobs, and a decent standard of living."
				)
				(= cycles 1)
			)
			(5
				(= cycles 1)
			)
			(6
				(if (<= (gLongSong prevSignal:) 8)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(localproc_0)
				(= seconds 2)
			)
			(8
				(= cycles 5)
			)
			(9
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(10
				(= local1 1)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 8 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Unfortunately, progress is not without its side effects. Poverty and crime are going up about as fast as the new cultural center."
				)
				(= cycles 1)
			)
			(11
				(= cycles 1)
			)
			(12
				(if (<= (gLongSong prevSignal:) 9)
					(-- state)
				)
				(= cycles 1)
			)
			(13
				(scene1 setCycle: Beg self)
			)
			(14
				(Display 5 1 dsRESTOREPIXELS local0)
				(scene1 dispose:)
				(client setScript: scene3Script)
			)
		)
	)
)

(instance scene3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (<= (gLongSong prevSignal:) 10)
					(-- state)
				)
				(localproc_0)
				(= cycles 1)
			)
			(2
				(scene3 init: setCycle: CT 4 1)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(if (<= (gLongSong prevSignal:) 11)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(JHead cycleSpeed: 7 setCycle: RandCycle)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 9 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Homicide Detective Sonny Bonds and his wife Marie are still on a 'honeymoon high' from their wedding a few years back."
				)
				(= cycles 1)
			)
			(6
				(scene3 setCycle: End self)
			)
			(7
				(= seconds 3)
			)
			(8
				(scene3EgoFace init: setCycle: End self)
				(scene3MarieFace init: setCycle: End self)
			)
			(9 0)
			(10
				(= cycles 1)
			)
			(11
				(if (<= (gLongSong prevSignal:) 12)
					(-- state)
				)
				(= cycles 1)
			)
			(12
				(localproc_0)
				(= seconds 2)
			)
			(13
				(= cycles 5)
			)
			(14
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(15
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 10 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Marie's got a good job at Oak Tree Mall and the two have a beautiful new home."
				)
				(= cycles 1)
			)
			(16
				(= local1 0)
				(= cycles 1)
			)
			(17
				(= cycles 1)
			)
			(18
				(if (<= (gLongSong prevSignal:) 13)
					(-- state)
				)
				(= cycles 1)
			)
			(19
				(Display 5 1 dsRESTOREPIXELS local0)
				(localproc_0)
				(scene3 dispose:)
				(= cycles 2)
			)
			(20
				(client setScript: scene2Script)
			)
		)
	)
)

(instance scene2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (<= (gLongSong prevSignal:) 14)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(scene2 init: setCycle: End)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(if (<= (gLongSong prevSignal:) 15)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(localproc_0)
				(= seconds 2)
			)
			(6
				(= cycles 5)
			)
			(7
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(8
				(= local1 1)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 11 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "As for Sonny, he was promoted to Detective Sergeant with the Lytton Police Department."
				)
				(= cycles 1)
			)
			(9
				(scene2Arm setLoop: 1 setPri: 15 init:)
				(= cycles 2)
			)
			(10
				(scene2Eyes setCycle: End init:)
				(scene2Arm setCycle: End self)
			)
			(11
				(scene2Eyes setCycle: Beg self)
			)
			(12
				(scene2Lapel init:)
				(= cycles 1)
			)
			(13
				(= cycles 1)
			)
			(14
				(if (<= (gLongSong prevSignal:) 16)
					(-- state)
				)
				(= cycles 1)
			)
			(15
				(localproc_0)
				(= seconds 2)
			)
			(16
				(= cycles 5)
			)
			(17
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(18
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 12 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "As the story opens, Sonny's just finished his Sergeant's training and is back on duty."
				)
				(scene2Mouth init: setCycle: End self)
			)
			(19
				(scene2Arm
					setLoop: 1
					moveSpeed: 3
					cycleSpeed: 3
					setMotion: MoveTo -60 93 self
				)
			)
			(20
				(scene2Lapel setCycle: End)
				(localproc_0)
				(= seconds 6)
			)
			(21
				(= local1 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(scene2 dispose:)
				(= cycles 2)
			)
			(22
				(client setScript: endPartScript)
			)
		)
	)
)

(instance endPartScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (<= (gLongSong prevSignal:) 17)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(JHead cycleSpeed: 9 setCycle: RandCycle)
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 13 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Overburdened as the department is, he's been assigned to Traffic Division for a bit. Seems Traffic's always understaffed."
				)
				(= cycles 1)
			)
			(3
				(= cycles 1)
			)
			(4
				(if (<= (gLongSong prevSignal:) 18)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(localproc_0)
				(= seconds 2)
			)
			(6
				(= cycles 5)
			)
			(7
				(JHead setCycle: RandCycle)
				(= cycles 1)
			)
			(8
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 14 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS) ; "Well, that's Sonny's life - and it's a good one, worth protecting. And now it's time for you to assume the role of Detective Sonny Bonds. I happen to know you're in for a heck of a day."
				)
				(= seconds 13)
			)
			(9
				(Display 5 1 dsRESTOREPIXELS local0)
				(= local0
					(Display 5 15 dsCOORD 186 0 dsCOLOR global125 dsALIGN alCENTER dsWIDTH 140 dsSAVEPIXELS)
				)
				(= cycles 1)
			)
			(10
				(localproc_0)
				(= seconds 3)
			)
			(11
				(gLongSong fade:)
				(gCurRoom newRoom: 10)
			)
		)
	)
)

(instance JHead of Prop
	(properties
		x 163
		y 40
		description {Jim's Mouth}
		view 100
		cycleSpeed 9
	)
)

(instance headScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JHead setCycle: 0)
				(= seconds (Random 0 5))
			)
			(1
				(JHead setCycle: RandCycle)
				(= seconds (Random 1 8))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance JHand of Prop
	(properties
		x 189
		y 128
		description {Jim's Hand}
		view 100
		loop 2
		cycleSpeed 13
	)
)

(instance handScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 15))
			)
			(1
				(JHand setCycle: End self)
			)
			(2
				(= seconds 1)
			)
			(3
				(JHand setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance JOpenHand of Prop
	(properties
		x 193
		y 127
		description {Jim's Hand}
		view 100
		loop 3
		priority 15
		signal 16400
	)
)

(instance openHandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(if local1
					(= cycles 1)
				else
					(JOpenHand setCycle: End)
					(= seconds (Random 3 6))
				)
			)
			(2
				(if local1
					(= cycles 1)
				else
					(JOpenHand cel: 0)
					(= cycles 1)
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance JEye of Prop
	(properties
		x 166
		y 25
		description {Jim's Eye}
		view 100
		loop 1
		cycleSpeed 12
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(JEye cel: 1)
				(= cycles 1)
			)
			(2
				(JEye cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance JArm of Prop
	(properties
		x 111
		y 100
		view 100
		loop 4
		cycleSpeed 13
	)
)

(instance armScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JArm setCycle: 0)
				(= seconds (Random 20 30))
			)
			(1
				(JArm cycleSpeed: 14 setCycle: End self)
			)
			(2
				(JArm setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance scene1 of Prop
	(properties
		x 93
		y 29
		description {The City}
		view 101
		cycleSpeed 8
	)
)

(instance scene2 of Prop
	(properties
		x 40
		y 23
		description {Graduation}
		view 103
		priority 3
		signal 16
		cycleSpeed 8
	)

	(method (init)
		(scene2Arm init:)
		(scene2Eyes x: (self x:) y: (+ (self y:) 6))
		(scene2Mouth x: (- (self x:) 3) y: (+ (self y:) 31))
		(scene2Lapel x: (+ (self x:) 20) y: (+ (self y:) 47))
		(super init:)
	)

	(method (dispose)
		(scene2Arm dispose:)
		(scene2Lapel dispose:)
		(scene2Eyes dispose:)
		(scene2Mouth dispose:)
		(super dispose:)
	)
)

(instance scene2Arm of Actor
	(properties
		x 17
		y 83
		description {arm}
		view 103
		loop 1
		priority 14
		signal 16
	)
)

(instance scene2Lapel of Prop
	(properties
		view 103
		loop 2
		priority 11
		signal 16
	)
)

(instance scene2Eyes of Prop
	(properties
		view 103
		loop 3
		priority 11
		signal 16
	)
)

(instance scene2Mouth of Prop
	(properties
		view 103
		loop 4
		priority 11
		signal 16
	)
)

(instance scene3 of Prop
	(properties
		x 70
		y 67
		description {hug}
		view 104
		priority 3
		signal 16
		cycleSpeed 8
	)

	(method (dispose)
		(scene3EgoFace dispose:)
		(scene3MarieFace dispose:)
		(super dispose:)
	)
)

(instance scene3EgoFace of Prop
	(properties
		x 60
		y 54
		view 104
		loop 1
		priority 4
		signal 16
	)
)

(instance scene3MarieFace of Prop
	(properties
		x 30
		y 83
		view 104
		loop 2
		priority 4
		signal 16
	)
)

