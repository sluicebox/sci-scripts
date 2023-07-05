;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use Window)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties
		sel_20 {aboutCode}
	)

	(method (sel_57)
		(gGame sel_365: 0)
		(gSystemWindow sel_25: 50 sel_26: 42)
		(Print 4 0 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "King Graham's Board Game Challenge Team: Director: Bill Davis Producers: Tammy Dargan Tony Caudill Software Supervisor: J. Mark Hood"
		(Print 4 1 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "King Graham's Board Game Challenge Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
		(Print 4 2 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Producer: Stuart Moulder Game Designers: Marti McKenn Bridget McKenna"
		(Print 4 3 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) Art Designer: Jay Friedmann Lead Programmer: Warren Schwader Composer: Rob Atesalp"
		(Print 4 4 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) Animators: Nathan Larsen, Marc Hudgins, Terrance C. Falls, Michael Hutchinson, Richard Powell"
		(Print 4 5 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) Background Artist: Maurice Morgan Programmers: Michael Brock, Tom DeSalvo, John Harrell, Charles "Chip" Kerchner, Kim Bowdish Music Director: Mark Seibert"
		(Print 4 6 77 {Credits} 27 1 78 { Done } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) System Development: Jeff Stephenson, Dan Foy, Larry Scott, J. Mark Hood, Mark Wilden, Christopher Smith, Ken Koch Sound Effects: Rob Atesalp Quality Assurance: Dan Woolard"
		(gGame sel_365: 12)
		(DisposeScript 4)
	)
)

