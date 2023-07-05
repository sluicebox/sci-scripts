;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Osc)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm060 0
	Mayor 1
)

(instance roomTimer of Timer ; UNUSED
	(properties)
)

(class Fool of Actor
	(properties
		approachDist 1
		cueCount 0
		lastTime -1
		fseconds -1
		ticksToDo -1
		maxLoop -1
		status 1
		talkCount 0
	)

	(method (init)
		(super init:)
		(= fseconds (Random 6 12))
	)

	(method (cue)
		(super cue:)
		(switch (++ cueCount)
			(1
				(cond
					((!= status 1) 0)
					((!= maxLoop -1)
						(self setLoop: (Random 0 maxLoop) setCycle: End self)
					)
					(else
						(self setCycle: End self)
					)
				)
			)
			(2
				(= fseconds 2)
				(self stopUpd:)
			)
			(3
				(if (== status 1)
					(self setCel: 0 stopUpd:)
					(= cueCount 0)
					(= fseconds (Random 4 12))
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((!= status 1) 0)
			((!= fseconds -1)
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(if (not (-- fseconds))
						(self cue:)
					)
				)
			)
			(
				(or
					(u< (+ ticksToDo lastTime) (GetTime))
					(and
						(u> lastTime (GetTime))
						(u> (+ ticksToDo lastTime) lastTime)
					)
				)
				(self cue:)
			)
		)
	)
)

(instance elevatorSnd of Sound ; UNUSED
	(properties
		flags -1
		number 922
	)
)

(class Script_ of Script
	(properties
		register2 -1
	)
)

(instance rm060 of PQRoom
	(properties
		picture 165
		style 9
	)

	(method (init)
		(super init:)
		(HandsOff)
		(SetFlag 1)
		(gTheIconBar disable:)
		(gGame setCursor: 996)
		(if (not (gLongSong2 handle:))
			(gLongSong2 number: 584 loop: -1 play:)
		)
		(gEgo init: view: 623 posn: 161 95)
		(cameraMan init:)
		(soundMan init:)
		(photoMan init: setScript: theExtras)
		(self setScript: theEnd)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(return (and script 0))
	)

	(method (dispose)
		(super dispose:)
		(gCast eachElementDo: #dispose)
		(LoadMany 0 939)
	)
)

(instance theEnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 0 cycleSpeed: 9 setCycle: Osc 1 self)
				(soundMan cycleSpeed: 9 setCycle: CT 4 1 self)
			)
			(1)
			(2
				(gMessager say: 1 0 0 1 self) ; "...that the scourge of the Death Angel upon our fair city has at last been eradicated. I'm delighted to tell you all that Jesse Bains has been convicted of numerous felonies, including the attempted murder of a police officer and possession of narcotics with intent to sell. It'll be a long, long time before Jesse Bains sees the light of day!"
			)
			(3
				(gMessager say: 1 0 0 2 self) ; "And for that, we have one very brave police officer to thank. A man who was prepared to make the ultimate sacrifice...a man who laid his life on the line to make Lytton a safer place for us all..."
			)
			(4
				(gMessager say: 1 0 0 3 self) ; "...a man to whom we owe a debt of gratitude we can never quite repay, although we're starting by promoting him to Narcotics Detective and presenting him with the LPD's highest honor, the Commendation for Valor..."
			)
			(5
				(gMessager say: 1 0 0 4 self) ; "Ladies and Gentlemen, I give you the man of the hour...Detective Sonny Bonds!"
			)
			(6
				(closeUp init: cycleSpeed: 12 setLoop: 0 setCycle: End self)
			)
			(7
				(gMessager say: 1 0 0 5 self) ; "You think to yourself, "I wish I had somebody to share this moment with...""
			)
			(8
				(gMessager say: 1 0 0 6 self) ; "And then you remember...you've got your first date with Marie tonight!"
			)
			(9
				(gMessager say: 1 0 0 7 self) ; "The award...the promotion...the admiration of the entire city...and the start of a new close friendship..."
			)
			(10
				(gMessager say: 1 0 0 8 self) ; "...it doesn't get any better than this."
			)
			(11
				(closeUp dispose:)
				(gEgo setLoop: 1 cycleSpeed: 11 setCycle: End self)
			)
			(12
				(gEgo setLoop: 2 cycleSpeed: 11 setCycle: End self)
			)
			(13
				(photoMan setScript: 0)
				(gLongSong fade:)
				(gLongSong2 fade: self)
			)
			(14
				(gCurRoom newRoom: 299)
			)
		)
	)
)

(instance theExtras of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cameraMan
					setLoop: 0
					cycleSpeed: 8
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(cameraMan stopUpd:)
				(= seconds 3)
			)
			(2
				(photoMan
					setLoop: 0
					cycleSpeed: 8
					ignoreActors: 1
					setCycle: End self
				)
			)
			(3
				(photoMan stopUpd:)
				(= seconds 3)
			)
			(4
				(cameraMan setLoop: 0 setCycle: Beg self)
			)
			(5
				(cameraMan stopUpd:)
				(= seconds 3)
			)
			(6
				(photoMan setLoop: 0 setCycle: Beg self)
			)
			(7
				(photoMan stopUpd:)
				(= seconds 3)
			)
			(8
				(cameraMan setLoop: 1 setCycle: End self)
			)
			(9
				(cameraMan stopUpd:)
				(= seconds 3)
			)
			(10
				(photoMan setLoop: 1 setCycle: End self)
			)
			(11
				(photoMan stopUpd:)
				(= seconds 3)
			)
			(12
				(cameraMan setLoop: 1 setCycle: Beg self)
			)
			(13
				(cameraMan stopUpd:)
				(= seconds 3)
			)
			(14
				(photoMan setLoop: 1 setCycle: Beg self)
			)
			(15
				(photoMan stopUpd:)
				(= seconds 3)
			)
			(16
				(self changeState: 0)
			)
		)
	)
)

(instance cameraMan of Prop
	(properties
		x 184
		y 131
		view 621
		loop 1
		cel 3
	)
)

(instance soundMan of Prop
	(properties
		x 146
		y 126
		view 622
		cel 1
	)
)

(instance photoMan of Prop
	(properties
		x 109
		y 141
		view 620
		cel 11
	)
)

(instance closeUp of Prop
	(properties
		x 150
		y 151
		view 624
		cel 4
		priority 12
		signal 16
	)
)

(instance Mayor of Narrator
	(properties
		x 50
		y 20
		talkWidth 170
		font 4
		showTitle 1
		back 19
	)
)

