;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use Print)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use Timer)
(use Flags)
(use Motion)
(use Actor)
(use System)

(public
	ro110 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 1
	local6
	local7
	local8
)

(procedure (localproc_0)
	(if (== (gCurRoom script:) soLarryDances)
		(soLarryDances kill:)
	)
)

(procedure (localproc_1)
	(if (== (gCurRoom script:) soStagedEnding)
		(soStagedEnding kill:)
	)
)

(procedure (localproc_2)
	(cond
		((not (oHintFlags test: 0))
			(return 0)
		)
		((not (oHintFlags test: 1))
			(return 1)
		)
		((not (oHintFlags test: 2))
			(return 2)
		)
		((not (oHintFlags test: 3))
			(return 3)
		)
		((not (oHintFlags test: 4))
			(return 4)
		)
		((not (oHintFlags test: 5))
			(return 5)
		)
		((not (oHintFlags test: 6))
			(return 6)
		)
		((not (oHintFlags test: 7))
			(return 7)
		)
		((not (oHintFlags test: 8))
			(return 8)
		)
		((not (oHintFlags test: 9))
			(return 9)
		)
		((not (oHintFlags test: 10))
			(return 10)
		)
		(else
			(return 11)
		)
	)
)

(procedure (localproc_3)
	(Printf
		{%d %d %d %d\n%d %d %d %d\n%d %d %d\n%d}
		(oHintFlags test: 0)
		(oHintFlags test: 1)
		(oHintFlags test: 2)
		(oHintFlags test: 3)
		(oHintFlags test: 4)
		(oHintFlags test: 5)
		(oHintFlags test: 6)
		(oHintFlags test: 7)
		(oHintFlags test: 8)
		(oHintFlags test: 9)
		(oHintFlags test: 10)
		(localproc_2)
	)
)

(instance oHintFlags of Flags
	(properties
		size 11
	)
)

(instance ro110 of L7Room
	(properties)

	(method (init &tmp temp0)
		(super init: &rest)
		(gOMusic1 setMusic: 0)
		(= global330 0)
		(= gToShamara 0)
		(proc64038_3 0)
		(poLarry init: hide:)
		(voLarryMouth init: hide:)
		(poLarryEyes init: hide:)
		(poShamara init: hide:)
		(voShamaraMouth init: hide:)
		(poShamaraEyes init: hide:)
		(voWallet init: hide:)
		(voViseGrips init: hide:)
		(voHairWeaveKit init: hide:)
		(foBed init:)
		(foHeadboard init:)
		(foLeftTable init:)
		(foRightTable init:)
		(foLeftHandcuff init:)
		(foRightHandcuff init:)
		(foCondom init:)
		(foBra init:)
		(= global316 45)
		(oHintFlags init:)
		(= local0 0)
		(= local1 1)
		(= local2 0)
		(gGame handsOff:)
		(self setScript: soPlayOpening)
	)

	(method (newRoom)
		(= global330 0)
		(= gToShamara 0)
		(if (gTimers contains: oHintTimer)
			(oHintTimer dispose: delete:)
		)
		(gOSound1 stop:)
		(oAmbientFire fadeOut:)
		(super newRoom: &rest)
	)

	(method (dispose)
		(oHintFlags dispose:)
		(if (gTimers contains: oHintTimer)
			(oHintTimer dispose: delete:)
		)
		(super dispose: &rest)
	)

	(method (notify param1 &tmp temp0)
		(oHintFlags set: param1)
		(if (> (= temp0 (localproc_2)) local0)
			(= local0 temp0)
			(= local1 1)
			(if (gTimers contains: oHintTimer)
				(oHintTimer setReal: oHintTimer global316)
			)
		)
	)

	(method (gimme)
		(localproc_3)
	)
)

(class StopableScript of Script
	(properties)

	(method (kill))
)

(instance soPlayOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= local3 0)
				(gMessager say: 0 0 15 1 coEndTalk) ; "(PORN MOVIE SOUNDTRACK) Moan. Oh. Baby. Yes. There, no there! Oh, God."
				(= ticks 120)
			)
			(2
				(gOSound1 setRelVol: 200 playSound: 10111)
				(= cycles 1)
			)
			(3
				(if (not local3)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(gMessager say: 0 0 1 1 self) ; "(APPROACHING NIRVANA) Oh, baby! You're the GREATest! This has gotta be the BEST night of my life!!"
			)
			(5
				(Load rsPIC 11000)
				(Load rsVIEW 11000)
				(gOSound1 stop:)
				(gMessager say: 0 0 1 2 self) ; "(SULTRY, TEASING, TEMPTING) I need more, Larry; more! And, something new. (SUGGESTIVELY) Here...slip into these!"
			)
			(6
				(= local3 0)
				(gMessager say: 0 0 1 3 coEndTalk) ; "(Breathlessly) God, Shamara, is there anything we haven't done?"
				(= ticks 120)
			)
			(7
				(gOSound1 playSound: 10112)
				(= ticks 120)
			)
			(8
				(gOSound1 playSound: 10112)
				(= cycles 1)
			)
			(9
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(10
				(gMessager say: 0 0 1 4 self) ; "(SUDDENLY COLD) There's lots I haven't done, Laffer. (THE BOMBSHELL) That's why I'm leaving you."
			)
			(11
				(gMessager say: 0 0 1 5 self) ; "(BEWILDERED) Leaving? Now?"
			)
			(12
				(voWallet show:)
				(voViseGrips show:)
				(voHairWeaveKit show:)
				(poLarry show:)
				(voLarryMouth show:)
				(poLarryEyes show:)
				(poShamara show:)
				(gCurRoom drawPic: 11000)
				(FrameOut)
				(gOMusic1 playSound: 11000)
				(gOSound1 setRelVol: 100 playSound: 10113)
				(gOSound1 preload: 10123)
				(gOSound1 preload: 10121)
				(poShamara
					view: 11001
					loop: 0
					cel: 0
					cycleSpeed: 6
					doit:
					setCycle: End self 7 9999
				)
			)
			(13
				(gOSound1 playSound: 10121)
			)
			(14
				(= cycles 1)
			)
			(15
				(poShamara
					view: 11002
					loop: 0
					cel: 0
					posn: 540 462
					cycleSpeed: 6
					doit:
					setCycle: End self
				)
			)
			(16
				(Load rsVIEW 11004 11015)
				(poShamaraSmoke init: setCycle: End self)
				(gOSound1 playSound: 10128)
				(poShamara
					view: 11003
					loop: 0
					cel: 0
					posn: 540 462
					doit:
					setCycle: End self
				)
			)
			(17)
			(18
				(oShortSound playSound: 10123)
				(poLarry
					view: 11004
					loop: 0
					cel: 1
					posn: 432 93
					cycleSpeed: 7
					doit:
					setCycle: End self
				)
				(voLarryMouth hide:)
				(poLarryEyes hide:)
			)
			(19
				(poLarry setCycle: Beg self)
			)
			(20
				(poLarry
					view: 11015
					loop: 0
					cel: 0
					posn: 432 93
					cycleSpeed: 6
					doit:
				)
				(gOSound1 stop:)
				(poLarryEyes show:)
				(voLarryMouth show:)
				(= cycles 1)
			)
			(21
				(= local4 1)
				(poShamara view: 11000 loop: 0 cel: 0 posn: 540 462)
				(UpdateScreenItem poShamara)
				(voShamaraMouth show:)
				(toShamara view: 11000 loop: 1 x: 540 y: 465)
				(= cycles 1)
			)
			(22
				(= global330 toLarry)
				(= gToShamara toShamara)
				(= local3 0)
				(gMessager say: 0 0 1 6 coEndTalk) ; "A night with you gives a woman plenty of time to think. (SLIGHTLY SLOWER) That New Age philosophy crap just isn't me. (HARD AND COLD AGAIN) What I really love is: MONEY!"
				(= cycles 1)
			)
			(23
				(= ticks 70)
			)
			(24
				(poShamaraSmoke dispose:)
				(= ticks 170)
			)
			(25
				(= local4 0)
				(poShamara
					view: 11005
					loop: 0
					cel: 0
					x: 540
					y: 465
					setCycle: End self 18 9999
				)
				(voShamaraMouth hide:)
				(if (!= (toShamara mouth:) 0)
					((toShamara mouth:) hide:)
				)
			)
			(26
				(gOSound1 playSound: 10122)
				(voWallet dispose:)
			)
			(27
				(= cycles 1)
			)
			(28
				(poShamara
					view: 11005
					loop: 1
					cel: 0
					x: 540
					y: 465
					setCycle: End self 3 9999
				)
			)
			(29
				(if (not (gTalkers isEmpty:))
					((toShamara mouth:)
						view: 11006
						loop: 1
						cel: 0
						x: 540
						y: 465
						show:
					)
				)
			)
			(30
				(= cycles 1)
			)
			(31
				(poShamara view: 11006 loop: 0 cel: 0 posn: 540 465 doit:)
				(poShamaraEyes show:)
				(if (toShamara mouth:)
					((toShamara mouth:)
						view: 11006
						loop: 1
						cel: 0
						x: 540
						y: 465
						show:
					)
				else
					(voShamaraMouth show:)
				)
				(= cycles 1)
			)
			(32
				(if (not local3)
					(-= state 1)
				else
					(voShamaraMouth show:)
				)
				(= cycles 1)
			)
			(33
				(poCigToFlames init: hide:)
				(voShamaraMouth show:)
				(gMessager say: 0 0 1 7 self) ; "You can't leave me here like this!"
			)
			(34
				(= gToShamara 0)
				(poShamara
					view: 11010
					loop: 0
					cel: 0
					x: 540
					y: 465
					doit:
					setCycle: End self 1 4 7 9999
				)
				(voShamaraMouth hide:)
				(poShamaraEyes hide:)
				(= local3 0)
			)
			(35
				(poLarry
					view: 11018
					loop: 0
					cel: 0
					x: 432
					y: 93
					doit:
					setCycle: CT 4 1
				)
				(voLarryMouth hide:)
				(poLarryEyes hide:)
			)
			(36
				(gMessager say: 0 0 1 8 coEndTalk) ; "You're right. (STICKS CIGARETTE IN HIS MOUTH) So long, sucker!"
			)
			(37
				(poLarry setCycle: End)
			)
			(38
				(= cycles 1)
			)
			(39
				(poShamara
					view: 11010
					loop: 1
					cel: 0
					x: 540
					y: 462
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(40
				(poLarry view: 11020 loop: 0 cel: 0 x: 432 y: 93)
				(UpdateScreenItem poLarry)
				(voLarryMouth show:)
				(poShamara dispose:)
				(= cycles 1)
			)
			(41
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(42
				(gMessager say: 0 0 1 10 self) ; "Hey! I don't smoke!"
			)
			(43
				(= global330 toLarry)
				(voLarryMouth hide:)
				(poLarry view: 11020 loop: 0 cel: 0 x: 432 y: 93)
				(gMessager say: 0 0 1 12 self) ; "(PARALLEL FIRST LINE) Oh, baby! You're the LOWest! This has gotta be the WORST night of my life!!"
			)
			(44
				(Load 140 10130) ; WAVE
				(poLarry
					view: 11021
					loop: 0
					cel: 0
					x: 432
					y: 93
					setCycle: End self
				)
				(voLarryMouth hide:)
				(= global330 0)
				(= local3 0)
				(gMessager say: 0 0 1 13 coEndTalk) ; "(SIGH) At least things can't get any worse! (ONE LOUD HACK SENDS THE CIGARETTE ONTO THE BED)"
			)
			(45
				(poLarry
					view: 11022
					loop: 0
					cel: 0
					x: 432
					y: 93
					setCycle: CT 27 1 self
				)
			)
			(46
				(gOSound1 playSound: 10130)
				(poLarry setCycle: End self 35)
			)
			(47
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(48
				(poCigToFlames show: setCycle: End self)
				(poFinalFlames1 init: hide:)
				(poLarryDances init: hide:)
				(oAmbientFire setAmbient: 10124)
			)
			(49
				(poCigToFlames setCycle: RangeRandCycle 1440 16 18)
				(= local3 0)
				(gMessager say: 0 0 1 14 coEndTalk) ; "(QUIETLY) I should never say that!"
				(= ticks 120)
			)
			(50
				(poFinalFlames1 show:)
				(poCigToFlames dispose:)
				(= cycles 1)
			)
			(51
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(52
				(= local5 1)
				(self setScript: soStagedEnding self)
			)
			(53
				(self dispose:)
			)
		)
	)
)

(instance soStagedEnding of StopableScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(self changeState: local5)
			)
			(1
				(poLarry
					view: 11015
					loop: 3
					cel: 0
					x: 432
					y: 93
					cycleSpeed: 9
					setCycle: End self
				)
				(voLarryMouth hide:)
				(poLarryEyes hide:)
				(gOMusic1 stop: setMusic: 11010)
				(+= local5 1)
			)
			(2
				(oShortSound playSound: 10127)
				(= cycles 1)
				(+= local5 1)
			)
			(3
				(= global330 toLarry)
				(poLarry view: 11015 loop: 0 cel: 0 x: 432 y: 93 show:)
				(voLarryMouth show:)
				(poLarryEyes show:)
				(if (not local6)
					(= local6 1)
					(oHintSfx playSubtitledSound: 11038 0 0 18 1 self)
				)
				(+= local5 1)
			)
			(4
				(= global330 toLarry)
				(poLarry view: 11015 loop: 0 cel: 0 x: 432 y: 93 show:)
				(voLarryMouth show:)
				(poLarryEyes show:)
				(if (not local7)
					(= local7 1)
					(gMessager say: 0 0 18 2 self) ; "(CONFUSED) Me?"
				)
				(+= local5 1)
			)
			(5
				(= global330 0)
				(if (not local8)
					(= local8 1)
					(oHintSfx playSubtitledSound: 11039 0 0 18 3 self)
				)
				(+= local5 1)
			)
			(6
				(= global330 0)
				(poLarryDances show: setCycle: CT 15 1 self)
				(poLarry dispose:)
				(voLarryMouth dispose:)
				(poLarryEyes dispose:)
				(+= local5 1)
			)
			(7
				(poLarryDances setCycle: Beg self)
				(+= local5 1)
			)
			(8
				(+= local5 1)
				(gCurRoom setScript: soLarryDances)
				(oHintTimer setReal: oHintTimer global316)
				(self dispose:)
			)
		)
	)

	(method (kill)
		(= global330 0)
		(gMessager kill:)
		(self dispose:)
	)
)

(instance soGrabHairKit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global330 0)
				(= local3 0)
				(gMessager say: 10 8 0 0 coEndTalk) ; "My comb-over COULD use a little thickening."
				(poGrabKit
					view: 11031
					loop: 0
					cel: 0
					init:
					setCycle: End self 27 9999
				)
				(cond
					((== local5 0)
						(poLarry hide:)
					)
					((== local5 1)
						(poLarry hide:)
					)
					((== local5 2)
						(poLarry hide:)
					)
					((== local5 3)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 4)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 5)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 6)
						(poLarryDances hide:)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 7)
						(poLarryDances hide:)
					)
					(else
						(poLarryDances hide:)
					)
				)
			)
			(1
				(voHairWeaveKit hide:)
			)
			(2
				(= cycles 1)
			)
			(3
				(cond
					((== local5 0)
						(poLarry show:)
					)
					((== local5 1)
						(poLarry show:)
					)
					((== local5 2)
						(poLarry show:)
					)
					((== local5 3)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 4)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 5)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 6)
						(poLarryDances show:)
					)
					((== local5 7)
						(poLarryDances show:)
					)
					(else
						(poLarryDances show:)
					)
				)
				(poGrabKit dispose:)
				(= cycles 1)
			)
			(4
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(if (> local5 8)
					(oHintTimer setReal: oHintTimer global316)
					(gCurRoom setScript: soLarryDances)
				else
					(gCurRoom setScript: soStagedEnding)
				)
				(self dispose:)
			)
		)
	)
)

(instance soPinToCuffs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poPinToCuffs
					view: 11032
					loop: 0
					cel: 0
					init:
					setCycle: End self 6 9999
				)
				(cond
					((== local5 0)
						(poLarry hide:)
					)
					((== local5 1)
						(poLarry hide:)
					)
					((== local5 2)
						(poLarry hide:)
					)
					((== local5 3)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 4)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 5)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 6)
						(poLarryDances hide:)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 7)
						(poLarryDances hide:)
					)
					(else
						(poLarryDances hide:)
					)
				)
			)
			(1
				(gOSound1 playSound: 10126)
			)
			(2
				(cond
					((== local5 0)
						(poLarry show:)
					)
					((== local5 1)
						(poLarry show:)
					)
					((== local5 2)
						(poLarry show:)
					)
					((== local5 3)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 4)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 5)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 6)
						(poLarryDances show:)
					)
					((== local5 7)
						(poLarryDances show:)
					)
					(else
						(poLarryDances show:)
					)
				)
				(poPinToCuffs hide:)
				(gMessager say: 3 14 0 1 self) ; "The needle is just too straight to use as a lock pick!"
			)
			(3
				(poPinToCuffs dispose:)
				(gGame handsOn:)
				(oHintTimer setReal: oHintTimer global316)
				(gCurRoom setScript: soLarryDances)
				(self dispose:)
			)
		)
	)
)

(instance soGrabViseGrips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 0)
				(gMessager say: 11 8 0 0 coEndTalk) ; "It's a good thing Shamara used those Vice Grips last night. I can just reach 'em from here."
				(= ticks 180)
			)
			(1
				(poGrabViceGrips
					view: 11035
					loop: 2
					cel: 0
					init:
					setCycle: End self 8 9999
				)
				(cond
					((== local5 0)
						(poLarry hide:)
					)
					((== local5 1)
						(poLarry hide:)
					)
					((== local5 2)
						(poLarry hide:)
					)
					((== local5 3)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 4)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 5)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 6)
						(poLarryDances hide:)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 7)
						(poLarryDances hide:)
					)
					(else
						(poLarryDances hide:)
					)
				)
			)
			(2
				(voViseGrips hide:)
			)
			(3
				(= cycles 1)
			)
			(4
				(cond
					((== local5 0)
						(poLarry show:)
					)
					((== local5 1)
						(poLarry show:)
					)
					((== local5 2)
						(poLarry show:)
					)
					((== local5 3)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 4)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 5)
						(poLarry show:)
						(voLarryMouth show:)
						(poLarryEyes show:)
					)
					((== local5 6)
						(poLarryDances show:)
					)
					((== local5 7)
						(poLarryDances show:)
					)
					(else
						(poLarryDances show:)
					)
				)
				(poGrabViceGrips dispose:)
				(= cycles 1)
			)
			(5
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(if (> local5 8)
					(oHintTimer setReal: oHintTimer global316)
					(gCurRoom setScript: soLarryDances)
				else
					(gCurRoom setScript: soStagedEnding)
				)
				(self dispose:)
			)
		)
	)
)

(instance soUnlockCuffs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: oHintTimer)
					(oHintTimer dispose: delete:)
				)
				((ScriptID 64017 0) set: 19) ; oFlags
				(= local3 0)
				(gMessager say: 3 65 0 1 coEndTalk) ; "Maybe..."
				(poUnlockRightCuff init: setCycle: End self 17 9999)
				(cond
					((== local5 0)
						(poLarry hide:)
					)
					((== local5 1)
						(poLarry hide:)
					)
					((== local5 2)
						(poLarry hide:)
					)
					((== local5 3)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 4)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 5)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 6)
						(poLarryDances hide:)
						(poLarry hide:)
						(voLarryMouth hide:)
						(poLarryEyes hide:)
					)
					((== local5 7)
						(poLarryDances hide:)
					)
					(else
						(poLarryDances hide:)
					)
				)
			)
			(1
				(gOSound1 playSound: 10126)
			)
			(2
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(3
				(poRightCuff init: setCycle: End self)
			)
			(4
				(poUnlockLeftCuff init: setCycle: End self 2 10 18 9999)
				(poUnlockRightCuff dispose:)
			)
			(5
				(gOSound1 playSound: 10126)
			)
			(6
				(gOSound1 playSound: 10126)
			)
			(7
				(= local3 0)
				(gMessager say: 0 0 31 1 coEndTalk 2) ; "Yes!"
			)
			(8
				(poLeftCuff init:)
				(poUnlockLeftCuff hide:)
				(= cycles 1)
			)
			(9
				(if (not local3)
					(-= state 1)
				)
				(= cycles 1)
			)
			(10
				(gCurRoom newRoom: 120) ; ro120
				(self dispose:)
			)
		)
	)
)

(instance soLarryDances of StopableScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLarryDances view: 11023 loop: 0 cel: 0 show:)
				(= ticks 60)
			)
			(1
				(poLarryDances setCycle: End self (Random 3 23) 9999)
			)
			(2
				(if (and (gTalkers isEmpty:) (not (oHintSfx isPlaying:)))
					(switch local2
						(0
							(oYellSfx playSound: 111)
						)
						(1
							(oYellSfx playSound: 112)
						)
						(2
							(oYellSfx playSound: 113)
						)
					)
				)
			)
			(3
				(= cycles 1)
			)
			(4
				(poLarryDances setCycle: Beg self)
			)
			(5
				(if (> (++ local2) 2)
					(= local2 0)
				)
				(= ticks (Random 180 300))
			)
			(6
				(self changeState: 0)
			)
		)
	)

	(method (kill)
		(gMessager kill:)
		(self dispose:)
	)
)

(instance soFlameOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poFinalFlames1 setCycle: End self)
			)
			(1
				(poFinalFlames1
					loop: 1
					cel: 0
					posn: (- (poFinalFlames1 x:) 41) (- (poFinalFlames1 y:) 2)
					setCycle: RandCycle -1
				)
				(= ticks (Random 720 1440))
			)
			(2
				(poFinalFlames2 init: setCycle: End self)
			)
			(3
				(poFinalFlames2
					loop: 1
					cel: 0
					posn: (- (poFinalFlames2 x:) 41) (- (poFinalFlames2 y:) 2)
					setCycle: RandCycle -1
				)
				(= ticks (Random 720 1440))
			)
			(4
				(poFinalFlames3 init: setCycle: End self)
			)
			(5
				(poFinalFlames3
					loop: 1
					cel: 0
					posn: (- (poFinalFlames3 x:) 41) (- (poFinalFlames3 y:) 2)
					setCycle: RandCycle -1
				)
				(= ticks (Random 720 1440))
			)
			(6
				(poFinalFlames4 init: setCycle: End self)
			)
			(7
				(poFinalFlames4
					loop: 1
					cel: 0
					posn: (- (poFinalFlames4 x:) 41) (- (poFinalFlames4 y:) 2)
					setCycle: RandCycle -1
				)
				(= ticks (Random 720 1440))
			)
			(8
				(poFinalFlames5 init: setCycle: End self)
			)
			(9
				(poFinalFlames5
					loop: 1
					cel: 0
					posn: (- (poFinalFlames5 x:) 41) (- (poFinalFlames5 y:) 2)
					setCycle: RandCycle -1
				)
				(self dispose:)
			)
		)
	)
)

(instance poGrabKit of Prop
	(properties
		x 450
		y 93
		priority 220
		fixPriority 1
		view 11031
		cycleSpeed 6
	)
)

(instance poPinToCuffs of Prop
	(properties
		x 450
		y 93
		view 11032
		cycleSpeed 6
	)
)

(instance poGrabViceGrips of Prop
	(properties
		x 450
		y 93
		priority 220
		fixPriority 1
		view 11035
		cycleSpeed 6
	)
)

(instance poUnlockRightCuff of Prop
	(properties
		x 444
		y 93
		view 11039
		cycleSpeed 6
	)
)

(instance poUnlockLeftCuff of Prop
	(properties
		x 444
		y 93
		view 11040
		cycleSpeed 6
	)
)

(instance poRightCuff of Prop
	(properties
		x 444
		y 93
		view 11065
		cycleSpeed 6
	)
)

(instance poLeftCuff of Prop
	(properties
		x 444
		y 93
		view 11065
		loop 1
		cycleSpeed 6
	)
)

(instance poLarryDances of Prop
	(properties
		noun 4
		x 445
		y 93
		view 11023
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 6 77)
	)
)

(instance poCigToFlames of Prop
	(properties
		x 299
		y 330
		view 11029
		cycleSpeed 6
	)
)

(instance poFinalFlames1 of Prop
	(properties
		noun 5
		x 297
		y 337
		view 11045
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77)
	)

	(method (show)
		(super show: &rest)
		(self setScript: soFlameOn)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(77 ; Whiz
				(gMessager say: 4 77 0 0) ; "(TAKING A LEAK) Ahhhh. (ONLY NOW YOU REALIZE IT WAS IN YOUR PANTS) Oops."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poFinalFlames2 of Prop
	(properties
		noun 5
		x 208
		y 350
		view 11045
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(77 ; Whiz
				(gMessager say: 4 77 0 0) ; "(TAKING A LEAK) Ahhhh. (ONLY NOW YOU REALIZE IT WAS IN YOUR PANTS) Oops."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poFinalFlames3 of Prop
	(properties
		noun 5
		x 73
		y 330
		view 11045
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(77 ; Whiz
				(gMessager say: 4 77 0 0) ; "(TAKING A LEAK) Ahhhh. (ONLY NOW YOU REALIZE IT WAS IN YOUR PANTS) Oops."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poFinalFlames4 of Prop
	(properties
		noun 5
		x 172
		y 431
		view 11045
		cycleSpeed 4
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(77 ; Whiz
				(gMessager say: 4 77 0 0) ; "(TAKING A LEAK) Ahhhh. (ONLY NOW YOU REALIZE IT WAS IN YOUR PANTS) Oops."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poFinalFlames5 of Prop
	(properties
		noun 5
		x 588
		y 436
		view 11045
		cycleSpeed 9
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 77)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(77 ; Whiz
				(gMessager say: 4 77 0 0) ; "(TAKING A LEAK) Ahhhh. (ONLY NOW YOU REALIZE IT WAS IN YOUR PANTS) Oops."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poShamaraSmoke of Prop
	(properties
		view 11002
		loop 1
	)

	(method (init)
		(= x (poShamara x:))
		(= y (poShamara y:))
		(super init: &rest)
	)
)

(instance foBed of Feature
	(properties
		noun 6
		x 254
		y 282
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 218 238 224 233 235 232 239 234 253 202 258 199 261 180 262 114 267 45 283 29 288 24 291 23 298 38 307 68 320 106 332 186 345 225 348 268 347 310 345 384 332 432 322 470 309 486 300 478 275 485 261 485 243 477 233 469 231 452 223 433 220 418 221 404 227 400 225 380 222 370 221 351 228 332 221 309 221 300 225 296 224 283 217 264 216 254 220
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 77)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(77 ; Whiz
				(gMessager say: 4 77 0 0) ; "(TAKING A LEAK) Ahhhh. (ONLY NOW YOU REALIZE IT WAS IN YOUR PANTS) Oops."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRightTable of Feature
	(properties
		noun 2
		x 177
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 264 128 235 124 234 120 228 126 221 148 213 171 203 204 210 229 214 234 218 233 223 225 225 220 255 187 262
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(gMessager say: 2 1 0 1) ; "There's nothing more on THAT table."
				else
					(gMessager say: 2 1 6 1) ; "That table would be empty, if Shamara hadn't left her Vice Grips lying there."
				)
			)
			(8 ; Take
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(gMessager say: 2 8 0 1) ; "There's nothing more on that table."
				else
					(voViseGrips doVerb: 8)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLeftTable of Feature
	(properties
		noun 1
		x 500
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 579 416 596 396 596 381 606 335 627 270 635 265 638 262 637 258 632 255 560 244 504 263 497 272 503 279 509 279 513 328 519 375 515 382 514 387 518 393 514 393 513 397 510 398 517 404 521 402 562 413 566 420 573 420
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(gMessager say: 1 1 0 1) ; "There's nothing more on THAT table."
				else
					(gMessager say: 1 1 5 1) ; "One of La Costa Lotta's complimentary "Lil' Hair Weave Kits" lies on the table. You were planning to take it home."
				)
			)
			(8 ; Take
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(gMessager say: 1 8 0 1) ; "There's nothing more on that table."
				else
					(voHairWeaveKit doVerb: 8)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLeftHandcuff of Feature
	(properties
		noun 3
		x 306
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 246 137 313 138 329 41 282 34
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(14 ; Needle
				(if (> local5 8)
					(localproc_0)
				else
					(localproc_1)
				)
				(gCurRoom setScript: soPinToCuffs)
			)
			(13 ; Vice Grips
				(gMessager say: 3 13 0 1 0 110) ; "There's no way your Vice Grips are strong enough. Those grips spell "vice" with a "C," not an "S.""
			)
			(98 ; Lil' Hair Weave Kit
				(oHintSfx playSubtitledSound: 11040 3 98 0 1)
			)
			(65 ; Bent Needle
				(if (> local5 8)
					(localproc_0)
				else
					(localproc_1)
				)
				(gCurRoom setScript: soUnlockCuffs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRightHandcuff of Feature
	(properties
		noun 3
		x 454
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 513 123 514 27 416 32 417 143
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(14 ; Needle
				(if (> local5 8)
					(localproc_0)
				else
					(localproc_1)
				)
				(gCurRoom setScript: soPinToCuffs)
			)
			(13 ; Vice Grips
				(gMessager say: 3 13 0 1 0 110) ; "There's no way your Vice Grips are strong enough. Those grips spell "vice" with a "C," not an "S.""
			)
			(98 ; Lil' Hair Weave Kit
				(oHintSfx playSubtitledSound: 11040 3 98 0 1)
			)
			(65 ; Bent Needle
				(if (> local5 8)
					(localproc_0)
				else
					(localproc_1)
				)
				(gCurRoom setScript: soUnlockCuffs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCondom of Feature
	(properties
		noun 12
		x 614
		y 415
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 639 426 625 426 618 424 617 420 607 420 607 418 609 415 608 413 595 413 595 411 595 408 589 408 593 405 597 407 617 409 617 413 623 417 626 419 634 418 639 418
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBra of Feature
	(properties
		noun 13
		x 610
		y 321
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 619 397 621 395 617 389 618 381 613 377 611 371 617 369 625 356 619 339 617 332 626 323 631 311 627 301 615 297 611 297 616 263 604 246 600 246 598 247 600 249 612 265 606 298 602 310 604 321 613 333 614 339 605 344 598 352 598 358 596 363 590 366 591 381 601 390 608 392 615 397
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 0 8 6 1 0 16) ; "You don't need that."
			)
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foHeadboard of Feature
	(properties
		noun 7
		x 406
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 470 232 486 214 496 196 508 179 521 158 529 140 540 114 542 109 547 100 544 93 545 85 543 41 529 0 502 0 407 0 399 14 393 26 389 33 388 37 371 13 347 0 312 0 283 28 267 58 266 101 277 140 299 185 322 221 336 222 347 228 371 221 383 221 396 224 406 225 421 221 447 221
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voWallet of View
	(properties
		x 351
		y 324
		view 11050
	)
)

(instance voHairWeaveKit of View
	(properties
		noun 10
		x 563
		y 255
		priority 200
		fixPriority 1
		view 11055
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(8 ; Take
				(if ((ScriptID 64017 0) test: 20) ; oFlags
					(gMessager say: 1 1) ; "There's nothing more on THAT table."
				else
					((ScriptID 64017 0) set: 20) ; oFlags
					(gCurRoom notify: 2)
					(gCurRoom notify: 7)
					(cond
						((and (== (gCurRoom script:) soLarryDances) (> local5 8))
							(localproc_0)
						)
						(
							(and
								(== (gCurRoom script:) soStagedEnding)
								(< local5 8)
							)
							(localproc_0)
						)
					)
					(gCurRoom setScript: soGrabHairKit)
					(gEgo get: ((ScriptID 64037 0) get: 21)) ; oInvHandler, ioHairWeaveKit
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voViseGrips of View
	(properties
		noun 11
		x 183
		y 215
		view 11060
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom notify: 1)
				(super doVerb: theVerb)
			)
			(8 ; Take
				(if ((ScriptID 64017 0) test: 21) ; oFlags
					(gMessager say: 1 1) ; "There's nothing more on THAT table."
				else
					((ScriptID 64017 0) set: 21) ; oFlags
					(gCurRoom notify: 2)
					(gCurRoom notify: 6)
					(cond
						((and (== (gCurRoom script:) soLarryDances) (> local5 8))
							(localproc_0)
						)
						(
							(and
								(== (gCurRoom script:) soStagedEnding)
								(< local5 8)
							)
							(localproc_0)
						)
					)
					(gCurRoom setScript: soGrabViseGrips)
					(gEgo get: ((ScriptID 64037 0) get: 51)) ; oInvHandler, ioViceGrips
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poLarry of Prop
	(properties
		noun 4
		x 432
		y 93
		priority 50
		fixPriority 1
		view 11015
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 6 77)
	)
)

(instance voLarryMouth of View
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super show: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= priority (+ (poLarry priority:) 1))
		(voLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance poLarryEyes of Prop
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 2))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= view (poLarry view:))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super show: &rest)
		(self setCycle: Blink 10)
	)
)

(instance poShamara of Prop
	(properties
		x 540
		y 462
		priority 200
		fixPriority 1
		view 11000
		loop 2
	)
)

(instance voShamaraMouth of View
	(properties)

	(method (init)
		(= view (poShamara view:))
		(= loop (+ (poShamara loop:) 1))
		(= x (poShamara x:))
		(= y (poShamara y:))
		(self setPri: (+ (poShamara priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poShamara view:))
		(= loop (+ (poShamara loop:) 1))
		(= x (poShamara x:))
		(= y (poShamara y:))
		(self setPri: (+ (poShamara priority:) 1))
		(super show: &rest)
	)
)

(instance toShamara of Talker
	(properties)

	(method (init)
		(= priority (+ (poShamara priority:) 5))
		(voShamaraMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(if local4
			(voShamaraMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance poShamaraEyes of Prop
	(properties)

	(method (init)
		(= view (poShamara view:))
		(= loop (+ (poShamara loop:) 2))
		(= x (poShamara x:))
		(= y (poShamara y:))
		(self setPri: (+ (poShamara priority:) 2))
		(super init: &rest)
		(self setCycle: Blink 18)
		(self cycleSpeed: 12)
	)

	(method (show)
		(= view (poShamara view:))
		(= x (poShamara x:))
		(= y (poShamara y:))
		(super show:)
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local3 1)
	)
)

(instance oHintTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(0
				(oHintSfx playSubtitledSound: 11021 0 0 3 1)
				(= global316 25)
			)
			(1
				(oHintSfx playSubtitledSound: 11020 0 0 2 1)
			)
			(2
				(switch local1
					(1
						(oHintSfx playSubtitledSound: 11022 0 0 4 1)
					)
					(2
						(oHintSfx playSubtitledSound: 11023 0 0 4 2)
					)
				)
				(if (> (++ local1) 2)
					(= local1 2)
				)
			)
			(3
				(oHintSfx playSubtitledSound: 11027 0 0 9 1)
			)
			(4
				(switch local1
					(1
						(oHintSfx playSubtitledSound: 11024 0 0 7 1)
					)
					(2
						(oHintSfx playSubtitledSound: 11025 0 0 7 2)
					)
				)
				(if (> (++ local1) 2)
					(= local1 2)
				)
			)
			(5
				(oHintSfx playSubtitledSound: 11028 0 0 11 1)
			)
			(6
				(switch local1
					(1
						(oHintSfx playSubtitledSound: 11036 0 0 17 1)
					)
					(2
						(oHintSfx playSubtitledSound: 11037 0 0 17 2)
					)
				)
				(if (> (++ local1) 2)
					(= local1 2)
				)
			)
			(7
				(switch local1
					(1
						(oHintSfx playSubtitledSound: 11034 0 0 14 1)
					)
					(2
						(oHintSfx playSubtitledSound: 11035 0 0 14 2)
					)
				)
				(if (> (++ local1) 2)
					(= local1 2)
				)
			)
			(8
				(switch local1
					(1
						(oHintSfx playSubtitledSound: 11032 0 0 13 1)
					)
					(2
						(oHintSfx playSubtitledSound: 11033 0 0 13 2)
					)
				)
				(if (> (++ local1) 2)
					(= local1 2)
				)
			)
			(9
				(switch local1
					(1
						(oHintSfx playSubtitledSound: 11029 0 0 12 1)
					)
					(2
						(oHintSfx playSubtitledSound: 11030 0 0 12 2)
					)
					(3
						(oHintSfx playSubtitledSound: 11031 0 0 12 3)
					)
				)
				(if (> (++ local1) 3)
					(= local1 3)
				)
			)
			(10
				(oHintSfx playSubtitledSound: 11026 0 0 8 1)
			)
			(11
				(return)
			)
		)
		(self setReal: self 25)
	)
)

(instance oAmbientFire of TPSound
	(properties)
)

(instance oShortSound of TPSound
	(properties)
)

(instance oHintSfx of TPSound
	(properties)
)

(instance oYellSfx of TPSound
	(properties)
)

