;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm47 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp1 (Display &rest dsALIGN alCENTER dsCOORD 10 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS))
	(repeat
		(= temp0 (Event distance: 5))
		(breakif (& (temp0 done:) $0005))
		(temp0 bumpTurn:)
	)
	(temp0 bumpTurn:)
	(Display 47 0 dsRESTOREPIXELS temp1)
)

(instance bainsRunning of Act
	(properties)
)

(instance bainsShadow of Act
	(properties)
)

(instance sonnyRunning of Act
	(properties)
)

(instance sonnyShadow of Act
	(properties)
)

(instance legs of Prop
	(properties)
)

(instance weeds of Act
	(properties)
)

(instance weeds2 of Act
	(properties)
)

(instance bubbles of Act
	(properties)
)

(instance programming of View
	(properties)
)

(instance art of View
	(properties)
)

(instance animation of View
	(properties)
)

(instance project of View
	(properties)
)

(instance coordinator of View
	(properties)
)

(instance system of View
	(properties)
)

(instance development of View
	(properties)
)

(instance music of View
	(properties)
)

(instance heitman of View
	(properties)
)

(instance jeff of View
	(properties)
)

(instance pablo of View
	(properties)
)

(instance stuart of View
	(properties)
)

(instance crowe of View
	(properties)
)

(instance jerry of View
	(properties)
)

(instance fischbach of View
	(properties)
)

(instance mickie of View
	(properties)
)

(instance dave of View
	(properties)
)

(instance vu of View
	(properties)
)

(instance cheri of View
	(properties)
)

(instance chris of View
	(properties)
)

(instance rm47 of Rm
	(properties
		picture 47
		style 6
	)

	(method (incClientPos)
		(super incClientPos:)
		(HandsOff)
		(Load rsVIEW 311)
		(Load rsVIEW 903)
		(Load rsVIEW 904)
		(Load rsVIEW 209)
		(Load rsVIEW 292)
		(bainsRunning
			nsLeft: 209
			sel_360: 1
			sel_354: -30 140
			setSpeed: Walk
			sel_400: 11 1
			incClientPos:
		)
		(bainsShadow
			nsLeft: 209
			sel_360: 2
			sel_354: -40 135
			setSpeed: Walk
			sel_400: 11 1
			incClientPos:
			sel_362: 1
			hide: 1
		)
		(sonnyRunning
			nsLeft: 292
			sel_360: 1
			sel_354: -30 140
			setSpeed: Walk
			sel_400: 8 1
			incClientPos:
		)
		(sonnyShadow
			nsLeft: 292
			sel_360: 2
			sel_354: -40 135
			setSpeed: Walk
			sel_400: 8 1
			sel_362: 1
			hide: 1
			incClientPos:
		)
		(legs
			nsLeft: 311
			nsRight: 0
			sel_354: 253 125
			hide: 0
			incClientPos:
			sel_316: 1
			setSpeed: Fwd
		)
		(weeds
			nsLeft: 311
			sel_360: 1
			sel_354: 10 130
			hide: 2
			incClientPos:
			setSpeed: Fwd
			sel_316: 1
			sel_400: 4 1
			sel_340: MoveTo 300 130 weed1Script
		)
		(weeds2
			nsLeft: 311
			sel_360: 1
			sel_354: 150 140
			hide: 2
			incClientPos:
			setSpeed: Fwd
			sel_400: 4 1
			sel_340: MoveTo 300 140 weed2Script
		)
		(bubbles
			nsLeft: 311
			sel_360: 2
			sel_354: 60 130
			hide: 1
			sel_400: 4 5
			incClientPos:
			setSpeed: Fwd
			sel_340: MoveTo 160 0 bubbleScript
		)
		(self sel_370: scubaScript)
	)

	(method (set)
		(if (> local0 1)
			(-- local0)
		)
		(if (== local0 1)
			(= local0 0)
			(self prompt:)
		)
		(super set:)
	)

	(method (bumpTurn)
		(weed2Script bumpTurn:)
		(weed1Script bumpTurn:)
		(sonnyScript bumpTurn:)
		(bainsScript bumpTurn:)
		(scubaScript bumpTurn:)
		(bubbleScript bumpTurn:)
		(super bumpTurn:)
	)
)

(instance scubaScript of Script
	(properties)

	(method (incClientPos)
		(self echo: 0)
	)

	(method (canControl param1)
		(if (== (param1 done:) 4)
			(gGame sel_450:)
		)
	)

	(method (echo param1)
		(switch (= state param1)
			(0
				(system
					nsLeft: 903
					sel_360: 3
					sel_312: 0
					sel_362: 1
					hide: 15
					sel_354: 153 64
					incClientPos:
					sel_356:
				)
				(development
					nsLeft: 903
					sel_360: 3
					sel_312: 1
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 158 82
					sel_356:
				)
				(jeff
					nsLeft: 904
					sel_360: 0
					sel_312: 0
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 157 97
					sel_356:
				)
				(heitman
					nsLeft: 904
					sel_360: 0
					sel_312: 1
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 158 115
					sel_356:
				)
				(pablo
					nsLeft: 904
					sel_360: 0
					sel_312: 2
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 158 131
					sel_356:
				)
				(stuart
					nsLeft: 904
					sel_360: 0
					sel_312: 3
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 159 148
					sel_356:
				)
				(= local0 40)
			)
			(1
				(system bumpTurn:)
				(development bumpTurn:)
				(heitman bumpTurn:)
				(jeff bumpTurn:)
				(pablo bumpTurn:)
				(stuart bumpTurn:)
				(project
					nsLeft: 903
					sel_360: 4
					sel_312: 0
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 156 86
					sel_356:
				)
				(coordinator
					nsLeft: 903
					sel_360: 4
					sel_312: 1
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 157 104
					sel_356:
				)
				(crowe
					nsLeft: 904
					sel_360: 1
					sel_312: 0
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 155 121
					sel_356:
				)
				(= local0 30)
			)
			(2
				(project bumpTurn:)
				(coordinator bumpTurn:)
				(crowe bumpTurn:)
				(legs bumpTurn:)
				(weeds bumpTurn:)
				(weeds2 bumpTurn:)
				(bubbles bumpTurn:)
				(gCurRoom sel_486: 885)
				(programming
					nsLeft: 903
					sel_360: 0
					sel_312: 0
					hide: 15
					incClientPos:
					sel_354: 97 20
					sel_362: 1
					sel_356:
				)
				(jerry
					nsLeft: 904
					sel_360: 1
					sel_312: 1
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 97 38
					sel_356:
				)
				(fischbach
					nsLeft: 904
					sel_360: 1
					sel_312: 2
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 97 54
					sel_356:
				)
				(dave
					nsLeft: 904
					sel_360: 2
					sel_312: 2
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 97 71
					sel_356:
				)
				(heitman
					nsLeft: 904
					sel_360: 2
					sel_312: 0
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 97 88
					sel_356:
				)
				(mickie
					nsLeft: 904
					sel_360: 2
					sel_312: 1
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 97 105
					sel_356:
				)
				(vu
					nsLeft: 904
					sel_360: 5
					sel_312: 0
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 97 121
					sel_356:
				)
				(= local0 20)
			)
			(3
				(bainsScript echo: 0)
				(= local0 30)
			)
			(4
				(programming bumpTurn:)
				(jerry bumpTurn:)
				(fischbach bumpTurn:)
				(heitman bumpTurn:)
				(mickie bumpTurn:)
				(dave bumpTurn:)
				(art
					nsLeft: 903
					sel_360: 1
					sel_312: 0
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 38 50
					sel_356:
				)
				(animation
					nsLeft: 903
					sel_360: 1
					sel_312: 1
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 121 50
					sel_356:
				)
				(cheri
					nsLeft: 904
					sel_360: 3
					sel_312: 1
					sel_362: 1
					hide: 3
					incClientPos:
					sel_354: 96 70
					sel_356:
				)
				(vu sel_360: 3 sel_312: 0 sel_354: 96 90)
				(= local0 40)
			)
			(5
				(art bumpTurn:)
				(animation bumpTurn:)
				(vu bumpTurn:)
				(cheri bumpTurn:)
				(music
					nsLeft: 903
					sel_360: 2
					sel_312: 0
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 97 50
					sel_356:
				)
				(chris
					nsLeft: 904
					sel_360: 4
					sel_312: 0
					sel_362: 1
					hide: 15
					incClientPos:
					sel_354: 97 70
					sel_356:
				)
				(= local0 40)
			)
			(6
				(music bumpTurn:)
				(chris bumpTurn:)
				(gCurRoom sel_486: 48)
				(= local0 10)
			)
			(7
				(localproc_0 47 1) ; "One Year has passed since Detective Sonny Bonds successfully brought Jessie Bains (The Death Angel) to justice. Bains' world of rampant drugs and open violence, the world he controlled so well, has been silenced. As the memory of this animal slowly fades, the city of Lytton once again lives in the peace and serenity of its past."
				(localproc_0 47 2) ; "Officer Sonny Bonds has been promoted to the position of 'Homicide Detective.' The day begins with Detective Bonds arriving for another routine work day, or so it seems..."
				(gGame sel_450:)
			)
		)
	)
)

(instance bainsScript of Script
	(properties)

	(method (echo param1)
		(switch (= state param1)
			(0
				(bainsRunning incClientPos: sel_340: MoveTo 172 140 self)
				(bainsShadow incClientPos: sel_340: MoveTo 162 135)
			)
			(1
				(bainsShadow
					lsLeft: (bainsShadow lsBottom:)
					sel_340: MoveTo 235 135
				)
				(bainsRunning sel_360: 0 lsLeft: (bainsRunning lsBottom:))
				(bainsRunning sel_340: MoveTo 245 140 self)
				(sonnyScript echo: 0)
			)
			(2
				(bainsShadow
					lsLeft: (bainsShadow lsBottom:)
					sel_340: MoveTo 330 135
				)
				(bainsRunning sel_360: 1 lsLeft: (bainsRunning lsBottom:))
				(bainsRunning sel_340: MoveTo 340 140 self)
			)
			(3
				(bainsRunning bumpTurn:)
				(bainsShadow bumpTurn:)
			)
		)
	)
)

(instance sonnyScript of Script
	(properties)

	(method (echo param1)
		(switch (= state param1)
			(0
				(sonnyRunning sel_340: MoveTo 172 140 self)
				(sonnyShadow sel_340: MoveTo 162 135)
			)
			(1
				(sonnyShadow
					lsLeft: (sonnyShadow lsBottom:)
					sel_340: MoveTo 230 135
				)
				(sonnyRunning sel_340: MoveTo 240 140 self)
				(sonnyRunning sel_360: 0 lsLeft: (sonnyRunning lsBottom:))
			)
			(2
				(sonnyShadow
					lsLeft: (sonnyShadow lsBottom:)
					sel_340: MoveTo 330 135
				)
				(sonnyRunning sel_340: MoveTo 340 140 self)
				(sonnyRunning sel_360: 1 lsLeft: (sonnyRunning lsBottom:))
			)
			(3
				(sonnyRunning bumpTurn:)
				(sonnyShadow bumpTurn:)
			)
		)
	)
)

(instance bubbleScript of Script
	(properties)

	(method (echo param1)
		(switch (= state param1)
			(0
				(bubbles sel_354: 60 130 sel_340: MoveTo 160 0 self)
			)
			(1
				(self echo: 0)
			)
		)
	)
)

(instance weed1Script of Script
	(properties)

	(method (echo param1)
		(switch (= state param1)
			(1
				(weeds sel_354: 10 130 sel_340: MoveTo 300 130 self)
			)
			(2
				(self echo: 1)
			)
		)
	)
)

(instance weed2Script of Script
	(properties)

	(method (echo param1)
		(switch (= state param1)
			(3
				(weeds sel_354: 10 140 sel_340: MoveTo 300 140 self)
			)
			(4
				(self echo: 1)
			)
		)
	)
)

